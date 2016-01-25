package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class WelcomeWindowController implements Initializable, ControlledScreen {

	ScreenController sc;
	private Controller appController;
	List<?> data = null;
	
	@Override
	public void setScreenController(ScreenController screenController) {
		this.sc = screenController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
