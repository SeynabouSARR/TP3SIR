package domain;

import org.mongodb.morphia.annotations.Entity;

@Entity
public class Article {
	Long id;
	String name;
	int stars;
	public Article() {
	
	}
	public Article(Long id, String name, int stars) {
		this.id = id;
		this.name = name;
		this.stars = stars;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}

}
