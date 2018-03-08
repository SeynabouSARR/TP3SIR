package dao.morphia;

import java.util.List;

import org.mongodb.morphia.Key;

public interface DAO<T> {


	public List<T> getList();
	public Key<T> save(T element);


}
