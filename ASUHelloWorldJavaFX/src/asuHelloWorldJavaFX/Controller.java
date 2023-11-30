package asuHelloWorldJavaFX;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller{
	@FXML
	private TextField usertext;
	@FXML
	private TextField passtext;
	@FXML
	private Label errorLabel;
	@FXML 
	private Button myButton;
	
	String username;
	String password;
	
	private Stage stage; 
	private Scene scene; 
	private Parent root;
	
	private String[] usernames = {"testuser1", "testuser2", "testuser3"};
	private String[] passwords = {"pass123", "pass1234", "pass12345"};
	
	public void switchScene(ActionEvent event) throws IOException{
	}
	public void submit(ActionEvent event) throws IOException {
		username = usertext.getText();
		password = passtext.getText();
		if (password.length() < 6) {
				errorLabel.setText("Error: Password too short");
		}
		for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(username)) {
                if (passwords[i].equals(password)) {
                	Parent root = FXMLLoader.load(getClass().getResource("Effortconsole.fxml"));
        			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        			scene = new Scene(root);
        			stage.setScene(scene);
        			stage.show();	
                }
            } else {
            	errorLabel.setText("Incorrect username or password");
            }
        }
	}
}