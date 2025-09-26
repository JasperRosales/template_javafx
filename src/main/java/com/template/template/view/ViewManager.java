package com.template.template.view;

import com.template.template.MainApplication;
import com.template.template.view.ControlledScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewManager {

    private final Stage stage;

    public ViewManager(Stage stage) {
        this.stage = stage;
    }

    public <T> T showView(String fxmlFileName, String title) throws IOException {
        URL fxmlLocation = MainApplication.class.getResource(fxmlFileName);
        if (fxmlLocation == null) {
            throw new IOException("FXML file not found: " + fxmlFileName);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene newScene = new Scene(fxmlLoader.load());

        double width = stage.getWidth();
        double height = stage.getHeight();

        stage.setTitle(title);
        stage.setScene(newScene);

        if (width > 0 && height > 0) {
            stage.setWidth(width);
            stage.setHeight(height);
        }

        stage.show();

        T controller = fxmlLoader.getController();
        if (controller instanceof ControlledScreen controlled) {
            controlled.setViewManager(this);
        }

        return controller;
    }
}
