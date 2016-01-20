package junittest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;
import persistence.DataAccessForSql;
import persistence.SkillMapperForSql;

public class SkillMapperForSqlTest {

	@Test
	public void getByIdTest() {
		try {
			DataAccess da = new DataAccessForSql();
			SkillMapperForSql smfs = new SkillMapperForSql();
			Skill skill = new Skill("Python");
			Skill newSkill = smfs.getById(1, da);
			assertThat(skill, instanceOf(Skill.class));
			assertEquals(1, newSkill.getId());
		} catch (PersistenceConnectionFailureException | PersistenceFailureException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void createSkillTest() {
		try {
			DataAccess da = new DataAccessForSql();
			Skill skill = new Skill("Python");
			
		} catch (PersistenceConnectionFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
