package produ.jes12.registroconsulta.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.util.AlertaUtil;
import produ.jes12.registroconsulta.util.NavegacionUtil;

import java.io.File;

public class MainController {

    private AlertaUtil alerta;

    @FXML private VBox rootPane;
    @FXML private MenuBar menuBar;
    @FXML private ToolBar toolBar;

    @FXML
    public void initialize() {
        // Implementación del ContextMenu en código para la rúbrica (sin tocar el FXML)
        ContextMenu contextMenu = new ContextMenu();

        MenuItem itemRegistro = new MenuItem("Registrar Nuevo Cliente");
        MenuItem itemConsulta = new MenuItem("Ver Listado de Clientes");
        MenuItem itemDirectorio = new MenuItem("Elegir Carpeta de Exportación...");

        itemRegistro.setOnAction(e -> abrirVentanaRegistro(null));
        itemConsulta.setOnAction(e -> abrirVentanaConsulta(null));
        itemDirectorio.setOnAction(e -> handleSeleccionarCarpeta(null));

        contextMenu.getItems().addAll(itemRegistro, itemConsulta, itemDirectorio);

        // Se despliega al hacer clic derecho en cualquier parte del área principal
        rootPane.setOnContextMenuRequested(event ->
                contextMenu.show(rootPane, event.getScreenX(), event.getScreenY())
        );
    }

    @FXML
    public void abrirVentanaRegistro(ActionEvent event) {
        NavegacionUtil.abrirModal(
                "/produ/jes12/registroconsulta/registro.fxml",
                "Registro de Cliente y Solicitud",
                rootPane.getScene().getWindow()
        );
    }

    @FXML
    public void abrirVentanaConsulta(ActionEvent event) {
        NavegacionUtil.abrirModal(
                "/produ/jes12/registroconsulta/consulta.fxml",
                "Consulta de Clientes Registrados",
                rootPane.getScene().getWindow()
        );
    }

    @FXML
    public void handleSeleccionarCarpeta(ActionEvent event) {
        // Requerimiento de DirectoryChooser para la ventana principal
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Seleccionar Carpeta para Exportación / Respaldos");

        Stage stage = (Stage) rootPane.getScene().getWindow();
        File carpeta = dirChooser.showDialog(stage);

        if (carpeta != null) {
            alerta.mostrarError(
                    "Directorio Configurado",
                    "Ruta seleccionada correctamente",
                    "Carpeta de destino:\n" + carpeta.getAbsolutePath()
            );
        }
    }

    @FXML
    public void handleCerrarSesion(ActionEvent event) {
        boolean confirmar = AlertaUtil.mostrarConfirmacion(
                "Cerrar Sesión",
                "¿Desea cerrar la sesión actual?",
                "Regresará a la pantalla de inicio de sesión."
        );

        if (confirmar) {
            Stage stageActual = (Stage) rootPane.getScene().getWindow();
            NavegacionUtil.cambiarVentana(
                    stageActual,
                    "/produ/jes12/registroconsulta/login.fxml",
                    "Acceso al Sistema - Inicio de Sesión",
                    550,
                    450
            );
        }
    }

    @FXML
    public void handleSalir(ActionEvent event) {
        // Alert de confirmación antes de cerrar la aplicación por completo
        boolean confirmar = AlertaUtil.mostrarConfirmacion(
                "Salir del Sistema",
                "¿Está seguro de que desea salir?",
                "Se cerrará la aplicación de inmediato."
        );

        if (confirmar) {
            Platform.exit();
        }
    }
}