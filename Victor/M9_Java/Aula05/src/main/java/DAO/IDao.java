package DAO;

import java.util.List;

/**
 * @author Victor
 * @param <T>
 * @param <ID>
 */
public interface IDao<T, ID> {

    void insert(T t);
    
    List<T> findAll();
}
