package domain;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

public class ArticleDAO implements DAO {

	private Morphia morphia;
    private Datastore datastore;

	public ArticleDAO() {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), "tp3");

	}






	public List<Article> getList() {

		Query<Article> query = datastore.createQuery(Article.class);
	    List<Article> objects = query.asList();

		return objects;
	}



	public Key save(Object element) {
		// TODO Auto-generated method stub
		return null;
	}




}
