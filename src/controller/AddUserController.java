package controller;


import dataservice.MemberDataAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Address;
import model.LibraryMember;
import model.Message;


public class AddUserController {
@FXML 
private TextField txtFName;
@FXML 
private TextField txtLName;
@FXML 
private TextField txtMemId;
@FXML
private TextField txtPhone;
@FXML
private TextField txtStreet;
@FXML
private TextField txtCity;
@FXML
private TextField txtState;
@FXML
private TextField txtZip;



public void addMember(ActionEvent event) {
	
	
	try{
		Address a=new Address(txtStreet.getText(), txtCity.getText(), txtState.getText(), txtZip.getText());
		LibraryMember libMember=new LibraryMember(a, txtFName.getText(), txtLName.getText(),txtMemId.getText(), txtPhone.getText());
		 clear();
		
		 MemberDataAccess memberDao = new MemberDataAccess();
		 memberDao.saveUser(libMember);
		 Message.showInformationDialog("Member is successfully added");
		 
	
	}catch(Exception e){
		new Message();
		Message.showWarningDialog("All Fields are required");
		
						}
}

public void clear(){
	txtFName.clear();
	txtLName.clear();
	txtMemId.clear();
	txtPhone.clear();
	txtStreet.clear();
	txtCity.clear();
	txtState.clear();
	txtZip.clear();
}
}

