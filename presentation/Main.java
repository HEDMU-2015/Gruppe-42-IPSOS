package presentation;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		CreateWindow createWindow = new CreateWindow("/presentation/fxml/MainWindow.fxml");
		createWindow.windowCreater();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
