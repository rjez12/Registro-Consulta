package produ.jes12.registroconsulta.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.model.Cliente;

import java.io.IOException;

public class DetalleController {

    @FXML
    private TextField txtNombreCompleto;

    @FXML
    private TextField txtTipoCliente;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtTipoSolicitud;

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

        txtNombreCompleto.setText(
                cliente.getNombres() + " " + cliente.getApellidos()
        );

        txtTipoCliente.setText(cliente.getTipoCliente());
        txtCiudad.setText(cliente.getCiudad());
        txtFechaNacimiento.setText(cliente.getFechaNacimiento().toString());
        txtTipoSolicitud.setText(cliente.getTipoSolicitud());
    }

    @FXML
    private void volverConsulta() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/produ/jes12/registroconsulta/consulta.fxml"
                    )
            );

            Parent root = loader.load();

            Stage stage = (Stage) txtNombreCompleto
                    .getScene()
                    .getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}