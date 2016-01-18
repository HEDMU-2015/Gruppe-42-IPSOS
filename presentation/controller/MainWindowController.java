package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.CreateWindow;

public class MainWindowController implements Initializable {

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

	CreateWindow createWindow;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void btnFindSkills(ActionEvent event) {
		createWindow = new CreateWindow("/fxml/FindEmployee.fxml");
		createWindow.windowCreater();
	}

	public void btnSearch(ActionEvent event) {

	}

	public void btnDAS(ActionEvent event) {
		createWindow = new CreateWindow("/fxml/DepartmentAndSkills.fxml");
		createWindow.windowCreater();
	}

	public void btnEAS(ActionEvent event) {
		createWindow = new CreateWindow("/fxml/EmployeeProfile.fxml");
		createWindow.windowCreater();
	}
}
