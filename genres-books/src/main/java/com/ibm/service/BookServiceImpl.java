package com.ibm.service;

import java.util.List;
import java.util.UUID;

import com.ibm.model.Book;
import com.ibm.model.Genre;
import com.ibm.repository.BookRepository;
import com.ibm.repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {
	private BookRepository bookRepo;
	{
		try{
			bookRepo = new BookRepositoryImpl();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Genre addGenre(Genre genre) {
		// TODO Auto-generated method stub
		return bookRepo.addGenre(genre);
	}
	
	@Override
	public Genre findGenreById(int genreId) {
		// TODO Auto-generated method stub
		return bookRepo.findGenreById(genreId);
	}
	
	private static Integer generateId(){
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		int a=Integer.parseInt(str);
		return a;
	}

	@Override
	public List<Genre> getAllGenres() {
		// TODO Auto-generated method stub
		return bookRepo.getAllGenres();
	}

	@Override
	public Genre updateGenreById(Genre genre) {
		// TODO Auto-generated method stub
		return bookRepo.updateGenreById(genre);
	}

	@Override
	public Boolean deleteGenreById(int genreId) {
		// TODO Auto-generated method stub
		return bookRepo.deleteGenreById(genreId);
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.addBook(book);
	}
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.getAllBooks();
	}

	@Override
	public Book findBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookRepo.findBookById(bookId);
	}

	@Override
	public Book updateBookById(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.updateBookById(book);
	}

	@Override
	public Boolean deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookRepo.deleteBookById(bookId);
	}
	

}
