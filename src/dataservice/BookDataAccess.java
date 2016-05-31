package dataservice;

import java.util.List;

import model.Book;;

public class BookDataAccess extends iDataAccess {
	public void saveUser(Book book) {
		List<Book> allBook = getAllItems();
		allBook.add(book);
		save(allBook);
	}

	public Book serachUser(String isbn) {
		List<Book> allBook = getAllItems();
		for (Book book : allBook) {
			if (book.getISBN().equals(isbn))
				return book;
		}
		return null;

	}

	public void updateBook(Book book) {
		List<Book> allBook = getAllItems();
		for (int i=0;i<allBook.size();i++) {
			if (allBook.get(i).getISBN().equals(book.getISBN())) {
				allBook.remove(i);
				allBook.add(i, book);
				//System.out.println(allBook.get(i).getCopies()[0].getCopyNum());
				break;
			}
		}
		save(allBook);
	}

}
