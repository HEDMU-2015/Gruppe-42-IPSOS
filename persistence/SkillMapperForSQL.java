package persistence;

import exceptions.PersistenceFailureException;

public interface SkillMapperForSQL {

	public void createSkill (skill,DataAcces da) throws PersistenceFailureException;
	
	public void deleteSkill(skill, DataAcces da) throws PersistenceFailureException;
	
	public void updateSkill(skill,DataAcces da) throws PersistenceFailureException;
		
}
