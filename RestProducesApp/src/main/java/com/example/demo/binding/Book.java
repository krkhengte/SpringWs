package com.example.demo.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private Integer bookId;
	private String bookName;
	private Double bookPrice;
}
