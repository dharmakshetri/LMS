package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import dataservice.BookDataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Book;
import model.BooksRecord;

public class RecordsController implements Initializable
{
	@FXML
	private Label lblTotalBooks;

	@FXML
	private Label lblAuthor;

	@FXML
	private Label lblBiography;

	@FXML
	private TableView<BooksRecord> tbl_checkoutRecord;

	@FXML
	private TableColumn<BooksRecord, String> cISBN;

	@FXML
	private TableColumn<BooksRecord, String> cBookTitle;

	private BookDataAccess bookDataAccess;

	private List<BooksRecord> booksCollection;

	public RecordsController()
	{
		bookDataAccess = new BookDataAccess();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		booksCollection = new ArrayList<>();
		ObservableList<Book> books = FXCollections.observableArrayList(bookDataAccess.getAllBooks());
		lblTotalBooks.setText(Integer.toString(books.size()));

		cISBN.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
		cBookTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

		books.forEach(a -> {
			booksCollection.add(new BooksRecord(a.getISBN(), a.getTitle(), a.getAuthorList().toString()));
		});

		tbl_checkoutRecord.setItems(FXCollections.observableArrayList(booksCollection));

		//
		tbl_checkoutRecord.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showAuthor(newValue));
	}

	public void showAuthor(BooksRecord record){

		//lblAuthor.setText(record.);
	}
}
