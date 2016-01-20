package junittest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;
import persistence.SkillMapperForSql;

public class DepartmentMapperForSqlTest {

	@Test
	public void testCreateDepartment() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchAllDepartments() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		try {
			DataAccess da = new DataAccessForSql();
			DepartmentMapperForSql dmfs = new DepartmentMapperForSql();
			Skill skill = new Skill("Python");
			Skill newSkill = smfs.getById(1, da);
			assertThat(skill, instanceOf(Skill.class));
			assertEquals(1, newSkill.getId());
		} catch (PersistenceConnectionFailureException | PersistenceFailureException e) {
			e.printStackTrace();
		}
	}

}
