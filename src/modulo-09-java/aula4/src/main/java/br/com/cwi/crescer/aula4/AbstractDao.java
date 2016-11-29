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
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().merge(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public void delete(T t) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().remove(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }

}
