package seleniumUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {

	private String databaseServerName = "localhost";
	private String databasePort = "1521";
	private String databaseName = "xe";
	private String userName = "hr";
	private String password = "hr";
	// private String connectionString = "jdbc:oracle:thin:hr@" +
	// databaseServerName + ":" + databasePort + ":" + databaseName;
	private String connectionString = "jdbc:oracle:thin:hr@//" + databaseServerName + ":" + databasePort + "/"
			+ databaseName;

	private ResultSet resultSet = null;
	private Statement statement = null;
	private Connection connection = null;

	private void connecToOracle() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		connection = DriverManager.getConnection(connectionString, userName, password);
		statement = connection.createStatement();
	}

	public ResultSet runSQLQuery(String sqlQuery) throws SQLException, ClassNotFoundException {
		connecToOracle();
		resultSet = statement.executeQuery(sqlQuery);
		return resultSet;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public static void main(String[] args) {
		DataBaseManager db = new DataBaseManager();
		ResultSet resultSet = null;
		try {
			resultSet = db.runSQLQuery("Select * from EMPLOYEES");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not locate DB driver !");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Could not connection database !");
			e.printStackTrace();
		}
		try {
			System.err.println("EmployeeID" + "\t" + "First_Name" + "\t" + "Last_Name" + "\t" + "Email" + "\t \t"
					+ "Phone_Number");
			while (resultSet.next()) {
				int employeeID = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("FIRST_NAME");
				String lastName = resultSet.getString("LAST_NAME");
				String email = resultSet.getString("EMAIL");
				String phoneNumber = resultSet.getString("PHONE_NUMBER");

				System.out.println(employeeID + "\t \t" + firstName + "\t \t" + lastName + "\t \t" + email + "\t \t \t"
						+ phoneNumber);
			}

			db.closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
