package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;

@SpringBootTest
public class BooksServiceTest {
	
	Books books1;
	
	List<Books> books;
	
	@InjectMocks
	BooksService booksService;
	
	@Mock
    BooksRepository booksRepository;
	
	@BeforeEach
	void setup() {
		books1 = save();
		books1.setBookid(1);
		books1.setBookname("java");
		books1.setPrice(99);
		books1.setAuthor("raj");
		
		books = findAll();
		List<Books> books = new ArrayList();
		Books books1 = new Books();
		books1.setAuthor("yogesh");
		books1.setBookid(2);
		books1.setBookname("english");
		books1.setPrice(100);
		
		Books books2 = new Books();
		books2.setAuthor("yogesh");
		books2.setBookid(3);
		books2.setBookname("hindi");
		books2.setPrice(100);
   }
	
	private List<Books> findAll() {
		List<Books> books = new ArrayList();
		Books books1 = new Books();
		books1.setAuthor("yogesh");
		books1.setBookid(2);
		books1.setBookname("english");
		books1.setPrice(100);
		
		Books books2 = new Books();
		books2.setAuthor("yogesh");
		books2.setBookid(3);
		books2.setBookname("hindi");
		books2.setPrice(100);
		
		books.add(books1);
		books.add(books2);
		return books;
	}

	private Books save() {
	  
		Books books = new Books();
		books.setBookid(1);
		books.setBookname("java");
		books.setPrice(99);
		books.setAuthor("raj");
		return books;
	}

	@Test 
	void saveBookss_test( ) {
		when(booksRepository.save(Mockito.any(Books.class))).thenReturn(books1);
		Books actualOutPut = booksService.saveBookss(books1);
		assertEquals(books1.toString(), actualOutPut.toString());
		}
	@Test
	void saveBookssList_test() {
		when(booksRepository.findAll()).thenReturn(books);
		List<Books> actualOutPutLit = booksService.getAllBooks();
		assertEquals(actualOutPutLit.size(), books.size());
		}
	@Test
	void delete_test() {
		when(booksRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(books1));
		int bookId = booksService.delete(books1.getBookId());
		assertEquals(books1.getBookId(),bookId); 
		
	}
	@Test
	void update_test() {
		when(booksRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(books1));
		when(booksRepository.save(Mockito.any(Books.class))).thenReturn(books1);
		boolean actualOutput = booksService.equals(books1);
		
	}
}
