package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class ASUHelloWorldJavaFX extends Application {
    
    public void start(Stage stage) throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("Effortlogin.fxml"));
    	Scene scene = new Scene(root); 
    	stage.setScene(scene);
        stage.show();
    }
}
