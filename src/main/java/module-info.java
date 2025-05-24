module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    exports org.example;
    exports org.example.controllers;
    opens org.example.controllers;
}
