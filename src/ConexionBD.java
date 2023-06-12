import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/JDBCServlet")
public class ConexionBD extends HttpServlet {

	public static void main(String[] args) {
		String serverIP = "50.62.223.194";
		String dbName = "MaquinariaHnosMorales";
		String user = "usuarioStock";
		String password = "usuarioStock";

		String url = "jdbc:mysql://" + serverIP + ":3306/" + dbName;

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM Stock";
			try (Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sql)) {
				while (resultSet.next()) {
					String f1 = resultSet.getString(1);
					String f2 = resultSet.getString(2);
					System.out.println(f1 + "  " + f2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}