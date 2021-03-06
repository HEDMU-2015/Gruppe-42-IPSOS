package persistence;

import java.util.List;
import java.util.Map;

import domain.Department;
import exceptions.PersistenceFailureException;

public interface DepartmentMapper {
//	
	public void createDepartment(Department department,DataAccess da) throws PersistenceFailureException;
	
	public void deleteDepartment(Department department, DataAccess da) throws PersistenceFailureException;
	
	public void updateDepartment(Department department, DataAccess da) throws PersistenceFailureException;
	
	public List<Department> fetchAllDepartments(DataAccess da)throws PersistenceFailureException;
	
	public Department getById(int id, DataAccess da) throws PersistenceFailureException;
	
	public Map<Integer, Department> fetchEmployeeDepartments(int id, DataAccess da) throws PersistenceFailureException;
	
	
	
}
