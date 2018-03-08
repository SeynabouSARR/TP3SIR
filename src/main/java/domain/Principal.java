package domain;

import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.connection.QueryResult;

import dao.morphia.AddressDAO;
import dao.morphia.ArticleDAO;
import dao.morphia.PersonDAO;

public class Principal {

	final static String DATABASE_NAME = "_tp3_";

	public static void main(String[] args) {

		PersonDAO managerPerson = new PersonDAO(DATABASE_NAME);
		ArticleDAO managerArticle = new ArticleDAO(DATABASE_NAME);
		AddressDAO managerAddress = new AddressDAO(DATABASE_NAME);

	    Person seynabou = new Person();
	    seynabou.setName("Seynabou SARR");
	    Person melaine = new Person();
	    melaine.setName("Melaine BOUE");
	    Person meco = new Person();
	    meco.setName("Meco DEBOUE");

	    Address address_bois_perrin11 = new Address();
	    address_bois_perrin11.setStreet("11 Rue du bois perrin");
	    address_bois_perrin11.setCity("Rennes");
	    address_bois_perrin11.setPostCode("35700");
	    address_bois_perrin11.setCountry("France");

	    Address address_bois_perrin13 = new Address();
	    address_bois_perrin13.setStreet("13A Rue du bois perrin");
	    address_bois_perrin13.setCity("Rennes");
	    address_bois_perrin13.setPostCode("35700");
	    address_bois_perrin13.setCountry("France");

	    Address address_cesson_sevigne = new Address();
	    address_cesson_sevigne.setStreet("70 Rue de Rennes");
	    address_cesson_sevigne.setCity("Cesson Sevigné");
	    address_cesson_sevigne.setPostCode("35510");
	    address_cesson_sevigne.setCountry("France");

	    //Key<Address> cle1 = ds.save(address_bois_perrin11);
	    managerAddress.save(address_bois_perrin11);
	    managerAddress.save(address_bois_perrin13);
	    managerAddress.save(address_cesson_sevigne);
	    System.out.println("Enregistrement des adresses terminées");

	    melaine.addAddress(address_bois_perrin11);
	    seynabou.addAddress(address_bois_perrin13);
	    meco.addAddress(address_cesson_sevigne);

	    managerPerson.save(melaine);
	    managerPerson.save(seynabou);
	    managerPerson.save(meco);
	    System.out.println("Enregistrement des personnes terminées");

	    Article myHpComputer = new Article();
	    myHpComputer.setStars(5);
	    myHpComputer.setName("HP LAPTOP OIE");
	    myHpComputer.addBuyer(seynabou);
	    managerArticle.save(myHpComputer);

	    Article telephone_iphone = new Article();
	    telephone_iphone.setStars(5);
	    telephone_iphone.setName("iPhone 7S");
	    telephone_iphone.addBuyer(seynabou);
	    telephone_iphone.addBuyer(melaine);
	    telephone_iphone.addBuyer(meco);
	    managerArticle.save(telephone_iphone);

	    System.out.println("Enregistrement des articles");



		//Article article_a_effacer = managerArticle.find("iPhone 7S");
		//managerArticle.delete(article_a_effacer);
	    List<Article> articles = managerArticle.getList();

	    System.out.println("--------------------------------------------------------");
	    int compteur = 1;
	    for (Article article : articles) {
			System.out.println(compteur+" "+article);
			compteur++;
		}
	    System.out.println("--------------------------------------------------------");



	}

}
