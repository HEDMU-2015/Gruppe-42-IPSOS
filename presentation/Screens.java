package presentation;

public enum Screens {
	MAIN_WINDOW_MENU("../presentation/fxml/MenuWithMainWindow.fxml"),
	TABLE_VIEW_WINDOW("../presentation/fxml/TableView.fxml"),
	ADD_SKILL_TO_EMPLOYEE("../presentation/fxml/AddSkillToEmployee.fxml"),
	DEPARTMENT_AND_SKILLS("../presentation/fxml/DepartmentAndSkills.fxml"),
	EMPLOYEE_PROFILE("../presentation/fxml/EmployeeProfile.fxml"),
	FIND_EMPLOYEE("../presentation/fxml/FindEmployee.fxml");
	
	
	private String fxmlPath;

	private Screens(String fxmlPath) {
		this.fxmlPath = fxmlPath;
	}
	
	public String getPath() {
		return this.fxmlPath;
	}

	
}
