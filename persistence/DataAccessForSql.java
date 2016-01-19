package persistence;

import java.io.FileNotFoundException;
import java.sql.Connection;

import exceptions.PersistenceCommitFailureException;
import utils.IpsosLogger;
import utils.Properties;
import utils.Settings;

public class DataAccessForSql implements DataAccess {
	
	Connection connection = null;
	
	public DataAccessForSql() {
		try{
			Properties	props = new Properties(Settings.PROPERTIES_PATH);
			String connectionUri = props.get("connectionUri");
			String dbUsername = props.get("dbUsername");
			String dbPassword = props.get("dbPassword");
		} catch(FileNotFoundException exc) {
			IpsosLogger.getInstance().error(exc);
		}
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void commit() throws PersistenceCommitFailureException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
