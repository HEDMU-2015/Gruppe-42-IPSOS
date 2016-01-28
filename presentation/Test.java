package presentation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import domain.Department;
import exceptions.PersistenceConnectionFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;

public class Test {

	static Map<String, Department> departments = new HashMap<>();
	static Map<String, Department> departmentsTree = new HashMap<>();

	public static void main(String args[]) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			DataAccess da = new DataAccessForSql();
			statement = da.getConnection()
					.prepareStatement("SELECT d.id, d.name, d.parent_id FROM departments AS d "
							+ "INNER JOIN employees_departments AS ed ON(d.id = ed.department_id) "
							+ "WHERE ed.employee_id = 1");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Department department = new Department(resultSet.getString("name"));
				department.setId(resultSet.getInt("id"));
				department.setParent_id(resultSet.getInt("parent_id"));
				departments.put(String.valueOf(department.getId()), department);
			}
			resultSet.close();
			statement.close();
		} catch (PersistenceConnectionFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void buildTree(int parentId) {
		Iterator<String> itr = departments.keySet().iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			Department department = departments.get(key);
			if (departments.get(department.getParent_id()) != null) {
				departments.get(key).setParent(departments.get(department.getParent_id()));
				departments.get(department.getParent_id()).addChild(department);
			}
		}
		
	}
}
