package fi.haagahelia.foodSharingDatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long availabilityid;
	private String availability;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
	private List<Post> posts;

	public Status() {
	}

	public Status(String availability) {
		super();
		this.availability = availability;
	}

	public Long getAvailabilityid() {
		return availabilityid;
	}

	public void setAvailabilityid(Long availabilityid) {
		this.availabilityid = availabilityid;
	}
	@Column(name="availability")
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}