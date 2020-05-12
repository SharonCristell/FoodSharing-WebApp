package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.foodSharingDatabase.FoodSharingDatabaseApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
class FoodSharingApplicationTests {
	@Autowired
	private FoodSharingDatabaseApplication controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}