package hotelProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Hotel {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String city;
	private int cost;
	private int roomAvaiable;
	
	private boolean wifi;
	private boolean ac;
	private boolean isMealIncluded;
	private boolean isRestaurantAvailable;
	private double totalRating = 0;
	
	@JsonIgnoreProperties(value= {"hibernateLazyInitializer","applications"})
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Review> reviews;
	
	public Hotel() {
	}
	
	
	
	public Hotel(String name, String city, int cost, int roomAvaiable, boolean wifi, boolean ac, boolean isMealIncluded,
			boolean isRestaurantAvailable, List<Review> reviews) {
		super();
		this.name = name;
		this.city = city;
		this.cost = cost;
		this.roomAvaiable = roomAvaiable;
		this.wifi = wifi;
		this.ac = ac;
		this.isMealIncluded = isMealIncluded;
		this.isRestaurantAvailable = isRestaurantAvailable;
		this.reviews = reviews;
	}



	public Hotel(int id, String name, String city, int cost, int roomAvaiable, boolean wifi, boolean ac,
			boolean isMealIncluded, boolean isRestaurantAvailable, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.cost = cost;
		this.roomAvaiable = roomAvaiable;
		this.wifi = wifi;
		this.ac = ac;
		this.isMealIncluded = isMealIncluded;
		this.isRestaurantAvailable = isRestaurantAvailable;
		this.reviews = reviews;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getRoomAvaiable() {
		return roomAvaiable;
	}
	public void setRoomAvaiable(int roomAvaiable) {
		this.roomAvaiable = roomAvaiable;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public boolean isMealIncluded() {
		return isMealIncluded;
	}
	public void setMealIncluded(boolean isMealIncluded) {
		this.isMealIncluded = isMealIncluded;
	}
	public boolean isRestaurantAvailable() {
		return isRestaurantAvailable;
	}
	public void setRestaurantAvailable(boolean isRestaurantAvailable) {
		this.isRestaurantAvailable = isRestaurantAvailable;
	}

	public double getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	
	
}
