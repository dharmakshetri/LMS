package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8373185079771219066L;
	private String isbn;
	private String title;
	private List<BookCopy> copies = new ArrayList<BookCopy>();
	private List<Author> authorList;
	private int maxCheckoutLength;
	
	
	public List<BookCopy> getCopies() {
		return copies;
	}


	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}


	public Book() {
	}

	
	public Book(String title, String isbn, int maxCheckoutLength,int numOfCopies,
			List<Author> authorList) throws CloneNotSupportedException {
		int number=numOfCopies;
		this.title=title;
		this.isbn = isbn;
		this.maxCheckoutLength=maxCheckoutLength;
		this.authorList = authorList; 
		BookCopy copy =new BookCopy(number,this,true);
		BookCopy cTemp = (BookCopy ) copy.clone();
		this.copies.add(cTemp);
		copies.add(cTemp);
	}
	
	public void addCopy() throws CloneNotSupportedException {
		if(this.copies == null){
			this.copies = new ArrayList<BookCopy>();
		}
		BookCopy c = new BookCopy(this.copies.size() + 1,this,true);
		BookCopy cTemp = (BookCopy ) c.clone();
		this.copies.add(cTemp);
	}
	public void updateBookCopyArray(BookCopy copy) {
		for(int i = 0; i < copies.size(); ++i) {
			if(copies.get(i).getCopyNum() == copy.getCopyNum()) {
				copies.add(i, copy);
				break;
			}
		}
		
	}
	
	public int getMaxCheckoutLength() {
		
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getISBN() {
		return isbn;
	}

	public void setISBN(String iSBN) {
		isbn = iSBN;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}
}
