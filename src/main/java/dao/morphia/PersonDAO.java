package dao.morphia;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import domain.Person;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.DAO;
import org.mongodb.morphia.query.Query;



public class PersonDao implements Dao<Person> {
  private Morphia morphia;
  Datastore datastore;
  Query<Person> query;
  
  /**
   * constructor.
   * @param databaseName : nom de la base de données.
   */
  public PersonDao(String databaseName) {
    morphia = new Morphia();
    morphia.mapPackage("domain");
    datastore = morphia.createDatastore(new MongoClient(), databaseName);
  }
  
  /**
   * getlist.
   */
  public List<Person> getList() {
    query = datastore.createQuery(Person.class);
    List<Person> persons = query.asList();
    return persons;
  }
  
  /**
   *save.
   *@param person : la personne. 
   */
  public Key<Person> save(Person person) {
    return datastore.save(person);
  }
  
  /**
   * find.
   * @param name : nom de la personne.
   */
  public Person find(String name) {
    Query<Person> queryPerson = query.field("name").equal(name);
    return queryPerson.get();
  }
  
  /**
   * delete.
   * @param person : la personne.
   */
  public WriteResult delete(Person person) {
    return datastore.delete(person);
  }
  
  /**
   * get.
   * @param id : identifiant.
   */
  public Person get(ObjectId id) {
    return datastore.get(Person.class, id);
  }

}
