package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import domain.Department;
import exceptions.PersistenceConnectionFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;

public class Test {
	
	public Map<Integer, Department> map = new HashMap<>();
	
	public Map<Integer, Department> test() {
		try {
			DataAccess da = new DataAccessForSql();
			PreparedStatement stmt = da.getConnection().prepareStatement("SELECT * FROM departments ORDER BY parent_id");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Department d = new Department(rs.getString("name"));
				d.setId(rs.getInt("id"));
				d.setParent_id(rs.getInt("parent_id"));
				map.put(d.getId(), d);
			}
		} catch (PersistenceConnectionFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
}
