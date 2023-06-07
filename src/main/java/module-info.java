module com.carmengitit.ws02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.carmengitit.ws02 to javafx.fxml;
    exports com.carmengitit.ws02;
    exports com.carmengitit.ws02.controller;
    opens com.carmengitit.ws02.controller to javafx.fxml;
}