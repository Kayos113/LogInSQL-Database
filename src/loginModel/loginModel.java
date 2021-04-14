package loginModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.ConnectionUtil;

public class loginModel {

	public static boolean login(String username, String password) 
	{
		ResultSet rs = null;
		try {
			
			Connection connection = getConnection("Users.sqlite");
			
			String loginRequest = "SELECT * from Users WHERE UserName=? AND Password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginRequest);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			boolean loggedIn = rs.next();
			if(loggedIn)
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static Connection getConnection(String databaseName)
	{
		return ConnectionUtil.getConnection(databaseName);
	}
}
