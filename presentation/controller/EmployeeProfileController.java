package presentation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.Employee;
import domain.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.CreateWindow;
import presentation.ScreenController;
import utils.IpsosLogger;

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
		this.data = (List<Employee>) data;

	}

	@Override
	public void init() {
		Employee employee = data.get(0);
		lblName.setText(employee.getName());
		lblEmail.setText(employee.getEmail());

		Image image = null;
		try {
			File file = new File(
					System.getProperty("user.dir") + File.separator + "presentation" + File.separator + "folder.png");
			image = new Image(new FileInputStream(file));
		} catch (Exception e) {
			IpsosLogger.getInstance().error(e);
		}
		Node folderIcon = new ImageView(image);

		Employee employeeProfile = appController.getEmployeeProfile(employee.getId());
		TreeItem<String> rootItem = new TreeItem<String>("Departments", folderIcon);
		// int departmentId = -1;
		// int parentId = -1;
		TreeItem<String> leaf = null;
		buildTree(employeeProfile.getSkills(), rootItem, leaf, 0);
	}

	public void buildTree(List<Skill> skills, TreeItem<String> rootItem, TreeItem<String> leaf, int start) {

		int listSize = skills.size();
		int departmentId = -1;
		for (int i = start; i < listSize; i++) {
			if (!skills.get(i).getDepartment().isChild()) {
				leaf = new TreeItem<String>(skills.get(i).getDepartment().getName());
				rootItem.getChildren().add(leaf);
				departmentId = skills.get(i).getDepartment().getId();
				for (int b = i++; b < listSize; b++) {
					if (skills.get(b).getDepartment().isChild() && departmentId == skills.get(b).getDepartment().getParent_id()) {
						TreeItem<String> child = new TreeItem<String>(skills.get(b).getDepartment().getName());
						leaf.getChildren().add(child);
					}
				}
			} else {
				buildTree(skills, rootItem, leaf, i);
			}
		}

		rootItem.setExpanded(true);
		treeView.setRoot(rootItem);
	}

	public void extractParentsChildren() {

	}
}
