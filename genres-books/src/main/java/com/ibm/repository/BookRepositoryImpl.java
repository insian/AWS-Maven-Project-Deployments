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
	public Boolean updateGenreById(Genre genre) {
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(genre);
			session.getTransaction().commit();
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteGenreById(Genre genre) {
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.remove(genre);
			session.getTransaction().commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Book addBook(Book book) {
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.merge(book);
			session.getTransaction().commit();
			return book;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
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
	public Boolean deleteBookById(Book book) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
