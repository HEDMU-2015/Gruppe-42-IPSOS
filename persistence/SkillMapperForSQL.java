package persistence;

import exceptions.PersistenceFailureException;

public interface SkillMapperForSQL {

	public void createSkill (Skill skill,DataAcces da) throws PersistenceFailureException;
	
	public void deleteSkill(Skill skill, DataAcces da) throws PersistenceFailureException;
	
	public void updateSkill(Skill skill,DataAcces da) throws PersistenceFailureException;
		
}
