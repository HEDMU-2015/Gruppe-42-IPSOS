package logic;

import java.util.List;

public interface controller {

	public void createSkill(Skill skill);
	
	public void deleteSkill(Skill skill);
	
	public void updateSkill(Skill skill);
	
	public void createDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public List<Employee> findEmployee(List<skills> skills);
	
	public List<Employee> findEmployeeByName(String name);
	
	public void addEmployeeSkill(Skill skill);
	
	public EmployeeProfile fetchEmployeeProfile(int id);
}
