package logic;

import java.util.List;

import domain.Department;
import domain.EmployeeProfile;
import domain.Skill;

public interface Controller {

	public void createSkill(Skill skill);
	
	public void deleteSkill(Skill skill);
	
	public void updateSkill(Skill skill);
	
	public void createDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public void updateDepartment(Department department);

	public List findEmployee(List skills);
	
	public List findEmployeeByName(String name);
	
	public void addEmployeeSkill(Skill skill);
	
	public EmployeeProfile fetchEmployeeProfile (int id);
	
	public List fetchAllDepartments();
}
