package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Controller;
import logic.ControllerImpl;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Controller appController = new ControllerImpl();
		CreateIcon createIcon = new CreateIcon(stage);
		createIcon.iconCreater();
		ScreenController sc = new ScreenController(appController);
		sc.loadScreen("tableViewByName", Screens.TABLE_VIEW_BY_NAME);
		sc.loadScreen("addSkillToEmployee", Screens.ADD_SKILL_TO_EMPLOYEE);
		sc.loadScreen("departmentAndSkills", Screens.DEPARTMENT_AND_SKILLS);
		sc.loadScreen("employeeProfile", Screens.EMPLOYEE_PROFILE);
		sc.loadScreen("findEmployee", Screens.FIND_EMPLOYEE);
		sc.loadScreen("welcome", Screens.WELCOME_WINDOW);

		sc.setScreen("welcome");
		sc.toBack();
		AnchorPane ancPane = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Screens.MAIN_WINDOW_MENU.getPath()));
			ancPane = (AnchorPane) loader.load();
			
			ControlledScreen controlledScreen = (ControlledScreen) loader.getController();
			controlledScreen.setScreenController(sc);
			controlledScreen.setAppController(appController);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ancPane.getChildren().add(0, sc);
		Scene scene = new Scene(ancPane);
		stage.setScene(scene);
		stage.show();
	}

}
