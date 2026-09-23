package produ.jes12.registroconsulta.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.model.Cliente;
import produ.jes12.registroconsulta.model.ClienteRepository;

import java.io.IOException;
import java.time.LocalDate;

public class ConsultaController {

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> colNombreCompleto;

    @FXML
    private TableColumn<Cliente, String> colTipoCliente;

    @FXML
    private TableColumn<Cliente, String> colCiudad;

    @FXML
    private TableColumn<Cliente, LocalDate> colFechaNacimiento;

    @FXML
    private TableColumn<Cliente, String> colTipoSolicitud;

    @FXML
    public void initialize() {

        colNombreCompleto.setCellValueFactory(
                new PropertyValueFactory<>("nombreCompleto")
        );

        colTipoCliente.setCellValueFactory(
                new PropertyValueFactory<>("tipoCliente")
        );

        colCiudad.setCellValueFactory(
                new PropertyValueFactory<>("ciudad")
        );

        colFechaNacimiento.setCellValueFactory(
                new PropertyValueFactory<>("fechaNacimiento")
        );

        colTipoSolicitud.setCellValueFactory(
                new PropertyValueFactory<>("tipoSolicitud")
        );

        tablaClientes.setItems(
                ClienteRepository.getClientes()
        );
    }

    @FXML
    private void seleccionarCliente(MouseEvent event) {

        if (event.getClickCount() == 2) {

            Cliente clienteSeleccionado =
                    tablaClientes
                            .getSelectionModel()
                            .getSelectedItem();

            if (clienteSeleccionado != null) {
                abrirDetalle(clienteSeleccionado);
            }
        }
    }

    private void abrirDetalle(Cliente cliente) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/produ/jes12/registroconsulta/detalle.fxml"
                            )
                    );

            Parent root = loader.load();

            DetalleController detalleController =
                    loader.getController();

            detalleController.setCliente(cliente);

            Stage stage =
                    (Stage) tablaClientes
                            .getScene()
                            .getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}