package com.ibm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="genre_id")
	private Genre genre;

	public Book(int isbnNo, String bookTitle, String bookAuthor) {
		super();
		this.isbnNo = isbnNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}
	
	
}
