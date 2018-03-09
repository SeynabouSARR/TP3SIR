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

import domain.Person;

public class PersonDAO implements DAO<Person> {

	private Morphia morphia;
     Datastore datastore;
     Query<Person> query;

	public PersonDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Person> getList() {

		query = datastore.createQuery(Person.class);
	    List<Person> persons = query.asList();



		return persons;
	}



	public Key<Person> save(Person person) {
		return datastore.save(person);
	}






	public Person find(String name) {
		Query<Person> queryPerson = query.field("name").equal(name);
		return queryPerson.get();
	}






	public WriteResult delete(Person person) {
		return datastore.delete(person);

	}






	public Person get(ObjectId id) {
		return datastore.get(Person.class, id);
	}




}
