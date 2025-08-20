package PanelForm;

import Conexion.ExeSql;
import Dialogos.*;
import Dialogos.jdBuscarCliPrv;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import static PanelForm.pfBuscaDoc.BuscaArchivos;
import static Utilidades.DocElect.carpeta;
import Utilidades.Ftp;
import Utilidades.GeneraDTE;
import Utilidades.GeneraDTE_FTP;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Utilidades.Ftp;
import static Utilidades.Ftp.busca;
import Utilidades.LogError;
import Utilidades.PanelTab;
import facturas.ArrayOfString;
import facturas.DTE;
import facturas.DTESoap;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamail.Window;
import java.util.concurrent.TimeUnit;
import static javamail.Window.PassWord;
import static javamail.Window.Username;
import javax.mail.Session;
import javax.*;
import javax.activation.*;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.print.PrintService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class pfFACCliente extends javax.swing.JPanel {
    
    //***************Variables Costo Promedio *****************//  
   
    ArrayList<ArrayList<String>> Lista  = new ArrayList<ArrayList<String>>();
            
 //*************************************************************//   
    
    
    
    String RutMaster;
    int Tipo; // 0::Nuevo    1:Abrir
    int TipoPago = 0;  //  1:Contado / 2:Crédito  /  3:Sin Costo
    
    int refGuia = 0;
    int refOcc = 0;
    
    
    int productos = 0;
    int dif = 0;
       
   
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();

    
    public void BajaArchivo() {
        String Archivo =Ftp.busca_SinAbrir("33", lbFolio.getText().trim(),"facturas","dte");
    }

    private void MailRápido() {
        JOptionPane.showMessageDialog(null, "Se enviará factura, un momento.");
        String Archivo =Ftp.busca_SinAbrir("33", lbFolio.getText().trim(),"facturas","dte");    
        String NumFactura = lbFolio.getText().trim();
        String Rut = txRut.getText().trim();
        String Orden = cbNroOrden.getSelectedItem().toString().trim();
        String CodigoOC = cbCodigoOc.getSelectedItem().toString().trim();

        ExeSql sql = new ExeSql();
        ResultSet Rs = null;

        String usuario = "despachos@luvaly.cl";
        String pass = "3Logica.";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        String recipient = "pagos@luvaly.cl"; 
        
        //Contacto Orden
        String Query = "select nombre,fono,celular,email\n" +
                       " from clicontactopersonas\n" +
                       " where id IN(select contacto \n" +
                       " from occh\n" +
                       " where rut =" +  Rut + " and  codigo_oc =" + CodigoOC +
                       " and orden = '" + Orden + "')  and email <> ''";
        try {
            Rs = sql.Select(Query);
            for(int i = 0; Rs.next(); i++){
                recipient = recipient + ","+Rs.getString("email").trim();  
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Contacto Factura
        String Query2 = "select nombre,fono,celular,email\n" +
                        " from clicontactopersonas\n" +
                        " where id_cargo IN (8) and rut =" +  Rut + " and  codigo_oc =" + CodigoOC+ " and email <> '' "; 
        try {
            Rs = sql.Select(Query2);
            for(int i = 0; Rs.next(); i++){
                recipient = recipient + ","+Rs.getString("email").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);  
        }
        //Contacto Guía
        String Query3 = "select nombre,fono,celular,email\n" +
                " from clicontactopersonas\n" +
                " where id IN(select  contacto from ctactecli\n" +
                " where rut =" + Rut + " and  codigo_oc = " + CodigoOC + " and nrodocrel = " + NumFactura + "  and tipdocrel= 'FAC')  and email <> ''";
        try {
            Rs = sql.Select(Query3);
            for(int i = 0; Rs.next(); i++){
                recipient = recipient + ","+Rs.getString("email").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[][] productos = null;
        String detalle = "select p.nombre, det.sku, det.cantidad\n"
                       + "from ctacteclidet det \n"
                       + "left join producto p on p.sku = det.sku\n"
                       + "where nrodocto = "+NumFactura+" and tipdocto = 'FAC' and rut = "+Rut+"";
        try {
            Rs = sql.Select(detalle);
            Rs.last();
            productos = new String[Rs.getRow()][3];
            Rs.beforeFirst();
            for(int i = 0; Rs.next(); i++){
                productos[i][0]=Rs.getString("sku").trim();
                productos[i][1]=Rs.getString("nombre").trim();
                productos[i][2]=Rs.getString("cantidad").trim();  
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        String[] recipients = recipient.split(",");
        String sender = "despachos@luvaly.cl"; 
        String host = "127.0.0.1"; 

        // creating session object to get properties 
        Session session = Session.getDefaultInstance(props); 

        try { 
            // MimeMessage object. 
            MimeMessage message = new MimeMessage(session); 

            // Set From Field: adding senders email to from field. 
            message.setFrom(new InternetAddress(sender)); 

            // Set To Field: adding recipient's email to from field.
            for(int i = 0; i < recipients.length; i++){
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients[i]));
            }

            // Set Subject: subject of the email 
            message.setSubject("FACTURA N°: "+NumFactura+" - LUVALY SPA"); 

            // set body of the email. 
            String body =   "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "    <head>\n" +
                            "        <style>\n" +
                            "            body {\n" +
                            "                background-color: white;\n" +
                            "                text-decoration: none;\n" +
                            "                font-family:verdana;\n" +
                            "            }\n" +
                            "            #head {\n" +
                            "                letter-spacing: 2px;\n" +
                            "                text-transform: uppercase;\n" +
                            "                background-color: #b2ecff;\n" +
                            "                margin: auto;\n" +
                            "                width: 80%;\n" +
                            "                padding: 10px;\n" +
                            "                text-align: left;\n" +
                            "                color: #4CAF50;              \n" +
                            "            }\n" +
                            "            #factura {\n" +
                            "                color: red;\n" +
                            "            }\n" +
                            "            #body {\n" +
                            "                margin: auto;\n" +
                            "                width: 80%;\n" +
                            "                border: 1px solid #b2ecff;\n" +
                            "                padding: 10px;\n" +
                            "                text-align: left;\n" +
                            "                font-size: 15px;\n" +
                            "            }\n" +
                            "            #grande {\n" +
                            "                margin-left: 10px;\n" +
                            "                color: black;\n" +
                            "            }\n" +
                            "            #footer {\n" +
                            "                margin: auto;\n" +
                            "                width: 80%;\n" +
                            "                border: 1px solid #b2ecff;\n" +
                            "                padding: 10px;\n" +
                            "                text-align: left;\n" +
                            "                font-size: 10px;\n" +
                            "                letter-spacing: 0px;\n" +
                            "            }\n" +
                            "            #detalle {\n" +
                            "                margin: auto;\n" +
                            "                width: 80%;\n" +
                            "                border: 1px solid #b2ecff;\n" +
                            "                padding: 10px;\n" +
                            "                text-align: left;\n" +
                            "                font-size: 10px;\n" +
                            "                letter-spacing: 0px;\n" +
                            "            }\n" +
                            "            table {\n" +
                            "                width:100%;\n" +
                            "            }\n" +
                            "            table, th, td {\n" +
                            "                border: 1px solid b2ecff;\n" +
                            "                border-collapse: collapse;\n" +
                            "            }\n" +
                            "            th, td {\n" +
                            "                padding: 15px;\n" +
                            "                text-align: left;\n" +
                            "            }\n" +
                            "            #t01 tr:nth-child(even) {\n" +
                            "                background-color: #eee;\n" +
                            "            }\n" +
                            "                #t01 tr:nth-child(odd) {\n" +
                            "                background-color: #fff;\n" +
                            "            }\n" +
                            "            #t01 th {\n" +
                            "                background-color: #b2ecff;\n" +
                            "                color: black;\n" +
                            "            }\n" +
                            "        </style>\n" +
                            "    </head>\n" +
                            "    <body>\n" +
                            "        <div id=\"head\">\n" +
                            "            <span id=\"grande\"><b>FACTURA N° : </b></spanp><span id=\"factura\"><b>"+NumFactura+"</b></span><br>\n" +
                            "        </div>\n" +
                            "        <div id=\"body\">        \n" +
                            "            <span>Junto con saludar,\n" +
                            "            se envia factura número: "+NumFactura+",<br>\n" +
                            "            asociada a la Orden de Compra: "+CodigoOC+"-"+Orden+"<br>\n" +
                            "            <br>\n" +
                            "            \n" +
                            "        </div>\n" +
                            "        <br>\n" +
                            "        <div id=\"detalle\">\n" +
                            "            <span></span>\n" +
                            "            <table id=\"t01\">\n" +
                            "                <thead>\n" +
                            "                    <tr>\n" +
                            "                        <th>SKU</th>\n" +
                            "                        <th>Producto</th>\n" +
                            "                        <th>Cantidad</th>\n" +
                            "                    </tr>    \n" +
                            "                </thead>\n" +
                            "                <tbody>\n";
                            for(int o = 0; o < productos.length; o++){
                                body = body + "<tr>\n"
                                            + "<td>"+productos[o][0]+"</td>" 
                                            + "<td>"+productos[o][1]+"</td>"
                                            + "<td>"+productos[o][2]+"</td>"
                                            + "</tr>\n";
                            }
                            body = body + "  </tbody>\n" +
                            "            </table>\n" +
                            "        </div>\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <br>\n" +
                            "        <div id=\"footer\">\n" +
                            "            <span>Luvaly SPA<br>\n" +
                            "                Huerfanos 01871, Modulo 11, Temuco, Araucanía</span>\n" +
                            "        </div>\n" +
                            "    </body>\n" +
                            "</html>";

            String filename = Archivo;
            String[] file = Archivo.split("/");
            String def_file = file[file.length-1];
            DataSource source = new FileDataSource(filename); 
           // Send email. 
            BodyPart messageBodyPart1 = new MimeBodyPart(); 
            messageBodyPart1.setContent(body, "text/html;  charset=ISO-8859-1");
            BodyPart messageBodyPart2 = new MimeBodyPart();  
            messageBodyPart2.setDataHandler(new DataHandler(source));   
            messageBodyPart2.setFileName(def_file);
            
            Multipart multipartObject = new MimeMultipart();   
            multipartObject.addBodyPart(messageBodyPart1);   
            multipartObject.addBodyPart(messageBodyPart2);    
            System.out.println(recipient);
            message.setSentDate(new Date());
            message.setContent(multipartObject,  "text/html; charset=utf-8"); 
            
            Transport t = session.getTransport("smtp");
            t.connect(usuario, pass);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("Mail successfully sent"); 
            JOptionPane.showMessageDialog(null, "Facturación se envió correctamente");
        } 
        catch (MessagingException mex)  
        { 
           mex.printStackTrace(); 
        } 
    }
    
    private enum Columnas{Sku,Nombre,UM,Cantidad,Unitario,Total,UniReal};
    int PesoCorreccion=0;
        

    public pfFACCliente() {
        initComponents();
        SetTipo(-1);
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        btAgregar.setVisible(false);
        btEliminar.setVisible(false);
        cbReferencia.setVisible(false);
        txReferencia.setVisible(false);
        btPDF.setVisible(false);
        btMail.setVisible(false);
        btEmiteMan.setVisible(false);
        txRut.setEnabled(false);
        txRut.setEditable(false);
        btIr.setEnabled(false);
        
         //Despliega boton para emitir una Guia Manualmente
        if (fmMain.GetUsuarioAdministrador()){
            btEmiteMan.setVisible(true);
        }
        
        
        lbTipo.setVisible(false);
//        cbCodigoOc.setSelectedIndex(-1);
//        cbNroOrden.setSelectedIndex(-1);
        
        txTotalOCC.setVisible(false);
        txTotalFAC.setVisible(false);
        
      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        btCorrigePeso = new javax.swing.JButton();
        chk_esRefacturacion = new javax.swing.JCheckBox();
        btEmiteMan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbFolio = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dtEmision = new org.jdesktop.swingx.JXDatePicker();
        btPDF = new javax.swing.JButton();
        btMail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        txDv = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txComuna = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txCiudad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbTipoDespacho = new javax.swing.JComboBox();
        txObs = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbTipoPago = new javax.swing.JLabel();
        cbTipoPago = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        cbCodigoOc = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNroOrden = new javax.swing.JComboBox();
        txTotalFAC = new javax.swing.JTextField();
        txTotalOCC = new javax.swing.JTextField();
        btEliminar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txExento = new javax.swing.JTextField();
        txNeto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txIva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txImpEspecifico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGuias = new javax.swing.JList();
        btGuias = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        rbReferencia = new javax.swing.JCheckBox();
        cbReferencia = new javax.swing.JComboBox<String>();
        txReferencia = new javax.swing.JTextField();
        btEmitir = new javax.swing.JButton();
        chkSinGuia = new javax.swing.JCheckBox();
        chkSinOcc = new javax.swing.JCheckBox();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));

        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/add16.png"))); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setBorder(null);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/open16.png"))); // NOI18N
        btAbrir.setText("Abrir");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        jXLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OCCliente24.png"))); // NOI18N
        jXLabel1.setText("FACTURA CLIENTE");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btCorrigePeso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Peso16.png"))); // NOI18N
        btCorrigePeso.setText("Corrección");
        btCorrigePeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCorrigePesoActionPerformed(evt);
            }
        });

        chk_esRefacturacion.setText("Es Refacturacion");
        chk_esRefacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_esRefacturacionActionPerformed(evt);
            }
        });

        btEmiteMan.setText("Emite Manual");
        btEmiteMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmiteManActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCorrigePeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEmiteMan)
                .addGap(78, 78, 78)
                .addComponent(chk_esRefacturacion)
                .addContainerGap(732, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAbrir)
                        .addComponent(btCorrigePeso)
                        .addComponent(chk_esRefacturacion)
                        .addComponent(btEmiteMan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        add(pnMenu);

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("FACTURA");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 14, 56, -1));

        lbFolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFolio.setForeground(new java.awt.Color(255, 51, 51));
        jPanel4.add(lbFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 14, -1, -1));

        txEstado.setEditable(false);
        jPanel4.add(txEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 118, -1));

        jLabel5.setText("F. Emisión");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel6.setText("Estado");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        dtEmision.setBackground(new java.awt.Color(255, 255, 255));
        dtEmision.setEnabled(false);
        jPanel4.add(dtEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 145, -1));

        btPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/pdf.png"))); // NOI18N
        btPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDFActionPerformed(evt);
            }
        });
        jPanel4.add(btPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 21, 22));

        btMail.setText("Mail");
        btMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMailActionPerformed(evt);
            }
        });
        jPanel4.add(btMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 60, -1));

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "UM", "Cantidad", "V. Unitario", "Total Linea", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setResizable(false);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(1).setResizable(false);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(2).setResizable(false);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(3).setResizable(false);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(4).setResizable(false);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(5).setResizable(false);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 170));

        jLabel1.setText("Rut");

        txRut.setEnabled(false);
        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
        });

        txDv.setEditable(false);

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.setBorderPainted(false);
        btIr.setEnabled(false);
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        txNombre.setEnabled(false);

        jLabel9.setText("Dirección");

        txDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDireccionActionPerformed(evt);
            }
        });

        jLabel7.setText("Comuna");

        jLabel8.setText("Ciudad");

        jLabel16.setText("Despacho");

        cbTipoDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Directo" }));

        txObs.setEnabled(false);
        txObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txObsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txObsKeyTyped(evt);
            }
        });

        jLabel18.setText("Observación");

        lbTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTipo.setText("0");
        lbTipo.setToolTipText("");

        lbTipoPago.setText("Tipo Pago");

        cbTipoPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Eliga una opción", "Contado", "Crédito", "Sin Costo" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTipoDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTipoPago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txObs, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIr)
                    .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(cbTipoDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTipoPago))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(15, 15, 15))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel6.setPreferredSize(new java.awt.Dimension(239, 70));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbCodigoOc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCodigoOc.setSelectedIndex(-1);
        cbCodigoOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoOcActionPerformed(evt);
            }
        });
        jPanel6.add(cbCodigoOc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 14, 145, -1));

        jLabel3.setText("Código OC");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 19, -1, -1));

        jLabel4.setText("Nro Orden");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        cbNroOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNroOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNroOrdenActionPerformed(evt);
            }
        });
        jPanel6.add(cbNroOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 145, -1));

        txTotalFAC.setText("0");
        txTotalFAC.setToolTipText("");
        jPanel6.add(txTotalFAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 89, -1));

        txTotalOCC.setText("0");
        jPanel6.add(txTotalOCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 89, -1));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Cancel.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/add2.png"))); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel11.setText("Exento");

        txExento.setEditable(false);
        txExento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txExento.setText("0");

        txNeto.setEditable(false);
        txNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNeto.setText("0");

        jLabel10.setText("Neto");

        txIva.setEditable(false);
        txIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txIva.setText("0");

        jLabel12.setText("I.V.A.");

        txTotal.setEditable(false);
        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0");

        jLabel13.setText("TOTAL");

        jLabel14.setText("Imp. específico");

        txImpEspecifico.setEditable(false);
        txImpEspecifico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txImpEspecifico.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txNeto)
                    .addComponent(txIva)
                    .addComponent(txExento, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txTotal)
                    .addComponent(txImpEspecifico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txExento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txImpEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setViewportView(lstGuias);

        btGuias.setText("Editar");
        btGuias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuiasActionPerformed(evt);
            }
        });

        jLabel17.setText("Guias de Despacho");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btGuias))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGuias)
                .addGap(6, 6, 6))
        );

        rbReferencia.setText("Referencia Externa");
        rbReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReferenciaActionPerformed(evt);
            }
        });

        cbReferencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Orden de Compra", "Nota de Pedido", "Hoja Entrada Servicio", "Unidad de Pago (MOP)", "Sin Orden de Compra" }));
        cbReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReferenciaActionPerformed(evt);
            }
        });

        btEmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/derecha16.png"))); // NOI18N
        btEmitir.setText("Emitir");
        btEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmitirActionPerformed(evt);
            }
        });

        chkSinGuia.setText("Sin Referencia Guía Cliente");

        chkSinOcc.setText("Sin Referencia Orden Cliente");
        chkSinOcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSinOccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btAgregar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btEliminar))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbReferencia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(chkSinGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkSinOcc, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                            .addGap(73, 73, 73)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEmitir)))
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEmitir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btEliminar)
                                .addComponent(btAgregar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(chkSinGuia)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(rbReferencia)
                                    .addComponent(cbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(chkSinOcc))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
static private int GetCol(String Col){
        return Columnas.valueOf(Col).ordinal();
    }
//--------------------------------------------------------------------------------
// Funcion SET DE TIPOS
//--------------------------------------------------------------------------------
    private void SetTipo(int ElTipo){
        // NADA
        if(ElTipo==-1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          Habilita(false);
          Edicion(false);
          Limpia();
          txRut.setEnabled(true);
          txRut.setEditable(true);
          btIr.setEnabled(true);
          txRut.requestFocus();
          btCancelar.setEnabled(false);
          btGuardar.setEnabled(false);
          btNuevo.setEnabled(true);
          btEditar.setEnabled(false);
          btEmitir.setEnabled(false);
          btEmitir.setVisible(false);
          Tipo=-1;
          
        }
        // NUEVA ORDEN
        else if(ElTipo==1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
          btGuardar.setEnabled(true);
          btCancelar.setEnabled(true);
          btEditar.setEnabled(false);
          btNuevo.setEnabled(false);
          btEmitir.setEnabled(false);
          btEmitir.setVisible(false);

          Habilita(true);
          Edicion(true);
          Limpia();
          txRut.requestFocus();
          Tipo=1;
        }
        else if(ElTipo==2){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          //btEditar.setEnabled(true);
          btNuevo.setEnabled(true);
          btGuardar.setEnabled(false);
          btCancelar.setEnabled(false);
          btEmitir.setEnabled(true);
          btEmitir.setVisible(false);
          Habilita(true);
          Edicion(false);
          txRut.setEditable(true);
          Tipo=2;
        }
        else if(ElTipo==3){
            btEmitir.setEnabled(false);
            btEmitir.setVisible(false);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btEditar.setEnabled(false);
            btNuevo.setEnabled(false);
            Habilita(true);
            Edicion(true);
        }
    }
//--------------------------------------------------------------------------------
// EDICION
//--------------------------------------------------------------------------------
private void Edicion(boolean Estado){
    
//    txNroOc.setEditable(Estado);
    txDireccion.setEditable(Estado);
    txCiudad.setEditable(Estado);
    txComuna.setEditable(Estado);

    txRut.setEditable(Estado);
    txNombre.setEditable(Estado);
    txDv.setEditable(Estado);
  
    txNeto.setEditable(Estado);
    txExento.setEditable(Estado);
    txIva.setEditable(Estado);
    txTotal.setEditable(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
    
//    dtEmision.setEditable(Estado);

}
//--------------------------------------------------------------------------------
// LIMPIA
//--------------------------------------------------------------------------------
private void Limpia(){
    DefaultComboBoxModel dfCm = new DefaultComboBoxModel();
    DefaultTableModel   dfTm = (DefaultTableModel) Grilla.getModel();
   
    DefaultListModel dfLista = new DefaultListModel();
    txRut.setText("");
    txNombre.setText("");
    txDv.setText("");
    txNeto.setText("");
    txExento.setText("");
    txIva.setText("");
    txTotal.setText("");
    txDireccion.setText("");
    txComuna.setText("");
    txCiudad.setText("");
    txObs.setText("");
           

    cbCodigoOc.setModel(dfCm);
//    cbContacto.setModel(dfCm);
//    lstGuias.removeAll();
    cbTipoDespacho.setSelectedIndex(-1);
    lbFolio.setText("");
    dtEmision.setDate(null);
    txEstado.setText("");
    cbNroOrden.setSelectedIndex(-1);
    while(dfTm.getRowCount()>0)
    dfTm.removeRow(0);

    lstGuias.setModel(dfLista);
    
}    
//--------------------------------------------------------------------------------
// HABILITA
//--------------------------------------------------------------------------------
private void Habilita(boolean Estado){
    
    cbCodigoOc.setEnabled(Estado);
    cbNroOrden.setEnabled(Estado);
//    cbContacto.setEnabled(Estado);
//    btDetalleCon.setEnabled(Estado);
//    txNroOc.setEnabled(Estado);
    txDireccion.setEnabled(Estado);
    txCiudad.setEnabled(Estado);
    txComuna.setEnabled(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
   
    txRut.setEnabled(Estado);
    txNombre.setEnabled(Estado);
    txDv.setEnabled(Estado);
  
    //dtEmision.setEnabled(Estado);
    txNeto.setEnabled(Estado);
    txExento.setEnabled(Estado);
    txIva.setEnabled(Estado);
    txTotal.setEnabled(Estado);
    btIr.setEnabled(Estado);
    txEstado.setEnabled(Estado);
    cbTipoDespacho.setEnabled(Estado);
    //dtEmision.setEnabled(Estado);
    
}

    public void NuevaFactura(String Rut, String CodigoOc, String Numero){
    
        btNuevo.doClick();
        txRut.setText(Rut);
        btIr.doClick();
        int posOrden =0, posCodigoOC=0;
    
        for(int i=0 ; i < cbCodigoOc.getItemCount();i++){
            cbCodigoOc.setSelectedIndex(i);
            
            if(cbCodigoOc.getSelectedItem().toString().equals(CodigoOc) ){
             //   CargaDatosCodigoOC();
                posCodigoOC=i;
                break; 
            }
               
        }
    
        for(int i=0 ; i < cbNroOrden.getItemCount();i++){
            cbNroOrden.setSelectedIndex(i);
            cbNroOrden.getSelectedItem().toString();
            if(cbNroOrden.getSelectedItem().toString().equals(Numero) ){
                posOrden= i;
               break; 
            }   
        }
    
        cbCodigoOc.setSelectedIndex(posCodigoOC);
        cbNroOrden.setSelectedIndex(posOrden);
        
    }





    private void CargaProductosDesdeGuias(){
        DefaultTableModel   dfTm = (DefaultTableModel) Grilla.getModel();
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int j;
        boolean Existe;
        //Limpia
        while(dfTm.getRowCount()>0)
            dfTm.removeRow(0); 
        try { 
            for (int i = 0; i < lstGuias.getModel().getSize(); i++) {
           
                Existe = false;
                Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.valorunitario,d.totallinea\n"
                        + "from ctacteclidet d \n"
                        + "left join producto p on d.sku=p.sku\n"
                        + "left join par_unidad u on p.unidad=u.codigo\n"
                        + "where d.rut=" + txRut.getText() + "\n"
                        + "and d.tipdocto='GDC'\n"
                        + "and d.nrodocto=" + lstGuias.getModel().getElementAt(i).toString());
                while (Rs.next()) {
                    //Busca si el codigo ya fue cargado
                    for (j = 0; j < Grilla.getRowCount(); j++) {
                        if (Grilla.getValueAt(j, GetCol("Sku")).toString().equals(Rs.getString("sku"))) {
                            Existe = true;
                            break;
                        }
                    }
                    //Si existe suma las cantidades
                    if (Existe) {
                        
                        double Antes = Double.valueOf(Grilla.getValueAt(j, GetCol("Cantidad")).toString().replace(",", ""));
                        System.out.println(Antes);
                        Grilla.setValueAt((Antes + Rs.getDouble("cantidad")), j, GetCol("Cantidad"));
                        Antes =(Antes + Rs.getDouble("cantidad")) * Rs.getDouble("valorunitario");
                        Grilla.setValueAt(Antes, j, GetCol("Total"));
                        Existe = false;
                    
                    } //Si no existe, AGREGA EL PRODUCTO
                    else {
                        
                        dfTm.addRow(new Object[]{
                            Rs.getString("sku"),
                            Rs.getString("nombre"),
                            Rs.getString("um"),
                            fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                            fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                            fmMain.FormatoNumero(Rs.getDouble("totallinea")),
                            fmMain.FormatoNumero2(Rs.getDouble("valorunitario"))
                        });
                    }
                }
                
              
                Sumador();
                
                
                
               // System.out.println("PesoCorreccionFAC ES : " + PesoCorreccionFAC);
            }
        
        } catch (Exception e) {
                System.out.println("2" + e);
        }
        finally{
             Sql.Close();
        }

        
    }
    
    
    
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            Limpia();
            Habilita(false);
            txObs.setEnabled(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
        }
        
        else if(fmMain.OkCancel("¿Seguro de cancelar?")==JOptionPane.OK_OPTION){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            
        }
        
        
    }//GEN-LAST:event_btCancelarActionPerformed

    
    public void boton_nuevo(){
           Tipo=1;
        Limpia();
        Habilita(false);
        Edicion(false);
        txRut.setEnabled(true);
        txRut.setEditable(true);
        txEstado.setText("Sin Emitir");
        btIr.setEnabled(true);
        btAbrir.setEnabled(false);
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        cbTipoDespacho.setSelectedIndex(0);
    }
    public void setear_datos(String  rut, String codigo_oc, String orden){
        // Metodo que rescata el rut, codigo_oc y orden para abrir la factura con su guia
        // Seteo Rut
        txRut.setText(rut);
        btIr.doClick();
        cbCodigoOc.setSelectedItem(codigo_oc);
        cbNroOrden.setSelectedItem(orden);
        //btGuias.doClick();
    }
            
    
    
    
    
    
    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        Tipo=1;
        
        Limpia();
        Habilita(false);
        Edicion(false);
        txRut.setEnabled(true);
        txRut.setEditable(true);
        txEstado.setText("Sin Emitir");
        btIr.setEnabled(true);
        btAbrir.setEnabled(false);
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        cbTipoDespacho.setSelectedIndex(0);
    }//GEN-LAST:event_btNuevoActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txRutKeyPressed
