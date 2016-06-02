package controller;

import enums.Role;
import application.Library;
import dataservice.UserDataAccess;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.User;
import model.Message;

public class LogInController {

	public static Role role = null;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btncancel;
	@FXML
	private TextField txtusername;
	@FXML
	private PasswordField txtpassword;

	public LogInController() {

	}

	@FXML
	public void doCancel() {
		if (Message.showConfirmDialog("Are you want to exit?"))
			Platform.exit();
	}

	@FXML
	public void doLogIn() {
		if (validateForm()) {
			User user = new User(getUserName(), getUserPassword());
			UserDataAccess userDao = new UserDataAccess();
			User result = userDao.serachUser(user);
			if (result != null) {
				try {
					role = result.getRole();
					Pane root = FXMLLoader.load((getClass().getResource("/view/homepage.fxml")));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("HomePage");
					stage.show();
					Library.loginStage.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Message.showWarningDialog(
						"Login couldn't be completed. Please be sure to enter correct username and password.");
			}
		}

	}

	private String getUserName() {
		return txtusername.textProperty().get();
	}

	private String getUserPassword() {
		return txtpassword.textProperty().get();
	}

	private Boolean validateForm() {
		if (getUserName().isEmpty() || getUserPassword().isEmpty()) {
			Message.showWarningDialog("All Fields are required");
			return false;
		}
		return true;
	}

}
