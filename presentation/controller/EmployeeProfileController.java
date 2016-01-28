package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.CreateWindow;
import presentation.ScreenController;
import presentation.Screens;

public class EmployeeProfileController implements Initializable, ControlledScreen {
	//
	@FXML
	private TreeView<String> treeView;

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
	List<Employee> data = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@Override
	public void init() {
		lblName.setText(data.get(0).getName());
		lblEmail.setText(data.get(0).getEmail());
	}


	public void btnAddSkill(ActionEvent event) {
		CreateWindow createWindow = new CreateWindow(Screens.ADD_SKILL_TO_EMPLOYEE.getPath());
		createWindow.setAppController(this.appController);
		createWindow.setScreenController(this.screenController);
		createWindow.setData(data);
		createWindow.windowCreater();
	}

	public void btnRemoveSkill(ActionEvent event) {
//		appController.removeEmployeeSkill(skill, data.get(0));
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
		this.data = (List<Employee>) data;

	}

	
	
}
