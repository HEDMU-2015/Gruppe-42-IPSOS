package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Department;
import exceptions.PersistenceFailureException;
//@Author Martin
public class DerpartmentMapperForSql implements DepartmentMapper{

	private final String CREATE_DEPARTMENT_SQL= "INSERT INTO departments(name,parent_id) VALUES(?,?)";
	private final String DELETE_DEPARTMENT_SQL = "DELETE FROM department WHERE id= ?";
	private final String UPDATE_DEPARTMENT_SQL = "UPDATE department SET name = ? WHERE id = ?";
	private final String FETCH_ALL_DEPARTMENTS = "SELECT * FROM departments";
	//
	@Override
	public void createDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement PreparedStatement = null;
		
		try {
			PreparedStatement = da.getConnection().prepareStatement(CREATE_DEPARTMENT_SQL);
			
			PreparedStatement.setString(1,department.getName());
			PreparedStatement.setString(2,department.getParentId());
			PreparedStatement.executeQuery();
			PreparedStatement.close();
			
			
		} catch (SQLException e)  {
			throw new PersistenceFailureException("Query has failed!");
		}		
		
	}

	@Override
	public void deleteDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement PreparedStatement = null;
		try {
			PreparedStatement = da.getConnection().prepareStatement(DELETE_DEPARTMENT_SQL);
			PreparedStatement.setInt(1,department.getId());
			PreparedStatement.executeQuery();
			PreparedStatement.close();
			
			
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed!");
			
		}
		
	}

	@Override
	public void updateDepartment(Department department, DataAccess da) throws PersistenceFailureException {
		PreparedStatement PreparedStatement;
		try{
			PreparedStatement = da.getConnection().prepareStatement(UPDATE_DEPARTMENT_SQL);
			PreparedStatement.setString(1,department.getName());
			PreparedStatement.setInt(1,department.getId());
			PreparedStatement.executeQuery();
			PreparedStatement.close();
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
				Department d = new Department(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("parent_id"));
				departments.add(d);
			
			}
			resultSet.close();
			statement.close();
		}catch(SQLException e){
			throw new PersistenceFailureException("Query has failed!");
		}
				
		
		return departments;
	}

}
