package model;

import java.io.Serializable;

public class Author extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3058710255576263053L;
	private String credentials;
	//private String shortBio;
	//private List<Book> bookList;

	public Author() {
	
	}

	public Author(String firstname, String lastName, String phone, Address address, String credentials) {
		super(firstname, lastName, phone, address);
		this.credentials = credentials;
		
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

//	public List<Book> getBookList() {
//		return bookList;
//	}
//
//	public void setBookList(List<Book> bookList) {
//		this.bookList = bookList;
//	}
//
//	public String getShortBio() {
//		return shortBio;
//	}
//
//	public void setShortBio(String shortBio) {
//		this.shortBio = shortBio;
//	}
	
}
