package hospital.repositories.concrete;

import hospital.repositories.DbSessionFactory;
import hospital.repositories.interfaces.IRepository;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class Repository<T> implements IRepository<T> {
    private final Class<T> type;
    private final Session session;

    public Repository(Class<T> type) {
        this.type = type;
        session  = DbSessionFactory.get();
    }

    @Override
    public void add(T entity) {
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void update(T entity) {
        try{
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(T entity) {
        try{
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public T getById(int id) {
        try{
            session.beginTransaction();
            T entity = session.load(type, id);
            Hibernate.initialize(entity);
            return entity;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        try {
            session.beginTransaction();
            return session.createCriteria(type).list();

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<T>();
    }

    @Override
    public T getByField(String name, Object value)
    {
        T foundValue = null;
        try{
            Criteria criteria = session.createCriteria(type);
            foundValue = (T)criteria.add(Restrictions.eq(name, value)).uniqueResult();
        } catch (Exception e){
            System.out.println(e);
        }
        return foundValue;
    }

    @Override
    public void close()
    {
        session.close();
    }
}
