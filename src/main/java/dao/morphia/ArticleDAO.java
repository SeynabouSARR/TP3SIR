package dao.morphia;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import domain.Article;

public class ArticleDAO implements DAO<Article> {

	private Morphia morphia;
    private Datastore datastore;

	public ArticleDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Article> getList() {

		Query<Article> query = datastore.createQuery(Article.class);
	    List<Article> objects = query.asList();

		return objects;
	}



	public Key<Article> save(Article article) {
		return datastore.save(article);
	}




}
