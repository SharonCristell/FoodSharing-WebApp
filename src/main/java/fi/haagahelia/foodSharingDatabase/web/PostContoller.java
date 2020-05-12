package fi.haagahelia.foodSharingDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.foodSharingDatabase.domain.Item;
import fi.haagahelia.foodSharingDatabase.domain.ItemRepository;
import fi.haagahelia.foodSharingDatabase.domain.Post;
import fi.haagahelia.foodSharingDatabase.domain.PostRepository;
import fi.haagahelia.foodSharingDatabase.domain.Status;
import fi.haagahelia.foodSharingDatabase.domain.StatusRepository;
import fi.haagahelia.foodSharingDatabase.domain.Type;
import fi.haagahelia.foodSharingDatabase.domain.TypeRepository;

@Controller
public class PostContoller {

	@Autowired
	private PostRepository repository;
	@Autowired
	private TypeRepository drepository;

	@Autowired
	private StatusRepository arepository;
	
	@Autowired
	private ItemRepository jrepository;

	
	@RequestMapping("/home")
	public String home() {
		return "home";

	}
	/**
	 * Login page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * This is a home page after successfully log in
	 * 
	 * @param model
	 * @return the page list of all posts 
	 */

	@RequestMapping("/postlist")
	public String postList(Model model) {
		model.addAttribute("posts", repository.findAll());
		return "postlist";

	}

	
	/**
	 * Return page when add a post to the list 
	 * @param  model
	 * @return a form add
	 */
	
	
	@RequestMapping(value = "/add")
	public String addPost(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("types", drepository.findAll());
		model.addAttribute("status", arepository.findAll());
		return "addPost";
	}


	
	/**
	 * edit html page for a specific post Id
	 * only for Admin
	 * @param postId
	 * @param model
	 * @return a form to edit
	 */
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") Long postId, Model model) {
		model.addAttribute("post", repository.findById(postId));
		model.addAttribute("types", drepository.findAll());
		model.addAttribute("status", arepository.findAll());
		return "editPost";
	}


	
	/**
	 * Return page when submit post
	 * @param post
	 * @return
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Post post) {
		repository.save(post);
		return "redirect:/postlist";
	}


	/**
	 * delete by specific post Id
	 * only for Admin
	 * @param postId
	 * @param model
	 * @return 
	 */
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("id") Long postId, Model model) {
		repository.deleteById(postId);
		return "redirect:/postlist";
	}
	

	/**
	 * Items page 
	 * 
	 * @param model
	 * @return the page returns the list of items to apply
	 */

	@RequestMapping("/items")
	public String itemsList(Model model) {
		model.addAttribute("items", jrepository.findAll());
		return "items";

	}
	
	/**
	 * delete by specific item Id
	 * only for Admin role
	 * @param itemId
	 * @param model
	 * @return 
	 */

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deleteItem/{itemid}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable("itemid") Long itemid, Model model) {
		jrepository.deleteById(itemid);
		return "redirect:/items";
	}
	

	/**
	 * Return page when add a addItem to the list 
	 * @param  model
	 * @return a form add
	 */
	
	
	@RequestMapping(value = "/addItem")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		return "addItem";
	}
	
	
	/**
	 * Return page when submit item
	 * @param item
	 * @return
	 */
	
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public String save(Item item) {
		jrepository.save(item);
		return "redirect:/items";
	}
	
	
	// RESTful services

	/**
	 * This end point: /post
	 * 
	 * @return a Rest API JSON file with all the posts in database
	 */

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> postListRest() {
		return (List<Post>) repository.findAll();
	}

	/**
	 * This end point: /post
	 * 
	 * @return a Rest API JSON file with a specific id
	 */

	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Post> findStudentRest(@PathVariable("id") Long postId) {
		return repository.findById(postId);
	}

	/**
	 * This end point: /types
	 * 
	 * @return a Rest API JSON file with all types
	 */

	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public @ResponseBody List<Type> typeListRest() {
		return (List<Type>) drepository.findAll();
	}

	/**
	 * This end point: /availabilities
	 * 
	 * @return a Rest API JSON file with all availabilities
	 */

	@RequestMapping(value = "/availabilities", method = RequestMethod.GET)
	public @ResponseBody List<Status> statusListRest() {
		return (List<Status>) arepository.findAll();
	}


	/**
	 * This end point: /item
	 * 
	 * @return a Rest API JSON file with all the posts in database
	 */

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public @ResponseBody List<Item> itemListRest() {
		return (List<Item>) jrepository.findAll();
	}

	/**
	 * This end point: /item
	 * 
	 * @return a Rest API JSON file with a specific id
	 */

	@RequestMapping(value = "/item/{itemid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Item> findJonsRest(@PathVariable("itemid") Long itemid) {
		return jrepository.findById(itemid);
	}
	

}
