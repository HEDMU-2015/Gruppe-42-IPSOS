package presentation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class WelcomeWindowController implements Initializable, ControlledScreen {

	ScreenController sc;
	
	@Override
	public void setScreenController(ScreenController screenController) {
		this.sc = screenController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
