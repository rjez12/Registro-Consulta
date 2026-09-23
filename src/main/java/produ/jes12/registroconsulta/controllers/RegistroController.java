package produ.jes12.registroconsulta.controllers;

import produ.jes12.registroconsulta.util.AlertaUtil;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;


import java.io.File;

public class RegistroController {
    private AlertaUtil alertaUtil;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private ComboBox<String> cmbCuidad;

    @FXML
    private DatePicker dpFechaNac;

    @FXML
    private RadioButton rbSolicitudInscripcion;

    @FXML
    private RadioButton rbSolicitudReembolso;

    @FXML
    private RadioButton rbRenovacion;

    @FXML
    private ToggleGroup tgTipoSolicitud;

    @FXML
    private CheckBox cbServiciosInteres;

    @FXML
    private TextField txtFotografia;

    @FXML
    private ImageView ivFotografia;

    @FXML
    private Button btnSeleccionarFotografia;

    @FXML
    private TextField txtDireccionInformacionPersonal;

    @FXML
    private Button btnSeleccionarDirectorio;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private void initialize(){
        tgTipoSolicitud = new ToggleGroup();
        rbSolicitudInscripcion.setToggleGroup(tgTipoSolicitud);
        rbRenovacion.setToggleGroup(tgTipoSolicitud);
        rbSolicitudReembolso.setToggleGroup(tgTipoSolicitud);

        cmbCuidad.getItems().addAll("Managua", "León", "Granada", "Masaya", "Estelí");
    }


    @FXML
    private void seleccionarSeleccionarDirectorio(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Imagen");


        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg")
        );

        File f =  fc.showOpenDialog(btnSeleccionarFotografia.getScene().getWindow());

        if(f != null){
            txtFotografia.setText(f.getAbsolutePath());

            Image image = new Image(f.toURI().toString());

            ivFotografia.setImage(image);
        }

    }

    @FXML
    private void seleccionarFotografia(){
        DirectoryChooser dc =  new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f =  dc.showDialog(btnSeleccionarDirectorio.getScene().getWindow());

        if(f != null){
            txtDireccionInformacionPersonal.setText(f.getAbsolutePath());
        }
    }


    @FXML
    private void guardarCliente(){
        if (validarFormulario()) {

            AlertaUtil.mostrarInfo("Éxito", "Registro guardado", "El cliente se ha registrado correctamente.");
            limpiarFormulario();
        }

        else{
            return;
        }
    }

    private Boolean validarFormulario(){
        if (!validarSoloLetras(txtNombres.getText())) {
            AlertaUtil.mostrarError("Error en Nombres", "Formato inválido", "Por favor llene el campo Nombres y verifique que solo contenga letras.");
            return false;
        }

        if (!validarSoloLetras(txtApellidos.getText())) {
            AlertaUtil.mostrarError("Error en Apellidos", "Formato inválido", "Por favor llene el campo Apellidos y verifique que solo contenga letras.");
            return false;
        }

        if (cmbCuidad.getValue() == null) {
            AlertaUtil.mostrarError("Falta Ciudad", "Campo incompleto", "Por favor seleccione una ciudad de la lista.");
            return false;
        }

        if (dpFechaNac.getValue() == null) {
            AlertaUtil.mostrarError("Falta Fecha", "Campo incompleto", "Por favor seleccione la fecha de nacimiento.");
            return false;
        }

        if (tgTipoSolicitud.getSelectedToggle() == null) {
            AlertaUtil.mostrarError("Falta Tipo de Solicitud", "Campo incompleto", "Por favor seleccione una opción en Tipo de solicitud.");
            return false;
        }

        if (txtFotografia.getText() == null || txtFotografia.getText().isBlank()) {
            AlertaUtil.mostrarError("Falta Fotografía", "Campo incompleto", "Por favor seleccione una fotografía para el cliente.");
            return false;
        }

        return true;
    }

    private Boolean validarSoloLetras(String text){
        String regexLetras = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$";


        if(text == null || text.isBlank()){
            alertaUtil.mostrarError("Texto Vacio", "No puede continuar con el campo vacio", "Por favor llene el campo y verifique que solo contenga letras");

            return false;
        }

        return text.matches(regexLetras);
    }



    @FXML
    private void limpiarFormulario(){
        txtNombres.clear();
        txtApellidos.clear();
        cmbCuidad.setValue(null);
        dpFechaNac.setValue(null);

        if (tgTipoSolicitud.getSelectedToggle() != null) {
            tgTipoSolicitud.getSelectedToggle().setSelected(false);
        }

        cbServiciosInteres.setSelected(false);
        txtFotografia.clear();
        ivFotografia.setImage(null);
        txtDireccionInformacionPersonal.clear();

    }


}
