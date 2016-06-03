package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Address;
import model.Author;
import model.Book;
import model.Message;
import dataservice.BookDataAccess;
import dataservice.MemberDataAccess;

public class AddBookController {
	private List<Author> authorList = new ArrayList<Author>();
	@FXML
	private TextField txtCity;

	@FXML
	private Label lblMessage;

	@FXML
	private TextField txtMobile;

	@FXML
	private TextArea txtDescription;

	@FXML
	private Label lblAuthors;

	@FXML
	private TextField txtLname;

	@FXML
	private TextField txtState;

	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtNoOfCopy;

	@FXML
	private TextField txtZip;

	@FXML
	private TextField txtCheckOut;

	@FXML
	private TextField txtTitle;

	@FXML
	private TextField txtFname;

	@FXML
	private Button btnAddAuthor;

	@FXML
	private Button lblSubmit;

	@FXML
	private TextField txtISBN;

	@FXML
	private TextField txtCredential;

	@FXML
	void addAuthor(ActionEvent event) {

		Address address = new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());

		Author author = new Author(txtFname.getText(), txtLname.getText(), txtMobile.getText(), address,
				txtCredential.getText());

		authorList.add(author);
		lblAuthors.setText(lblAuthors.getText() + "\n" + txtFname.getText() + " " + txtLname.getText());
		txtCity.clear();
		txtCredential.clear();
		txtFname.clear();
		txtLname.clear();
		txtState.clear();
		txtStreet.clear();
		txtMobile.clear();
		txtZip.clear();

	}

	@FXML
	void addBook(ActionEvent event) throws NumberFormatException, CloneNotSupportedException {

		Book book = new Book(txtTitle.getText(), txtISBN.getText(), Integer.parseInt(txtCheckOut.getText()),
				Integer.parseInt(txtNoOfCopy.getText()), authorList);
		 BookDataAccess memberDao = new BookDataAccess();
		 memberDao.saveUser(book);
		 Message.showInformationDialog("Book is successfully added");
		txtISBN.clear();
		txtTitle.clear();
		txtDescription.clear();
		txtCheckOut.clear();
		txtNoOfCopy.clear();

	}
}
