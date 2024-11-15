module bank.system {
    exports com.example;
    exports com.example.controllers;
    exports com.example.models;
    
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example.controllers to javafx.fxml;
}
