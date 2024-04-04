package jfs.backend.service;

import java.util.List;

import jfs.backend.entity.Book;

public interface BookService {

	public String upsertBook(Book book);  // add or Update
	public List<Book> getAllBooks();
	public String deleteBook(Integer bookId);
	
	
	
}
