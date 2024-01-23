package com.ibm;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
    	Book book  = new Book();
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
    	
    	//Find Genre by Id
    	/*try {
    		System.out.println("Enter Genre Id");
			genre = bookService.findGenreById(Integer.parseInt(br.readLine()));
			if(genre==null) {
				System.out.println("Invalid Genre Id");
			} else {
				System.out.println(genre);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	//Update Genre By Id
    	/*try {
    		System.out.println("Enter Genre Id");
			genre = bookService.findGenreById(Integer.parseInt(br.readLine()));
			if(genre==null) {
				System.out.println("Invalid Genre Id");
			} else {
				System.out.println("Enter Genre Name");
				genre.setGenreName(br.readLine());
				System.out.println("Enter Shelf Number");
				genre.setShelfNo(br.readLine());
				if(bookService.updateGenreById(genre)) {
					System.out.println("Updated Successfully "+genre);
				} else {
					System.out.println("Updated Not Successfully");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	
    	//Not Completed
    	//Delete Genre By Id
    	try {
    		System.out.println("Enter Genre Id");
			genre = bookService.findGenreById(Integer.parseInt(br.readLine()));
			if(genre==null) {
				System.out.println("Invalid Genre Id");
			} else {
				System.out.println(genre);
				bookService.deleteGenreById(genre);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    	//Add Books
    	/*try {
			System.out.println("Enter Genre Id");
			genre = bookService.findGenreById(Integer.parseInt(br.readLine()));
			if(genre==null) {
				System.out.println("Invalid Genre ID");
			}
			else {
				book.setGenre(genre);
				System.out.println("Enter Book Title");
				book.setBookTitle(br.readLine());
				System.out.println("Enter Book Author");
				book.setBookAuthor(br.readLine());
				bookService.addBook(book);
			}    		
		} catch (Exception e) {
			// TODO: handle exception
		}*/
    	
    	
    }
    
}
