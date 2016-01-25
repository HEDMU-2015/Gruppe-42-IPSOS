package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.CreateWindow;
import presentation.ScreenController;

public class EmployeeProfileController implements Initializable, ControlledScreen {
//
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

	private ScreenController screenController;
	private Controller appController;
	List<?> data = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnAddSkill(ActionEvent event) {
		CreateWindow createWindow = new CreateWindow("/presentation/fxml/AddSkillToEmployee.fxml");
		createWindow.windowCreater();
	}

	public void btnRemoveSkill(ActionEvent event) {

	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}

	@Override
	public void setAppController(Controller appController) {
		this.appController = appController;
	}
	
	@Override
	public List<?> getData() {
		return this.data;
	}

	@Override
	public void setData(List<?> data) {
		this.data = data;
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
