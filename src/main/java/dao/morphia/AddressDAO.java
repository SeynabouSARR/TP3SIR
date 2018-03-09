package dao.morphia;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import domain.Address;
import domain.Person;

public class AddressDAO implements DAO<Address> {

	private Morphia morphia;
    private Datastore datastore;
    Query<Address> query;

	public AddressDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Address> getList() {

		query = datastore.createQuery(Address.class);
	    List<Address> addresses = query.asList();

		return addresses;
	}



	public Key<Address> save(Address address) {
		return datastore.save(address);
	}






	public Address find(String name) {
		Query<Address> queryAddress = query.field("name").equal(name);
		return queryAddress.get();
	}






	public WriteResult delete(Address address) {
		return datastore.delete(address);

	}






	public Address get(ObjectId id) {
		return datastore.get(Address.class, id);
	}




}
