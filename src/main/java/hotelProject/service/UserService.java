package hotelProject.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import hotelProject.entity.User;
import hotelProject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public Page<User> getAllUser(int page, int size) {
		try {
			return userRepo.findAll(PageRequest.of(page, size));			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public User getUser(int id) {
		try {
			return userRepo.findById(id).orElse(null);		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public User addUser(User user) {
		try {
			return userRepo.save(user);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void deleteUser(int id) {
		try {
			userRepo.deleteById(id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		userRepo.deleteById(id);
	}

	@PostConstruct
	private void addUser() {

		// Adding Users As using h2 DataBase (in memory)
		userRepo.saveAll(Arrays.asList(new User(1, "John", "Pune", "M"), new User(2, "Rahul", "Kochi", "M"),
				new User(3, "Sara", "Delhi", "F"), new User(4, "Preeti", "Pune", "F"),
				new User(5, "Alex", "Mumbai", "M"), new User(6, "Siddhi", "Bangalore", "F"),
				new User(7, "Sid", "Mumbai", "M"), new User(8, "Nina", "Delhi", "F")));
		System.out.println("Added Sample Users");

	}
}
