package logic;

import java.util.ArrayList;
import java.util.List;

import domain.Department;
import domain.Employee;
import domain.Skill;
import persistence.DataAccess;
import persistence.DataAccessForSql;
import persistence.DepartmentMapper;
import persistence.DepartmentMapperForSql;
import persistence.EmployeeMapper;
import persistence.EmployeeMapperForSql;
import persistence.SkillMapper;
import persistence.SkillMapperForSql;
import utils.IpsosLogger;

/**
 * @author Dennis
 */
public class ControllerImpl implements Controller {

	private SkillMapper sm;
	private DepartmentMapper dm;
	private EmployeeMapper em;

	@Override
	public void createSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			da = new DataAccessForSql();
			sm.createSkill(skill, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public void deleteSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			da = new DataAccessForSql();
			sm.deleteSkill(skill, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public void updateSkill(Skill skill) {
		DataAccess da = null;
		sm = new SkillMapperForSql();
		try {
			da = new DataAccessForSql();
			sm.updateSkill(skill, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public void createDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			da = new DataAccessForSql();
			dm.createDepartment(department, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public void deleteDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			da = new DataAccessForSql();
			dm.deleteDepartment(department, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public void updateDepartment(Department department) {
		DataAccess da = null;
		dm = new DepartmentMapperForSql();
		try {
			da = new DataAccessForSql();
			dm.updateDepartment(department, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public List<Employee> findEmployee(List<Skill> skills) {
		DataAccess da = null;
		List<Employee> employees = new ArrayList<>();
		em = new EmployeeMapperForSql();
		try {
			da = new DataAccessForSql();
			employees = em.findEmployee(skills, da);
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByName(String name) {
		DataAccess da = null;
		List<Employee> employeesByName = new ArrayList<>();
		em = new EmployeeMapperForSql();
		try {
			da = new DataAccessForSql();
			employeesByName = em.findEmployeeByName(name, da);
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
		return employeesByName;
	}

	@Override
	public void addEmployeeSkill(Skill skill, Employee employee) {
		DataAccess da = null;
		em = new EmployeeMapperForSql();
		try {
			da = new DataAccessForSql();
			em.addEmployeeSkill(employee, skill, da);
			da.commit();
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
	}

	@Override
	public Employee fetchEmployee(int id) {
		DataAccess da = null;
		em = new EmployeeMapperForSql();
		Employee employee = null;
		List<Skill> skills = new ArrayList<>();
		try {
			da = new DataAccessForSql();
			employee = em.fetchEmployee(skills, da);
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
		return employee;
	}

	@Override
	public List<Department> fetchAllDepartments() {
		DataAccess da = null;
		List<Department> fetchAllDepartments = new ArrayList<>();
		dm = new DepartmentMapperForSql();
		try {
			da = new DataAccessForSql();
			fetchAllDepartments = dm.fetchAllDepartments(da);
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}

		return fetchAllDepartments;
	}

	@Override
	public List<Skill> fetchDepartmentSkills(int id) {
		DataAccess da = null;
		List<Skill> fetchDepartmentSkills = new ArrayList<>();
		sm = new SkillMapperForSql();
		try {
			da = new DataAccessForSql();
			fetchDepartmentSkills = sm.fetchDepartmentSkills(id, da);
			da.close();
		} catch (Exception exc){
			IpsosLogger.getInstance().error(exc);
		}
		return fetchDepartmentSkills;
	}

}
