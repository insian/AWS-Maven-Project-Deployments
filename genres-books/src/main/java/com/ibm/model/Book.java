package com.ibm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="books")
public class Book {
	@Id
	@Column(name="isbn_no")
	private int isbnNo;
	
	@Column(name="book_title")
	private String bookTitle;
	
	@Column(name="book_author")
	private String bookAuthor;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="genre_id")
	private Genre genre;

	public Book(int isbnNo, String bookTitle, String bookAuthor) {
		super();
		this.isbnNo = isbnNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}

	@Override
	public String toString() {
		return "Book [isbnNo=" + isbnNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", genreId=" + genre.getGenreId() 
		+ ", genreName=" + genre.getGenreName()  + ", genreShelfNo=" + genre.getShelfNo() + "]";
	}
}
