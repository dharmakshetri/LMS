package model;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Message {

	public  static void showWarningDialog(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("WARNING");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	public static void showInformationDialog(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public static  Boolean showConfirmDialog(String confirmMsg) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(null);
		alert.setContentText(confirmMsg);

		Optional<ButtonType> result = alert.showAndWait();
		return result.get() == ButtonType.OK ? true : false;

	}
}
