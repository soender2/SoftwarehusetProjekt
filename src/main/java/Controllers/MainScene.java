package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class MainScene {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public TextField Initials_holder;
    public Button loginbutton;



    public void goToSystem(ActionEvent event) throws IOException {
        URL url = new File("src/test/resources/fxml/systemScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        initSystem();
        stage.show();

    }

    public void initSystem() throws IOException{
            String user_initals = Initials_holder.getText();
            systemScene.setInitials(user_initals);

    }



}

