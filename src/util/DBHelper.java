package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Design pattern: Singleton
// Không sủa file này
public final class DBHelper {

	private static DBHelper instance = null;
	private Connection connection = null;
	private String user;
	private String password;
	private String dbName;

	private DBHelper() {
		// Để private để khoá không cho tạo đối tượng
		this.user = Config.USER;
		this.password = Config.PASSWORD;
		this.dbName = Config.DB_NAME;
	}

	private DBHelper(String user, String password, String dbName) {
		super();
		this.user = user;
		this.password = password;
		this.dbName = dbName;
	}

	private static String createConnectURL(String user, String password, String database) {
		String url = String.format(
				"jdbc:sqlserver://localhost:1433;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true;",
				database, user, password);
		return url;
	}

	public synchronized static DBHelper getDefaultInstance() {
		if (instance == null)
			instance = new DBHelper();
		return instance;
	}

	public DBHelper getInstance(String user, String password, String dbName) {
		return new DBHelper(user, password, dbName);
	}

	public Connection getConnection() throws SQLException {
		if (this.connection == null || this.connection.isClosed())
			this.connection = DriverManager.getConnection(createConnectURL(user, password, dbName));
		return this.connection;
	}

}
