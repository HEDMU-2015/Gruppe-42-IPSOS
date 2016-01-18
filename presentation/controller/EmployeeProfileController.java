package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import presentation.CreateWindow;

public class EmployeeProfileController implements Initializable {

	@FXML
	private TreeView<String> department, skill, treeView;

	@FXML
	private Label lblName;

	@FXML
	private Label lblEmail;

	@FXML
	private Button btnAddSkill;

	@FXML
	private Button btnRemoveSkill;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnAddSkill(ActionEvent event) {
		CreateWindow createWindow = new CreateWindow("/fxml/AddSkillToEmployee.fxml");
		createWindow.windowCreater();
	}

	public void btnRemoveSkill(ActionEvent event) {

	}

}
