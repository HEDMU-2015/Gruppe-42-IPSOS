package logic;

public interface Controller {

	public void createSkille(Skill skill);
	
	public void deleteSkill(Skill skill);
	
	public void updateSkill(Skill skill);
	
	public void createDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public void updateDepartment(Department department);

	public List<Employee> findEmployee(List<Skills>);
	
	public List<Employee> findEmployeeByName(String name);
	
	public void addEmployeeSkill(Skill skill);
	
	public List<Employee> fetchEmployeeProfile (int id);
	
	public List<Departments> fetchAllDepartments();
}
