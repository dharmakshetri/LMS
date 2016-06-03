package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Library;
import common.DataHelper;
import enums.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Message;

public class HomePageController implements Initializable {
	@FXML
	private Button btnCheckOutBook;
	@FXML
	private Button btnAddMember;
	@FXML
	private Button btnAddBook;
	@FXML
	private Button btnAddBookCopy;
	@FXML
	private Button btnSignOut;
	@FXML
	private Button btnRecord;
	@FXML
	private Button btnOverdue;
	@FXML
	private Label welcomeLBL;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (LogInController.role.toString().equals(Role.ADMIN.toString())) {
			btnCheckOutBook.setDisable(true);
			welcomeLBL.setText("Welcome, Access Level [" + Role.ADMIN.toString() + "]");
		} else if (LogInController.role.toString().equals(Role.LIBRARIAN.toString())) {
			btnAddBook.setDisable(true);
			btnAddBookCopy.setDisable(true);
			btnAddMember.setDisable(true);
			welcomeLBL.setText("Welcome, System Access Level [" + Role.LIBRARIAN.toString() + "]");

		} else {
			welcomeLBL.setText("Welcome, System Access Level [" + Role.BOTH.toString() + "]");
		}

	}

	@FXML
	protected void showRecords(ActionEvent event){
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/Records.fxml")));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Records");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void showOverdue(ActionEvent event){
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/Overdue.fxml")));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Records");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void addMember() {
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/AddMember.fxml")));
			Scene scene = new Scene(root, DataHelper.MAIN_WINDOW_WIDTH, DataHelper.MAIN_WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle(" Member Add Form");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addBook() {
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/AddBook.fxml")));
			Scene scene = new Scene(root, DataHelper.MAIN_WINDOW_WIDTH, DataHelper.MAIN_WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Book Add Form");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addBookCopy() {
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/AddBookCopy.fxml")));
			Scene scene = new Scene(root, DataHelper.MAIN_WINDOW_WIDTH, DataHelper.MAIN_WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("BookCopy Add Form");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void checkOutBook() {
		try {
			Pane root = FXMLLoader.load((getClass().getResource("/view/CheckOutRecord.fxml")));
			Scene scene = new Scene(root, DataHelper.MAIN_WINDOW_WIDTH, DataHelper.MAIN_WINDOW_HEIGHT);
			scene.getStylesheets().add(getClass().getResource("/application/library.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Checkout Book");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void logout(ActionEvent event) {
		if (Message.showConfirmDialog("Are you sure to logout?")) {
			try {
				btnSignOut.getScene().getWindow().hide();
				Library main = new Library();
				Stage stage = new Stage();
				main.start(stage);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
