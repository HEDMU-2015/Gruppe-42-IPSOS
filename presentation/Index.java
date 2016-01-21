package presentation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Index extends Application {
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
		Group group = new Group();
		group.getChildren().addAll(sc);
		Scene scene = new Scene(group);
		stage.setScene(scene);
		stage.show();
	}

}
