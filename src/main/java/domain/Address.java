package domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;


@Entity("adress")
public class Address {
  @Id
  @Property("id")
  private ObjectId id;
  String street;
  String city;
  String postCode;
  String country;
  
  /**
   * constructor.
   */
  public Address() {}
  
  /**
   * getteurs.
   * @return id : identifiant.
   */
  public ObjectId getId() {
    return id;
  }
  
  /**
   * setteurs.
   * @param id : identifiant.
   */
  public void setId(ObjectId id) {
    this.id = id;
  } 
  
  /**
   * constructor avec parametres.
   * @param id : id.
   * @param street : rue.
   * @param city : ville.
   * @param postCode : code postale
   * @param country : pays.
   */
  public Address(ObjectId id, String street, String city, String postCode, String country) {
    this.id = id;
    this.street = street;
    this.city = city;
    this.postCode = postCode;
    this.country = country;
  }
  
  /**
   * Getters.
   * @return street : rue.
   */
  public String getStreet() {
    return street;
  }
  
  /**
   * Setter.
   * @param street : rue.
   */
  public void setStreet(String street) {
    this.street = street;
  }
  
  /**
   * getters.
   * @return city : ville.
   */
  public String getCity() {
    return city;
  }
  
  /**
   * Setter.
   * @param city : ville.
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /**
   * getters.
   * @return postCode : code postal.
   */
  public String getPostCode() {
    return postCode;
  }
  
  /**
   * setter.
   * @param postCode : code postal.
   */
  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
  
  /**
   * getters.
   * @return country : pays.
   */
  public String getCountry() {
    return country;
  }
  
  /**
   * setter.
   *  @param country : pays
   */
  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    String address = "Address : [id:" + id + "] ";
    address += " => " + street + ", " + postCode + ", " + city + ", " + country;
    return address;
  }

}
