package hotelProject.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import hotelProject.entity.Hotel;
import hotelProject.entity.Review;
import hotelProject.entity.User;
import hotelProject.repository.HotelRepository;
import hotelProject.repository.ReviewRepository;
import hotelProject.repository.UserRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Page<Hotel> getAllHotel(int page, int size) {
		try {
			return hotelRepo.findAll(PageRequest.of(page, size));		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ResponseEntity<String> addReview(String comment, int rating, int hotelID, int userId) {

		Hotel hotel = hotelRepo.findById(hotelID).orElse(null);
		User user = userRepo.findById(userId).orElse(null);

		if (hotel == null)
			return new ResponseEntity<String>("No hotel found", HttpStatus.BAD_GATEWAY);
		if (user == null)
			return new ResponseEntity<String>("No user found", HttpStatus.BAD_GATEWAY);
		if (rating < 0 || rating > 10)
			return new ResponseEntity<String>("Rating should be between 1 to 10", HttpStatus.BAD_GATEWAY);
		;
		;

		List<Review> reviews = hotel.getReviews();
		Review review = new Review(rating, comment, user);

		// Calculating new totalRating
		double totalRating = (new BigDecimal(hotel.getTotalRating() * reviews.size() + review.getStar()))
				.divide(BigDecimal.valueOf(reviews.size() + 1), 2, RoundingMode.HALF_EVEN).doubleValue();
		reviews.add(review);
		hotel.setTotalRating(totalRating);
		hotel.setReviews(reviews);
		hotelRepo.save(hotel);

		return new ResponseEntity<String>("Review Added", HttpStatus.OK);
	}

	public Page<Hotel> getHotelBy(String field, String value, int page, int size) {

		//For the easiness, using this approach as we want to filter by one field.
		
		if (field.equals("totalRating"))
			field = "total_rating";
		else if (field.equals("isMealIncluded"))
			field = "is_meal_included";
		else if (field.equals("isRestaurantAvailable"))
			field = "is_restaurant_available";
		else if (field.equals("roomAvaiable"))
			field = "room_avaiable";

		String query;
		if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
			query = "select * from hotel h where h." + field + "=" + value + "";
		} else {
			query = "select * from hotel h where h." + field + "='" + value + "'";
		}

		try {
			List<Hotel> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<Hotel>(Hotel.class));

			Pageable p = PageRequest.of(page, size);

			return new PageImpl<>(list, p, list.size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public Hotel getHotel(int id) {
		return hotelRepo.findById(id).orElse(null);
	}

	public Hotel addHotel(Hotel hotel) {
		try {
			return hotelRepo.save(hotel);		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void deleteHotel(int id) {
		try {
			hotelRepo.deleteById(id);;			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@PostConstruct
	private void addhotels() {

		// Adding Hotels As using h2 DataBase (in memory)
		hotelRepo.saveAll(
				Arrays.asList(new Hotel(1, "Novotel", "Pune", 4000, 4, true, true, true, false, new ArrayList<>()),
						new Hotel(2, "Haytt", "Mumbai", 6000, 10, true, true, false, true, new ArrayList<>()),
						new Hotel(3, "Oberoi", "Bangalore", 5500, 2, false, true, true, false, new ArrayList<>()),
						new Hotel(4, "Orchid", "Pune", 3500, 6, true, false, true, true, new ArrayList<>()),
						new Hotel(5, "Orchid", "Bangalore", 3500, 6, true, false, true, false, new ArrayList<>()),
						new Hotel(6, "Taj", "Mumbai", 7000, 3, true, false, true, false, new ArrayList<>()),
						new Hotel(7, "Novotel", "New Delhi", 5500, 5, true, false, true, false, new ArrayList<>()),
						new Hotel(8, "Orchid", "New Delhi", 3500, 12, true, false, false, true, new ArrayList<>()),
						new Hotel(9, "Orchid", "Mumbai", 3500, 26, true, false, true, false, new ArrayList<>()),
						new Hotel(10, "Novotel", "Hyderabad", 5500, 8, true, true, false, false, new ArrayList<>()),
						new Hotel(11, "Novotel", "Bangalore", 4500, 7, true, false, true, false, new ArrayList<>()),
						new Hotel(12, "Haytt", "Hyderabad", 5000, 10, true, true, false, true, new ArrayList<>())

				));
		System.out.println("Added Sample Hotels");
	}

}
