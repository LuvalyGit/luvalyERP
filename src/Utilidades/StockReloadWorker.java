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
            System.out.println("Iniciando actualización BATCH de stock en SEGUNDO PLANO...");

            // 1. Convertir la lista [1, 2, 3] al formato de array de PostgreSQL "{1,2,3}"
            String sqlArray = "{" + this.idsDeSucursales.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(",")) + "}";

            // 2. Crear la consulta SQL (UNA SOLA LLAMADA)
            String sqlQueryCompleto = "SELECT public.upsert_producto_sucursal_BATCH('" + sqlArray + "')";

            // 3. Ejecutar la función de la base de datos
            sql.ExeSql(sqlQueryCompleto);

            System.out.println("¡Proceso de actualización BATCH en fondo finalizado!");

        } catch (Exception e) {
            // Si algo falla, guardamos el mensaje de error para mostrarlo después
            this.errorMensaje = e.getMessage();
            e.printStackTrace();
        } finally {
            // Es MUY importante cerrar la conexión en el 'finally'
            if (sql != null) {
                try {
                    sql.Close();
                } catch (Exception e) {
                    System.err.println("Error crítico: no se pudo cerrar la conexión.");
                    e.printStackTrace();
                }
            }
        }
        return null; // No devolvemos nada
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
