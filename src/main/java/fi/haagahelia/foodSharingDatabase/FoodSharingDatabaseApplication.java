package fi.haagahelia.foodSharingDatabase;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.foodSharingDatabase.domain.Item;
import fi.haagahelia.foodSharingDatabase.domain.ItemRepository;
import fi.haagahelia.foodSharingDatabase.domain.Post;
import fi.haagahelia.foodSharingDatabase.domain.PostRepository;
import fi.haagahelia.foodSharingDatabase.domain.Status;
import fi.haagahelia.foodSharingDatabase.domain.StatusRepository;
import fi.haagahelia.foodSharingDatabase.domain.Type;
import fi.haagahelia.foodSharingDatabase.domain.TypeRepository;
import fi.haagahelia.foodSharingDatabase.domain.UserRepository;
import fi.haagahelia.foodSharingDatabase.domain.Visitor;

@SpringBootApplication
public class FoodSharingDatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(FoodSharingDatabaseApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(FoodSharingDatabaseApplication.class, args);

	}

	@Bean
	public CommandLineRunner postdemo(PostRepository repository, TypeRepository drepository,
			StatusRepository arepository, UserRepository urepository, ItemRepository jrepository) {
		return (arg) -> {
			log.info("save some types and status");
			
			drepository.save(new Type("Non-food"));
			drepository.save(new Type("Food"));
	

			arepository.save(new Status("shared"));
			arepository.save(new Status("needed"));
			
			log.info("save some posts");

			Post p1 = new Post("Lamp ", "Little lamp", "Espoo", "10.05.2020", "13.05.2020",
					"7 days", drepository.findByName("Non-food").get(0), arepository.findByAvailability("shared").get(0));
			Post p2 = new Post("Cutlery", "Spoons, knives", "Turku", "12.05.2020", "12.06.2020", "12 months",
					drepository.findByName("Non-food").get(0), arepository.findByAvailability("shared").get(0));
			Post p3 = new Post("Clothes", "Sweaters, t-shirts, gloves for children", "Helsinki", "10.05.2020",
					"undefined", "5 months", drepository.findByName("Non-food").get(0),
					arepository.findByAvailability("needed").get(0));

			repository.save(p1);
			repository.save(p2);
			repository.save(p3);
			
			log.info("fetch all the posts");
			for (Post post : repository.findAll()) {
				log.info(post.toString());
			}

			// Create users with BCrypt encoded password (user/user, admin/admin)
			Visitor user1 = new Visitor("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Visitor user2 = new Visitor("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			Item i1 = new Item ("Yogurt",
					"Strawberry yogurt", "Espoo", "Contact to arrange" );
			Item i2 = new Item ("Brownies",
					"Fazer brownies", "Turku", "Mornings from 8am to 11am" );
			Item i3 = new Item ("Frying pan",
					"Frying pan and cutlery", "Helsinki", "Afternoons from 3pm to 7pm" );
		
			
			jrepository.save(i1);
			jrepository.save(i2);
			jrepository.save(i3);
		};
	}

}
