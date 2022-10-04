package hotelProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hotelProject.entity.Hotel;
import hotelProject.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	
	@Autowired
	HotelService hotelService;
	
	/**
	 * 
	 * @param page: page number
	 * @param size: page size
	 * @return List of Hotels
	 * 
	 * eg-
	 * 		Get: http://localhost:8080/hotel?page=0&size=5
	 */
	@GetMapping()
	public Page<Hotel> getAllHotel(@RequestParam("page") int page, @RequestParam("size") int size ){
		return hotelService.getAllHotel(page, size);
	}
	
	
	/**
	 * 
	 * @param userId
	 * @param hotelId
	 * @param rating
	 * @param comment
	 * @return responseEntity with message
	 * 
	 * eg-
	 * 		Post: http://localhost:8080/hotel/add/review?user=8&hotel=1&rating=9
	 * 		body: (String) comment
	 */
	@PostMapping("/add/review")
	public ResponseEntity<String> addReview(
			@RequestParam("user") int userId, 
			@RequestParam("hotel") int hotelId, 
			@RequestParam("rating") int rating, 
			@RequestBody String comment){
		return hotelService.addReview(comment, rating, hotelId, userId);
	}
	
	/**
	 * 
	 * @param id
	 * @return hotel details
	 * 
	 * eg-
	 * 		Get: http://localhost:8080/hotel/get?id=9
	 */
	@GetMapping("/get")
	public Hotel getHotel(@RequestParam("id") int id){
		return hotelService.getHotel(id);
	}
	
	/**
	 * 
	 * @param field: any property of hotel
	 * @param value: value of the field
	 * @param page
	 * @param size
	 * @return
	 * 
	 * eg-
	 * 		Get: http://localhost:8080/hotel/find?field=wifi&value=true&page=0&size=5
	 */
	@GetMapping("/find")
	public Page<Hotel> getHotelBy(
			@RequestParam("field") String field, 
			@RequestParam("value") String value, 
			@RequestParam("page") int page, 
			@RequestParam("size") int size ){
		return hotelService.getHotelBy(field, value, page, size);
	}
	
	/**
	 * 
	 * @param hotel: hotel Object
	 * @return hotel's details
	 * 
	 * eg-
	 * 		Post: http://localhost:8080/hotel/add
	 *	 	body: Hotel object
	 */
	@PostMapping("/add")
	public Hotel addHotel(@RequestBody() Hotel hotel){
		return hotelService.addHotel(hotel);
	}
	
	/**
	 * 
	 * @param id: Hotel Id
	 * 
	 * eg-
	 * 		Delete: http://localhost:8080/hotel/delete?id=2
	 */
	@DeleteMapping("/delete")
	public void deleteHotel(@RequestParam("id") int id){
		hotelService.deleteHotel(id);
	}
	
	
}
