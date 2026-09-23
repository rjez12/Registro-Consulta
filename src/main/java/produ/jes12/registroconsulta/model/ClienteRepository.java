package produ.jes12.registroconsulta.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class ClienteRepository {

    private static ClienteRepository instance;
    private final ObservableList<Cliente> clientes;

    private ClienteRepository() {
        this.clientes = FXCollections.observableArrayList();
        cargarDatosDePrueba(); // Datos iniciales para verificar la tabla de inmediato
    }

    // Acceso global único (Singleton)
    public static synchronized ClienteRepository getInstance() {
        if (instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    public ObservableList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // Clientes de ejemplo para que la tabla no esté vacía al iniciar
    private void cargarDatosDePrueba() {
        clientes.add(new Cliente(
                "Carlos", "Mendoza", "Persona Natural", "Managua",
                LocalDate.of(1995, 5, 14), "Soporte",
                List.of("Mantenimiento"), "", "C:\\Expedientes\\CarlosMendoza"
        ));

        clientes.add(new Cliente(
                "Empresa Hermanos Pollos", "S.A.", "Empresa / Corporativo", "León",
                LocalDate.of(2010, 8, 22), "Cotización",
                List.of("Consultoría", "Desarrollo"), "", "C:\\Expedientes\\EmpresaAlfa"
        ));
    }
}