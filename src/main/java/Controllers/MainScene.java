package Controllers;

import Exceptions.IllegalInputException;
import io.cucumber.datatable.internal.difflib.StringUtills;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import system.app.PMA;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainScene  {
    public static String name;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    public PMA pma;

    @FXML
    public TextField Initials_holder;
    public Button loginbutton;
    String user_initials;


    public void goToSystem(ActionEvent event) throws IOException, IllegalInputException {
        URL url = new File("src/test/resources/fxml/systemScene.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        name = Initials_holder.getText();
        login();
    }

    public void login() throws IOException, IllegalInputException {
        if (Initials_holder.getText().length() <=4 && Initials_holder.getText().matches("^[a-zA-Z]*$") ){
            stage.setScene(scene);
            initSystem();
            stage.show();
        }  else {
            errorAlert.setContentText("Illegal input. Input Must be initials of four letters");
            errorAlert.showAndWait();
            throw new IllegalInputException("Illegal input. Input Must be initials of four letters");
        }
    }

    public void initSystem() {
        String user_initials = Initials_holder.getText();
        systemScene.setInitials(user_initials);
    }
}

