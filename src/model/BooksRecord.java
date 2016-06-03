package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BooksRecord
{
	private final SimpleStringProperty isbn = new SimpleStringProperty("");

	private final SimpleStringProperty title = new SimpleStringProperty("");

	private final SimpleStringProperty author = new SimpleStringProperty("");

	private final SimpleStringProperty biography = new SimpleStringProperty("");


	public BooksRecord() {

	}

	public BooksRecord(String isbn, String title, String author) {
		setISBN(isbn);
		setTitle(title);
		setAuthor(author);
		//setBiography(biography);
	}

	public void setISBN(String isbn) {
		this.isbn.set(isbn);
	}

	public String getISBN() {
		return this.isbn.get();
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public String getAuthor() {
		return this.author.get();
	}

	public void setBiography(String biography) {
		this.biography.set(biography);
	}

	public String getBiography() {
		return this.biography.get();
	}

	public void setTitle(String title)
	{
		this.title.set(title);
	}

	public String getTitle()
	{
		return this.title.get();
	}

	public StringProperty isbnProperty() {
		return this.isbn;
	}

	public StringProperty titleProperty() {
		return this.title;
	}

	public StringProperty biographyProperty() {
		return this.biography;
	}

	public StringProperty authorProperty() {
		return this.author;
	}
}
