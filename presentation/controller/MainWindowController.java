package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.AbstractFXMLController;
import presentation.ControlledScreen;
import presentation.CreateWindow;
import presentation.ScreenController;
import presentation.Screens;

public class MainWindowController implements Initializable, ControlledScreen {
	@FXML
	private Button btnFindSkills;

	@FXML
	private TextField txtfieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableView<String> tableView;

	@FXML
	private Button btnDAS;

	@FXML
	private Button btnEAS;

	ScreenController screenController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void btnFindEmployee(ActionEvent event) {
		screenController.setScreen("findEmployee");
	}

	public void btnSearchEmployeeByName(ActionEvent event) {
		
	}

	public void btnDAS(ActionEvent event) {
		screenController.setScreen("departmentAndSkills");
	}

	public void btnEAS(ActionEvent event) {
		screenController.setScreen("employeeProfile");
	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}
}
