package persistence;

import java.awt.List;
import java.sql.PreparedStatement;

import exceptions.PersistenceFailureException;

public interface EmployeeMapper {

	public List<Employee> findEmployee(List<Skill> skills, DataAccess da) throws PersistenceFailureException;
	
	public List<Employee> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException;
	
	public void addEmployeeSkill(Skill skill) throws PersistenceFailureException;
	
	public void setBindValues(Skills skills, PreparedStatement statement);
	
	public void createBindParams(Skills skills);
	
	public void removeEmployeeSkill(EmployeeProfile ep) throws PersistenceFailureException;
	
	public EmployeeProfile fetchEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException;
}
