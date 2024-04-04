package jfs.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Author {

	private Integer authorid;
	private String authorName;
	
}
