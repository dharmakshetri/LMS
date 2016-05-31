package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import model.Book;

public class CheckoutRecordEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7666572549187222698L;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;

	SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");

	public CheckoutRecordEntry(BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		this.bookCopy = bookCopy;
		this.checkOutDate = checkoutDate;
		this.dueDate=dueDate;
	}

	
}
