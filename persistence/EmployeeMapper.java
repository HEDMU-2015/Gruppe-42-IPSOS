package persistence;

import java.util.List;
import java.sql.PreparedStatement;

import domain.Employee;
import domain.Skill;
import exceptions.PersistenceFailureException;

public interface EmployeeMapper {

	public List<Employee> findEmployee(List<Skill> skills, DataAccess da) throws PersistenceFailureException;
	
	public List<Employee> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException;
	
	public void addEmployeeSkill(Employee employee, Skill skill, DataAccess da) throws PersistenceFailureException;
	
	public void setBindValues(List<Skill> skills, PreparedStatement statement) throws PersistenceFailureException;
	
	public String createBindParams(List<Skill> skills);
	
	public void removeEmployeeSkill(Employee employee, Skill skill, DataAccess da) throws PersistenceFailureException;
	
	public Employee getById(int id, DataAccess da) throws PersistenceFailureException;
	
	public Employee getEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException;
	
}
