package registerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.ConnectionUtil;

public class registerModel {

	public static boolean register(String firstName, String lastName, String username, String password) 
	{
		try {
			
			Connection connection = getConnection("Users.sqlite");
			
			String loginRequest = "INSERT INTO Users (FirstName, LastName, UserName, Password)"
					+ "VALUES ( ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(loginRequest);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);
			System.out.println(preparedStatement.toString());
			int created = preparedStatement.executeUpdate();
			if(created!=0)
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
