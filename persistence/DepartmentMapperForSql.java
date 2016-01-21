package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Department;
import exceptions.PersistenceFailureException;
//@Author Martin
public class DepartmentMapperForSql implements DepartmentMapper{

	private final String CREATE_DEPARTMENT_SQL= "INSERT INTO departments(name,parent_id) VALUES(?,?)";
	private final String DELETE_DEPARTMENT_SQL = "DELETE FROM departments WHERE id= ?";
	private final String UPDATE_DEPARTMENT_SQL = "UPDATE departments SET name = ? WHERE id = ?";
	private final String FETCH_ALL_DEPARTMENTS = "SELECT * FROM departments";
	//
	@Override 
	public void createDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		
		try {
			statement = da.getConnection().prepareStatement(CREATE_DEPARTMENT_SQL);
			
			statement.setString(1,department.getName());
			statement.setInt(2,department.getParent_id());
			statement.execute();
			statement.close();
		} catch (SQLException e)  {
			throw new PersistenceFailureException("Query has failed!");
		}		
		
	}

	@Override
	public void deleteDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = da.getConnection().prepareStatement(DELETE_DEPARTMENT_SQL);
			statement.setInt(1,department.getId());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed!");
			
		}
		
	}

	@Override
	public void updateDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement;
		try{
			statement = da.getConnection().prepareStatement(UPDATE_DEPARTMENT_SQL);
			statement.setString(1,department.getName());
			statement.setInt(2,department.getId());
			statement.execute();
			statement.close();
		}catch(SQLException e){
			throw new PersistenceFailureException("Query has failed!");
		}
		
	}

	@Override
	public List<Department> fetchAllDepartments(DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List <Department>departments = new ArrayList<Department>();
		
		
		try{
			
			statement = da.getConnection().prepareStatement(FETCH_ALL_DEPARTMENTS);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Department d = new Department(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getInt("parent_id"));
				departments.add(d);
			
			}
			resultSet.close();
			statement.close();
		}catch(SQLException e){
			throw new PersistenceFailureException("Query has failed!");
		}
				
		
		return departments;
	}
	
	@Override
	public Department getById(int id, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Department department = null;
		String sql = "SELECT * FROM departments WHERE id = ?";
		try {
			statement = da.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				department = new Department(resultSet.getString("name"));
				department.setId(resultSet.getInt("id"));
				department.setParent_id(resultSet.getInt("parent_id"));
				resultSet.close();
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceFailureException("Query has failed!");
		}
		return department;
	}

}
