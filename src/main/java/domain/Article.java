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
  
  /**
   * constructor.
   */
  public Article() {

  }
  
  /**
   * constructor avec paramètres.
   * @param id : id.
   * @param name : nom.
   * @param stars : etoiles.
   */
  public Article(ObjectId id, String name, int stars) {
    this.id = id;
    this.name = name;
    this.stars = stars;
  }
  
  /**
   * getters.
   * @return id : identifiant.
   */
  public ObjectId getId() {
    return id;
  }
  
  /**
   * setter.
   * @param id : id.
   */
  public void setId(ObjectId id) {
    this.id = id;
  }
  
  /**
   * getters.
   * @return name : nom.
   */
  public String getName() {
    return name;
  }
  
  /**
   * setter.
   * @param name : nom.
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * getters.
   * @return stars : etoiles.
   */
  public int getStars() {
    return stars;
  }
  
  /**
   * setter.
   * @param stars : etoiles.
   */
  public void setStars(int stars) {
    this.stars = stars;
  }
  
  /**
   * getters.
   * @return buyers : acheteurs.
   */
  public List<Person> getBuyers() {
    return buyers;
  }
  
  /**
   * setter.
   * @param buyers : acheteurs.
   */
  public void setBuyers(List<Person> buyers) {
    this.buyers = buyers;
  }
  
  /**
   * addBuyer.
   * @param person : personne.
   */
  public void addBuyer(Person person) {
    this.buyers.add(person);
  }

  @Override
  public String toString() {
    String articleDetails = "-------------------------------";
    articleDetails += "--------------------------------------------------\n";
    articleDetails += "Article [id=" + id + ", name=" + name;
    articleDetails += ", stars=" + stars + "\n Acheteurs --\n";
    for (Person person : this.buyers) {
      articleDetails += person.toString() + "\n";
    }
    return articleDetails;
  }


}
