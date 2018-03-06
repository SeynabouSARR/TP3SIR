package domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("adress")
public class Address {
	@Id
	private ObjectId id;
	String street;
	String city;
	String postCode;
	String country;

	public Address() {

	}

	public Address(ObjectId id, String street, String city, String postCode, String country) {
		this.id = id ;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [_id=" + id + ", street=" + street + ", city=" + city + ", postCode=" + postCode + ", country="
				+ country + "]";
	}

}
