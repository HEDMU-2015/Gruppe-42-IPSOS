package persistence;

import java.util.List;

import domain.Skill;
import exceptions.PersistenceFailureException;

public interface SkillMapper {

	public void createSkill(Skill skill, DataAccess da) throws PersistenceFailureException;
	
	public void deleteSkill(Skill skill, DataAccess da) throws PersistenceFailureException;
	
	public void updateSkill(Skill skill, DataAccess da) throws PersistenceFailureException;
	
	public List<Skill> fetchDepartmentSkills(int id, DataAccess da) throws PersistenceFailureException;
	
	public Skill getById(int id, DataAccess da) throws PersistenceFailureException;
		
}
