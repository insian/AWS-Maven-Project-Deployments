package com.ibm.service;

import java.util.List;

import com.ibm.model.Book;
import com.ibm.model.Genre;

public interface BookService {
	Genre addGenre(Genre genre);
	List<Genre> getAllGenres();
	Genre findGenreById(int genreId);
	Genre updateGenreById(Genre genre);
	Boolean deleteGenreById(int genreId);
	
	Book addBook(Book book);
	List<Book> getAllBooks();
	Book findBookById(int bookId);
	Book updateBookById(Book book);
	Boolean deleteBookById(int bookId);
}
