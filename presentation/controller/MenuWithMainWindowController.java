/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.Employee;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class MenuWithMainWindowController implements Initializable, ControlledScreen {
	//
	@FXML
	private Button menu;
	@FXML
	private AnchorPane navList;
	@FXML
	private ToolBar menuBar;
	@FXML
	private Button findEmployeeBySkills;
	@FXML
	private Button findEmployeeByName;
	@FXML
	private Button AllDepartmentsAndSkills;
	@FXML
	private TextField inputName;

	private ScreenController screenController;
	private Controller appController;
	List<?> data = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		prepareSlideMenuAnimation();
		navList.setOnMouseClicked(e -> {
			navList.setTranslateX(-180);
		});
	}

	private void prepareSlideMenuAnimation() {
		TranslateTransition openNav = new TranslateTransition(new Duration(350), navList);
		openNav.setToX(0);
		TranslateTransition closeNav = new TranslateTransition(new Duration(350), navList);
		menu.setOnAction((ActionEvent evt) -> {
			if (navList.getTranslateX() != 0) {
				openNav.play();
			} else {
				closeNav.setToX(-(navList.getWidth()));
				closeNav.play();
			}
		});
	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;

	}

	public void findEmployeeBySkills(ActionEvent e) {
		screenController.setScreen("findEmployee");

	}

	public void allDepartmentsAndSkills(ActionEvent e) {
		screenController.setScreen("departmentAndSkills");
	}

	@Override
	public void setAppController(Controller appController) {
		this.appController = appController;
	}

	public void findEmployeeByName(ActionEvent e) {
		if (!inputName.getText().isEmpty()) {
			List<Employee> employees = appController.findEmployeeByName(inputName.getText().toLowerCase());
			screenController.setScreen("tableViewByName", employees);
		}
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
