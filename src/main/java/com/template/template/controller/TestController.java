package com.template.template.controller;

import com.template.template.model.User;
import com.template.template.service.UserService;
import com.template.template.view.ControlledScreen;
import com.template.template.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TestController implements ControlledScreen {

    private UserService service = new UserService();
    private ViewManager viewManager;

    @FXML
    private TextField nameField, ageField;


    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    @FXML
    public void handleSubmitData(ActionEvent actionEvent) {
        String name = nameField.getText();
        String ageText = ageField.getText();

        if (name.isEmpty() || ageText.isEmpty()) {
            System.out.println("⚠ Please fill in all fields!");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            User user = new User(name, age);
            service.addUser(user);

            nameField.clear();
            ageField.clear();

        } catch (NumberFormatException e) {
            System.out.println("⚠ Age must be a number!");
        }
    }

    @FXML
    public void handleSwitch(ActionEvent actionEvent) {
        try {
            viewManager.showView("Page.fxml", "Other Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
