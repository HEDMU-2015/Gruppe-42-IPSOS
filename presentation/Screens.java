package presentation;

public enum Screens {
	MAIN_WINDOW_MENU("../presentation/fxml/MenuWithMainWindow.fxml"),
	TABLE_VIEW_BY_NAME("../presentation/fxml/TableViewByName.fxml"),
	TABLE_VIEW_BY_SKILLS("../presentation/fxml/TableViewBySkills.fxml"),
	ADD_SKILL_TO_EMPLOYEE("../presentation/fxml/AddSkillToEmployee.fxml"),
	DEPARTMENT_AND_SKILLS("../presentation/fxml/DepartmentAndSkills.fxml"),
	EMPLOYEE_PROFILE("../presentation/fxml/EmployeeProfile.fxml"),
	FIND_EMPLOYEE("../presentation/fxml/FindEmployee.fxml"),
	WELCOME_WINDOW("../presentation/fxml/WelcomeWindow.fxml");
	
	
	private String fxmlPath;

	private Screens(String fxmlPath) {
		this.fxmlPath = fxmlPath;
	}
	
	public String getPath() {
		return this.fxmlPath;
	}

	
}
