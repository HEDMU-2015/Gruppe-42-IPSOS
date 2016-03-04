package junittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Skill;
import exceptions.PersistenceCommitFailureException;
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
			Skill newSkill = smfs.getById(1, da);
			assertEquals(1, newSkill.getId());
		} catch (PersistenceConnectionFailureException | PersistenceFailureException e) {
			e.printStackTrace();
		}
	}

	 @Test
	 public void createSkillTest() {
	 // Remember to test with real id's, names and department id's.
	 try {
	 DataAccess da = new DataAccessForSql();
	 SkillMapperForSql smfs = new SkillMapperForSql();
	 Skill skill = new Skill("Python19");
	 skill.setDepartmentId(1);
	 smfs.createSkill(skill, da);
	 Skill newSkill = smfs.getById(19, da);
	 da.commit();
	 da.close();
	 System.out.println(newSkill.getName());
	 assertEquals(19, newSkill.getId());
	 assertEquals("Python19", newSkill.getName());
	 } catch (PersistenceConnectionFailureException e) {
	 e.printStackTrace();
	 } catch (PersistenceFailureException e) {
	 e.printStackTrace();
	 } catch (PersistenceCommitFailureException e) {
	 e.printStackTrace();
	 }
	 }

	// @Test
	// public void deleteSkillTest() {
	// // Remember to test with existing record.
	// try {
	// DataAccess da = new DataAccessForSql();
	// SkillMapperForSql smfs = new SkillMapperForSql();
	// Skill skill = smfs.getById(19, da);
	// smfs.deleteSkill(skill, da);
	// da.commit();
	// da.close();
	// assertEquals(19, skill.getId());
	// assertEquals("Python19", skill.getName());
	// } catch (PersistenceConnectionFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceCommitFailureException e) {
	// e.printStackTrace();
	// }
	// }

	// @Test
	// public void updateSkillTest() {
	// try {
	// DataAccess da = new DataAccessForSql();
	// SkillMapperForSql smfs = new SkillMapperForSql();
	// Skill skill = smfs.getById(18, da);
	// System.out.println("hello");
	// skill.setName("Python18");
	// smfs.updateSkill(skill, da);
	// Skill newSkill = smfs.getById(18, da);
	// da.commit();
	// da.close();
	// assertEquals(18, newSkill.getId());
	// assertEquals("Python18", newSkill.getName());
	// } catch (PersistenceConnectionFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceFailureException e) {
	// e.printStackTrace();
	// } catch (PersistenceCommitFailureException e) {
	// e.printStackTrace();
	// }
	// }

//	@Test
//	public void fetchDepartmentSkillsTest() {
//		try {
//			DataAccess da = new DataAccessForSql();
//			SkillMapperForSql smfs = new SkillMapperForSql();
//			List<Skill> skills = smfs.fetchDepartmentSkills(1, da);
//			da.commit();
//			da.close();
//			assertEquals(5, skills.size());
//		} catch (PersistenceConnectionFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceFailureException e) {
//			e.printStackTrace();
//		} catch (PersistenceCommitFailureException e) {
//			e.printStackTrace();
//		}
//	}
}
