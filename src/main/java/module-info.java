module com.example.text {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.fxmisc.richtext;

    opens com.example.text to javafx.fxml;
    exports com.example.text;
    exports com.example.text.controller;
    opens com.example.text.controller to javafx.fxml;
}