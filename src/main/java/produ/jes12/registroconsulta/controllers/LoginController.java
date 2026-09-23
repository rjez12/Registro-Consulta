package produ.jes12.registroconsulta.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        //Validar los campos vacios
        if (usuario.isEmpty() || password.isEmpty()) {
            NavegacionUtil.mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos Incompletos",
                    "Por favor, ingrese tanto el usuario como la contraseña."
            );
            return;
        }

        //Credenciales para prueba
        if (usuario.equals("admin") && password.equals("1234")) {
            NavegacionUtil.cambiarVentana(
                    txtUsuario,
                    "/produ/jes12/registroconsulta/main.fxml",
                    "Sistema Principal"
            );
        } else {
            NavegacionUtil.mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Acceso Denegado",
                    "El usuario o la contraseña son incorrectos."
            );
        }
    }

    @FXML
    private void handleSalir(ActionEvent event) {
        if (NavegacionUtil.mostrarConfirmacion("Confirmar Salida", "¿Está seguro de que desea salir de la aplicación?")) {
            System.exit(0);
        }
    }
}