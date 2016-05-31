package model;

import java.io.Serializable;

public class BookCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -868546811515604784L;
	private int copyNum;
	private Book book;
	
	private boolean isAvailable;
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public BookCopy() {
	}

	public BookCopy(int noOfCopy,Book book,boolean isAvailable) {
		this.copyNum = noOfCopy;
		this.book=book;
		this.isAvailable=isAvailable;
	}
	public BookCopy changeAvailability() {
		this.isAvailable = !isAvailable;
		book.updateBookCopyArray(this);
		return this;
	}

	
	public int getCopyNum() {
		return copyNum;
	}

	public void setCopyNum(int copyNum) {
		this.copyNum = copyNum;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

//	public boolean isCheckedout() {
//		return isCheckedout;
//	}
//
//	public void setCheckedout(boolean isCheckedout) {
//		this.isCheckedout = isCheckedout;
//	}
}
