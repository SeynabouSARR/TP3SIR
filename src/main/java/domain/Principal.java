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
	    p.setName("Tintin");

	    Address address = new Address();
	    address.setStreet("11 Rue du bois perrin");
	    address.setCity("Rennes");
	    address.setPostCode("35700");
	    address.setCountry("France");
	    //set address
	    //p.addAddress(address);
	    // Save the POJO
	    //System.out.println("aaaaaaaaaaa "+ObjectId.get());
	    Key<Person> cle = ds.save(p);

	    System.out.println("bbbbbbbbb "+cle);
	    System.out.println(p);
			    /*for (Person e : ds.find(Person.class))
	    {
	    	System.out.println("println(e)");
	    }*/

	   Query<Person> query = ds.createQuery(Person.class);
	   List<Person> personnes = query.asList();

	      
	   System.out.println(personnes.size());
	   System.out.println(ds.getDB().getCollectionNames());






		 /*String dbName = new String("bank");
		     MongoClient mongo = new MongoClient();
		     Morphia morphia = new Morphia();
		     Datastore datastore = morphia.createDatastore(mongo, dbName);

		     morphia.mapPackage("domain");

		     Humain homme = new Humain();
		     homme.setName("Mecodeboue");


		     Key<Humain> savedHumain = datastore.save(homme);
		     System.out.println(savedHumain);

		     Query<Humain> query = datastore.createQuery(Humain.class);
		     List<Humain> humains = query.asList();

		     System.out.println(humains.size());*/
	}

}
