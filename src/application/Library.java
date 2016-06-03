package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import enums.Role;
import factory.RoleFactory;
import model.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

import bInterface.OnLoginSuccessListener;
import bInterface.Roles;
import common.DataHelper;
import controller.LogInController;
import dataservice.UserDataAccess;

public class Library extends Application implements OnLoginSuccessListener {
	public static Stage loginStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			loginStage = primaryStage;
			UserDataAccess obj = new UserDataAccess();
			
			RoleFactory roleFacory= new RoleFactory();
			User admin= (User) roleFacory.createRoles("admin");
			User librain=(User)roleFacory.createRoles("librain");
			
			obj.saveUser(admin);
			obj.saveUser(librain);
			//obj.saveUser(new User("lib", "123", Role.LIBRARIAN));
			//obj.saveUser(new User("admin", "123", Role.ADMIN));
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
            Parent root = loader.load();
            ((LogInController)loader.getController()).initialize(this);
            
			Scene scene = new Scene(root, DataHelper.WINDOW_WIDTH, DataHelper.WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("library.css").toExternalForm());
			loginStage.setScene(scene);
			loginStage.setTitle("LogIn");
			loginStage.show();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void onLoginSuccess() {
		// TODO Auto-generated method stub
		Pane root;
		try {
			root = FXMLLoader.load((getClass().getResource("/view/homepage.fxml")));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("HomePage");
			stage.show();
			Library.loginStage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
