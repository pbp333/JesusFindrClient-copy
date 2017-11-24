package org.academiadecodigo.hackathon.jesusfindr.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class ChatController implements Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView avatarShow;

    @FXML
    private TextArea chatWindow;

    @FXML
    private Label usernameShow;

    @FXML
    private Label ageShow;

    @FXML
    private Label spiritAnimalShow;

    @FXML
    private TextField chatWritter;

    @FXML
    private Button logoutButton;

    @FXML
    private Button unmatchButton;

    @FXML
    void logout(ActionEvent event) {

        Navigation.getInstance().loadScreen("initialscreen");
    }

    @FXML
    void unmatch(ActionEvent event) {

    }

    @FXML
    void sendMessage(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            String username = ((LoginController) Navigation.getInstance().getControllers().get("loginscreen")).getUsername();
            String message = chatWritter.getText() + "\n";

            Client.getInstance().sendMessage(username + ": " + message);
            chatWindow.appendText(username + ": " + message);
            chatWritter.setText("");
        }
    }

    @FXML
    void initialize() {
        chatWindow.setEditable(false);
    }

    public TextArea getChatWindow() {
        return chatWindow;
    }
}