//------------------------------------------------------------------------------
// Carga Cliente
//------------------------------------------------------------------------------
    private boolean CargaCliente(String Rut){
    ExeSql Sql = new ExeSql();
    ResultSet Rs;
    
        try {

            Rs = Sql.Select("select rut,dv,nombre\n"
                    + "from cliente\n"
                    + "where rut=" + Rut);

            Rs.next();
            txRut.setText(Rs.getString("Rut"));
            txDv.setText(Rs.getString("dv"));
            txNombre.setText(Rs.getString("nombre").trim());
            dtEmision.setDate(new Date());
            RutMaster = Rs.getString("Rut");
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            Sql.Close();
        }
    }
//------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc(String Rut) {
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbCodigoOc.setModel(cbMd);

        try {
           // Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            
            Rs = Sql.Select("select codigo_oc as codigo_oc from ctactecli \n" +
                            "where tipdocto='GDC' \n" +
                            "and rut="+Rut+"\n" +
                            "and estado = 1 \n" +
                            "and nrodocrel is null");
            
            
            while (Rs.next()) {
                cbMd.addElement(Rs.getString("codigo_oc"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Sql.Close();
        }

    }
    private void txDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDireccionActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty())
        if(JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el registro?") == JOptionPane.YES_OPTION){
            DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
            tbMd.removeRow(Grilla.getSelectedRow());
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();
        if(tbModel.getRowCount()<50){
            jdOCCAgregaProducto AgregaProducto = new jdOCCAgregaProducto(null,true);
            AgregaProducto.setLocationRelativeTo(null);
            AgregaProducto.setTitle("Agragar Producto");
            AgregaProducto.setVisible(true);
            tbModel.addRow(AgregaProducto.GetFila());
//        Sumador();
        }
        else {
            JOptionPane.showMessageDialog(null, "No se puede agregar más de 50 productos");
        }

    }//GEN-LAST:event_btAgregarActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        Habilita(false);
        Edicion(false);
        Limpia();
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr .setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        Tipo=2;
    }//GEN-LAST:event_btAbrirActionPerformed
    public void AbrirFactura(String Numero){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultListModel dfLista = new DefaultListModel();;
        
        try {
            Rs = Sql.Select("select c.femision,c.codigo_oc,c.occh,cc.direccion,cc.comuna,cc.ciudad,c.estado as EstadoInt, case c.estado when 0 then 'Sin Emitir' when 1 then 'Emitida' else 'Anulada' end as Estado, \n" +
                            "tipodespacho,observacion, c.tipo_pago " +   
                            "from ctactecli c\n" +
                            "left join clicontacto cc on c.rut=cc.rut and c.codigo_oc=cc.codigo_oc \n" +
                            "where c.tipdocto='FAC'\n" +
                            "and c.nrodocto=" + Numero);
            
            Rs.next();
            lbFolio.setText(Numero);
            txDireccion.setText(Rs.getString("direccion").trim());
            txComuna.setText(Rs.getString("comuna").trim());
            txCiudad.setText(Rs.getString("ciudad").trim());
            
            txObs.setText(Rs.getString("observacion").trim());
            txEstado.setText(Rs.getString("Estado"));
            
            if (Rs.getString("Estado").equals("Emitida")){
                btPDF.setVisible(true);
              //  btMail.setVisible(true);
            }
            else{
                btPDF.setVisible(false);
                btMail.setVisible(false);
            }
            dtEmision.setDate(Rs.getDate("femision"));
            cbTipoDespacho.setSelectedIndex(Rs.getInt("tipodespacho"));
            
            cbTipoPago.setSelectedIndex(Rs.getInt("tipo_pago"));
            
            
            
                btEmitir.setEnabled(true);
                btEmitir.setVisible(false);
              

            
            DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
            cbMd.addElement(Rs.getString("codigo_oc")); 
            cbCodigoOc.setModel(cbMd);

            DefaultComboBoxModel cbMd2 = new DefaultComboBoxModel();
            cbMd2.addElement(Rs.getString("occh")); 
            cbNroOrden.setModel(cbMd2);
            
            
            Rs = Sql.Select("select nrodocto \n" +
                            "from ctactecli\n" +
                            "where tipdocto='GDC'\n" +
                            "and tipdocrel='FAC'\n" +
                            "and nrodocrel=" + Numero);
            
            while(Rs.next()){
                dfLista.addElement(Rs.getString("nrodocto"));
            }
            lstGuias.setModel(dfLista);
            CargaProductosDesdeGuias();
            CargaReferenciaExterna(Numero);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
    }
    private void CargaReferenciaExterna(String NroDocto){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        try {
            Rs = Sql.Select("select cod_ref,doc_ref,fecha\n" +
                            "from fac_referencias\n" +
                            "where tipdocto='FAC'\n" +
                            "and nrodocto=" + NroDocto);
            if(Sql.GetRowCount()>0){
                Rs.next();
                rbReferencia.setSelected(true);
                cbReferencia.setSelectedIndex(Rs.getInt("cod_ref")-801);
                txReferencia.setText(Rs.getString("doc_ref").trim());
                cbReferencia.setVisible(true);
                txReferencia.setVisible(true);
            }
            else{
                cbReferencia.setVisible(false);
                txReferencia.setVisible(false);
                rbReferencia.setSelected(false);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
    }
    
    
    
    
    
    private void FindeAgno(){
        if(fmMain.GetFacNewYear()==1){
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date Fecha=df.parse("2015/12/31");
                dtEmision.setDate(Fecha);
                //dtEmision.setEditable(false);
                
            } catch (Exception e) {
            }
            
        }
            
        System.out.println("NewYear");
    }
    
    
    private void ActualizaFac(String NuevoFolio){
    
        boolean Carga;
        
        Carga=CargaCliente(txRut.getText());
       
        // Si cargó cliente 
        if(Carga){
            
            AbrirFactura(NuevoFolio);
            SetTipo(2);
          //VERIFICA NIVEL DE USUARIO PARA EDITAR FACTURA
            int pruebaUusario = 100;
            int intNivelUsuario = 0;
            intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
           
            if( intNivelUsuario == pruebaUusario){
        
                btEditar.setVisible(true);
            
            }else{
            
                btEditar.setVisible(false);
            }
        
        }else{
         
            txRut.setText("");
            txNombre.setText("");
            txRut.requestFocus();
        }
        
    }
    
    
    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        boolean Carga;
        if(!txRut.getText().isEmpty()){
            Carga=CargaCliente(txRut.getText());
            
        }
        else{
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            Carga=CargaCliente(BPC.GetRut());
        }
        
        // Si cargó cliente y es nuevo.
        if(Carga && (Tipo==1 || Tipo==-1) ){
            CargaCodOc(RutMaster);
            if(fmMain.GetFacNewYear()==1)
                FindeAgno();
            Habilita(true);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(false);
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
        
        }
        // Si cargó cliente y esta abriendo
        if(Carga && Tipo==2){
            
            jdAbrirDocumento ADoc = new jdAbrirDocumento(null, true);
                if(ADoc.ShowModal("FAC",RutMaster)==JOptionPane.YES_OPTION){
                    AbrirFactura(ADoc.GetNumero());
                    SetTipo(2);
                   //VERIFICA NIVEL DE USUARIO PARA EDITAR FACTURA
                    int pruebaUusario = 100;
                    int intNivelUsuario = 0;
                    intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
                    if( intNivelUsuario == pruebaUusario){
                         btEditar.setVisible(true);
                    }else{
                         btEditar.setVisible(false);
                    }
                }
                else{
                    txRut.setText("");
                    txNombre.setText("");
                    txRut.requestFocus();
                }
            
        }
        
            

    }//GEN-LAST:event_btIrActionPerformed
    private void cbCodigoOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoOcActionPerformed
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbNroOrden.setModel(cbMd);

        try {
            // --Carga Datos de Cliente
            Rs = Sql.Select("select giro,direccion,ciudad,comuna,region\n" +
                            "from clicontacto\n" +
                            "where rut=" + txRut.getText()+ " and codigo_oc=" + cbCodigoOc.getSelectedItem().toString());
            Rs.next();
            txDireccion.setText(Rs.getString("direccion").trim());
            txCiudad.setText(Rs.getString("ciudad").trim());
            txComuna.setText(Rs.getString("comuna").trim());
        
        }catch (Exception e) {
         
            System.out.println(e);
        }

        //--Carga Ordenes Pendientes de Despacho
        if (Tipo != 2) {
            
            try {
            
                Rs = Sql.Select("select occh as orden \n" +
                                "from ctactecli \n" +
                                "where tipdocto='GDC' \n" +
                                "and rut=" + txRut.getText() + "\n" +
                                "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + " \n" +
                                "and estado = 1 \n" +
                                "and nrodocrel is null");  //011713088

                while (Rs.next()) {
                    
                    cbMd.addElement(Rs.getString("orden").trim());
                }
                
            }catch (Exception e) {
             
                System.out.println(e);
            
            }finally{
                Sql.Close();
            }
        }
    }//GEN-LAST:event_cbCodigoOcActionPerformed

    private void cbNroOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNroOrdenActionPerformed
        
        if (cbCodigoOc.getSelectedItem() != null){
        
            ResultSet Rs;
            ExeSql Sql = new ExeSql();
       
            String Query =  "select tipo_pago\n" +
                            "from occh \n" +
                            "where rut=" + txRut.getText() + " \n"+
                            "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + " \n"+
                            "and orden='" + cbNroOrden.getSelectedItem().toString().trim() + "'";
            try{
                
                Rs = Sql.Select(Query);
                Rs.next();
            
                TipoPago = Rs.getInt("tipo_pago");
            
                cbTipoPago.setSelectedIndex(TipoPago);
                
                lbTipo.setText(""+TipoPago);
            
                
            } catch (Exception e) {
            
                System.out.println(e);
            }
        
        }
    }//GEN-LAST:event_cbNroOrdenActionPerformed
    public String getFechaAsString() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return( sdf.format( (dtEmision.getDate()).getTime() ) );
    }
    
    public boolean ExisteContactoFactura() {
        
        boolean existe = false;
        ExeSql sqlo = new ExeSql();
        ResultSet rss = null;
        
        try {
            
            rss = sqlo.Select("select cp.email \n" +
                              "from clicontactopersonas cp \n" +
                              "where cp.id_cargo = 8 \n" +
                              "and cp.codigo_oc = "+cbCodigoOc.getSelectedItem().toString()+" \n" +
                              "and cp.rut = "+txRut.getText()+"");
            
            if(rss.next()==false){
                
                existe = false;
                
                JOptionPane.showMessageDialog(null, "Cliente no posee contacto para facturación");
                
                if(JOptionPane.showConfirmDialog(null, "¿Desea Crearlo?")==0){
            
                    pfClientes Cli = new pfClientes();
                    pnPestanas.addTab("Nuevo Cliente", Cli);
                    PanelTab btc=new PanelTab(pnPestanas,0);
                    pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cli), btc);
                    pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
                    Cli.txRut.setText(txRut.getText());
                    Cli.btIr.doClick();
                
                }else {
 
                }
            
            }else {
            
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
       
        
        
        if(rbReferencia.isSelected() && txReferencia.getText().isEmpty()){
         
            fmMain.Mensaje("Ingrese referencia o Desactive Opción!!");
            return;
        }
            
            
        if(cbTipoPago.getSelectedIndex() == 0){
                
            fmMain.Mensaje("Debe Ingresar una forma de pago !!");
            return;
        }
            
            
        if (Grilla.getRowCount() == 0){
            
            fmMain.Mensaje("La Guia de Despacho no se cargó correctamente !!");
            return;
                
            
        }
        
        
         int items = Grilla.getRowCount();
        
        
        System.out.println("Los Items SON : "+items);
        
        if (items > 38){
        
            fmMain.Mensaje("No se puede Generar documento con mas de 38 items!!");
            return;
        
        }
        
//        double totalocc = Double.parseDouble(txTotalOCC.getText().trim());
//        double totalfacant = Double.parseDouble(txTotalFAC.getText().trim());
//        double totalgdactual = Double.parseDouble(txTotal.getText().trim().replaceAll("\\,", ""));
        
        
//        double totalfac = totalfacant + totalgdactual;
//       
//        if (totalfac > totalocc){
//        
//            fmMain.Mensaje("Total Factura(s) ( "+fmMain.FormatoNumeroSinDecimal(totalfac)+" ) es mayor al total de la Orden ( "+fmMain.FormatoNumeroSinDecimal(totalocc)+" )");
//            return;
//        
//        }
        
        
        
        if(fmMain.OkCancel("¿Guardar Documento?")== JOptionPane.OK_OPTION && ExisteContactoFactura()){
            
            ResultSet Rs;
        
            ExeSql Sql = new ExeSql();
            ExeSql Sql2 = new ExeSql();
            ExeSql Sql3 = new ExeSql();
            ExeSql Sql4 = new ExeSql();
            ExeSql Sql5 = new ExeSql();
            
            String Query = "";
            String Guia;
                        

            //Graba Nueva Factura
            if (Tipo == 1) {
                try {
                        //Obtiene Correlativo
                   
                    
                        String NewCorrelativo  = "";
                    
                        Rs = Sql.Select("select sp_getcorrelativo \n" +
                                        "from sp_getcorrelativo('FAC')");   
                        Rs.next();
                        NewCorrelativo  = Rs.getString("sp_getcorrelativo");
                        Rs.close();
                    
                        
                        
                     //**************************************************** // 
                    
//                      NewCorrelativo = "24";    //Folio Provisorio
                    
                  //*****************************************************//  
                        
                        if (lstGuias.getModel().getSize() > 1) {
                            Guia = "-99";
                        } else {
                            Guia = lstGuias.getModel().getElementAt(0).toString();
                        }
                        
                        
                        if(cbTipoPago.getSelectedIndex() == 1){
                
                            TipoPago = 1;
                            
                        }else if(cbTipoPago.getSelectedIndex() == 2){
                        
                        
                            TipoPago = 2;
                        
                        }else if(cbTipoPago.getSelectedIndex() == 3) {
                        
                            TipoPago = 3;
                        
                        }
                        

                        Query = " INSERT INTO ctactecli(\n"
                              + " rut, tipdocto, nrodocto, tipdocorigen, nrodocorigen, femision, \n"
                              + " totalexento, totalafecto, totaliva, totalimpespecifico,totaldocto,codigo_oc,occh,tipodespacho,observacion, tipo_pago)\n"
                              + " VALUES ("
                              + txRut.getText() + ","
                              + "'FAC',"
                              + NewCorrelativo + ","
                              + "'GDC',"
                              + Guia + ",'"
                              + getFechaAsString() + "',"
                              + fmMain.SetGuardar(txExento.getText().trim()) + ","
                              + fmMain.SetGuardar(txNeto.getText().trim()) + ","
                              + fmMain.SetGuardar(txIva.getText().trim()) + ","
                              + fmMain.SetGuardar(txImpEspecifico.getText().trim()) + ","
                              + fmMain.SetGuardar(txTotal.getText().trim()) + ","
                              + cbCodigoOc.getSelectedItem().toString().trim() + ",'"
                              + cbNroOrden.getSelectedItem().toString().trim() +  "'," + cbTipoDespacho.getSelectedIndex()+",'"+txObs.getText() +"',"+TipoPago+")";
                        
                        Sql2.ExeSql(Query);
                        Sql2.Commit();

                    // Actualiza Guias
                    for (int i = 0; i < lstGuias.getModel().getSize(); i++) {
                        
                        String NroGuia = lstGuias.getModel().getElementAt(i).toString();
                        Query = "update ctactecli set tipdocrel='FAC', nrodocrel=" + NewCorrelativo + " \n";
                                
                        if (chk_esRefacturacion.isSelected()){
                        
                            Query = Query + ",es_refacturacion = true " + " \n";    
                        }
                        
                        Query = Query + "where rut=" + txRut.getText() + " \n" +
                                        "and tipdocto='GDC' \n" +
                                        "and nrodocto=" + NroGuia;
                        
                        Sql3.ExeSql(Query);
                        Sql3.Commit();
                    }

                    for (int i = 0; i < Grilla.getRowCount(); i++) {
                        
                        Query = " INSERT INTO ctacteclidet(\n"
                                + " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n"
                                + " VALUES ("
                                + txRut.getText() + ","
                                + "'FAC',"
                                + NewCorrelativo + ",'"
                                + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString().trim() + "',"
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ")";
                        
                        Sql4.ExeSql(Query);
                        Sql4.Commit();
                    
                    }
                    
                    //Agrega Referencias externas 
                    
                    if(rbReferencia.isSelected()){
                        
                        int CodRef = cbReferencia.getSelectedIndex() + 801;
                        
                        if (cbReferencia.getSelectedIndex()==2){
                            
                            CodRef = 10801;  //Hoja Entrada Servicio
                        }
                        
                        if (cbReferencia.getSelectedIndex()==3){
                            
                            CodRef = 20801;    //Unidad de Pago (MOP)
                        }
                        
                        Sql5.ExeSql("insert into fac_referencias\n" +
                                   "(rut,tipdocto,nrodocto,cod_ref,doc_ref) values\n" +
                                   "("+ txRut.getText() +",'FAC',"+ NewCorrelativo +"," + CodRef + ",'"+ txReferencia.getText().trim() +"')");
                        Sql5.Commit();
                    }
                    
                    
                    JOptionPane.showMessageDialog(null, "Guardado");
                        
                   
                    lbFolio.setText(NewCorrelativo);
                    SetTipo(2);
                    
                    txObs.setEnabled(false);
          
            //************************************************************************************************************************//          
                    Emitir_Factura();
                    
                    ActualizaFac(NewCorrelativo);
                    
                    
                    if (txRut.getText().equals("76440015") || txRut.getText().equals("77244658") ){   //ECONA o DISOSUR
                    
                        Verifica_Saldo_Occ(cbCodigoOc.getSelectedItem().toString().trim(), cbNroOrden.getSelectedItem().toString().trim());
                    
                    }
            //************************************************************************************************************************//                  
                    
                } catch (Exception e) {
                    Sql2.Rollback();
                    Sql3.Rollback();
                    Sql4.Rollback();
                    Sql5.Rollback();
                    
                    
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally {
                    Sql2.Close();
                    Sql3.Close();
                    Sql4.Close();
                    Sql5.Close();
                    
                }

            }else {  //Graba cambios Factura existente
                
                try {
                    Query = "UPDATE ctactecli SET "
                            + "tipdocorigen='OCC', "
                            + "nrodocorigen=" + cbNroOrden.getSelectedItem().toString().trim() + ","
                            + "occh = " + cbNroOrden.getSelectedItem().toString().trim() + ","
                            + "femision='" + getFechaAsString() + "',"
                            + "totalexento=" + txExento.getText().trim() + ","
                            + "totalafecto=" + txNeto.getText().trim() + ","
                            + "totaliva=" + txIva.getText().trim() + ","
                            + "totaldocto=" + txTotal.getText().trim() + " "
                             + "tipodespacho= " + cbTipoDespacho.getSelectedIndex() + " "
                            + "WHERE tipdocto='GDC' "
                            + "AND nrodocto=123456 "
                            + "AND rut=" + txRut.getText();

                    Sql.ExeSql(Query);
                    System.out.println("Guarda Encabezado");

                    Query = "DELETE FROM ctacteclidet "
                            + "WHERE tipdocto='GDC' "
                            + "AND   nrodocto=123456 "
                            + "AND   rut=" + txRut.getText();
                    Sql.ExeSql(Query);

                    for (int i = 0; i < Grilla.getRowCount(); i++) {
                        Query = " INSERT INTO ctacteclidet(\n"
                                + " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n"
                                + " VALUES ("
                                + txRut.getText() + ","
                                + "'GDC',"
                                + "123456,'"
                                + Grilla.getModel().getValueAt(i, 0).toString() + "',"
                                + Grilla.getModel().getValueAt(i, 3).toString() + ","
                                + Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString() + ","
                                + Grilla.getModel().getValueAt(i, 5).toString() + ")";

                        Sql.ExeSql(Query);
                    }
                    
                    Sql.Commit();
                    
                    
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally{
                    Sql.Close();
                }
            }
            
        }
        
       
    }//GEN-LAST:event_btGuardarActionPerformed
    //--------------------------------------------------------------------------------
    // SUMADOR
    //--------------------------------------------------------------------------------
    private void Sumador(){    
        
        double Neto=0;
        double Neto2=0;
        double Exento=0;
        double Iva=0;
        double Total=0;
        String Unitario,Cantidad;
    
        for(int i=0; i< Grilla.getRowCount(); i++){
            Unitario = Grilla.getModel().getValueAt(i,GetCol("UniReal")).toString();
            Cantidad = Grilla.getModel().getValueAt(i,GetCol("Cantidad")).toString();
            Unitario = Unitario.replace(fmMain.GetMiles(), "");
            Cantidad = Cantidad.replace(fmMain.GetMiles(), "");
            Neto =  (Double.parseDouble(Unitario) * Double.parseDouble(Cantidad)) + Neto;
        }
        
        //Neto = Math.round(Neto);
        Iva = Math.round((Neto * Double.parseDouble("0.19")));
   
        System.out.println("PesoCorreccion ES : "+PesoCorreccion);
        
        if(PesoCorreccion != 0){
        
            if(PesoCorreccion==1){
                
                Iva = Iva + 1;
            
            }else{
                            
                Neto = Neto - 1;
            
            }
        }
    
        Total = Neto + Iva;
        
        txNeto.setText(fmMain.FormatoTotal(Neto));
        txExento.setText(fmMain.FormatoTotal(Exento));
        txIva.setText(fmMain.FormatoTotal(Iva));
        txTotal.setText(fmMain.FormatoTotal(Total));
    }
//------------------------------------------------------------------------------
//  
//------------------------------------------------------------------------------
    
    private void Verifica_Saldo_Occ(String codigo_oc, String orden){
    
            
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
       
        
        try{
                
                Rs = Sql.Select("select * from occhdet \n" +
                                "where rut=" + txRut.getText() + " \n"+
                                "and codigo_oc=" + codigo_oc + " \n"+
                                "and orden='" + orden + "'");
                
                
                if (Sql.GetRowCount() > 0){
                
                    while (Rs.next()){
                    
                        int cantidad = Rs.getInt("cantidad");
                        int facturado = Rs.getInt("facturado");
                        String Sku = Rs.getString("sku").trim(); 
                        
                        System.out.println("LA cantidad ES : "+cantidad);
                        System.out.println("LO facturado ES : "+facturado);
                        System.out.println("EL Sku ES : "+Sku);
                        
                        
                        if(cantidad > facturado ){
                        
                            
                            if (facturado > 0){
                               
                                Sql2.ExeSql("UPDATE occhdet SET \n" +
                                           "cantidad = " + facturado + "\n" +
                                           "WHERE rut= " + txRut.getText() + " \n" +  
                                           "AND codigo_oc=" + codigo_oc + "\n" +
                                           "AND orden='" + orden + "'\n" +
                                           "AND sku='" + Sku + "'");
                                
                            }else if (facturado == 0){
                            
                                Sql2.ExeSql("DELETE FROM occhdet \n" +
                                            "WHERE rut= " + txRut.getText() + " \n" +
                                            "AND codigo_oc=" + codigo_oc + "\n" +
                                            "AND orden='" + orden + "'\n" +
                                            "AND sku='" + Sku+ "'");
                            
                            }
                          
                            Sql2.Commit();
                        
                        }
                        
                    
                    }
                    
                    
                    Sql3.ExeSql("UPDATE occh SET \n" + 
                                "estado = 2, \n" +
                                "estadodespacho = 2 \n" +
                                "WHERE rut= " + txRut.getText() + " \n" +
                                "AND codigo_oc=" + codigo_oc + "\n" +
                                "AND orden='" + orden + "'");
                    
                    Sql3.Commit();
                    
                }
                
        } catch (SQLException e) {
            
            Sql2.Rollback();
            Sql3.Rollback();
            
            System.out.println(e);
        
        }finally{
            
            Sql.Close();
            Sql2.Close();
            Sql3.Close();
        
        }
    
    
    }
    
    
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        double prec;    
        if(evt.getClickCount()==2 && !Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty() && Tipo == 1){
            jdIngresaNumero2 jdNumero = new jdIngresaNumero2(null, true);
            jdNumero.setLocationRelativeTo(null);
            
            prec = Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Unitario")).toString()));
            jdNumero.SetPrecio(prec);
            jdNumero.setVisible(true);        
            
//            if(jdNumero.GetNumero() != -99 ){
//                Grilla.setValueAt(jdNumero.GetNumero(), Grilla.getSelectedRow(),3);
//                Grilla.setValueAt(Float.parseFloat(Grilla.getModel().getValueAt(Grilla.getSelectedRow(),3).toString()) * Float.parseFloat(fmMain.SetGuardar(Grilla.getModel().getValueAt(Grilla.getSelectedRow(),4).toString())), Grilla.getSelectedRow(),5);
//                Sumador();
//            }
       
        
         if(jdNumero.GetNumero() != -99 ){
                
                Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetPrecio()), Grilla.getSelectedRow(), GetCol("Unitario"));
                Grilla.setValueAt(jdNumero.GetPrecio(), Grilla.getSelectedRow(), GetCol("UniReal"));
                
                double Total = Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Cantidad")).toString())) * Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("UniReal")).toString()));
                
                Grilla.setValueAt(fmMain.FormatoNumero(Total), Grilla.getSelectedRow(), GetCol("Total"));
                Sumador();
            }
        
        
        
        
        
        
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void btEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmitirActionPerformed

        Emitir_Factura();
//        ExeSql Sql = new ExeSql();
//        
//        try {
//            
//            Sql.ExeSql("update ctactecli set estado=1 where tipdocto='FAC' and nrodocto=" + lbFolio.getText().trim());
//            Sql.Commit();
//            //GeneraDTE.Generar(txRut.getText().trim(),"FAC" ,lbFolio.getText().trim());
//            GeneraDTE_FTP.Generar(txRut.getText().trim(),"FAC" ,lbFolio.getText().trim());
//            
//            
//            JOptionPane.showMessageDialog(null,"Documento Emitido");
//            btEmitir.setEnabled(false);
//            btEmitir.setVisible(false);
//            txEstado.setText("Emitido");
//            btEditar.setEnabled(false);
//        } catch (SQLException ex) {
//            fmMain.Mensaje("se produjo un error en el proceso: "+ex.getMessage());
//            Sql.Rollback();
//        } finally{
//            Sql.Close();
//        }
//        
       
       
    }//GEN-LAST:event_btEmitirActionPerformed
    
    private void Emitir_Factura(){
        
       
        
        Runnable miRunnable = new Runnable() {
            
            public void run() {
                try{
                    ExeSql Sql = new ExeSql();
                    
                    
                    try {
                      
                        Sql.ExeSql("update ctactecli set estado=1 where tipdocto='FAC' and nrodocto=" + lbFolio.getText().trim());
                        Sql.Commit();
                        
                        if (chkSinGuia.isSelected()){
                        
                                refGuia = 0;    //Sin Guia Cliente como referencia
                        
                        }else if (!chkSinGuia.isSelected()){ 
                                                        
                                refGuia = 1;     //Con Guia como Referencia
                        }
                        
                        
                        
                        if (chkSinOcc.isSelected()){
                        
                                refOcc = 0;     //Sin Orden Cliente como referencia
                        
                        }else if (!chkSinOcc.isSelected()){ 
                                                        
                                refOcc = 1;
                        }
                        
                        GeneraDTE_FAC(txRut.getText().trim(),"FAC",lbFolio.getText().trim(),refGuia,refOcc);
                        
                       
                        JOptionPane.showMessageDialog(null,"Documento Emitido");
                        
                        btPDF.setVisible(true);

                        btEmitir.setEnabled(false);
                        btEmitir.setVisible(false);
                        txEstado.setText("Emitido");
                        btEditar.setEnabled(false);
                        
                    } catch (SQLException ex) {
                        fmMain.Mensaje("se produjo un error en el proceso: "+ex.getMessage());
                        Sql.Rollback();
                       
                    } finally{
                        Sql.Close();
                       
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                   // MailRápido();    
                }
            }

            
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        
        
    }
    
    
    
    private void GeneraDTE_FAC(String ParRut,String ParTipo, String ParNumero,int ParGDC, int ParOCC){
    
        File factura = null;
        
       // boolean Resultado=true;
        String Rut = ParRut;
        String Tipo = ParTipo;
        String Numero = ParNumero;
        int parOCC = ParOCC;
        int parGDC = ParGDC;
        
        String TipoNro = "";
        String TipoPago = "1";  //Contado
        String TipoPagoGlosa = "contado";  //Contado
        
        String ElRut = "";
        String ElNombre = "";
        String ElGiro = "";
        String LaDireccion = "";
        String LaComuna = "";
        String LaCiudad = "";
        String LaObservacion = "";
        
        String Fecha = "";
        
        String ElAfecto = "";
        String ElIva = "";
        String ElTotal = "";
        
        String FolioRef = "";
        String FechaGDC = "";
                        
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ExeSql Sql4 = new ExeSql();
        ExeSql SqlLuv = new ExeSql();
        
        ResultSet Rs, Rs2, Rs3,Rs4, RsLuv = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
      
        Document doc= new Document();  
        
        try {
              
            File directorio = new File("C:\\temp_luvaly\\");  

            if (!directorio.exists()){

                directorio.mkdir();

            }
            
            
            File directorio2 = new File("C:\\doc_luvaly\\");  

            if (!directorio2.exists()){

                directorio2.mkdir();

            }
            
        
            Rs = Sql.Select("select c.* from ctactecli c \n"+
                           "left join caja_ventas cv ON c.rut = cv.rut and c.nrodocto = cv.nrodocto \n"+ 
                           "where c.tipdocto='" + Tipo +"' and c.nrodocto=" + Numero);
            Rs.next();
        
            switch (Tipo){
                case "GDC": TipoNro="52"; break;
                case "FAC": TipoNro="33"; break;
                case "NCC": TipoNro="61"; break;
                case "NDC": TipoNro="56"; break;
                case "FEC": TipoNro="34"; break;
                case "BOC": TipoNro="39"; break;
            }
            
            
            if (!Rs.getString("tipo_pago").equals("2")){   //Si no es Crédito
            
                 TipoPago = "1";
                 TipoPagoGlosa = "contado";
            
            }else if (Rs.getString("tipo_pago").equals("2")) {   //Si es Crédito
            
                TipoPago = "2";
                TipoPagoGlosa = "crédito";
            
            }
            
            
            
            Fecha = sdf.format(Rs.getDate("femision"));
            
            Namespace ns= Namespace.getNamespace("http://www.sii.cl/SiiDte");
            
            
            //Document doc= new Document();    
            
                Element root=new Element("DTE").setAttribute("version", "1.0");
                //root.setAttribute("encoding","UTF-8");
                root.setNamespace(ns);
                
                    Element documento=new Element("Documento").setAttribute("ID","F"+lbFolio.getText().trim()+"T"+TipoNro);
                    documento.setNamespace(ns);
        
                        Element encabezado=new Element("Encabezado"); 
                        encabezado.setNamespace(ns);
        
                            Element Iddoc=new Element("IdDoc").setNamespace(ns); 
                                            
                                Iddoc.addContent(new Element("TipoDTE").addContent(TipoNro).setNamespace(ns));
                                Iddoc.addContent(new Element("Folio").addContent(lbFolio.getText().trim()).setNamespace(ns));
                                Iddoc.addContent(new Element("FchEmis").addContent(Fecha).setNamespace(ns));
                                Iddoc.addContent(new Element("FmaPago").addContent(TipoPago).setNamespace(ns));
                                Iddoc.addContent(new Element("TermPagoCdg").addContent("0").setNamespace(ns));
                                Iddoc.addContent(new Element("TermPagoGlosa").addContent(TipoPagoGlosa).setNamespace(ns));
                                
                            Element Emisor=new Element("Emisor").setNamespace(ns); 
                                
                                Emisor.addContent(new Element("RUTEmisor").addContent("76231391-K").setNamespace(ns));
                                Emisor.addContent(new Element("RznSoc").addContent("EMPRESA COMERCIALIZADORA LUIS VALDES LYON S.P.A.").setNamespace(ns));
                                Emisor.addContent(new Element("GiroEmis").addContent("COMERCIALIZADORA DE ARTICULOS DE FERRETERIA").setNamespace(ns));
                                Emisor.addContent(new Element("Telefono").addContent("+56(45)2658390").setNamespace(ns));
                                Emisor.addContent(new Element("CorreoEmisor").addContent("contacto@luvaly.cl").setNamespace(ns));
                                Emisor.addContent(new Element("Acteco").addContent("464909").setNamespace(ns));
                                Emisor.addContent(new Element("Acteco").addContent("466302").setNamespace(ns));
                                Emisor.addContent(new Element("DirOrigen").addContent("AVENIDA HUERFANOS 01871").setNamespace(ns));
                                Emisor.addContent(new Element("CmnaOrigen").addContent("TEMUCO").setNamespace(ns));
                                Emisor.addContent(new Element("CiudadOrigen").addContent("TEMUCO").setNamespace(ns));
                                
                                
                        //**************************************************************** DATOS CLIENTE ******************************************************************//        
                                
                                String Query = "select d.rut || '-' || co.dv as rut, co.nombre,c.giro,c.direccion,c.ciudad,c.comuna, d.observacion \n"+
                                               "from ctactecli d \n"+
                                               "left join cliente co on co.rut=d.rut \n"+
                                               "left join clicontacto c on d.rut=c.rut and d.codigo_oc = c.codigo_oc\n"+
                                               "where d.rut=" + Rut + "\n"+
                                               "and d.tipdocto='" + Tipo + "'\n"+
                                               "and d.nrodocto=" + Numero;
                                //System.out.println(Query);   
                                Rs2 = Sql2.Select(Query);
                                Rs2.next();

                                ElRut = Rs2.getString("rut").trim();
                                
                               // ElNombre = Rs2.getString("Nombre").trim().replaceAll("\\&", "&amp;");
                                ElNombre = Rs2.getString("Nombre").trim();
                                
                                
                                
                                if(Rs2.getString("giro").trim().length()>40){
                                    
                                     ElGiro = Rs2.getString("giro").substring(0, 40).trim();
                                    
                                }else{
                                    
                                    ElGiro = Rs2.getString("giro").trim();
                                
                                }    
                                
                                LaDireccion = Rs2.getString("direccion").trim();
                                LaComuna= Rs2.getString("comuna").trim();
                                LaCiudad = Rs2.getString("ciudad").trim();
                                LaObservacion = Rs2.getString("observacion").trim();
                                
                                
                                 ElNombre = Rs2.getString("Nombre").trim().replaceAll("\\&", "&amp;");
                                
                        //**************************************************************************************************************************************************//    
                            Element Receptor=new Element("Receptor").setNamespace(ns); 
                                            
                                Receptor.addContent(new Element("RUTRecep").addContent(ElRut).setNamespace(ns));
                                Receptor.addContent(new Element("RznSocRecep").addContent(ElNombre).setNamespace(ns));
                                Receptor.addContent(new Element("GiroRecep").addContent(ElGiro).setNamespace(ns));    
                                Receptor.addContent(new Element("DirRecep").addContent(LaDireccion).setNamespace(ns));    
                                Receptor.addContent(new Element("CmnaRecep").addContent(LaComuna).setNamespace(ns));    
                                Receptor.addContent(new Element("CiudadRecep").addContent(LaCiudad).setNamespace(ns));    
                                
                        //**************************************************************** TOTALES DOCUMENTO ******************************************************************//   
                                
                          ElAfecto = Rs.getString("totalafecto");
                          ElIva = Rs.getString("totaliva");
                          ElTotal = Rs.getString("totaldocto");
                                
                                
                                
                            Element Totales=new Element("Totales").setNamespace(ns); 
                                  
                                
                                System.out.println("totalafecto ES  :"+ElAfecto);
                                
                                Totales.addContent(new Element("MntNeto").addContent(ElAfecto).setNamespace(ns));
                                Totales.addContent(new Element("TasaIVA").addContent("19").setNamespace(ns));
                                Totales.addContent(new Element("IVA").addContent(ElIva).setNamespace(ns));
                                Totales.addContent(new Element("MntTotal").addContent(ElTotal).setNamespace(ns));
                                    
                        encabezado.addContent(Iddoc);
                        encabezado.addContent(Emisor);
                        encabezado.addContent(Receptor);
                        encabezado.addContent(Totales);
                
                    documento.addContent(encabezado);    
             
                    //************************************************* VERIFICA DIFERENCIA EN LOS SUBTOTALES Y NETO  **************************************************************************************//             
                    
                    Verifica_Netos(Tipo, Rut, Numero,ElAfecto );
                    
                    int difpaso = 0;
                    int unidesc = 0;
                    
                    
                    System.out.println("productos ES  :"+productos);
                    System.out.println("dif ES  :"+dif);
                    
                    difpaso = dif;
                    
                    
                    
                    if (productos >= dif){
                    
                        unidesc = 1;
                    
                    
                    }
                    
                    
                    if(dif < 0){
                        
                       dif = dif * -1;
                    }
                    
                    
                    
                    //**************************************************************** DETALLE PRODUCTOS ******************************************************************//   
                    
                     String LaLinea = "";
                    
                    
                    Rs3 = Sql3.Select("select d.sku,d.cantidad,d.valorunitario,d.totallinea\n" +
                            "from ctacteclidet d\n" +
                            "where d.tipdocto='"+ Tipo +"'\n" +
                            "and d.rut="+ Rut +"\n" +
                            "and d.nrodocto=" + Numero);
                   
                    int linea = 1;   //Establece le número de linea de cada producto
                                     
                    
                    while(Rs3.next()){ //Una iteración por producto
                    
                        RsLuv = SqlLuv.Select("SELECT p.nombre, u.um FROM producto p \n"+
                                      "LEFT JOIN par_unidad u ON u.codigo=p.unidad\n "+
                                      "WHERE p.sku = '"+Rs3.getString("sku").trim()+"'");
                        RsLuv.next();
               
                        String ElSku = Rs3.getString("sku");
                        String ElProd = RsLuv.getString("nombre").trim();
                        String LaCantidad = fmMain.FormatoNumero3(Rs3.getDouble("cantidad"));
                        String LaUnidad = RsLuv.getString("um");
                        String ElUnitario = fmMain.FormatoNumero4(Rs3.getDouble("valorunitario"));
                        System.out.println("ElUnitario ES  :"+ElUnitario);
                        
                        if (linea > dif){
                        
                           unidesc = 0;
                            
                        }
                        
                        
                        
                        if (difpaso > 0){
                        
                        
                            LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario"))-unidesc);
                        
                        
                        }else if (difpaso < 0) {
                        
                            LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario"))+unidesc);
                                                
                        }else if (difpaso == 0){
                        
                            LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario")));
                        }
                        
                        
                        Element Detalle=new Element("Detalle").setNamespace(ns);
                        
                           
                            String nLinea = String.valueOf(linea);    
                            
                            Detalle.addContent(new Element("NroLinDet").addContent(nLinea).setNamespace(ns));
                            
                            Element CdgItem=new Element("CdgItem").setNamespace(ns);  //Tipo Codificacion para los items
                                
                                CdgItem.addContent(new Element("TpoCodigo").addContent("INT1").setNamespace(ns));
                                CdgItem.addContent(new Element("VlrCodigo").addContent(ElSku).setNamespace(ns));
                            
                            Detalle.addContent(CdgItem);       
                            
                            Detalle.addContent(new Element("NmbItem").addContent(ElProd).setNamespace(ns));
                            Detalle.addContent(new Element("QtyItem").addContent(LaCantidad).setNamespace(ns));
                            Detalle.addContent(new Element("UnmdItem").addContent(LaUnidad).setNamespace(ns));
                            Detalle.addContent(new Element("PrcItem").addContent(ElUnitario).setNamespace(ns));
                            Detalle.addContent(new Element("MontoItem").addContent(LaLinea).setNamespace(ns));
                            
                            linea++;
                            
                        documento.addContent(Detalle);
                    }
                    
                    
                    
                   //******************************************* SE AGREGAN OBSERVACIONES SI CORRESPONDE *************//  
                    
                    
                    if (!LaObservacion.trim().isEmpty()){
                    
                        Element DetalleObs=new Element("Detalle").setNamespace(ns);
                    
                        String nLineaObs = String.valueOf(linea);
                    
                        DetalleObs.addContent(new Element("NroLinDet").addContent(nLineaObs).setNamespace(ns));
                        DetalleObs.addContent(new Element("NmbItem").addContent("Observación:").setNamespace(ns));
                        DetalleObs.addContent(new Element("DscItem").addContent(LaObservacion).setNamespace(ns));
                        DetalleObs.addContent(new Element("MontoItem").addContent("0").setNamespace(ns));
                    
                        documento.addContent(DetalleObs); 
                    
                    }
  
                    
        //*************************************** AGREGAR REFERENCIA DOCUMENTOS INTERNOS *************************************************//
                    
                    int lineaRef = 1;   //Establece le número de linea de cada Referencia  
                
                    
                //********************************************* GUIAS ************************************************//    
                    int Cont = 0;
                    
                    if (parGDC == 1){   //Lleva GUIA de referenca
                    
                    
                        Rs4 = Sql4.Select("select * from ctactecli where tipdocto IN ('GDC') and tipdocrel IN ('FAC') \n"+
                                          "and nrodocrel =" + Numero);
        
                        while (Rs4.next() && Cont < 21) {
                    
                            FolioRef = Rs4.getString("nrodocto");
                            FechaGDC = sdf.format(Rs4.getDate("femision"));
                    
                            Element Referencia=new Element("Referencia").setNamespace(ns);
                    
                                String nLineaRef = String.valueOf(lineaRef); 
                        
                                Referencia.addContent(new Element("NroLinRef").addContent(nLineaRef).setNamespace(ns));
                                Referencia.addContent(new Element("TpoDocRef").addContent("52").setNamespace(ns));
                                Referencia.addContent(new Element("FolioRef").addContent(FolioRef).setNamespace(ns));
                                Referencia.addContent(new Element("FchRef").addContent(FechaGDC).setNamespace(ns));
                          
                                lineaRef++;
                            
                            documento.addContent(Referencia);
                    
                            Cont++;
                    
                        }
                    
                    }
                    
                    //****************************************** OCC ******************************************************//
                
                
                    if (parOCC == 1){    //Lleva OCC de referencia Interna
                
                        Rs = Sql.Select("select oc.codigo_oc || '-' || oc.orden as folio, oc.femision \n"
                                      + "from ctactecli c\n"
                                      + "left join occh oc on c.rut=oc.rut and c.codigo_oc=oc.codigo_oc and c.occh=oc.orden\n"
                                      + "where c.tipdocto='" + Tipo + "'\n"
                                      + "and c.nrodocto=" + Numero);
                        Rs.next();
                
                        if(Rs.getString("folio").trim().length()>18){
                            FolioRef = Rs.getString("folio").substring(0, 18).trim();
                        }else{
                            FolioRef = Rs.getString("folio").trim();
                        }    
                           
                        String FechaOCC = sdf.format(Rs.getDate("femision"));
                    
                            
                        Element Referencia2=new Element("Referencia").setNamespace(ns); 
                            
                            
                                String nLineaRef2 = String.valueOf(lineaRef); 
                        
                                Referencia2.addContent(new Element("NroLinRef").addContent(nLineaRef2).setNamespace(ns));
                                Referencia2.addContent(new Element("TpoDocRef").addContent("801").setNamespace(ns));
                                Referencia2.addContent(new Element("FolioRef").addContent(FolioRef).setNamespace(ns));
                                Referencia2.addContent(new Element("FchRef").addContent(FechaOCC).setNamespace(ns));
                            
                        documento.addContent(Referencia2);        
                                        
                    }
                    
        //*************************************** AGREGAR REFERENCIA DOCUMENTOS EXTERNOS *************************************************//     
                    
                    lineaRef++;
                    
                    Rs = Sql.Select("select cod_ref,doc_ref,fecha\n" +
                                    "from fac_referencias\n" +
                                    "where tipdocto='FAC'\n" +
                                    "and nrodocto=" + Numero);
                
                    if(Sql.GetRowCount()>0){
                
                        while(Rs.next()){
                    
                            String TipoDocumento = Rs.getString("cod_ref").trim();
                    
                            switch (TipoDocumento){
                                case "801"  : TipoDocumento="801"; break;   //Orden de Compra
                                case "802"  : TipoDocumento="802"; break;   //Nota de Pedido
                                case "10801": TipoDocumento="HES"; break;   //Hoja Entrada Servicio
                                case "20801": TipoDocumento="UDP"; break;   //Unidad de Pago (Mop)
                            }
                    
                            
                            //805 = Proceso ChileCompra
                            
                            FolioRef = Rs.getString("doc_ref").trim();
                            String FechaRef = sdf.format(Rs.getDate("fecha"));
                            
                           
                            
                            Element Referencia3=new Element("Referencia").setNamespace(ns); 
                            
                                String nLineaRef2 = String.valueOf(lineaRef); 
                        
                                Referencia3.addContent(new Element("NroLinRef").addContent(nLineaRef2).setNamespace(ns));
                                Referencia3.addContent(new Element("TpoDocRef").addContent(TipoDocumento).setNamespace(ns));
                                Referencia3.addContent(new Element("FolioRef").addContent(FolioRef).setNamespace(ns));
                                Referencia3.addContent(new Element("FchRef").addContent(FechaRef).setNamespace(ns));
                            
                                lineaRef++;
                            
                            documento.addContent(Referencia3);        
                            
                        }
                    }
                    
                    
                    
                    
                    
                    
            root.addContent(documento);
        doc.setRootElement(root);

       
//Se genera el archivo XML 
//        XMLOutputter outter=new XMLOutputter();
//        outter.setFormat(Format.getPrettyFormat());
//        factura = new File("C:/temp_luvaly/mifactura.xml");
//        outter.output(doc, new FileWriter(factura));   
    
    }catch (SQLException ex) {
    
        Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
//    BufferedReader br;
        
        
        
      //******** Se traspasa el contenido del archivo XML a una variable de texto (String) *******//      
        
       
//        br = new BufferedReader(new InputStreamReader(new FileInputStream(factura), StandardCharsets.UTF_8));
//        String result = "";
//        String line = "";
//        
//        while( (line = br.readLine()) != null){
//        
//            result = result + line; 
//        }
//        
//        System.out.println(result);  
//      ******************************************************************************************************//        
      
        
        
        
  //Se genera el archivo XML (nueva opción)
        XMLOutputter outter=new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        
        DTE dte = new DTE();
        DTESoap soap = dte.getDTESoap();
        
                                            //    usuario      clave     contenido (false = envío de pruebas / true = envío a SII)
                                            //                              XML
        
        // ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", result, false);   //pruebas
    //    ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", outter.outputString(doc), false);   //pruebas
        
        //ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", result, true);
        ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", outter.outputString(doc), true);  //produccion
        
        
        
        
        if (respuesta.getString().isEmpty()){   //Si la respuesta es una cadena vacía el envío fue exitoso
        
            System.out.println("Documento ha sido emitido");
            
            
            //**********************************************************************************************************************************************
            int codimp = 0;
//        
//                jdBuscaImpresora imp = new jdBuscaImpresora(null,true);   //Para elegir la impresora en forma manual
//                imp.setLocationRelativeTo(null);
//                imp.setTitle("Impresoras");
//                imp.setVisible(true);
//        
//                if (imp.GetElige()){
//
//               
//                    codimp = imp.GetCodigo();
//
//                   
//                    Imprimir("76231391-K",ElRut,TipoNro,lbFolio.getText().trim(),Fecha,ElTotal,codimp, 1);
//        
//                }else {
//           
//                    return;
//        
//                }
            
            Imprimir("76231391-K",ElRut,TipoNro,lbFolio.getText().trim(),Fecha,ElTotal,codimp, 0);
            //*********************************************************************************************************************                   
            
            
        }else{        //De lo contrario el archivo XML presenta errores
        
            System.out.println("Error en envío : "+respuesta.getString());   //Se muestra los errores señalados
            
        }
        
    }
    
    
    
     public void Imprimir(String emisor, String receptor, String tipodte, String folio, String fecha, String total, int cimp,int imprime)  {
      
        System.out.println(emisor);
        System.out.println(receptor) ;
        System.out.println(tipodte);
        System.out.println(folio);
        System.out.println(fecha); 
        System.out.println(total);
        
        int Imprimir = imprime;
       
        try {
            PrintService[] services = PrinterJob.lookupPrintServices();
          
         //   int value = 4;
            
            int value = cimp; // El valor obtenido especifica la posicion de la impresora
            
            PrintService print = services[value];
           // System.out.println("EL VALOR DE LA IMPRESORA ES :"+services[value]);
            
            
            URL url=null;
            try {
           
                CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    
                //URL de pruebas
                
//                url = new URL("https://www.efacturadelsur.cl/certificacion/pdf?rutEmisor="+emisor+"&rutReceptor="+receptor+"&tipoDte="+tipodte+
//                              "&folio="+folio+"&fechaEmision="+fecha+"&montoTotal="+total);
                
                
                //URL de producción

              url = new URL("https://www.efacturadelsur.cl/app/pdf?rutEmisor="+emisor+"&rutReceptor="+receptor+"&tipoDte="+tipodte+
                            "&folio="+folio+"&fechaEmision="+fecha+"&montoTotal="+total);
                
                try{
                
                    InputStream in = url.openStream();
                    Files.copy(in, Paths.get("C:/doc_luvaly/FAC"+folio+".pdf"), StandardCopyOption.REPLACE_EXISTING);
                
                }catch(Exception e){

                      System.out.println("Archivo no encontrado !!");   //Se muestra los errores señalados
                    
                }    

            } catch (MalformedURLException e) {
                
                Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, e);
            }
            
            
            
            
            File fin = new File("C:/doc_luvaly/FAC"+folio+".pdf");

            
            if (Imprimir == 1){
            
                PDDocument document = Loader.loadPDF(fin);

                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPageable(new PDFPageable(document));
                job.setPrintService(print);
                job.print();
            
            }else if (Imprimir == 2){
                
                
                Desktop.getDesktop().open(fin);
                
            }
            
        
        }catch (FileNotFoundException ex) {
            
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        
        }catch (IOException | PrinterException ex) {
            
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    private void Verifica_Netos(String Tipo, String Rut, String Numero, String ElAfecto){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        
        
        double subtotal = 0;
        
        try {
           
            
            Rs = Sql.Select("select d.sku,d.cantidad,d.valorunitario,d.totallinea\n" +
                            "from ctacteclidet d\n" +
                            "where d.tipdocto='"+ Tipo +"'\n" +
                            "and d.rut="+ Rut +"\n" +
                            "and d.nrodocto=" + Numero);
                        
            while(Rs.next()){ 
                
                subtotal = subtotal +  Math.round(Rs.getDouble("cantidad")*Rs.getDouble("valorunitario"));
                
                productos++;
                
            }
            
            System.out.println("Total Lineas : "+subtotal);
            
            System.out.println("Total Neto : "+Integer.parseInt(ElAfecto));
            
            dif = (int)subtotal - Integer.parseInt(ElAfecto);
            
            System.out.println("Productos : "+productos);
            System.out.println("Diferencia : "+dif);
        
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    
    
    
    
    
    
    private void btGuiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuiasActionPerformed
        jdAgregaGuia AddGDC = new jdAgregaGuia(null, true);
        AddGDC.setTitle("Guias");
        AddGDC.setLocationRelativeTo(lstGuias);
        AddGDC.CargaGuias(txRut.getText(), cbCodigoOc.getSelectedItem().toString(), cbNroOrden.getSelectedItem().toString());
        AddGDC.setVisible(true);
        try {
            lstGuias.setModel(AddGDC.GetLista());
            
            CargaProductosDesdeGuias();
            
            txObs.setEnabled(true);
            
            CargaTotalOCC(cbCodigoOc.getSelectedItem().toString().trim(),cbNroOrden.getSelectedItem().toString().trim());
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btGuiasActionPerformed

    
    private void CargaTotalOCC(String CodigoOc, String Orden){
    
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;
        ResultSet Rs2;
        
        try {
            
            Rs = Sql.Select("select totaldocto from occh\n" +
                            "where rut="+ txRut.getText() +"\n" +
                            "and codigo_oc="+ CodigoOc.trim() +"\n" +
                            "and orden IN ('" + Orden.trim() + "')");
            
            
            if (Sql.GetRowCount() > 0){
            
                Rs.next();
                txTotalOCC.setText(Rs.getString("totaldocto"));
            
            }else{
            
                txTotalOCC.setText("0");
            
            }
            
            
            Rs2 = Sql2.Select("select sum(totaldocto) as sumafac from ctactecli\n" +
                            "where rut="+ txRut.getText() +"\n" +
                            "and codigo_oc="+ CodigoOc.trim() +"\n" +
                            "and occh IN ('" + Orden.trim() + "') \n"+
                            "and tipdocto IN ('FAC')");
            
            
            if (Sql2.GetRowCount() > 0){
            
                Rs2.next();
                txTotalFAC.setText(Rs2.getString("sumafac"));
            
            }else{
            
                txTotalFAC.setText("0");
            
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    
    
    
    private void btCorrigePesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCorrigePesoActionPerformed
        jdAjustePesos aju = new jdAjustePesos(null, true);
        aju.setLocationRelativeTo(null);
        aju.setTitle("Ajuste Pesos");
        aju.setVisible(true);
        PesoCorreccion = aju.GetAjuste();
        Sumador();
    }//GEN-LAST:event_btCorrigePesoActionPerformed

    private void rbReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReferenciaActionPerformed
        if(rbReferencia.isSelected()){
            cbReferencia.setVisible(true);
            txReferencia.setVisible(true);
        }
        else{
            cbReferencia.setVisible(false);
            txReferencia.setVisible(false);
        }
            
    }//GEN-LAST:event_rbReferenciaActionPerformed

    private void btPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDFActionPerformed

        //busca_pdf();
        busca_pdfFac();
        
    }//GEN-LAST:event_btPDFActionPerformed

    
    public void busca_pdfFac(){
    
        int encontrado = 0;
        
        try {
            
            
            String Tipo;
            String Numero;
           
            long size = 0;
            
             
            Tipo="FAC";
            System.out.println(Tipo);
            System.out.println(lbFolio.getText().trim());
            Numero= Tipo+lbFolio.getText().trim()+".";
            
           
            File directorio = new File("C:\\doc_luvaly");

            if (directorio.exists()){
                              
                File[] archivos = directorio.listFiles();
                
                for (File elemento : archivos) {
            
                    if (elemento.getName().contains(Numero)) {
                        
                          Numero = elemento.getName();
                          encontrado = 1;
                          break;
                        
                    }else{
                    
                        encontrado = 0;
                    }
                }
                
                
                
            }else if (!directorio.exists()){
                
                directorio.mkdir();
                
                
            }
            
            
            if (encontrado == 1 ){
            
                Path filePath =  Paths.get("c:/doc_luvaly/"+Numero);
            
                size = Files.size(filePath);
                System.out.println("The file size is " + size + " bytes");
            
            }
            
            
            if (encontrado == 1 && size > 0 ){
            
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A LOCAL !!!!!!!!!!!");

                File archivo = new File ("c:/doc_luvaly/"+Numero);
                Desktop.getDesktop().open(archivo);
                
                
                
            }else if (encontrado == 1 && size == 0 ){
                
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A REMOTO 1 !!!!!!!!!!!");
                
                
                
                String ElRut = txRut.getText().trim()+"-"+txDv.getText().trim();
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String Fecha = sdf.format(dtEmision.getDate());
                String ElTotal = txTotal.getText().trim().replaceAll("\\,", "");
                
                Imprimir("76231391-K",ElRut,"33",lbFolio.getText().trim(),Fecha,ElTotal,0,2);
                
                
                
            }else if (encontrado == 0){
                
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A REMOTO 2 !!!!!!!!!!!");
                
                
                try{
                    
                    String ElRut = txRut.getText().trim()+"-"+txDv.getText().trim();
                
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String Fecha = sdf.format(dtEmision.getDate());
                    String ElTotal = txTotal.getText().trim().replaceAll("\\,", "");
                
                    Imprimir("76231391-K",ElRut,"33",lbFolio.getText().trim(),Fecha,ElTotal,0,2);
                
                }catch (Exception e){
                
//                        System.out.println("El arhivo no fue encontrado...");
//                        return;
                    
                     busca_pdf();
                    
                   
                }
            
            }
            
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo encotrar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, e);
                
        }
    
    }
    
    
    
    
    
    
    
    
    
    public void busca_pdf(){
    
        int encontrado = 0;
        
        try {
            
            
            String Tipo;
            String Numero;
            int cont =0; 
            long size = 0;
             
            Tipo="33F";
            System.out.println(Tipo);
            System.out.println(lbFolio.getText().trim());
            Numero= Tipo+lbFolio.getText().trim()+".";
            
            
            
           
            File directorio = new File("C:\\facturas");

            if (directorio.exists()){
    
                              
                File[] archivos = directorio.listFiles();
                
                for (File elemento : archivos) {
            
                    if (elemento.getName().contains(Numero)) {
                        
                          Numero = elemento.getName();
                          encontrado = 1;
                          break;
                        
                    }else{
                    
                        encontrado = 0;
                    }
                }
                
                
                
            }else if (!directorio.exists()){

                directorio.mkdir();
                
            }
            
            
            if (encontrado == 1 ){
            
                Path filePath =  Paths.get("c:/facturas/"+Numero);
            
                size = Files.size(filePath);
                System.out.println("The file size is " + size + " bytes");
            
            }
            
            


             if (encontrado == 1 && size > 0 ){
            
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A LOCAL !!!!!!!!!!!");

                File objetofile = new File ("c:/facturas/"+Numero);
                 Desktop.getDesktop().open(objetofile);
                
            }else if (encontrado == 1 && size == 0 ){
            
                
                System.out.println("ENTRA A REMOTO con Archivo LOCAL en 0   !!!!!!!!!");
                
                File directorioFtp = new File("\\\\192.168.0.130\\Documentos Electronicos");
               

                if (directorioFtp.exists()){   //Se verifica que el directorio (carpeta) exista
    
                    File[] archivos = directorioFtp.listFiles();      //se capturan los nombres de todos los archivos del directorio
                
                    for (File elemento : archivos) {     //se va leyendo cada archivo
            
                        if (elemento.getName().contains(Numero)) {    //Si el nombre del archivo contiene el nombre que se busca
                        
                           Numero = elemento.getName();           //Se nota el nombre completo del archivo 
                           encontrado = 1;                        //Se indica que se ha encontrado  
                           break;                                 //Se termona el ciclo for  
                        
                        }else{
                    
                           encontrado = 0;
                        }
                    }
                    
                    
                    //***********
                    if (encontrado == 1){   //Si el archivo fue encontrado
            
                        System.out.println("LA Documento ES :"+Numero);
            

                        //File objetofile = new File ("c:/facturas/"+Factura);
                        File objetofile = new File ("//192.168.0.130/Documentos Electronicos/"+Numero);
                        
                        Desktop.getDesktop().open(objetofile);   //Se abre el archivo segun el programa asociado a él (configurado previamente en Windows)
                
                    }else if (encontrado == 0){
                    
                        System.out.println("El Archivo no existe...");
                        
                    
                    }        
                //***********
                
                }else{
        
                    System.out.println("El directorio no existe, verifique la ruta remota...");
                    return;
                }   
               
                
            }else if (encontrado == 0){
                
                 System.out.println("ENTRA A REMOTO !!!!!!!!!!!");
                
                File directorioFtp = new File("\\\\192.168.0.130\\Documentos Electronicos");
               

                if (directorioFtp.exists()){   //Se verifica que el directorio (carpeta) exista
    
                    File[] archivos = directorioFtp.listFiles();      //se capturan los nombres de todos los archivos del directorio
                
                    for (File elemento : archivos) {     //se va leyendo cada archivo
            
                        if (elemento.getName().contains(Numero)) {    //Si el nombre del archivo contiene el nombre que se busca
                        
                           Numero = elemento.getName();           //Se nota el nombre completo del archivo 
                           encontrado = 1;                        //Se indica que se ha encontrado  
                           break;                                 //Se termona el ciclo for  
                        
                        }else{
                    
                           encontrado = 0;
                        }
                    }
                    
                    
                    //***********
                    if (encontrado == 1){   //Si el archivo fue encontrado
            
                        System.out.println("LA Documento ES :"+Numero);
            

                        //File objetofile = new File ("c:/facturas/"+Factura);
                        File objetofile = new File ("//192.168.0.130/Documentos Electronicos/"+Numero);
                        
                        Desktop.getDesktop().open(objetofile);   //Se abre el archivo segun el programa asociado a él (configurado previamente en Windows)
                
                    }else if (encontrado == 0){
                    
                        System.out.println("El Archivo no existe...");
                        
                    
                    }        
                //***********
                
                }else{
        
                    System.out.println("El directorio no existe, verifique la ruta remota...");
                    return;
                }   
            
            
            }
            
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo,"
                    + " probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, e);
                
        }
    
    }
    
    private void cbReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbReferenciaActionPerformed

    private void btEmiteManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmiteManActionPerformed
        
        Emitir_Factura();
        btPDF.setEnabled(true);
        
    }//GEN-LAST:event_btEmiteManActionPerformed

    public void Mail() {
        Window ventana = new Window();// TODO add your handling code here:
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    ExeSql Sql = new ExeSql();
                    ResultSet Rs;
                    String Query ="";
                    String Archivo="";
                    String Guias[] = new String [50];
                    String Voucher[] = new String [50];
                    int Transporte_arr[] = new int [50];
                    String Archivos[] = new String [50];
                    int x=0;
                    int indArch =0;
                    String Valor = "";

                    Archivo =Ftp.busca_SinAbrir("33", lbFolio.getText().trim(),"facturas","dte");

                     try { 

                         //Busca Guias Asociadas
                         Query = " select nrodocto from ctactecli\n" +
                                " where tipdocrel = 'FAC' and nrodocrel = " + lbFolio.getText().trim();
                         Rs = Sql.Select(Query);

                         int i = 0;
                         while (Rs.next()){
                             Guias[i] = Rs.getString("nrodocto");
                             i++;
                         }

                        for (int j=0; j<= Guias.length-1; j++){
                                if (Guias[j] != null){
                                 Archivos[j]  =    Ftp.busca_SinAbrir("52", Guias[j],"facturas","dte");

                                }
                                else{
                                   Archivos[j]  = Archivo;
                                  indArch = j+1;
                                   break;
                                }
                        }

                        int k=0;
                        for (int j=0; j<= Guias.length-1; j++){
                         //-------------------------------------------------------------------------------------------
                                         //Busca Voucher Asociados
                                        Query = " select transporte, voucher , nrodocto, tipdocto  from transporte_despachos \n" +
                                               " where tipdocto = 'GDC"
                                                + "' and nrodocto = " + Guias[j] + " and pdf_voucher is not null";
                                        Rs = Sql.Select(Query);

                                        if (Rs.next()){
                                            Voucher[k] = Rs.getString("voucher");
                                            Transporte_arr[k]= Rs.getInt("transporte");
                                            k++;
                                        }
                        }

                                       Valor="";     
                                       for (int w=0; w<= Voucher.length-1; w++){
                                               if (Voucher[w] != null && Transporte_arr[w]==1){
                                                Archivos[indArch]  =    Ftp.busca_SinAbrir("52", Voucher[w],"tnt","tnt");
                                                indArch++;
                                               }
                                               else if (Voucher[w] != null && Transporte_arr[w]==7){
                                                    Valor = Ftp.busca_SinAbrir("52", Voucher[w],"blue","blue");
                                                   if (!Valor.equals(""))
                                                   {   
                                                        Archivos[indArch]  =    Valor;
                                                   }     
                                                indArch++;
                                               }
                                               else{
                                                  break;
                                               }
                                       }
                                 //-------------------------------------------------------------------------------------------




                    } catch (Exception e) {
                            System.out.println("2" + e);
                        }
                        finally{
                            Sql.Close();
                        }	


                    //fmMain.Mensaje("Archivo a enviar : " + Archivo);

                    ventana.Username = "despachos@luvaly.cl";
                    ventana.PassWord = "3Logica.";
                    ventana.Archivo = Archivo;
                    ventana.Archivos = Archivos;

                    ventana.NumFactura = lbFolio.getText().trim();
                    ventana.Rut = txRut.getText().trim();

                    ventana.Orden = cbNroOrden.getSelectedItem().toString().trim();
                    ventana.CodigoOC=   cbCodigoOc.getSelectedItem().toString().trim();
            //        ventana.setAdjunto(Archivo);
            //        ventana.setOC(cbCodigoOc.getSelectedItem().toString().trim() + "-" + cbNroOrden.getSelectedItem().toString().trim());

                    ventana.setDatos();
                    ventana.setVisible(true);


                     StringSelection Transporte = new StringSelection(cbCodigoOc.getSelectedItem().toString().trim() + "-" + cbNroOrden.getSelectedItem().toString().trim());
                     Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                     cb.setContents(Transporte, null);


                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    ventana.jButtonEnviar.doClick();
                }
            }

            
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        
        
    }
    
    private void btMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMailActionPerformed
        MailRápido();
//        Mail();
      
                
    }//GEN-LAST:event_btMailActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
         
    }//GEN-LAST:event_btEditarActionPerformed

    private void chk_esRefacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_esRefacturacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_esRefacturacionActionPerformed

    private void txObsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txObsKeyReleased
        txObs.setText(txObs.getText().toUpperCase());
    }//GEN-LAST:event_txObsKeyReleased

    private void txObsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txObsKeyTyped
        
        if (txObs.getText().length() >= 80 ){ // limit to 3 characters
                evt.consume();
        
        }
    }//GEN-LAST:event_txObsKeyTyped

    private void chkSinOccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSinOccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSinOccActionPerformed
    
    public static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCorrigePeso;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEmiteMan;
    private javax.swing.JButton btEmitir;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuias;
    public javax.swing.JButton btIr;
    private javax.swing.JButton btMail;
    public javax.swing.JButton btNuevo;
    private javax.swing.JButton btPDF;
    public javax.swing.JComboBox cbCodigoOc;
    public javax.swing.JComboBox cbNroOrden;
    private javax.swing.JComboBox<String> cbReferencia;
    private javax.swing.JComboBox cbTipoDespacho;
    private javax.swing.JComboBox cbTipoPago;
    private javax.swing.JCheckBox chkSinGuia;
    private javax.swing.JCheckBox chkSinOcc;
    private javax.swing.JCheckBox chk_esRefacturacion;
    private org.jdesktop.swingx.JXDatePicker dtEmision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbFolio;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTipoPago;
    private javax.swing.JList lstGuias;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JCheckBox rbReferencia;
    private javax.swing.JTextField txCiudad;
    private javax.swing.JTextField txComuna;
    private javax.swing.JTextField txDireccion;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txExento;
    private javax.swing.JTextField txImpEspecifico;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txObs;
    private javax.swing.JTextField txReferencia;
    public javax.swing.JTextField txRut;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txTotalFAC;
    private javax.swing.JTextField txTotalOCC;
    // End of variables declaration//GEN-END:variables
}
