package fi.haagahelia.foodSharingDatabase.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByTitle(String title);

}
