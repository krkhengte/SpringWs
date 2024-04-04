package jfs.backend.converter;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jfs.backend.binding.Book;

public class JsonToJavaConverter {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File jsonFile=new File("book.json");
	
		ObjectMapper mapper=new ObjectMapper();
		
		Book book = mapper.readValue(jsonFile, Book.class); // to convert the json data into java Object 
		System.out.println(book);
	}
}
