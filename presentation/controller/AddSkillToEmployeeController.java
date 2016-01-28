package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.Department;
import domain.Employee;
import domain.Skill;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class AddSkillToEmployeeController implements Initializable, ControlledScreen {
//
	@FXML
	private ComboBox<Department> comboDepartment;

	@FXML
	private ComboBox<Skill> comboSkill;

	@FXML
	private Button btnAdd;

	private ScreenController screenController;
	private Controller appController;
	private List<Department> departments = null;
	private List<?> data;
	private List<Skill> skills = null;
	private Skill skill;
	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void btnAdd(ActionEvent event) {
		
		screenController.setScreen("employeeProfile", data);
		appController.addEmployeeSkill(skill, (Employee) data.get(0));
		stage.close();
	}
	
	@Override
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void addComboDepartmentListener() {
		departments = appController.fetchAllDepartments();
		
		comboDepartment.setItems(FXCollections.observableArrayList(departments));
		comboDepartment.getSelectionModel().selectedItemProperty().addListener(e -> {
			if (comboSkill.isDisabled()) {
				comboSkill.setDisable(false);
			}
			if(comboDepartment.getSelectionModel().selectedItemProperty().get() != null) {
			loadSkills(comboDepartment.getSelectionModel().selectedItemProperty().get().getId());
			}
		});
	}

	public void addComboSkillListener() {
		comboSkill.getSelectionModel().selectedItemProperty().addListener(e -> {
			skill = comboSkill.getSelectionModel().selectedItemProperty().get();
			if (btnAdd.isDisabled()) {
				btnAdd.setDisable(false);
			}
		});
	}
	
	public void loadSkills(int id) {
		skills = appController.fetchDepartmentSkills(id);
		comboSkill.setItems(FXCollections.observableArrayList(skills));
	}
	
	public void setAppController(Controller appController) {
		this.appController = appController;
	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
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
		addComboDepartmentListener();
		addComboSkillListener();
	}

}
