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


	    Person seynabou = new Person();
	    seynabou.setName("Seynabou SARR");
	    Person melaine = new Person();
	    seynabou.setName("Melaine BOUE");
	    Person meco = new Person();
	    seynabou.setName("Meco DEBOUE");


	    Address address_bois_perrin11 = new Address();
	    address_bois_perrin11.setStreet("11 Rue du bois perrin");
	    address_bois_perrin11.setCity("Rennes");
	    address_bois_perrin11.setPostCode("35700");
	    address_bois_perrin11.setCountry("France");

	    Address address_bois_perrin13 = new Address();
	    address_bois_perrin11.setStreet("13A Rue du bois perrin");
	    address_bois_perrin11.setCity("Rennes");
	    address_bois_perrin11.setPostCode("35700");
	    address_bois_perrin11.setCountry("France");

	    Address address_cesson_sevigne = new Address();
	    address_bois_perrin11.setStreet("70 Rue de Rennes");
	    address_bois_perrin11.setCity("Cesson Sevigné");
	    address_bois_perrin11.setPostCode("35510");
	    address_bois_perrin11.setCountry("France");

	    //Key<Address> cle1 = ds.save(address_bois_perrin11);
	    ds.save(address_bois_perrin11);
	    ds.save(address_bois_perrin13);
	    ds.save(address_cesson_sevigne);
	    System.out.println("Enregistrement des adresses terminées");

	    melaine.getAddress().add(address_bois_perrin11);
	    seynabou.getAddress().add(address_bois_perrin13);
	    meco.getAddress().add(address_cesson_sevigne);

	    ds.save(melaine);
	    ds.save(seynabou);
	    ds.save(meco);
	    System.out.println("Enregistrement des personnes terminées");

	    Article myHpComputer = new Article();
	    myHpComputer.setStars(5);
	    myHpComputer.setName("HP LAPTOP OIE");
	    myHpComputer.getBuyers().add(seynabou);
	    ds.save(myHpComputer);

	    Article telephone_iphone = new Article();
	    telephone_iphone.setStars(5);
	    telephone_iphone.setName("iPhone 7S");
	    telephone_iphone.getBuyers().add(seynabou);
	    ds.save(telephone_iphone);
	    
	    System.out.println("Enregistrement des articles");
	    




	    System.out.println("Yess "+address_bois_perrin11.getId());


	    //set address
	    /*Key<Person> cle2 = ds.save(seynabou);

	    System.out.println("cle1 "+cle1);
	    System.out.println("cle2 "+cle2);*/
	    // Save the POJO
	    //System.out.println("aaaaaaaaaaa "+ObjectId.get());

	    //System.out.println(seynabou);
			    /*for (Person e : ds.find(Person.class))
	    {
	    	System.out.println("println(e)");
	    }*/

	   //Query<Person> query = ds.createQuery(Person.class);
	   //List<Person> personnes = query.asList();






	}

}
