package model;

public class Person {
public Address address;
private String fName;
private String lastName;
private String phone;

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
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
public Person(){
	
}
public Person( String fName, String lastName, String phone,Address address) {
	
	this.address = address;
	this.fName = fName;
	this.phone = phone;
	this.lastName=lastName;
}


}
