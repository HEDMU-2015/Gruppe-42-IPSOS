package junittest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import domain.Department;
import exceptions.PersistenceCommitFailureException;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;
import persistence.DepartmentMapperForSql;

public class DepartmentMapperForSqlTest {

//	@Test
//	public void testCreateDepartment() {
//		// Remember to test with real id's, names and department id's.
//		try {
//			DataAccess da = new DataAccessForSql();
//			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
//			Department department = new Department("DepartmentTest");
//			department.setParent_id(1);
//			dmfs.createDepartment(department, da);
//			Department newDepartment = dmfs.getById(3, da);
//			da.commit();
//			da.close();
//			assertEquals(3, newDepartment.getId());
//			assertEquals("DepartmentTest", newDepartment.getName());
//			assertEquals(1, newDepartment.getParent_id());
//		} catch (PersistenceConnectionFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceCommitFailureException e) {
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void testDeleteDepartment() {
//		// Remember to test with existing record.
//		try {
//			DataAccess da = new DataAccessForSql();
//			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
//			Department department = dmfs.getById(3, da);
//			dmfs.deleteDepartment(department, da);
//			da.commit();
//			da.close();
//			assertEquals(3, department.getId());
//			assertEquals("DepartmentTest", department.getName());
//		} catch (PersistenceConnectionFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceCommitFailureException e) {
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void testUpdateDepartment() {
//		try {
//			DataAccess da = new DataAccessForSql();
//			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
//			Department department = dmfs.getById(2, da);
//			department.setName("Quantitative");
//			dmfs.updateDepartment(department, da);
//			Department newDepartment = dmfs.getById(2, da);
//			da.commit();
//			da.close();
//			assertEquals(2, newDepartment.getId());
//			assertEquals("Quantitative", newDepartment.getName());
//		} catch (PersistenceConnectionFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceCommitFailureException e) {
//			e.printStackTrace();
//		}
//	}
//
	@Test
	public void testFetchAllDepartments() {
		try {
			DataAccess da = new DataAccessForSql();
			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
			List<Department> departments = dmfs.fetchAllDepartments(da);
			da.commit();
			da.close();
			assertEquals(2, departments.size());
		} catch (PersistenceConnectionFailureException e) {
			e.printStackTrace();
		} catch (PersistenceFailureException e) {
			e.printStackTrace();
		} catch (PersistenceCommitFailureException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		try {
			DataAccess da = new DataAccessForSql();
			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
			Department newDepartment = dmfs.getById(1, da);
			assertEquals(1, newDepartment.getId());
			assertEquals("Operations", newDepartment.getName());
			assertEquals(0, newDepartment.getParent_id());
		} catch (PersistenceConnectionFailureException | PersistenceFailureException e) {
			e.printStackTrace();
		}
	}

}
