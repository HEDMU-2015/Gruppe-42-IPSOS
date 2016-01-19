package logic;

import java.util.List;

import domain.Department;
import domain.Employee;
import domain.EmployeeProfile;
import domain.Skill;
import persistence.DataAccess;

public interface Controller {
//
	public void createSkill(Skill skill);
	
	public void deleteSkill(Skill skill);
	
	public void updateSkill(Skill skill);
	
	public List<Skill> fetchDepartmentSkills();
	
	public void createDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public List<Department> fetchAllDepartments();

	public List<Employee> findEmployee(List skills);
	
	public List<Employee> findEmployeeByName(String name);
	
	public void addEmployeeSkill(Skill skill);
	
	public EmployeeProfile fetchEmployeeProfile (int id);
	
}
