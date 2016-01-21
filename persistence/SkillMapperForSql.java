/**
 * @author Tsvetelin Tsonev
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Skill;
import exceptions.PersistenceFailureException;

public class SkillMapperForSql implements SkillMapper {
//
	private final String CREATE_SKILL_SQL = "INSERT INTO skills(name, department_id) VALUES (?,?)";
	private final String DELETE_SKILL_SQL = "DELETE FROM skills WHERE id = ?";
	private final String UPDATE_SKILL_SQL = "UPDATE skills SET name = ? WHERE id = ?";
//	private final String FETCH_DEPARTMENT_SKILLS = "SELECT * FROM skills WHERE department_id = ?";

	@Override
	public void createSkill(Skill skill, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = da.getConnection().prepareStatement(CREATE_SKILL_SQL);
			statement.setString(1, skill.getName());
			statement.setInt(2, skill.getDepartment().getId());
			statement.execute();
			statement.close();
		} catch (SQLException exc) {
			exc.printStackTrace();
			throw new PersistenceFailureException("Query has failed!");
		}
	}

	@Override
	public void deleteSkill(Skill skill, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = da.getConnection().prepareStatement(DELETE_SKILL_SQL);
			statement.setInt(1, skill.getId());
			statement.execute();
			statement.close();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed!");
		}
	}

	@Override
	public void updateSkill(Skill skill, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = da.getConnection().prepareStatement(UPDATE_SKILL_SQL);
			statement.setString(1, skill.getName());
			statement.setInt(2, skill.getId());
			statement.execute();
			statement.close();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed");
		}
	}

//	@Override
//	public List<Skill> fetchDepartmentSkills(int id, DataAccess da) throws PersistenceFailureException {
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		List<Skill> skills = new ArrayList<Skill>();
//		try {
//			statement = da.getConnection().prepareStatement(FETCH_DEPARTMENT_SKILLS);
//			statement.setInt(1, id);
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				Skill skill = new Skill(resultSet.getString("name"));
//				skill.setId(resultSet.getInt("id"));
//				skills.add(skill);
//			}
//			statement.close();
//			resultSet.close();
//		} catch (SQLException exc) {
//			throw new PersistenceFailureException("Query has failed");
//		}
//		return skills;
//	}

	@Override
	public Skill getById(int id, DataAccess da) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Skill skill = null;
		String sql = "SELECT * FROM skills WHERE id = ?";
		try {
			statement = da.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				skill = new Skill(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("department_id"));
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceFailureException("Query has failed!");
		}
		return skill;
	}
}
