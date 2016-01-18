package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class AddSkillToEmployeeController implements Initializable {

	@FXML
	private ComboBox<String> choiceDepartments;

	@FXML
	private ComboBox<String> choiceSkills;

	@FXML
	private Button btnAdd;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void btnAdd(ActionEvent event) {
		
	}
	
	

}
