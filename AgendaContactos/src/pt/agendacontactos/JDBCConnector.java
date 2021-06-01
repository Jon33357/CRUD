package pt.agendacontactos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	private Connection conn = null;
	private String url = "jdbc:mysql://127.0.0.1/agenda";
	private String user = "root";
	private String password = "";


	public Connection OpenDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			if (conn == null) {
				System.out.println("JDBC connection is not established");
			} else
				System.out.println("Congratulations," + 
						" JDBC connection is established successfully.\n");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	} 


	public void CloseDB() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

