package presentation;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreateIcon {

	public String iconPath = "http://goo.gl/9gO4sn";
	public Stage window;

	public CreateIcon(Stage window) {
		this.window = window;
	}

	public void iconCreater() {
		Image icon = new Image(iconPath);
		window.getIcons().add(icon);
	}
}
