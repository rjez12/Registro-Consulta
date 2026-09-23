package produ.jes12.registroconsulta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/produ/jes12/registroconsulta/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 580);
        stage.setTitle("Sistema de Gestión de Clientes - Menú Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}