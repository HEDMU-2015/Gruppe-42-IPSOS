package domain;

import java.util.List;

public class EmployeeProfile {

	List<Skill> skillList;
	Employee employee;
	
	public EmployeeProfile(int id, String name, String email) {
		employee = new Employee(id, name, email);
	}

	public int getId() {
		return employee.getId();
	}

	public void setId(int id) {
		employee.setId(id);
	}

	public String getName() {
		return employee.getName();
	}

	public void setName(String name) {
		employee.setName(name);
	}

	public String getEmail() {
		return employee.getEmail();
	}

	public void setEmail(String email) {
		employee.setEmail(email);
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	
}
