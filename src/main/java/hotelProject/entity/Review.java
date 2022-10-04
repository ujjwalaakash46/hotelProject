package hotelProject.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private int id;
	//10
	private int star;
	
	private String comment;
	
	@JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	

	public Review() {
	}

	public Review(int star, String comment, User user) {
		super();
		this.star = star;
		this.comment = comment;
		this.user = user;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
