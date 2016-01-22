package presentation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreenController extends StackPane {
//
	Map<String, Node> map = new HashMap<>();
	
	public ScreenController() {
		super();
	}

	public void loadScreen(String name, Screens fxmlPath) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath.getPath()));
			Parent screen = (Parent) loader.load();
			ControlledScreen cs = (ControlledScreen) loader.getController();
			cs.setScreenController(this);
			map.put(name, screen);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setScreen(String name) {
		Node newWindow = map.get(name);
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
