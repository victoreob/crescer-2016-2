package DAO;

import javax.persistence.EntityManager;

/**
 * @author Victor
 * @param <T>
 * @param <ID>
 *
 */
public abstract class AbstractDao<T, ID> implements IDao<T, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        try {

            this.getEntityManager().persist(t);

        } catch (Exception e) {

        }
    }

}
