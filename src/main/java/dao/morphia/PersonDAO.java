package dao.morphia;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import domain.Person;

public class PersonDAO implements DAO<Person> {

	private Morphia morphia;
     Datastore datastore;

	public PersonDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Person> getList() {

		Query<Person> query = datastore.createQuery(Person.class);
	    List<Person> persons = query.asList();

		return persons;
	}



	public Key<Person> save(Person person) {
		return datastore.save(person);
	}




}
