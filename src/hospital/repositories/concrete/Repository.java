package hospital.repositories.concrete;

import hospital.repositories.DbSessionFactory;
import hospital.repositories.interfaces.IRepository;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.*;

public class Repository<T> implements IRepository<T> {
    private final Class<T> type;

    public Repository(Class<T> type) {
        this.type = type;
    }

    @Override
    public void add(T entity) {
        Session session = DbSessionFactory.get();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();

        } catch (Exception e){
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T entity) {
        Session session = DbSessionFactory.get();
        try{
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(T entity) {
        Session session = DbSessionFactory.get();
        try{
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
    }

    @Override
    public T getById(int id) {
        Session session = DbSessionFactory.get();
        try{
            session.beginTransaction();
            T entity = session.load(type, id);
            Hibernate.initialize(entity);
            return entity;

        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        Session session = DbSessionFactory.get();
        try {
            session.beginTransaction();
            return session.createCriteria(type).list();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return new ArrayList<T>();
    }
}
