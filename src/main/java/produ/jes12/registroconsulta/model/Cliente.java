package produ.jes12.registroconsulta.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombres;
    private String apellidos;
    private String tipoCliente;
    private String ciudad;
    private LocalDate fechaNacimiento;
    private String tipoSolicitud;
    private List<String> serviciosInteres;
    private String rutaFotografia;
    private String rutaExpediente;

    // Constructor completo
    public Cliente(String nombres, String apellidos, String tipoCliente, String ciudad,
                   LocalDate fechaNacimiento, String tipoSolicitud,
                   List<String> serviciosInteres, String rutaFotografia, String rutaExpediente) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSolicitud = tipoSolicitud;
        this.serviciosInteres = (serviciosInteres != null) ? serviciosInteres : new ArrayList<>();
        this.rutaFotografia = rutaFotografia;
        this.rutaExpediente = rutaExpediente;
    }

    // Constructor por defecto
    public Cliente() {
        this.serviciosInteres = new ArrayList<>();
    }

    // Método utilitario para el TableView y vista de Detalle
    public String getNombreCompleto() {
        return (nombres != null ? nombres : "") + " " + (apellidos != null ? apellidos : "");
    }

    // Convierte la lista de servicios en una cadena legible separada por comas
    public String getServiciosComoTexto() {
        if (serviciosInteres == null || serviciosInteres.isEmpty()) {
            return "Ninguno";
        }
        return String.join(", ", serviciosInteres);
    }

    // Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public List<String> getServiciosInteres() {
        return serviciosInteres;
    }

    public void setServiciosInteres(List<String> serviciosInteres) {
        this.serviciosInteres = serviciosInteres;
    }

    public String getRutaFotografia() {
        return rutaFotografia;
    }

    public void setRutaFotografia(String rutaFotografia) {
        this.rutaFotografia = rutaFotografia;
    }

    public String getRutaExpediente() {
        return rutaExpediente;
    }

    public void setRutaExpediente(String rutaExpediente) {
        this.rutaExpediente = rutaExpediente;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + tipoCliente + " - " + ciudad + ")";
    }
}