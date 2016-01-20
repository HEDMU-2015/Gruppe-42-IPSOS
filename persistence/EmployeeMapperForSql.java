package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Employee;
import domain.EmployeeProfile;
import domain.Skill;
import exceptions.PersistenceFailureException;

public class EmployeeMapperForSql implements EmployeeMapper {

	private final static String ADD_EMPLOYEE_SKILL_SQL = "INSERT INTO employee_skills (employee_id, skill_id) VALUES (?, ?)";
	private final static String REMOVE_EMPLOYEE_SKILL_SQL = "DELETE FROM employee_skills WHERE employee_id = ? AND skill_id = ?";

	@Override
	public List<Employee> findEmployee(List<Skill> skills, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<>();

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
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Employee e = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("email"));
				employeeList.add(e);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed, try again!");
		}

		return employeeList;
	}

	@Override
	public List<EmployeeProfile> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<EmployeeProfile> profileList = new ArrayList<>();
		try {
			statement = da.getConnection()
					.prepareStatement("SELECT e.id, e.name, e.email, skills.skill_id, s.name"
							+ "FROM employees AS e LEFT JOIN employee_skills AS skills ON e.id = skills.employee_id "
							+ "LEFT JOIN skills AS s ON s.id = skills.skill_id WHERE LOWER(e.name) = ?");
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				EmployeeProfile e = new EmployeeProfile(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("email"));
				List<Skill> skillList = new ArrayList<>();
				Skill skill = new Skill(resultSet.getString("skill_name"));
				skill.setId(resultSet.getInt("skill_id"));
				skillList.add(skill);
				e.setSkillList(skillList);
				profileList.add(e);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed, try again!");
		}

		return profileList;
	}

	@Override
	public void addEmployeeSkill(Employee employee, Skill skill, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		try {
			statement = da.getConnection().prepareStatement(ADD_EMPLOYEE_SKILL_SQL);
			statement.setInt(1, employee.getId());
			statement.setInt(2, skill.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed!");
		}
	}

	@Override
	public void setBindValues(List<Skill> skills, PreparedStatement statement) throws PersistenceFailureException {
		int skillsSize = skills.size();
		for (int i = 0; i < skillsSize; i++) {
			Skill skill = skills.get(i);
			if (i < skillsSize - 1) {
				try {
					statement.setString(i + 1, skill.getName());
				} catch (SQLException e) {
					e.printStackTrace();
					throw new PersistenceFailureException("Something went wrong!");
				}
			}
		}
	}

	@Override
	public String createBindParams(List<Skill> skills) {
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
	public void removeEmployeeSkill(Employee employee, Skill skill, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		try {
			statement = da.getConnection().prepareStatement(REMOVE_EMPLOYEE_SKILL_SQL);
			statement.setInt(1, employee.getId());
			statement.setInt(2, skill.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed!");
		}
	}

	@Override
	public EmployeeProfile fetchEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		ResultSet resultSet;
		EmployeeProfile e;
		
		try {
			statement = da.getConnection().prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
			resultSet = statement.executeQuery();
			e = new EmployeeProfile(resultSet.getInt("id"), resultSet.getString("name"),
					resultSet.getString("email"));
			List<Skill> skillList = new ArrayList<>();
			Skill skill = new Skill(resultSet.getString("skill_name"));
			skill.setId(resultSet.getInt("skill_id"));
			skillList.add(skill);
			e.setSkillList(skillList);
			resultSet.close();
			statement.close();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed!");
		}

		return e;
	}

	@Override
	public void getById(int id) {
		String sql = "SELECT * FROM skills WHERE id = ?";
	}
}
