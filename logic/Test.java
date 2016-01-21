package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Department;
import domain.Employee;
import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;

public class Test {

	public static void main(String[] args) {
		Map<String, List<?>> sd = test();
		List<Department> departments = (List<Department>) sd.get("departments");
		for(int i = 0; i < departments.size(); i++) {
			Department department = departments.get(i);
			System.out.println(department.getName());
		}
	}
	public static Map<String, List<?>> test() {
		final String SQL = "SELECT s.id AS skill_id, s.name AS skill_name, d.id AS department_id,"
				+ "d.name AS department_name, d.parent_id FROM skills AS s "
				+ "INNER JOIN employee_skills AS es ON es.skill_id = s.id "
				+ "INNER JOIN employees AS e ON e.id = es.employee_id "
				+ "INNER JOIN departments AS d ON d.id = s.department_id "
				+ "WHERE e.id = 1";

		DataAccess da;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Map<String, List<?>> employeeProfile = null;
		try {
			da = new DataAccessForSql();
			statement = da.getConnection().prepareStatement(SQL);

			resultSet = statement.executeQuery();
			Employee employee = null;
			Department department = null;
			List<Skill> skillList = new ArrayList<>();
			List<Department> departmentList = new ArrayList<>();
			employeeProfile = new HashMap<>();
			int departmentId = 0;
			
			while (resultSet.next()) {
				Skill skill = new Skill(resultSet.getInt("skill_id"), resultSet.getString("skill_name"));
				skillList.add(skill);
				departmentId = resultSet.getInt("department_id");
				
				if (department == null) {
					department = new Department(resultSet.getInt("department_id"), resultSet.getString("department_name"),
							resultSet.getInt("parent_id"));
				} else if (department != null && departmentId != department.getId()) {
					department = new Department(resultSet.getInt("department_id"), resultSet.getString("department_name"),
							resultSet.getInt("parent_id"));
				}
				departmentList.add(department);
				
			}
			employeeProfile.put("departments", departmentList);
			employeeProfile.put("skills", skillList);
			
		} catch (PersistenceConnectionFailureException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeProfile;
	}
}

