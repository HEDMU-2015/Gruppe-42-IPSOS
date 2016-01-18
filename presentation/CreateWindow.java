package presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateWindow {

	String fxmlPath;
	String cssPath = "/presentation/application.css";

	public CreateWindow(String fxmlPath) {
		this.fxmlPath = fxmlPath;
	}

	public void windowCreater() {
		try {
			Stage window = new Stage();
			CreateIcon createIcon = new CreateIcon(window);
			createIcon.iconCreater();
			Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(cssPath).toExternalForm());
			window.setScene(scene);
			window.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
