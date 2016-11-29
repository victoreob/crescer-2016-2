package br.com.cwi.crescer.aula4;

import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
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

            this.getEntityManager().merge(t);

        } catch (Exception e) {

        }
    }

    @Override
    public void delete(T t) {
        try {

            this.getEntityManager().remove(t);

        } catch (Exception e) {

        }
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }

}
