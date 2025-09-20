module com.template.template {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.template.template to javafx.fxml;
    exports com.template.template;
}