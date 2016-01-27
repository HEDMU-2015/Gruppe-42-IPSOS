package presentation.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import domain.Department;
import domain.Employee;
import domain.Skill;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class FindEmployeeController implements Initializable, ControlledScreen {
	//
	@FXML
	private ComboBox<Skill> comboSkill;
	@FXML
	private ComboBox<Department> comboDepartment;
	@FXML
	private Button btnFind;
	@FXML
	private FlowPane chosenSkills;

	private ScreenController screenController;
	private Controller appController;
	private List<?> data = null;
	private List<Department> departments = null;
	private List<Skill> skills = null;
	private List<Skill> chosenSkillsList = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnFind(ActionEvent event) {
		if (!chosenSkillsList.isEmpty()) {
			employees = appController.findEmployee(chosenSkillsList);
			screenController.setScreen("tableViewBySkills", employees);
			chosenSkillsList.removeAll(chosenSkillsList);
			chosenSkills.getChildren().clear();
			comboSkill.getItems().clear();
			comboSkill.setDisable(true);
		}
		
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
		addComboDepartmentListener();
		addComboSkillListener();
	}

	public void loadSkills(int id) {
		skills = appController.fetchDepartmentSkills(id);
		comboSkill.setItems(FXCollections.observableArrayList(skills));
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
			Skill skill = comboSkill.getSelectionModel().selectedItemProperty().get();
			if (skill != null && !listContains(chosenSkillsList, skill)) {
				Label label = new Label(skill.getName());
				label.setStyle("-fx-background-color: white");
				label.setPadding(new Insets(4, 4, 4, 4));
				FlowPane.setMargin(label, new Insets(4, 4, 4, 4));
				Button btn = new Button("x");
				btn.setStyle("-fx-background-color: transparent");
				label.setGraphic(btn);
				label.setContentDisplay(ContentDisplay.RIGHT);
				chosenSkills.getChildren().add(label);
				chosenSkillsList.add(skill);
				removeSkillButtonAction(btn, label, skill);
			}
		});
	}

	public boolean listContains(List<Skill> skills, Skill skill) {
		for (Skill s : skills) {
			if (s.getName().equalsIgnoreCase(skill.getName()))
				return true;
		}
		return false;
	}

	public void removeSkillButtonAction(Button btn, Label label, Skill skill) {
		btn.setOnAction(e -> {
			chosenSkills.getChildren().remove(label);
			chosenSkillsList.remove(skill);
		});
	}
}
