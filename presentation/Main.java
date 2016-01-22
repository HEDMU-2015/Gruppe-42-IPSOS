package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
//
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ScreenController sc = new ScreenController();
		sc.loadScreen("mainWindow", Screens.MAIN_WINDOW);
		sc.loadScreen("addSkillToEmployee", Screens.ADD_SKILL_TO_EMPLOYEE);
		sc.loadScreen("departmentAndSkills", Screens.DEPARTMENT_AND_SKILLS);
		sc.loadScreen("employeeProfile", Screens.EMPLOYEE_PROFILE);
		sc.loadScreen("findEmployee", Screens.FIND_EMPLOYEE);
		
		sc.setScreen("mainWindow");
		sc.toBack();
		AnchorPane ancPane = null;
		try {
			 ancPane = FXMLLoader.load(getClass().getResource(Screens.MAIN_WINDOW_MENU.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ancPane.getChildren().add(0, sc);
		Scene scene = new Scene(ancPane);
		stage.setScene(scene);
		stage.show();
	}

}
