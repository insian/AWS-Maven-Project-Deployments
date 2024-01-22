package com.ibm;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.model.Book;
import com.ibm.model.Genre;
import com.ibm.service.BookService;
import com.ibm.service.BookServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static BookService bookService;
	static {
		bookService = new BookServiceImpl();
	}
	private static BufferedReader br =new BufferedReader(new InputStreamReader(in));
	
    public static void main( String[] args )
    {
    	Genre genre = new Genre();
    	//Add Genres
    	/*try {
			System.out.println("Enter Genre Name");
			genre.setGenreName(br.readLine());
			System.out.println("Enter Shelf Number");
			genre.setShelfNo(br.readLine());
			genre = bookService.addGenre(genre);
			System.out.println(genre);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	*/
    	
    	//Show All Genres
    	/*try {
			for(Genre g: bookService.getAllGenres()) {
				System.out.println(g);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    }
    
}
