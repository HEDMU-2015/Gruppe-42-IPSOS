package junittest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import domain.Employee;
import exceptions.PersistenceCommitFailureException;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;
import persistence.EmployeeMapper;
import persistence.EmployeeMapperForSql;

public class EmployeeMapperForSqlTest {

	// @Test
	// public void testFindEmployee() {
	// try {
	// DataAccess da = new DataAccessForSql();
	// EmployeeMapper emfs = new EmployeeMapperForSql();
	// SkillMapper smfs = new SkillMapperForSql();
	// List<Skill> skills = smfs.fetchDepartmentSkills(1, da);
	// List<Employee> employeeList = emfs.findEmployee(skills, da);
	// da.commit();
	// da.close();
	// System.out.println(employeeList.size());
	// assertEquals(2, employeeList.size());
	// } catch (PersistenceConnectionFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceCommitFailureException e) {
	// e.printStackTrace();
	// }
	// }

	// @Test
	// public void testFindEmployeeByName() {
	// try {
	// DataAccess da = new DataAccessForSql();
	// EmployeeMapper emfs = new EmployeeMapperForSql();
	// String name = "Rasmus".toLowerCase();
	// List<Employee> employeeList = emfs.findEmployeeByName(name, da);
	// da.commit();
	// da.close();
	// assertEquals(2, employeeList.size());
	// } catch (PersistenceConnectionFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceCommitFailureException e) {
	// e.printStackTrace();
	// }
	// }

	@Test
	public void testAddEmployeeSkill() {
		try {
			DataAccess da = new DataAccessForSql();
			EmployeeMapper emfs = new EmployeeMapperForSql();
			Employee employee = new Employee("DepartmentTest");
			employee.setParent_id(1);
			emfs.addEmployeeSkill(employee, skill, da);
			Employee newEmployeeSkill = emfs.getById(3, da);
			da.commit();
			da.close();
			assertEquals(3, newEmployeeSkill.getId());
			assertEquals("EmployeeSkillTest", newEmployeeSkill.getName());
			assertEquals(1, newEmployeeSkill.getParent_id());
		} catch (PersistenceConnectionFailureException e) {
			e.printStackTrace();
		} catch (PersistenceFailureException e) {
			e.printStackTrace();
		} catch (PersistenceCommitFailureException e) {
			e.printStackTrace();
		}
	}
	// @Test
	// public void testSetBindValues() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testCreateBindParams() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testRemoveEmployeeSkill() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testFetchEmployeeProfile() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGetById() {
	// fail("Not yet implemented");
	// }

}
