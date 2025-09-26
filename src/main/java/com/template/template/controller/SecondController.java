package com.template.template.controller;

import com.template.template.model.User;
import com.template.template.service.UserService;
import com.template.template.view.ControlledScreen;
import com.template.template.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondController implements ControlledScreen {

    private UserService service = new UserService();
    private ViewManager viewManager;

    @FXML
    private TextField fetchTextBox;

    @FXML
    private Label nameFetch, ageFetch;

    @Override
    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public void handleFetchData(ActionEvent actionEvent) {
        String nameToFetch = fetchTextBox.getText();

        if (nameToFetch == null || nameToFetch.isBlank()) {
            nameFetch.setText("Please enter a name");
            ageFetch.setText("");
            return;
        }

        try {
            User user = service.getUserFromName(nameToFetch);

            if (user != null) {
                nameFetch.setText(user.getName());
                ageFetch.setText(String.valueOf(user.getAge()));
            } else {
                nameFetch.setText("No user found");
                ageFetch.setText("");
            }

        } catch (Exception e) {
            e.printStackTrace();
            nameFetch.setText("Error fetching user");
            ageFetch.setText("");
        }
    }


    public void handleBack(ActionEvent actionEvent) {
        try {
            viewManager.showView("test.fxml", "Main Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
