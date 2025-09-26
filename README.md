# template javafx
This is a template repository for making desktop application using java's framework "javafx". Which is an awesome tool for making modern desktop application. This is also integrated in Intelij, an IDE that is widely used for making apps in java. 

## Installation
Install first the following to proceed to the developing stage.

IDE: Intelij Community Edition for Free
```
https://www.jetbrains.com/idea/download/?section=linux
```
Java21 sdk (Choose the msi installer or pick what you prefer to use)
```
https://www.oracle.com/java/technologies/downloads/#java21
```
Tools: SceneBuilder for drag and drop design
```
https://gluonhq.com/products/scene-builder/
```

Git for cloning and version control
```
https://git-scm.com/downloads/
```

## Setup

Once installed successfully, proceed to CMD and type:
```
git --version //to check if git is installed
```

Next, paste this link along with the command. 
```
git clone https://github.com/JasperRosales/template_javafx.git
```
That will create a git folder of the template project. 

Then proceed to going that directory by opening intelij and select the folder of the generated template in your chosen path directory.

Once done, open the src folder and check the resources. Right click the fxml file and click the open with scenebuilder.
Then after that configure the scenebuilder.exe by finding its executable. 

Note: It is recommended that you know where the exe file is before you set it. Otherwise you will need to reconfigure it in the settings of Intelij, though it is easy to find :)


## Development

Intelij uses FXML as the frontend of the application and fxml-catered annotated codes. To make a cleaner approach, I recommend that you follow the mvc format. Model-View Controller, which seperates the following.
- Model - Scheme Models that handle data transfer to the database like users, admin, task, product and others.
```java
package com.template.template.model;

//Note Research on how to use lombok if you want to make your code clean as sheesh
//btw ang init ni aban


public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
```
Also there is a quicker way to generate this. Right click this file, then click generate and generate getters and setters to so that private variables can encapsulated through this process. 

- View - This is basically the fxml, remember the fxml file should hava a controller if you want it to have functionality otherwise it wont work the way as you intented.
```
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>

<?import javafx.scene.control.Button?>
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.template.template.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <Button text="Hello!" onAction="#onHelloButtonClick"/>
</VBox>

```
Notice how there is a controller assigned to the fxml file. This will be the java code where we will doing the logic. Note: Right click if and open with scenebuilder if you want to drag and drop edit the components.

- Controller - This is where you write the logic for your application. Always remember that each fxml has its respective controller. THEY ARE PAIRS!! Sample from the previous hello.fxml
```java
package com.template.template;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
```

If you are trying to change the database configurations. Go to the Resources folder, under it click the application.configuration. There you will configure the following: 
```
#Database
db.driver=com.mysql.cj.jdbc.Driver
db.username=YOURUSERNAME //default is root
db.password=YOURPASSWORD 
db.url=jdbc:mysql://localhost:3306/YOURDATABASE?useSSL=false&allowPublicKeyRetrieval=true //the database name that you are trying to connect to
```
