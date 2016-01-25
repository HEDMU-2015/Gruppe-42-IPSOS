/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
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
	private Button showAllDepartments;
	@FXML
	private Button showAllSkills;
	
	

	private ScreenController screenController;

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
	
	

}
