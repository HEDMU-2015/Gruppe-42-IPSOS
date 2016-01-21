package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import presentation.AbstractFXMLController;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class FindEmployeeController implements Initializable, ControlledScreen {

	@FXML
	private ComboBox<String> comboSkill;

	@FXML
	private Button btnFind;

	private ScreenController screenController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnFind(ActionEvent event) {

	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}
}
