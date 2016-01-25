package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class DepartmentAndSkillsController implements Initializable, ControlledScreen {
//
	@FXML
	private TreeView<String> treeView;

	@FXML
	private Button btnCreateDepartment;

	@FXML
	private Button btnCreateSkill;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnChange;

	private ScreenController screenController;
	private Controller appController;
	List<?> data = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnCreateDepartment(ActionEvent event) {

	}

	public void btnCreateSkill(ActionEvent event) {

	}

	public void btnDelete(ActionEvent event) {

	}

	public void btnChange(ActionEvent event) {

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
