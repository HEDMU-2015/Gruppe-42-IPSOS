package logic;

import java.util.List;
import java.util.Map;

import domain.Department;
import domain.Employee;
import domain.Skill;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;

public interface Controller {

	public void createSkill(Skill skill);
	
	public void deleteSkill(Skill skill);
	
	public void updateSkill(Skill skill);
	
	public List<Skill> fetchDepartmentSkills(int id);
	
	public void createDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public List<Department> fetchAllDepartments();

	public List<Employee> findEmployee(List<Skill> skills);
	
	public List<Employee> findEmployeeByName(String name);
	
	public void addEmployeeSkill(Skill skill, Employee employee);
	
	public void removeEmployeeSkill(Skill skill, Employee employee);
	
	public Employee getEmployeeProfile (int id);
	
	public Map<Integer, Department> fetchEmployeeDepartments(int id);
	
	public List<Skill> fetchEmployeeSkills(int id);
}
