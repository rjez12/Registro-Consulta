package produ.jes12.registroconsulta.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.List;

public class ClienteRepository {

    private static final ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private static ClienteRepository instance;

    static {
        clientes.add(new Cliente(
                "Carlos", "Mendoza", "Persona Natural", "Managua",
                LocalDate.of(1995, 5, 14), "Soporte",
                List.of("Mantenimiento"), "", "C:\\Expedientes\\CarlosMendoza"
        ));
        clientes.add(new Cliente(
                "Empresa Alfa", "S.A.", "Empresa / Corporativo", "León",
                LocalDate.of(2010, 8, 22), "Cotización",
                List.of("Consultoría", "Desarrollo"), "", "C:\\Expedientes\\EmpresaAlfa"
        ));
    }

    private ClienteRepository() {}

    // Permite usar .getInstance() en DetalleApplication
    public static synchronized ClienteRepository getInstance() {
        if (instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    // Permite usar ClienteRepository.getClientes() directamente en ConsultaController
    public static ObservableList<Cliente> getClientes() {
        return clientes;
    }

    // Permite usar ClienteRepository.agregarCliente(...) en RegistroController
    public static void agregarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }
}