package dao.morphia;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;

import com.mongodb.WriteResult;

public interface DAO<T> {



	public T get(ObjectId id);
	public List<T> getList();
	public Key<T> save(T element);
	public T find(String name);
	public WriteResult delete(T element);


}
