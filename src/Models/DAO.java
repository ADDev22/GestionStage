package Models;

import java.sql.Connection;

public interface DAO<T> {
public Connection connect = SingletonConnection.getConnection();
public  T find(long id);
public  T create(T obj);
public  T update(T obj);
public abstract void delete(T obj); 
}