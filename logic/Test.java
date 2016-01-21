package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Department;
import domain.Employee;
import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;

public class Test {
//
	public static void main(String[] args) {
		Employee e = Test.test();
		for (Skill skill : e.getSkills()) {
			System.out.println(skill.getDepartment().getName());
			System.out.println("\t" + skill.getName());
			System.out.println();
		}
	}
	public static Employee test() {
		final String SQL = "SELECT e.id, e.name, e.email, s.id AS skill_id, s.name AS skill_name, "
				+ "d.id AS department_id, d.name AS department_name, d.parent_id "
				+ "FROM employees AS e INNER JOIN employee_skills AS es ON e.id = es.employee_id "
				+ "INNER JOIN skills AS s ON es.skill_id = s.id "
				+ "INNER JOIN departments AS d ON d.id = s.department_id "
				+ "WHERE e.id = 1";

		DataAccess da;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		List<Skill> skillList = new ArrayList<>();
		try {
			da = new DataAccessForSql();
			statement = da.getConnection().prepareStatement(SQL);
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
}

