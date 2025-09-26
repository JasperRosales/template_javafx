package com.template.template;

import com.template.template.view.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewManager viewManager = new ViewManager(stage);
        viewManager.showView("test.fxml", "Test Page");

    }
}
