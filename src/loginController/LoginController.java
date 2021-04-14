package loginController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController
{
	@FXML
	private Label loginMessageLabel;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	public void loginButtonPressed()
	{
		boolean loggedIn = loginModel.loginModel.login(usernameField.getText(), passwordField.getText());
		if(loggedIn)
		{
			loginMessageLabel.setText("Successfully logged in.");
		}
		else
		{
			loginMessageLabel.setText("Not logged in....");
		}
	}
	
	public void registerButtonPressed()
	{
		Parent secondRoot;
		try {
			secondRoot = FXMLLoader.load(getClass().getResource("/registerView/Register.fxml"));
			Scene secondScene = new Scene(secondRoot);
			Stage stage = (Stage) usernameField.getScene().getWindow();
	        stage.setScene(secondScene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
