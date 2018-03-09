package dao.morphia;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import domain.Address;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;



public class AddressDao implements Dao<Address> {
  private Morphia morphia;
  private Datastore datastore;
  Query<Address> query;
  
  /**
   * constructor.
   * @param databaseName : name database.
   */
  public AddressDao(String databaseName) {
    morphia = new Morphia();
    morphia.mapPackage("domain");
    datastore = morphia.createDatastore(new MongoClient(), databaseName);
  }
  
  /**
   * Getters.
   */
  public List<Address> getList() {

    query = datastore.createQuery(Address.class);
    List<Address> addresses = query.asList();
    return addresses;
  }
  
  /**
   * save.
   * @param address : enregistrement de l'address.
   */
  public Key<Address> save(Address address) {
    return datastore.save(address);
  }
  
  /**
   * find.
   * @param name : nom de l'address.
   */
  public Address find(String name) {
    Query<Address> queryAddress = query.field("name").equal(name);
    return queryAddress.get();
  }

  public WriteResult delete(Address address) {
    return datastore.delete(address);
  }
  
  /**
   * get.
   * @param id : identifiant.
   */
  public Address get(ObjectId id) {
    return datastore.get(Address.class, id);
  }




}
