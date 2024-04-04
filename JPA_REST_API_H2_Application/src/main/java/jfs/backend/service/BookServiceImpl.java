package jfs.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.Book;
import jfs.backend.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	public BookServiceImpl(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public String upsertBook(Book book) {
	
		Integer bookId = book.getBookId();
		
		bookRepo.save(book);
		
		if(bookId == null) {
		return	"Record Inserted";
		}else {
		return "Record Updated";
		}
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
		
	}

	@Override
	public String deleteBook(Integer bookId) {
		
		bookRepo.deleteById(bookId);
		
		return "Book Deleted";
	}

}
