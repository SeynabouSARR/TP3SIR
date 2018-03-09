package domain;

import java.util.ArrayList;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("article")
public class Article {

	 @Id
	 private ObjectId id;
	 private String name;
	 private int stars;

	 @Reference
	 private List<Person> buyers = new ArrayList<Person>();

	 public Article() {

	}

	public Article(ObjectId id, String name, int stars) {
		this.id = id;
		this.name = name;
		this.stars = stars;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public List<Person> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<Person> buyers) {
		this.buyers = buyers;
	}

	public void addBuyer(Person person) {
		this.buyers.add(person);
	}

	@Override
	public String toString() {
		String articleDetails = "---------------------------------------------------------------------------------\n";
		articleDetails += "Article [id=" + id + ", name=" + name + ", stars=" + stars +"\n Acheteurs --\n";

		for (Person person : this.buyers) {
			articleDetails+= person.toString()+"\n";
		}

		return articleDetails;
	}


}
