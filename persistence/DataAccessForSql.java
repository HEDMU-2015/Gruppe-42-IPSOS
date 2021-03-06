/**
 * @author Tsvetelin Tsonev
 */
package persistence;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.PersistenceCommitFailureException;
import exceptions.PersistenceConnectionFailureException;
import logic.Settings;
import utils.IpsosLogger;
import utils.Properties;

public class DataAccessForSql implements DataAccess {
	
	private Connection connection = null;
	
	public DataAccessForSql() throws PersistenceConnectionFailureException {
		try{
			Properties	props = new Properties(Settings.PROPERTIES_PATH);
			String connectionUri = props.get("connectionUri");
			String dbUsername = props.get("dbUsername");
			String dbPassword = props.get("dbPassword");
			connection = DriverManager.getConnection(connectionUri, dbUsername, dbPassword);
		} catch(FileNotFoundException exc) {
			IpsosLogger.getInstance().error(exc);
		} catch(SQLException exc) {
			throw new PersistenceConnectionFailureException("Failed to connect to database");
		}
	}
	
	public DataAccessForSql(String connectionUri, String dbUsername, String dbPassword) throws PersistenceConnectionFailureException {
		try{
			connection = DriverManager.getConnection(connectionUri, dbUsername, dbPassword);
		} catch(SQLException exc) {
			throw new PersistenceConnectionFailureException("Failed to connect to database");
		}
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void commit() throws PersistenceCommitFailureException {
		if(connection != null) {
			try{
				connection.commit();
			} catch(SQLException exc) {
				throw new PersistenceCommitFailureException("Failed to commit transaction");
			}
		}
	}

	@Override
	public void rollback() {
		if(connection != null) {
			try{
				connection.rollback();
			} catch(SQLException exc) {
				// This should never happen
			}
		}
	}

	@Override
	public void close() {
		if(connection != null) {
			try{
				connection.close();
			} catch(SQLException exc) {
				// Should already be closed
			}
		}
	}
	
	@Override
	public void setAutoCommit(boolean bool) {
		try {
			connection.setAutoCommit(bool);
		} catch (SQLException e) {
			// This should never happen
		}
	}

}
