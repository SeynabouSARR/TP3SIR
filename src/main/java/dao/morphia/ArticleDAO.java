package dao.morphia;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import domain.Article;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public class ArticleDao implements Dao<Article> {
  private Morphia morphia;
  private Datastore datastore;
  Query<Article> query;
  
  /**
   * constructor.
   * @param databaseName : nom de la base de données.
   */
  public ArticleDao(String databaseName) {
    morphia = new Morphia();
    morphia.mapPackage("domain");
    datastore = morphia.createDatastore(new MongoClient(), databaseName);
  }
  
  /**
   * Getteurs.
   */
  public List<Article> getList() {
    query = datastore.createQuery(Article.class);
    List<Article> objects = query.asList();
    return objects;
  }
  
  /**
   * save.
   * @param article : enregistrement de l'article.
   */
  public Key<Article> save(Article article) {
    return datastore.save(article);
  }
  
  /**
   * find.
   *@param name : nom de l'article.
   */
  public Article find(String name) {
    query = datastore.createQuery(Article.class);
    Query<Article> queryArticle = query.field("name").equal(name);
    return queryArticle.get();
  }
  
  /**
   * delete.
   * @param article : un article
   */
  public WriteResult delete(Article article) {
    return datastore.delete(article);
  }
  
  /**
   * get.
   * @param id : identifiant
   */
  public Article get(ObjectId id) {
    return datastore.get(Article.class, id);
  }




}
