package produ.jes12.registroconsulta.util;

import javafx.scene.control.Alert;

public class AlertaUtil {
    public static void mostrarError(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    // Método estático para mostrar un mensaje de INFORMACIÓN (Éxito)
    public static void mostrarInfo(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    // Método estático para mostrar una ADVERTENCIA
    public static void mostrarAdvertencia(String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
