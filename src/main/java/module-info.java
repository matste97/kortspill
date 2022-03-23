module no.ntnu.matste {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.matste to javafx.fxml;
    exports no.ntnu.matste;
}
