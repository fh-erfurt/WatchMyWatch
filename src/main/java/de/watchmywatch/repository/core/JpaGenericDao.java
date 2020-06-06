package de.watchmywatch.repository.core;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JpaGenericDao<T, ID extends Serializable> implements IGenericDao<T>
{

    private final Class<T> persistentClass;
    private EntityManager entityManager;

    public Class<T> getPersistentClass() {
        return persistentClass;
    }


    public JpaGenericDao(Class<T> type, EntityManager em )
    {
        this.persistentClass = type;
        this.entityManager = em;
    }

    public T findById( Long id )
    {
        final T result = getEntityManager().find( persistentClass, id );
        return result;
    }


    public Collection<T> findAll()
    {
        Query query = getEntityManager().createQuery( "SELECT e FROM " + getEntityClass().getCanonicalName() + " e" );
        return (Collection<T>) query.getResultList();
    }


    public void create(T entity )
    {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist( entity );
        getEntityManager().getTransaction().commit();
        //return entity;
    }


    public T update( T entity )
    {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge( entity );
        getEntityManager().getTransaction().commit();
        return savedEntity;
    }

    public void delete( Long id )
    {
        T entity = this.findById( id );
        this.delete( entity );
    }

    public void delete( T entity )
    {
        getEntityManager().getTransaction().begin();
        if(!getEntityManager().contains(entity))
            entity = getEntityManager().merge(entity);
        getEntityManager().remove( entity );
        getEntityManager().getTransaction().commit();
    }

    public void delete( List<T> entries )
    {
        for( T entity : entries )
        {
            delete(entity);
        }

    }


    public Class<T> getEntityClass()
    {
        return persistentClass;
    }

    public void setEntityManager( final EntityManager entityManager )
    {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

}


