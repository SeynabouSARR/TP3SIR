package dao.morphia;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import domain.Address;

public class AddressDAO implements DAO<Address> {

	private Morphia morphia;
    private Datastore datastore;

	public AddressDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Address> getList() {

		Query<Address> query = datastore.createQuery(Address.class);
	    List<Address> addresses = query.asList();

		return addresses;
	}



	public Key<Address> save(Address address) {
		return datastore.save(address);
	}




}
