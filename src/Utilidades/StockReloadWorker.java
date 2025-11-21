/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Conexion.ExeSql;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Marcelo Leiva
 */
public class StockReloadWorker extends SwingWorker<Void, Void> {

    // --- ESTAS ERAN LAS LÍNEAS QUE FALTABAN ---
    private final List<Integer> idsDeSucursales;
    private String errorMensaje = null;

    /**
     * Este es el constructor que tu formulario estaba buscando. Recibe la lista
     * de sucursales que se van a actualizar.
     *
     * @param ids La lista de IDs de sucursal (ej: 1, 2, 3)
     */
    public StockReloadWorker(List<Integer> ids) {
        this.idsDeSucursales = ids;
    }

    // --- FIN DE LAS LÍNEAS QUE FALTABAN ---
    /**
     * Este método contiene el trabajo "pesado". Se ejecuta en un hilo de fondo,
     * por lo que NO PUEDE tocar la UI.
     */
    @Override
    protected Void doInBackground() throws Exception {
        ExeSql sql = null;
        try {
            sql = new ExeSql();
            System.out.println("Iniciando actualización de stock (POR SUCURSAL)...");

            // RECORREMOS LA LISTA DE SUCURSALES UNA POR UNA
            // (La lista que pasaste al constructor: 1, 2, 3)
            for (Integer idSucursal : this.idsDeSucursales) {

                // Creamos la consulta simple para ESE id específico
                String query = "SELECT public.upsert_producto_sucursal_por_sucursal(" + idSucursal + ")";

                System.out.println("Actualizando Sucursal ID: " + idSucursal);

                // Ejecutamos
                sql.ExeSql(query);
            }

            System.out.println("¡Todas las sucursales fueron actualizadas!");

        } catch (Exception e) {
            this.errorMensaje = e.getMessage();
            e.printStackTrace();
        } finally {
            if (sql != null) {
                try {
                    sql.Close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Este método se ejecuta automáticamente cuando doInBackground() termina.
     * Se ejecuta en el hilo de la UI, por lo que SÍ PUEDE mostrar JOptionPanes.
     */
    @Override
    protected void done() {
        if (errorMensaje != null) {
            // Si guardamos un error, lo mostramos ahora
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar el stock: " + errorMensaje);
        } else {
            // Todo salió bien
            System.out.println("SwingWorker: Tarea completada con éxito.");
            // Opcional: podrías mostrar un mensaje de éxito, pero usualmente no es necesario
            // JOptionPane.showMessageDialog(null, "Stock actualizado correctamente.");
        }
    }
}
