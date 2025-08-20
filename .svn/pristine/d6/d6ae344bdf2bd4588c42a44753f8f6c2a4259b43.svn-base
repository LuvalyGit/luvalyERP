package javamail;

import Conexion.ExeSql;
import Formularios.fmMain;
import static PanelForm.pfFACCliente.wait;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication; 
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class Window extends javax.swing.JFrame {

    public static String Username = "";
    public static String PassWord = "";
    public static String Archivo="";
    public static String Orden ="";
    public static String CodigoOC ="";
    public static String NumFactura ="";
    public static String Rut ="";
    public static String Nombre_Contacto, Fono,Celular="";
    public static String Nombre_Contacto_OC, Fono_OC,Celular_OC="";
    public String Archivos[] = new String[50];
    
    
  
    
    String Mensage = "";
    String To = "";
    String Subject = "";
    String AdjArchivo ="";
 
//    String archivo = "/T33F18000.pdf";
//    String archivo2 = "T33F18000.pdf";
    
    
    
    
    
    
    public void SendMail() {
    
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

        try {

            
             // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText(jTextAreaMessage.getText().trim());

        
            List<BodyPart> bp = new LinkedList<BodyPart>();//<-------creamos una lista de adjuntos 
        for(int i =0; i<= Archivos.length-1; i++)    
        {
            
            if (Archivos[i] != null)
            {
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(
                new DataHandler(new FileDataSource(Archivos[i])));
                AdjArchivo   = fmMain.GetStringDeFinal('/', Archivos[i]); 
                adjunto.setFileName(AdjArchivo);
                bp.add(adjunto);
            }
            else
            {
                break;
            }
            
        }    
            
            

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            
           Iterator it = bp.iterator();//<------------la iteramos 
           while(it.hasNext())//<----------------la recorremos 
           { 
              BodyPart attach =(BodyPart)it.next();//<------------obtenemos el objeto 
            multiParte.addBodyPart(attach);//<-----------------finalmente lo añadimos al mensaje 
            } 
            
            
            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            
             message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            
            
        
            message.setSubject(jTextFieldSubject.getText().trim());
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect(Username, PassWord);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
           JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
           this.dispose();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void setDatos(){
           String datos_facturacion ="";
          ExeSql Sql = new ExeSql();
          ResultSet Rs, Rs1;
          String Query,Query2 = "";
       
                    Nombre_Contacto="";
                    Fono= "";
                    Celular= "";
                    
                    Nombre_Contacto_OC="";
                    Fono_OC= "";
                    Celular_OC= "";
          
// Contacto Orden de Compra          
            Query = "select nombre,fono,celular,email\n" +
                    " from clicontactopersonas\n" +
                    " where id IN(select contacto \n" +
                    " from occh\n" +
                    " where rut =" +  Rut + " and  codigo_oc =" + CodigoOC +
                    " and orden = '" + Orden + "')";
//            try {
//                Rs = Sql.Select(Query);
//                if (Rs.next()){
//                    jTextFieldTo.setText(Rs.getString("email").trim());
//                    Nombre_Contacto_OC= Rs.getString("nombre").trim();
//                    Fono_OC= Rs.getString("fono").trim();
//                    Celular_OC= Rs.getString("celular").trim();
//                }
//            }
//                 catch (Exception e) {
//                System.out.println(e.getMessage());
//                fmMain.Mensaje("Error: "  + e);
//             }  
            
            // Se añadir el correo de Facturacion
                  Query2 = "select nombre,fono,celular,email\n" +
                    " from clicontactopersonas\n" +
                    " where id_cargo IN (8) and rut =" +  Rut + " and  codigo_oc =" + CodigoOC; 
//        try {
//            Rs1 = Sql.Select(Query2);
//            datos_facturacion="";
//                    int i =1;
//                    while (Rs1.next()){
//                            if ( !Rs1.getString("email").trim().equals("")){
//                                
//                                if ( jTextFieldTo.getText().trim().equals(""))
//                                    {
//                                        jTextFieldTo.setText(Rs1.getString("email").trim());
//                                    }
//                                else
//                                    {
//                                        jTextFieldTo.setText(jTextFieldTo.getText().trim() + "," +  Rs1.getString("email").trim());
//                                    }    
//                            }
//                            
//                            datos_facturacion = datos_facturacion + "\n\nDatos Facturacion : " + i + " \n Nombre Contacto = " +  Rs1.getString("nombre").trim() + "\n" +
//                                                " Telefonos : " + Rs1.getString("fono").trim() + "  " + Rs1.getString("celular").trim() + "\n" +              
//                                                " Correo : " + Rs1.getString("email").trim() ;
//                            i++;
//                }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
//        }
                    
            //Contactos
//            Query = "select cli.email\n" +
//                    "from clicontactopersonas cli\n" +
//                    "left join par_general par on cli.id_cargo=par.codigo \n" +
//                    "where par.tipo='TIPCONTACTOCLI' and cli.rut="+Rut+" and cli.email <> ''\n" +
//                    "and cli.codigo_oc="+CodigoOC+"\n" +
//                    "and cli.id_cargo = 8";
//        try {
//            Rs = Sql.Select(Query);
//            if(Rs.next()) {
//                if ( jTextFieldTo.getText().trim().equals("")) {
//                    jTextFieldTo.setText(Rs.getString("email").trim());
//                }
//                else {
//                    jTextFieldTo.setText(jTextFieldTo.getText().trim() + "," +  Rs.getString("email").trim());
//                }    
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
// Comtacto de Guia de Despacho                    
            
//            try {
//                Query = "select nombre,fono,celular,email\n" +
//                   " from clicontactopersonas\n" +
//                   " where id IN(select  contacto from ctactecli\n" +
//                   " where rut =" + Rut + " and  codigo_oc = " + CodigoOC + " and nrodocrel = " + NumFactura + "  and tipdocrel= 'FAC')";
//            
//                Rs = Sql.Select(Query);
//                for(int i = 0 ; Rs.next(); i++){
//                    //jTextFieldTo.setText( jTextFieldTo.getText().trim() + "," + Rs.getString("email").trim());
//                       if ( jTextFieldTo.getText().trim().equals(""))
//                            {
//                                jTextFieldTo.setText(Rs.getString("email").trim());
//                            }
//                        else
//                            {
//                                jTextFieldTo.setText(jTextFieldTo.getText().trim() + "," +  Rs.getString("email").trim());
//                            }    
//                    Nombre_Contacto= Rs.getString("nombre");
//                    Fono= Rs.getString("fono");
//                    Celular= Rs.getString("celular");
//                }
//                
//                
//                    
//                   
//               } catch (Exception e) {
//                System.out.println(e.getMessage());
//                fmMain.Mensaje("Error: "  + e);
//            }finally{
//                Sql.Close();
//            }
                
        if ( jTextFieldTo.getText().trim().equals("")) {
                    jTextFieldTo.setText("rortiz@luvaly.cl");
                }
                else {
                        jTextFieldTo.setText(jTextFieldTo.getText().trim() + "," + "rortiz@luvaly.cl");
                } 
        String StrCuerpo= "Junto con Saludar. \n " +
                        "Se envia factura número :" + NumFactura + "\n Asociada a la Orden de Compra: " + CodigoOC + "-" +  Orden + "\n" +
                        "Datos de Orden Compra: \n" +
                        "Telefono_contacto :" + Fono_OC.trim() + " " + Celular_OC.trim() + "\n" +
                        "Nombre de Contacto :" + Nombre_Contacto_OC.toUpperCase().trim() + "\n\n" +
                        "Datos de Despacho: \n" +
                        "Telefono_contacto :" + Fono.trim() + " " + Celular_OC.trim() + "\n" +
                        "Nombre de Contacto :" + Nombre_Contacto.toUpperCase().trim() + "\n\n" +
                        "Atte Luvaly SPA.-\n" +
                        "Fono contacto: 45 2 658 390\n" +
                        "mail: contacto@luvaly.cl\n\n" +
                        "Sus depositos pueden ser generados a la cuenta corriente:\n" +
                        "BCI - Numero: 66113555\nRut: 76231391-K\nMail: pagos@luvaly.cl\n\n" +
                        "Banco Estado - Numero: 62370137973\nRut: 76231391-K\nMail: pagos@luvaly.cl";
                        StrCuerpo = StrCuerpo + "\n"  + datos_facturacion;
                        jTextAreaMessage.setText(StrCuerpo);
                        jTextFieldSubject.setText(" Luvaly - Documentos asociados orden : " + CodigoOC + "-" +  Orden);
    }
    
     public void setOC(String StrOrden){
               Orden=  StrOrden;
    }
    
        public void SendMail_Orig() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {
            String archivo = "c:/prueba.doc";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);
            message.setFileName(archivo);
            
            

            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Window() {
        initComponents();
        jTextAreaMessage.setLineWrap(true); //Se logra que haya salto de línea en el TextArea
        jTextAreaMessage.setWrapStyleWord(true); //Se impide la división de palabras en el TestArea
        
     
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTo = new javax.swing.JTextField();
        jTextFieldSubject = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jButtonEnviar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldTo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jTextFieldSubject.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Para");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Asunto");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Mensaje");

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextAreaMessage.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMessage);

        jButtonEnviar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar Campos");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        btSalir.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSubject)
                                    .addComponent(jTextFieldTo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalir)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonLimpiar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(btSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        //Se limpian los campos de texto
        jTextFieldTo.setText("");
        jTextFieldSubject.setText("");
        jTextAreaMessage.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    Enviar();
                    SendMail();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {

                }
            }

            
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();

        
        
    }//GEN-LAST:event_jButtonEnviarActionPerformed
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    public void Enviar() {
        ExeSql Sql = new ExeSql();
          ResultSet Rs;
          String Query="",correo="";
        try  
        {
            Query = "select nombre from par_general where tipo = 'CORREO_FACTURA'";
            Rs = Sql.Select(Query);
            if(Rs.next()){
               correo = Rs.getString("nombre");
            }
            
        } catch (Exception e) 
        {
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
        }
        finally
        {
                Sql.Close();
        }
        
        Mensage = jTextAreaMessage.getText();
        To = jTextFieldTo.getText() + "," + correo; 
        Subject = jTextFieldSubject.getText();

        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    public javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField jTextFieldSubject;
    private javax.swing.JTextField jTextFieldTo;
    // End of variables declaration//GEN-END:variables
}
