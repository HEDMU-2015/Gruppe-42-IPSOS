package presentation.controller;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import domain.Department;
import domain.Employee;
import domain.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafxutils.TreeBuilder;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.CreateWindow;
import presentation.ScreenController;
import presentation.Screens;

public class EmployeeProfileController implements Initializable, ControlledScreen {
	//
	@FXML
	private TreeView<String> treeView;

	private TreeItem<String> root = new TreeItem<>("Departments");
	private TreeItem<String> leaf;

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
	List<Skill> skills;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void init() {
		lblName.setText(data.get(0).getName());
		lblEmail.setText(data.get(0).getEmail());
		TreeBuilder treeBuilder = new TreeBuilder();
		Map<Integer, Department> tree = appController.fetchEmployeeDepartments(data.get(0).getId());
		skills = appController.fetchEmployeeSkills(data.get(0).getId());
		treeBuilder.buildTree(tree);
		buildTreeView(tree, root);
		root.setExpanded(true);
		treeView.setRoot(root);
	}

	public void btnAddSkill(ActionEvent event) {
		CreateWindow createWindow = new CreateWindow(Screens.ADD_SKILL_TO_EMPLOYEE.getPath());
		createWindow.setAppController(this.appController);
		createWindow.setScreenController(this.screenController);
		createWindow.setData(data);
		createWindow.windowCreater();
	}

	public void btnRemoveSkill(ActionEvent event) {
		// appController.removeEmployeeSkill(skill, data.get(0));
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

	public void buildTreeView(Map<Integer, Department> tree, TreeItem<String> root) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while (itr.hasNext()) {
			Department d = tree.get(itr.next());

			TreeItem<String> leaf = new TreeItem<String>(d.getName());
			for (Skill skill : skills) {
				if (skill.getDepartmentId() == d.getId()) {
					TreeItem<String> skillLeaf = new TreeItem<String>(skill.getName());
					leaf.getChildren().add(skillLeaf);
				}
			}
			root.getChildren().add(leaf);
			if (!d.getChildren().isEmpty()) {
				buildTreeView(d.getChildren(), leaf);
			}
		}
	}
}
