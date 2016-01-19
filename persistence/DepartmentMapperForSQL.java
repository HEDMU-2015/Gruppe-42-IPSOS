package persistence;

import java.util.List;
import exceptions.PersistenceFailureException;

public interface DepartmentMapperForSQL {
	
	public void createDepartment(department,DataAcces da) throws PersistenceFailureException;
	
	public void deleteDepartment(department, DataAcces da) throws PersistenceFailureException;
	
	public void updateDepartment(department, DataAcces da) throws PersistenceFailureException;
	
	public List<Departments> fetchAllDepartments(DataAcces da)throws PersistenceFailureException;
		
	
}
