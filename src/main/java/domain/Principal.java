package domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class Principal {

	public static void main(String[] args) {

		Morphia morphia = new Morphia();
	    MongoClient mongo = new MongoClient();
	    //morphia.map(Person.class).map(Address.class);
	    morphia.mapPackage("domain");

	    Datastore ds = morphia.createDatastore(mongo, "tp3");


	    Person p = new Person();
	    p.setName("Seynabou SARR");

	    Address address = new Address();
	    address.setStreet("13 Rue du bois perrin");
	    address.setCity("Rennes");
	    address.setPostCode("35700");
	    address.setCountry("France");
	    Key<Address> cle1 = ds.save(address);


	    //set address
	    p.getAddress().add(address);
	    Key<Person> cle2 = ds.save(p);

	    System.out.println("cle1 "+cle1);
	    System.out.println("cle2 "+cle2);
	    // Save the POJO
	    //System.out.println("aaaaaaaaaaa "+ObjectId.get());

	    System.out.println(p);
			    /*for (Person e : ds.find(Person.class))
	    {
	    	System.out.println("println(e)");
	    }*/

	   //Query<Person> query = ds.createQuery(Person.class);
	   //List<Person> personnes = query.asList();






	}

}
