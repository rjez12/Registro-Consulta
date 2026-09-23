package produ.jes12.registroconsulta.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.util.NavegacionUtil;

import java.io.File;

public class MainController {

    @FXML
    private VBox rootPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private ToolBar toolBar;

    @FXML
    private void abrirVentanaRegistro(ActionEvent event) {
        NavegacionUtil.cambiarVentana(
                rootPane,
                "/produ/jes12/registroconsulta/registro.fxml",
                "Formulario de Registro"
        );
    }

    @FXML
    private void abrirVentanaConsulta(ActionEvent event) {
        NavegacionUtil.cambiarVentana(
                rootPane,
                "/produ/jes12/registroconsulta/consulta.fxml",
                "Consulta de Clientes"
        );
    }

    @FXML
    private void handleSeleccionarCarpeta(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar Carpeta General");

        Stage stage = (Stage) rootPane.getScene().getWindow();
        File carpetaSeleccionada = directoryChooser.showDialog(stage);

        if (carpetaSeleccionada != null) {
            NavegacionUtil.mostrarAlerta(
                    javafx.scene.control.Alert.AlertType.INFORMATION,
                    "Carpeta Seleccionada",
                    "Ruta: " + carpetaSeleccionada.getAbsolutePath()
            );
        }
    }

    @FXML
    private void handleCerrarSesion(ActionEvent event) {
        if (NavegacionUtil.mostrarConfirmacion("Cerrar Sesión", "¿Está seguro de que desea salir al Login?")) {
            NavegacionUtil.cambiarVentana(
                    rootPane,
                    "/produ/jes12/registroconsulta/login.fxml",
                    "Iniciar Sesión"
            );
        }
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        if (NavegacionUtil.mostrarConfirmacion("Confirmar Salida", "¿Desea salir de la aplicación?")) {
            System.exit(0);
        }
    }
}