package fi.haagahelia.foodSharingDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostRepository extends CrudRepository<Post, Long> {

	List<Post> findByTitle(String title);
	
	List<Post> findByDescription(@Param("description") String description);
	List<Post> findByLocation(@Param("location") String location);
	List<Post> findByPostedDate(@Param("postedDate") String postedDate);
	List<Post> findByLastDate(@Param("lastDate") String lastDate);
	
	

}
