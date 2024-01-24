package com.ibm.service;

import java.util.List;

import com.ibm.model.Book;
import com.ibm.model.Genre;

public interface BookService {
	Genre addGenre(Genre genre);
	List<Genre> getAllGenres();
	Genre findGenreById(int genreId);
	Boolean updateGenreById(Genre genre);
	Boolean deleteGenreById(Genre genre);
	
	Book addBook(Book book);
	List<Book> getAllBooks();
	Book findBookById(int bookId);
	Boolean updateBookById(Book book);
	Boolean deleteBookById(Book book);
}
