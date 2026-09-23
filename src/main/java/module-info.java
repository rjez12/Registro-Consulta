module produ.jes12.registroconsulta {
    requires javafx.controls;
    requires javafx.fxml;

    opens produ.jes12.registroconsulta.controllers to javafx.fxml;
    opens produ.jes12.registroconsulta.model to javafx.base;

    exports produ.jes12.registroconsulta; // <-- Necesario para ejecutar las Applications
}