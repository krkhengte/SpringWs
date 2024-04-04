package jfs.backend.entity;

import org.hibernate.type.descriptor.jdbc.JsonAsStringJdbcType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "hotels")
@Entity
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
