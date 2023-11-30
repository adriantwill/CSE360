package asuHelloWorldJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SceneController implements Initializable{
	
	@FXML
	private Button startbutton;
	@FXML
	private Button finalbutton;
	@FXML
	private Rectangle colorrec;
	@FXML
	private Label examplelabel;
	@FXML
	private ChoiceBox<String> projectchoice;
	@FXML
	private ChoiceBox<String> lifecyclechoice;
	@FXML
	private ChoiceBox<String> effortchoice;
	@FXML
	private ChoiceBox<String> planchoice;
	@FXML
	private Label otherdetails;
	@FXML
	private TextField othertext;
	@FXML
	private Label errorLabel;
	
	private String[] projects = {"Business Project", "Development Project", "Operational Projects", "Strategic Project"};
	private String[] lifecycle = {"Planning Information", "Gathering Information", "Understanding", "Verifying"};
	private String[] efforts = {"Plans", "Deliverables", "Interruptions", "Defects", "Others"};
	private String[] deliverables = {"Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", "Outline", "Other"};
	private String[] plans = {"Project Plan", "Risk Management", "Plan Conceptual", "Design Plan", "Detailed Design Plan", "Implementation Plan"};
	private String[] interuptions = {"Break", "Phone", "Teammate", "Visitor", "Other"};
	private String[] defects = {"Defect1", "Defect2", "Other"};
	private long starttime;
	private long endtime;
	private long finaltime;
	
	public void clockstart(ActionEvent event) {
		starttime = System.currentTimeMillis();
		colorrec.setFill(Color.LIME);
		examplelabel.setText("Clock is running");
	}

	public String getProject(ActionEvent event) {
		String selection = projectchoice.getValue();
		return selection;
	}
	public String getLifeCycle(ActionEvent event) {
		String selection = lifecyclechoice.getValue();
		return selection;
	}
	public String getEffort(ActionEvent event) {
		String selection = effortchoice.getValue();
		if (selection == null || selection.isEmpty()) {
			return null;
		}
		if (effortchoice.getValue().equals("Plans")) {
			planchoice.getItems().removeAll();
			planchoice.getItems().addAll(plans);
			planchoice.setOnAction(this::getPlans);
		} else if (effortchoice.getValue().equals("Deliverables")) {
			planchoice.getItems().removeAll();
			planchoice.getItems().addAll(deliverables);
			planchoice.setOnAction(this::getPlans);
		} else if (effortchoice.getValue().equals("Interruptions")) {
			planchoice.getItems().removeAll();
			planchoice.getItems().addAll(interuptions);
			planchoice.setOnAction(this::getPlans);
		} else if (effortchoice.getValue().equals("Defects")) {
			planchoice.getItems().removeAll();
			planchoice.getItems().addAll(defects);
			planchoice.setOnAction(this::getPlans);
		}
		if (selection.equals("Others")) {
			otherdetails.setText("Enter other details here: ");
			othertext.setVisible(true);
		}
		return selection;
	}
	public String getPlans(ActionEvent event) {
		String selection = planchoice.getValue();
		if (selection == null || selection.isEmpty()) {
			return null;
		}
		if (selection.equals("Other")) {
			otherdetails.setText("Specify details here: ");
			othertext.setVisible(true);
		}
		return selection;
	}
	public long finalsubmit(ActionEvent event) {
		endtime = System.currentTimeMillis();
		finaltime = (endtime-starttime) / 1000;
		colorrec.setFill(Color.RED);
		examplelabel.setText("Clock is stopped");
		System.out.println("Project type: " + getProject(event));
		System.out.println("Life cycle: " + getLifeCycle(event));
		System.out.println("Effort: " + getEffort(event));
		System.out.println("Plans: " + getPlans(event));
		System.out.println("Time: " + finaltime + " seconds");
		return finaltime;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		othertext.setVisible(false);
		projectchoice.getItems().addAll(projects);
		projectchoice.setOnAction(this::getProject);
		lifecyclechoice.getItems().addAll(lifecycle);
		lifecyclechoice.setOnAction(this::getLifeCycle);
		effortchoice.getItems().addAll(efforts);
		effortchoice.setOnAction(this::getEffort);
		
		
	}
}