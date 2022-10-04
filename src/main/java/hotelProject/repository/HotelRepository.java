package hotelProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelProject.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
}
