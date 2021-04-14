package registerController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registerController {
	@FXML
	private Label registerMessageLabel;
	
	@FXML
	private TextField firstNameField, lastNameField, usernameField;
	
	@FXML
	private PasswordField passwordFieldAlpha, passwordFieldBeta;
	//alpha and beta fields exist for future implementation of password spell checking.
	
	@FXML
	public void registerButtonPressed()
	{
		boolean registered = registerModel.registerModel.register(firstNameField.getText(), lastNameField.getText(), usernameField.getText(), passwordFieldAlpha.getText());
		if(registered)
		{
			registerMessageLabel.setText("Successfully registered.");
		}
		else
		{
			registerMessageLabel.setText("Not registered....");
		}
	}
	
	public void cancelButtonPressed()
	{
		Parent secondRoot;
		try {
			secondRoot = FXMLLoader.load(getClass().getResource("/loginView/Login.fxml"));
			Scene secondScene = new Scene(secondRoot);
			Stage stage = (Stage) usernameField.getScene().getWindow();
	        stage.setScene(secondScene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
