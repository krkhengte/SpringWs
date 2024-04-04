package jfs.backend.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.binding.Book;

@RestController
public class BookRestController {

	@PostMapping(value = "/book",consumes = {"application/json","application/xml"})
	public ResponseEntity<String> addBook(@RequestBody Book book){ // Using RequestBody we can read the Json data
		
		System.out.println("Book Id :" + book.getBookId());
		System.out.println("Book Name :" + book.getBookName());
		System.out.println("Book Price :" + book.getBookPrice());
		
		String msg="Book Added Successfully....";
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		
	}
}
