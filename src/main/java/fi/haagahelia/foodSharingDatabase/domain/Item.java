package fi.haagahelia.foodSharingDatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemid;
	
	
	private String title, description, location, pickuptimes;
	
	public Item() {
		
	}
	
	
	
	

	public Item(String title, String description, String location, String pickuptimes) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.pickuptimes = pickuptimes;
	}


	public Long getItemid() {
		return itemid;
	}



	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}


	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getPickuptimes() {
		return pickuptimes;
	}

	public void setPickuptimes(String pickuptimes) {
		this.pickuptimes = pickuptimes;
	}
	
}
