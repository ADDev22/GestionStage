package Models.DAO;

import java.sql.Connection;

import Models.SingletonConnection;

public interface DAO<T> {
public Connection connect = SingletonConnection.getConnection();
public T find(int id);
public T create(T obj);
public T update(T obj);
public boolean  delete(T obj);
public T findTypeUser(int utilisateurId);
}