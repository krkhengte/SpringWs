package jfs.backend.converter;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jfs.backend.binding.Author;
import jfs.backend.binding.Book;

public class JavaToJsonConverter {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		Author author=new Author();
		author.setAuthorName("Rod Jhonson");
		author.setAuthorEmail("jhonson@gmail.com");
		author.setAuthorPhone(4847749485l);
		
		
		Book book=new Book();
		book.setId(101);
		book.setName("Spring");
		book.setPrice(500.00);
		book.setAuthor(author);
		
		
		
		ObjectMapper mapper=new ObjectMapper(); 
		mapper.writeValue(new File("book.json"), book); // Converting Object into JSON
		System.out.println("Conversion Completed..");
		
	}
}
