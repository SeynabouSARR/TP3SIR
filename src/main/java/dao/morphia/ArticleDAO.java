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

import domain.Article;
import domain.Person;

public class ArticleDAO implements DAO<Article> {

	private Morphia morphia;
    private Datastore datastore;
    Query<Article> query;

	public ArticleDAO(String database_name) {

		morphia = new Morphia();
		morphia.mapPackage("domain");
		datastore = morphia.createDatastore(new MongoClient(), database_name);

	}






	public List<Article> getList() {

		query = datastore.createQuery(Article.class);
	    List<Article> objects = query.asList();

		return objects;
	}



	public Key<Article> save(Article article) {
		return datastore.save(article);
	}






	public Article find(String name) {
		query = datastore.createQuery(Article.class);
		Query<Article> queryArticle = query.field("name").equal(name);
		return queryArticle.get();
	}

	public WriteResult delete(Article article) {
		return datastore.delete(article);
	}


	public Article get(ObjectId id) {
		return datastore.get(Article.class, id);
	}




}
