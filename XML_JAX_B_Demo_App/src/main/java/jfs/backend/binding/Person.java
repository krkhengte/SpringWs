package jfs.backend.binding;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private Integer Id;
	private String name;
	private Integer age;
	private Long phNo;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPhNo() {
		return phNo;
	}

	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}

	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + ", age=" + age + ", phNo=" + phNo + "]";
	}

}
