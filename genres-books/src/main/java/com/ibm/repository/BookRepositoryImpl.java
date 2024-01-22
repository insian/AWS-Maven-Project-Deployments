package com.ibm.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.factory.MySessionFactory;
import com.ibm.model.Book;
import com.ibm.model.Genre;

public class BookRepositoryImpl implements BookRepository{
	private SessionFactory sessionFactory = null;
	private Session session = null;
	{
		try {
			sessionFactory = MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	@Override
	public Genre addGenre(Genre genre) {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(genre);
		session.getTransaction().commit();
		return genre;
	}
	
	@Override
	public List<Genre> getAllGenres(){
		session = sessionFactory.openSession();
		TypedQuery<Genre> query = session.createQuery("FROM Genre G",Genre.class);
		return query.getResultList();
	}

	@Override
	public Genre findGenreById(int genreId) {
		session = sessionFactory.openSession();
		Genre genre = session.find(Genre.class, genreId);
		return genre;
	}
	
	@Override
	public Genre updateGenreById(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteGenreById(int genreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBookById(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
