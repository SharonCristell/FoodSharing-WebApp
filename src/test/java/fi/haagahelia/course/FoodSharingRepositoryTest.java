package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fi.haagahelia.foodSharingDatabase.domain.Post;
import fi.haagahelia.foodSharingDatabase.domain.PostRepository;
import fi.haagahelia.foodSharingDatabase.domain.StatusRepository;
import fi.haagahelia.foodSharingDatabase.domain.TypeRepository;

public class FoodSharingRepositoryTest {

	@Autowired
	private PostRepository repository;

	@Test
	public void findByTitleShouldReturnTitle() {
		List<Post> posts = repository.findByTitle("Dairy products");
		

		assertThat(posts).hasSize(1);
		assertThat(posts.get(0).getTitle()).isEqualTo("Dairy products");
	}
	StatusRepository arepository;
	TypeRepository drepository;

	@Test
	public void createNewPost() {
		
		
		Post posts = new Post("Dairy products", "Yogurt, milk, cheese", "Espoo", "10.05.2020", "13.05.2020",
				"7 days", drepository.findByName("Food").get(0), arepository.findByAvailability("shared").get(0));
		repository.save(posts);
		assertThat(posts.getId()).isNotNull();
	}

}