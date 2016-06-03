package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import bInterface.IBook;
import common.Common;
import dataservice.BookDataAccess;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import model.Author;
import model.Book;
import model.BookCopy;
import model.Message;

public class AddBookCopyController {

	@FXML
	private Button btnSearch;

	@FXML
	private TextField txtISBN;

	@FXML
	private Button btnAddCopies;
	@FXML
	private TextArea taDisplay;

	@FXML
	private TextField txtNumOfCopies;
	@FXML
	private TableView<Book> tblBook;
	@FXML
	private TableColumn<Book, String> tcISBN;

	@FXML
	private TableColumn<Book, String> tcTitle;

	@FXML
	private TableColumn<Book, String> tcNumber;

	@FXML
	private TableColumn<Book, Integer> tcLength;
	ObservableList<Book> bookl = null;
	Book book;
	List<BookCopy> copies;
	String tempISBN;
	boolean flag=false;
	public AddBookCopyController() {

	}

	@FXML
	public void searchISBN(ActionEvent event) {
		flag=true;
		displayBook(flag);
	}

	public void addCopies(ActionEvent event) throws CloneNotSupportedException {
		if (book != null) {
			int newNumberofCopies = Integer.parseInt(txtNumOfCopies.getText().trim());
			for (int i = 0; i < newNumberofCopies; i++) {
				book.addCopy();
			}	
			flag=false;
			txtISBN.clear();
			txtNumOfCopies.clear();
			BookDataAccess memberDao = new BookDataAccess();
			memberDao.updateBook(book);
			System.out.println(book.getCopies().get(0).getCopyNum());
			Message.showInformationDialog("Book Copy Successfully added");
			displayBook(flag);
			//BookDataAccess memberDao = new BookDataAccess();
			//memberDao.saveUser(book);

		}
	}
	
	public void displayBook(boolean f){
		String isbn;
		System.out.println("f="+f);
		if(f){
			Common.bookISBN=txtISBN.getText().trim();
		}else{
			Common.bookISBN=Common.bookISBN;
		}
		
		System.out.println("ISBN="+Common.bookISBN);
		BookDataAccess memberDao = new BookDataAccess();
		book = memberDao.serachUser(Common.bookISBN);
		
		
		if (book != null) {
			//Common.bookISBN=txtISBN.getText().trim();
			copies = book.getCopies();
			System.out.println("books Copies="+copies.get(copies.size()-1).getCopyNum() );
			//taDisplay.setText(book.getTitle() + "\t" + copies.get(copies.size()-1).getCopyNum()+ "\t" + book.getISBN());
	
			taDisplay.setText("Book Title : " + book.getTitle() + "\n" + "Book Copies : "
					+ copies.get(copies.size()-1).getCopyNum() + "\n" + "ISBN : " + book.getISBN());
			flag=false;
		
		} else {
			Message.showWarningDialog("Book Not Found!");
		}
	}

}
