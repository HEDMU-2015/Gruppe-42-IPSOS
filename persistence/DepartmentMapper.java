package persistence;

import java.util.List;

import domain.Department;
import exceptions.PersistenceFailureException;

public interface DepartmentMapper {
	
	public void createDepartment(Department department,DataAcces da) throws PersistenceFailureException;
	
	public void deleteDepartment(Department department, DataAcces da) throws PersistenceFailureException;
	
	public void updateDepartment(Department department, DataAcces da) throws PersistenceFailureException;
	
	public List fetchAllDepartments(DataAcces da)throws PersistenceFailureException;
	
}
