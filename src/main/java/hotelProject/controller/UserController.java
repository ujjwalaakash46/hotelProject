package hotelProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotelProject.entity.User;
import hotelProject.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 
	 * @param page: page number
	 * @param size: page size
	 * @return List of users
	 * 
	 * eg-
	 * 		Get: http://localhost:8080/user?page=0&size=5
	 */
	@GetMapping()
	public Page<User> getAllUser(@RequestParam("page") int page, @RequestParam("size") int size ){
		return userService.getAllUser(page, size);
	}
	
	/**
	 * 
	 * @param id: userId
	 * @return User details
	 * 
	 * eg-
	 * 		Get: http://localhost:8080/user/get?id=15
	 */
	@GetMapping("/get")
	public User getUser(@RequestParam("id") int id){
		return userService.getUser(id);
	}
	
	
	/**
	 * 
	 * @param id: UserId
	 * 
	 * eg-
	 * 		Delete: http://localhost:8080/user/delete?id=15
	 */
	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam("id") int id){
		userService.deleteUser(id);
	}
	
	/**
	 * 
	 * @param user object
	 * @return user's details
	 * 
	 * eg-
	 * 		Post: http://localhost:8080/add
	 * 		body:user object
	 */
	@PostMapping("/add")
	public User addUser(@RequestBody() User user){
		return userService.addUser(user);
	}
	
	
}
