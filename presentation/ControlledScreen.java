package presentation;

import java.util.List;

import javafx.stage.Stage;
import logic.Controller;

public interface ControlledScreen {

	static List<?> data = null;
 	
	public void setScreenController(ScreenController screenController);
	
	public void setAppController(Controller appController);
	
	public List<?> getData();

	public void setData(List<?> data);
	
	public void init();
	
	default public void setStage(Stage stage) {
		
	}

}
