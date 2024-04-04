package jfs.backend.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.entity.Book;
import jfs.backend.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService service;

	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody Book book) {

		String upsertBook = service.upsertBook(book);

		return new ResponseEntity<String>(upsertBook, HttpStatus.CREATED);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> allBooks = service.getAllBooks();

		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}

	@PutMapping("/book")
	public ResponseEntity<String> updatBook(@RequestBody Book book) {

		String upsertBook = service.upsertBook(book);
		return new ResponseEntity<String>(upsertBook, HttpStatus.OK);

	}

	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {

		String deleteBook = service.deleteBook(bookId);

		return new ResponseEntity<String>(deleteBook, HttpStatus.OK);

	}
}
