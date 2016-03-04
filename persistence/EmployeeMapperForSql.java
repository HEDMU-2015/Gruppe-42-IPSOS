package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Department;
import domain.Employee;
import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;

public class EmployeeMapperForSql implements EmployeeMapper {
//
	private final static String ADD_EMPLOYEE_SKILL_SQL = "INSERT INTO employee_skills (employee_id, skill_id) VALUES (?, ?)";
	private final static String REMOVE_EMPLOYEE_SKILL_SQL = "DELETE FROM employee_skills WHERE employee_id = ? AND skill_id = ?";
	private final static String GET_EMPLOYEE_PROFILE = "SELECT e.id, e.name, e.email, s.id AS skill_id, s.name AS skill_name, "
			+ "d.id AS department_id, d.name AS department_name, d.parent_id "
			+ "FROM employees AS e INNER JOIN employee_skills AS es ON e.id = es.employee_id "
			+ "INNER JOIN skills AS s ON es.skill_id = s.id "
			+ "INNER JOIN departments AS d ON d.id = s.department_id "
			+ "WHERE e.id = ? ORDER BY s.department_id";

	@Override
	public List<Employee> findEmployee(List<Skill> skills, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<>();

		String select = "SELECT employees.id, employees.name, employees.email,  COUNT(id) AS skills_count"
				+ " FROM employees INNER JOIN employee_skills ON(employees.id = employee_skills.employee_id)";
		String where = " WHERE employee_skills.skill_id IN(";
		String groupBy = " GROUP BY employees.id, employees.email, employees.name";
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
				e.setMatchingSkillsCount(resultSet.getInt("skills_count"));
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
	public List<Employee> findEmployeeByName(String name, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		ResultSet resultSet = null;
		List<Employee> profileList = new ArrayList<>();
		try {
			statement = da.getConnection().prepareStatement("SELECT * FROM employees WHERE LOWER(name) LIKE ?");
			statement.setString(1, "%" + name + "%");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Employee e = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("email"));
				profileList.add(e);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
			if (i <= skillsSize -1) {
				try {
					statement.setInt(i + 1, skill.getId());
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
		String bindParams = "";
		for (int i = 0; i < skillsSize;) {
			bindParams += "?, ";
			i++;
		}
		return bindParams.substring(0, bindParams.length()-2);
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
	public Employee getById(int id, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		String sql = "SELECT * FROM employees WHERE id = ?";
		try {
			statement = da.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("email"));
				resultSet.close();
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceFailureException("Query has failed!");
		}
		return employee;
	}
	
	@Override
	public Employee getEmployeeProfile(int id, DataAccess da) throws PersistenceFailureException {
		

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Skill> skillList = new ArrayList<>();
		try {
			da = new DataAccessForSql();
			statement = da.getConnection().prepareStatement(GET_EMPLOYEE_PROFILE);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if (employee == null) {
					employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
				}
				Skill skill = new Skill(resultSet.getInt("skill_id"), resultSet.getString("skill_name"));
				Department department = new Department(resultSet.getInt("department_id"),
						resultSet.getString("department_name"), resultSet.getInt("parent_id"));
				skill.setDepartment(department);
				skillList.add(skill);
			}
			employee.setSkills(skillList);
		} catch (PersistenceConnectionFailureException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Skill> fetchEmployeeSkills(int id, DataAccess da) throws PersistenceFailureException {
		List<Skill> skills = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = da.getConnection().prepareStatement("SELECT s.id, s.name, s.department_id FROM skills AS s " 
					+ "INNER JOIN employee_skills AS es ON(s.id = es.skill_id) "
					+ "WHERE es.employee_id = ?");
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Skill skill = new Skill(resultSet.getString("name"));
				skill.setId(resultSet.getInt("id"));
				skill.setDepartmentId(resultSet.getInt("department_id"));
				skills.add(skill);
			}
			statement.close();
			resultSet.close();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed");
		}
		return skills;
	}
}
