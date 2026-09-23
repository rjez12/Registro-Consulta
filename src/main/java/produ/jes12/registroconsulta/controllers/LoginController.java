package produ.jes12.registroconsulta.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.util.AlertaUtil;
import produ.jes12.registroconsulta.util.NavegacionUtil;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnSalir;

    @FXML
    private void handleIniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        // 1. Validar campos vacíos usando AlertaUtil.mostrarAdvertencia
        if (usuario.isEmpty() || password.isEmpty()) {
            AlertaUtil.mostrarAdvertencia(
                    "Campos Incompletos",
                    "Información requerida faltante",
                    "Por favor, ingrese tanto el usuario como la contraseña."
            );
            return;
        }

        // 2. Credenciales para prueba
        if (usuario.equals("admin") && password.equals("1234")) {
            // Obtenemos el Stage actual a partir del botón de inicio de sesión
            Stage stageActual = (Stage) btnIniciarSesion.getScene().getWindow();

            NavegacionUtil.cambiarVentana(
                    stageActual,
                    "/produ/jes12/registroconsulta/main.fxml",
                    "Sistema Principal - Menú de Navegación",
                    850,
                    580
            );
        } else {
            // 3. Acceso denegado usando AlertaUtil.mostrarError
            AlertaUtil.mostrarError(
                    "Acceso Denegado",
                    "Credenciales incorrectas",
                    "El usuario o la contraseña son incorrectos."
            );
        }
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        // 4. Confirmación de salida usando AlertaUtil
        boolean confirmar = AlertaUtil.mostrarConfirmacion(
                "Confirmar Salida",
                "¿Está seguro de que desea salir?",
                "Se cerrará la aplicación por completo."
        );

        if (confirmar) {
            Platform.exit();
        }
    }
}