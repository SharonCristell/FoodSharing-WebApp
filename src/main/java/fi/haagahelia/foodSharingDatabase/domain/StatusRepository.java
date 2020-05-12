package fi.haagahelia.foodSharingDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long > {
	
	
	 List<Status> findByAvailability(String availability);
	

}
