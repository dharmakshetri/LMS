package model;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -4387896556217602714L;
private String memId;
private String firstName;
private String lastName;
private String phone;
private CheckoutRecord record;

public CheckoutRecord getRecord() {
	return record;
}
public void setRecord(CheckoutRecord record) {
	this.record = record;
}
public LibraryMember(){
	super();
}
public LibraryMember(Address address, String firstName, String lastName, String memId, String phone) {
	super( firstName, lastName, phone,address);
	this.memId = memId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	
	
}

public Address getAddress(){
	return super.address;
}
public String getMemId() {
	return memId;
}
public void setMemId(String memId) {
	this.memId = memId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

}
