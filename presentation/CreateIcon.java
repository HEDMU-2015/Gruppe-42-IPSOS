package presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CreateIcon {

	public String iconPath = System.getProperty("user.dir") + File.separator + "presentation" + File.separator + "ipsos icon.png";
	public Stage window;

	public CreateIcon(Stage window) {
		this.window = window;
	}

	public void iconCreater() {
		Image icon = null;
		try {
			icon = new Image(new FileInputStream(new File(iconPath)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.getIcons().add(icon);
	}
}
