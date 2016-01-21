package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class AddSkillToEmployeeController implements Initializable, ControlledScreen {
//
	@FXML
	private ComboBox<String> choiceDepartments;

	@FXML
	private ComboBox<String> choiceSkills;

	@FXML
	private Button btnAdd;

	private ScreenController screenController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public void btnAdd(ActionEvent event) {
		screenController.setScreen("addSkillToEmployee");
		
	}
	
	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}
	

}
