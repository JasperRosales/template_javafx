module com.template.template {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;
    requires java.sql;

    opens com.template.template.controller to javafx.fxml;

    exports com.template.template;
    exports com.template.template.controller;
    exports com.template.template.view;
}
