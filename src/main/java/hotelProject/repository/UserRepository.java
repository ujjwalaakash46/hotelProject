package hotelProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelProject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
