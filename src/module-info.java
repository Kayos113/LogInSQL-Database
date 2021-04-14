module login {
	requires java.sql;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	exports app;
	opens app to javafx.graphics;
	exports loginController;
	opens loginController to javafx.fxml;
	exports registerController;
	opens registerController to javafx.fxml;
}