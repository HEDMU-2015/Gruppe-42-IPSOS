package presentation;

import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Controller;

public class CreateWindow {

	private String fxmlPath;
	private String cssPath = "/presentation/fxml/style.css";
	private Controller appController;
	private ScreenController screenController;
	private Stage stage;
	private List<?> data;

	public CreateWindow(String fxmlPath) {
		this.fxmlPath = fxmlPath;
	}
	
	public void windowCreater() {
		try {
			stage = new Stage();
			CreateIcon createIcon = new CreateIcon(stage);
			createIcon.iconCreater();
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
			Parent parent = loader.load();
			ControlledScreen cs = loader.getController();
			cs.setAppController(appController);
			cs.setScreenController(screenController);
			cs.setData(data);
			cs.setStage(stage);
			cs.init();
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	public void setAppController(Controller appController) {
		this.appController = appController;
	}
	
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
	
	
}
