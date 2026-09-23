package produ.jes12.registroconsulta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import produ.jes12.registroconsulta.controllers.DetalleController;
import produ.jes12.registroconsulta.model.ClienteRepository;

import java.io.IOException;

public class DetalleApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/produ/jes12/registroconsulta/detalle.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener el controlador e inyectarle el primer cliente de prueba
        DetalleController controller = fxmlLoader.getController();
        if (!ClienteRepository.getInstance().getClientes().isEmpty()) {
            controller.setCliente(ClienteRepository.getInstance().getClientes().get(0));
        }

        Scene scene = new Scene(root, 400, 480);
        stage.setTitle("Detalle del Cliente");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}