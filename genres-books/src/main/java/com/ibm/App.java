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
		}*/
    	
    	
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
    	
    	
    	//Delete Genre By Id
    	try {
    		System.out.println("Enter Genre Id");
			genre = bookService.findGenreById(Integer.parseInt(br.readLine()));
			if(genre==null) {
				System.out.println("Invalid Genre Id");
			} else {
				if(bookService.deleteGenreById(genre)) {
					System.out.println("Deleted Successfully");
				} else {
					System.out.println("Deletion Unsuccessful");
				}
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
				System.out.println(book);
			}    		
		} catch (Exception e) {
			// TODO: handle exception
		}*/
    	
    	
    	//Show All Books
    	/*try {
			for(Book b: bookService.getAllBooks()) {
				System.out.println(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	//Find Book by Id
    	/*try {
    		System.out.println("Enter Book Id");
			book = bookService.findBookById(Integer.parseInt(br.readLine()));
			if(book==null) {
				System.out.println("Invalid Book Id");
			} else {
				System.out.println(book);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	
    	//Update Book By Id
    	/*try {
    		System.out.println("Enter Book Id");
			book = bookService.findBookById(Integer.parseInt(br.readLine()));
			if(book==null) {
				System.out.println("Invalid Book Id");
			} else {
				System.out.println("Enter Book Title");
				book.setBookTitle(br.readLine());
				System.out.println("Enter Book Author");
				book.setBookAuthor(br.readLine());
				if(bookService.updateBookById(book)) {
					System.out.println("Updated Successfully "+book);
				} else {
					System.out.println("Updated Not Successfully");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	
    	//Delete Book By Id
    	/*try {
    		System.out.println("Enter Book Id");
			book = bookService.findBookById(Integer.parseInt(br.readLine()));
			if(book==null) {
				System.out.println("Invalid Book Id");
			} else {
				book.setGenre(null);
				if(bookService.deleteBookById(book)) {
					System.out.println("Deleted Successfully");
				} else {
					System.out.println("Deletion Unsuccessful");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    }
    
}
