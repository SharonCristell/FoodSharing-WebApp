package fi.haagahelia.foodSharingDatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public String title, description, location, postedDate, lastDate, duration;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeid")
	private Type type;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "availabilityid")
	private Status status;

	public Post() {

	}

	public Post(String title, String description, String location, String postedDate, String lastDate, String duration,
			Type type, Status status) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.postedDate = postedDate;
		this.lastDate = lastDate;
		this.duration = duration;
		this.type = type;
		this.status= status;

	}

	public long getId() {
		return id;
	}

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="postedDate")
	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	@Column(name="lastdate")
	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	@Column(name="duration")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Column(name="type")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	@Column(name="status")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
