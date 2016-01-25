package presentation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import logic.Controller;

public class ScreenController extends StackPane {
	Map<String, Node> map = new HashMap<>();
	Map<String, ControlledScreen> csMap = new HashMap<>();
	private Controller appController;
	Node newWindow = null;

	public ScreenController(Controller appController) {
		super();
		this.appController = appController;
	}

	public void loadScreen(String name, Screens fxmlPath) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath.getPath()));
			Parent screen = (Parent) loader.load();
			ControlledScreen cs = (ControlledScreen) loader.getController();
			cs.setScreenController(this);
			cs.setAppController(appController);
			csMap.put(name, cs);
			map.put(name, screen);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setScreen(String name) {
		setScreenNode(name, null);
		csMap.get(name).init();
	}

	public void setScreen(String name, List<?> data) {
		setScreenNode(name, data);
		csMap.get(name).setData(data);
		csMap.get(name).init();
	}
	
	private void setScreenNode(String name, List<?> data) {
		newWindow = map.get(name);
		if (!this.getChildren().isEmpty()) {
			this.getChildren().remove(getChildren().get(0));
			this.getChildren().add(0, newWindow);
		} else {
			this.getChildren().add(0, newWindow);
		}
	}

	public Node getScreen(String name) {
		return map.get(name);
	}

}
