package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import enums.Role;
import model.User;
import javafx.scene.Parent;
import javafx.scene.Scene;

import dataservice.UserDataAccess;

public class Main extends Application {
	public static Stage loginStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			loginStage = primaryStage;
			UserDataAccess obj = new UserDataAccess();
			// obj.saveUser(new User("lib", "123", Role.LIBRARIAN));
			// obj.saveUser(new User("admin", "123", Role.ADMIN));
			Parent root = FXMLLoader.load(getClass().getResource("/view/LogIn.fxml"));
			Scene scene = new Scene(root, 650, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			loginStage.setScene(scene);
			loginStage.setTitle("LogIn");
			loginStage.show();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
