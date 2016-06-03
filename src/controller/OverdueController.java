package controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import dataservice.MemberDataAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Author;
import model.CheckoutRecordEntry;
import model.LibraryMember;
import model.Message;
import model.OverdueRecord;

public class OverdueController implements Initializable{

	@FXML
	private TableView<OverdueRecord> tableView;

	@FXML
	private TextField txtMemberID;

	@FXML
	private TableColumn<OverdueRecord, String> isbnColumn;

	@FXML
	private TableColumn<OverdueRecord, String> memberColumn;

	@FXML
	private TableColumn<OverdueRecord, String> typeColumn;

	@FXML
	private TableColumn<OverdueRecord, String> checkoutDateColumn;

	@FXML
	private TableColumn<OverdueRecord, String> duedateColumn;

	@FXML
	ListView<Author> authorCopyPublicationListView;

	@FXML
	private TextField publicationSearchField;

	//private ScreenController myController;
	//private OverdueCalculator<OverdueRecord> publicationOverdueCalculator;
	private static List<OverdueRecord> publicationOverdueRecords;

	@FXML
	TextField txtSearch;

	public OverdueController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<OverdueRecord> listData = FXCollections
				.observableArrayList(getOverdueRecords());
		tableView.setItems(listData);

		isbnColumn.setCellValueFactory(cellData -> cellData.getValue().issueNoProperty());
		//typeColumn.setCellValueFactory(cellData -> cellData.getValue().typePropery());
		checkoutDateColumn.setCellValueFactory(cellData -> cellData.getValue().chkoutDatePropery());
		duedateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDatePropery());
		memberColumn.setCellValueFactory(cellData -> cellData.getValue().memberPropery());
	}

	//	private void setPublicationOverdueListView(List<PublicationOverdueRecord> publicationOverdueRecList) {
	//		ObservableList<OverdueRecord> listData = FXCollections
	//				.observableArrayList(publicationOverdueRecList);
	//		tableView.setItems(listData);
	//
	//		isbnColumn.setCellValueFactory(cellData -> cellData.getValue().issueNoProperty());
	//		typeColumn.setCellValueFactory(cellData -> cellData.getValue().typePropery());
	//		checkoutDateColumn.setCellValueFactory(cellData -> cellData.getValue().chkoutDatePropery());
	//		duedateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDatePropery());
	//		memberColumn.setCellValueFactory(cellData -> cellData.getValue().memberPropery());
	//	}


	@FXML
	public void searchPublicationOverdue(ActionEvent actionEvent)
	{
				List<OverdueRecord> filteredPublicationOverdueRecords = new ArrayList<>();
				List<OverdueRecord> records = getOverdueRecords();
				List<OverdueRecord> recordById = new ArrayList<OverdueRecord>();

				if (!publicationSearchField.getText().trim().isEmpty()) {

					records.forEach(a -> {
						if(a.getIssueno().trim().equalsIgnoreCase(publicationSearchField.getText().toString().trim())){
							recordById.add(a);
						}
					});
					if(recordById.size() >0){
					tableView.setItems(FXCollections
							.observableArrayList(recordById));
					}else{
						 Message.showInformationDialog("No Records Found.");
						 publicationSearchField.setText(null);
						 tableView.setItems(FXCollections
									.observableArrayList(records));
					}
				}
				else {
					tableView.setItems(FXCollections
							.observableArrayList(records));
				}


	}

	public List<OverdueRecord> getOverdueRecords() {
		MemberDataAccess memberDataAccess = new MemberDataAccess();
		List<LibraryMember> libraryMembers = memberDataAccess.getAllMembers();
		List<OverdueRecord> OverdueRecords = new ArrayList<>();
		for (LibraryMember libraryMember : libraryMembers) {
			if(libraryMember.getRecord() != null){
				if(libraryMember.getRecord().GetEntries() != null){
					libraryMember.getRecord().GetEntries().forEach(a -> {
						LocalDate date = a.getDueDate();
						if(LocalDate.now().isAfter(date)){
							OverdueRecords.add(new OverdueRecord(a.getBookCopy().getBook().getISBN(),
									libraryMember.getFirstName() + " " + libraryMember.getLastName(), a.getCheckOutDate(), a.getDueDate()));
						}
					});
				}
			}
		}

		return OverdueRecords;

	}
}