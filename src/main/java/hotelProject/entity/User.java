package hotelProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userTable")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String city;
	private String gender;
	
	
	public User() {
	}
	
	

	public User(int id, String name, String city, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.gender = gender;
	}



	public User(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
