package persistence;

import java.util.List;
import java.sql.PreparedStatement;

import domain.Employee;
import domain.EmployeeProfile;
import domain.Skill;
import exceptions.PersistenceFailureException;

public interface EmployeeMapper {

	public List<Employee> findEmployee(List skills, DataAccess da) throws PersistenceFailureException;
	
	public List<Employee> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException;
	
	public void addEmployeeSkill(Skill skill) throws PersistenceFailureException;
	
	public void setBindValues(List skills, PreparedStatement statement);
	
	public String createBindParams(List skills);
	
	public void removeEmployeeSkill(EmployeeProfile ep) throws PersistenceFailureException;
	
	public EmployeeProfile fetchEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException;
}
