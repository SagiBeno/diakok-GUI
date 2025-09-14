module com.example.diakok {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.diakok to javafx.fxml;
    exports com.example.diakok;
}