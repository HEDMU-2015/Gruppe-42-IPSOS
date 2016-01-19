package persistence;

import java.sql.PreparedStatement;
import java.util.List;

import domain.Employee;
import domain.EmployeeProfile;
import domain.Skill;
import exceptions.PersistenceFailureException;

public interface EmployeeMapper {
//
	public List<Employee> findEmployee(List<Skill> skills, DataAccess da) throws PersistenceFailureException;
	
	public List<Employee> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException;
	
	public void addEmployeeSkill(Skill skill) throws PersistenceFailureException;
	
	public void setBindValues(List<Skill> skills, PreparedStatement statement);
	
	public String createBindParams(List<Skill> skills);
	
	public void removeEmployeeSkill(EmployeeProfile ep) throws PersistenceFailureException;
	
	public EmployeeProfile fetchEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException;
}
