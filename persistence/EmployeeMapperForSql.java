package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import domain.EmployeeProfile;
import domain.Skill;
import exceptions.PersistenceFailureException;

public class EmployeeMapperForSql implements EmployeeMapper {

	
	@Override
	public List findEmployee(List skills, DataAccess da) throws PersistenceFailureException {
	Statement statement;
	ResultSet resultSet;
	
	String select = "SELECT employees.name, employees.email,  COUNT(id) AS skills_count"
		+ "FROM employees INNER JOIN employee_skills ON(employees.id = employee_skills.employee_id)";
	String where = " WHERE employee_skills.skill_id IN(";
	String groupBy = " GROUP BY employees.email, employees.name";
	String orderBy = " ORDER BY skills_count DESC";
	String bindParams;
	
	bindParams = createBindParams(skills) + ")";
	
	try {
		statement = da.getConnection().prepareStatement(select + where + bindParams + groupBy + orderBy);
		setBindValues(skills, statement);
	} catch (SQLException e) {
		e.printStackTrace();
		throw new PersistenceFailureException("Query has failed, try again!");
	}
	
		return null;
	}

	@Override
	public List findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployeeSkill(Skill skill) throws PersistenceFailureException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBindValues(List skills, PreparedStatement statement) {
		int skillsSize = skills.size();
		for (int i = 0; i < skillsSize; i++) {
			Skill skill = (Skill) skills.get(i);
			if(i<skillsSize-1) {
				statement.setString(i+1, skill.getName());
			}
		}
	}

	@Override
	public String createBindParams(List skills) {
		int skillsSize = skills.size();
		String bindParams = null;
		for (int i = 0; i < skillsSize;) {
			bindParams += "?,";
			i++;
		}
		bindParams.substring(0, -1);
		return bindParams;
	}

	@Override
	public void removeEmployeeSkill(EmployeeProfile ep) throws PersistenceFailureException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeProfile fetchEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException {
		// TODO Auto-generated method stub
		return null;
	}

}
