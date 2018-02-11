package by.itacademy.dao;

import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<T extends BaseEntity> {

    static final SessionFactory SESSION_FACTORY
            = new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    public BaseDao() {
        ParameterizedType parameterizedSuperclass
                = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSuperclass.getActualTypeArguments()[0];
    }

    public int save(T objectToSave) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.save(objectToSave);

        session.getTransaction().commit();
        session.close();

        return objectToSave.getId();
    }

    public T findById(int id) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        T result = session.get(entityClass, id);

        session.getTransaction().commit();
        session.close();

        return result;
    }

    public int update(T objectToUpdate) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.update(objectToUpdate);

        session.getTransaction().commit();
        session.close();

        return objectToUpdate.getId();
    }

    public void delete(T objectToDelete) {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        session.delete(objectToDelete);

        session.getTransaction().commit();
        session.close();


    }

    public List<T> findAll() {

        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        List<T> result = session
                .createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return result;

    }


}
