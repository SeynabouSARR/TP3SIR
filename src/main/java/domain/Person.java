package domain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Person {
	@Id
	@GeneretedValue
	private ObjectId id;
	private String name;
	@Reference
	private List<Address> address = new ArrayList<Address>();
	
	public Person() {
		
	}
	public Person(ObjectId id, String name) {
		this.id = id;
		this.name = name;
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
	public List<Address> getAddress() {
		return address;
	}
	public void addAddress(Address address) {
		this.address.add(address);
	}
	

}
