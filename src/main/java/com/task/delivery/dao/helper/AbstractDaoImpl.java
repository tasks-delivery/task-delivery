package com.task.delivery.dao.helper;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDaoImpl<E> implements AbstractDao<E> {

    private final Logger logger = LoggerFactory.getLogger(AbstractDaoImpl.class);

    private Class<E> persistentClass;

    @Autowired
    EntityManager entityManager;

    public AbstractDaoImpl() {
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(E e) {
        Session session = entityManager.unwrap(Session.class);
        session.save(e);
    }

    @Override
    public void update(E e) {
        Session session = entityManager.unwrap(Session.class);
        session.update(e);
    }

    @Override
    public void delete(E e) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(e);
    }

    @Override
    public List<E> list() {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(persistentClass);
        List<E> list = criteria.list();
        return list;
    }

    @Override
    public E getById(Serializable id) {
        Session session = entityManager.unwrap(Session.class);
        E e = session.get(persistentClass, id);
        return e;
    }
}