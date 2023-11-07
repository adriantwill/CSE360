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
	
	public void switchScene(ActionEvent event) throws IOException{
				
	}
	
	
	public void submit(ActionEvent event) throws IOException {
		username = usertext.getText();
		password = passtext.getText();
		if (password.length() < 6) {
			errorLabel.setText("Error: Password too short");
		}
		else if ((username.equals("testuser")) && (password.equals("123pass"))){
			Parent root = FXMLLoader.load(getClass().getResource("Effortconsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			errorLabel.setText("Error: Incorrect password");
		}		
		
	}
}
