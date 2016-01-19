package persistence;

import java.util.List;
import exceptions.PersistenceFailureException;

public interface DepartmentMapperForSQL {
	
	public void createDepartment(Department department,DataAcces da) throws PersistenceFailureException;
	
	public void deleteDepartment(Department department, DataAcces da) throws PersistenceFailureException;
	
	public void updateDepartment(Department department, DataAcces da) throws PersistenceFailureException;
	
	public List<Departments> fetchAllDepartments(DataAcces da)throws PersistenceFailureException;
	
}
