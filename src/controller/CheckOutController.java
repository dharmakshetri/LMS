package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataservice.BookDataAccess;
import dataservice.MemberDataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Book;
import model.BookCopy;
import model.CheckoutRecord;
import model.CheckoutRecordEntry;
import model.LibraryMember;
import model.Message;

public class CheckOutController {

	@FXML
	private Button btn_Search;

	@FXML
	private TextField tf_memberID;

	@FXML
	private TextField tf_ISBN;

	@FXML
	private Label lbl_memberID;

	@FXML
	private Label lbl_ISBN;

	@FXML
	private TableView<Book> tbl_checkoutRecord;

	@FXML
	private TableColumn<Book, String> cISBN;

	@FXML
	private TableColumn<Book, String> cBookTitle;

	@FXML
	private TableColumn<Book, String> cAuthor;

	@FXML
	private TableColumn<Book, Integer> cAvailable;

	@FXML
	private TableColumn<Book, String> cCheckout;

	@FXML
	private Pane pane_memberInfo;

	@FXML
	private Label lbl_memberFullName;

	@FXML
	private Label lbl_memberName;

	@FXML
	private Label lbl_phone;

	@FXML
	private Label lbl_phoneNo;

	@FXML
	private Label lbl_address;

	@FXML
	private Label lbl_street;

	@FXML
	private Label lbl_cityState;

	@FXML
	private Button btnCheckOut;

	ObservableList<Book> book = null;

	private static MemberDataAccess mda = new MemberDataAccess();
	
	private static BookDataAccess bda = new BookDataAccess();

	

	@FXML
	void onBtnSearch(ActionEvent event) {
		
		if (tf_memberID.getText().isEmpty() || tf_ISBN.getText().isEmpty()) {
			 Message.showWarningDialog("Input member id and/or book isbn");
		} else if (mda.serachUser(tf_memberID.getText())!= null
				&& (bda.serachUser(tf_ISBN.getText()) !=null)) {

			cISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
			cBookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
			cAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
			cAvailable.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Available"));
			cCheckout.setCellValueFactory(new PropertyValueFactory<Book, String>("Checkout"));

			// making the list of book from DA based on isbn input
			List<Book> bookNew = new ArrayList<Book>();
			Book bookFromRecord = bda.serachUser(tf_ISBN.getText().trim());
			bookNew.add(bookFromRecord);


			// making observablelist
			book = FXCollections.observableArrayList(bookNew);

			// loading tableview with book observablelist
			tbl_checkoutRecord.setItems(book);

			// setting member details on labels
			LibraryMember member = mda.serachUser(tf_memberID.getText().trim());
			lbl_memberName.setText(member.getFirstName() + " " + member.getLastName());
			lbl_phoneNo.setText(member.getPhone());
			lbl_street.setText(member.getAddress().getStreet());
			lbl_cityState.setText(member.getAddress().getCity() + ", " + member.getAddress().getState() + ", "
					+ member.getAddress().getZip());

			// tableview visiable true
			btnCheckOut.setVisible(true);
		} else
			Message.showWarningDialog("Book or Member is not found");;
	}

	@FXML
	void onBtnCheckOut(ActionEvent event) {
		//int bcUniqueid=-1;
		LibraryMember mem = mda.serachUser(tf_memberID.getText());
		Book book = bda.serachUser(tf_ISBN.getText());
		for(BookCopy bc:book.getCopies()) {
			if(bc.isAvailable()){
				//bcUniqueid = bc.getCopyNum();
				BookCopy copy =bc.changeAvailability();
				CheckoutRecordEntry entry = new CheckoutRecordEntry(copy,LocalDate.now(),LocalDate.now().plusDays(book.getMaxCheckoutLength()));
				CheckoutRecord record=new CheckoutRecord();
				record.addEntry(entry);
				mem.setRecord(record);
				bda.saveUser(book);
				mda.saveUser(mem);
				Message.showInformationDialog("Checkout Successfully");
			
			}
			else{
				Message.showWarningDialog("You Cannot check out");
			}
			
		}
		
	}

	

	void reload() {
		tbl_checkoutRecord.setItems(book);
	}

	
}
