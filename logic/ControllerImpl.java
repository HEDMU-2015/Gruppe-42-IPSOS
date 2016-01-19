package logic;

import java.util.List;

import domain.Department;
import domain.EmployeeProfile;
import domain.Skill;
import exceptions.PersistenceConnectionFailureException;
import exceptions.PersistenceFailureException;
import persistence.DataAccess;
import persistence.DepartmentMapper;
import persistence.EmployeeMapper;
import persistence.SkillMapper;
import utils.IpsosLogger;

public class ControllerImpl implements Controller {

	SkillMapper sm;
	DepartmentMapper dm;
	EmployeeMapper em;
	DataAccess da;

	@Override
	public void createSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			sm.createSkill(skill, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public void deleteSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			sm.deleteSkill(skill, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public void updateSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			sm.updateSkill(skill, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public void createDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			dm.createDepartment(department, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public void deleteDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			dm.deleteDepartment(department, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public void updateDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			dm.updateDepartment(department, da);
			da.commit();
			da.close();
		} catch (PersistenceConnectionFailureException pcfe) {
			IpsosLogger.getInstance().error(pcfe);
		} catch (PersistenceFailureException pfe) {
			IpsosLogger.getInstance().error(pfe);
			da.rollback();
		}
	}

	@Override
	public List findEmployee(List skills) {
		
		
		
		return null;
	}

	@Override
	public List findEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployeeSkill(Skill skill) {
		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeProfile fetchEmployeeProfile(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List fetchAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
