package produ.jes12.registroconsulta.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class NavegacionUtil {

    /**
     * Abre una ventana modal bloqueante (hija) sobre la ventana que la invoca.
     * Retorna el FXMLLoader cargado por si necesitas acceder a su controlador (útil para pasar datos).
     */
    public static FXMLLoader abrirModal(String fxmlPath, String titulo, Window ownerWindow) {
        try {
            URL url = NavegacionUtil.class.getResource(fxmlPath);
            if (url == null) {
                AlertaUtil.mostrarError(
                        "Error de Navegación",
                        "Recurso no encontrado",
                        "No se pudo localizar el archivo FXML en la ruta:\n" + fxmlPath
                );
                return null;
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.initModality(Modality.WINDOW_MODAL);

            if (ownerWindow != null) {
                stage.initOwner(ownerWindow);
            }

            stage.setScene(new Scene(root));
            stage.show();

            return loader;
        } catch (IOException e) {
            AlertaUtil.mostrarError(
                    "Error de Carga",
                    "No se pudo abrir la ventana modal",
                    "Ocurrió un error al cargar la vista:\n" + e.getMessage()
            );
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reemplaza la escena de la ventana actual y ajusta su tamaño (usado por ejemplo para Cerrar Sesión).
     */
    public static FXMLLoader cambiarVentana(Stage stageActual, String fxmlPath, String titulo, double ancho, double alto) {
        try {
            URL url = NavegacionUtil.class.getResource(fxmlPath);
            if (url == null) {
                AlertaUtil.mostrarError(
                        "Error de Navegación",
                        "Recurso no encontrado",
                        "No se pudo localizar el archivo FXML en la ruta:\n" + fxmlPath
                );
                return null;
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            stageActual.setTitle(titulo);
            stageActual.setScene(new Scene(root, ancho, alto));
            stageActual.centerOnScreen();
            stageActual.show();

            return loader;
        } catch (IOException e) {
            AlertaUtil.mostrarError(
                    "Error de Transición",
                    "No se pudo cambiar de ventana",
                    "Ocurrió un error al cargar la nueva vista:\n" + e.getMessage()
            );
            e.printStackTrace();
            return null;
        }
    }
}