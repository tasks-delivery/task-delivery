package com.task.delivery.service.helper;

import com.task.delivery.dao.helper.AbstractDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractServiceImpl<E> implements AbstractService<E> {

    private final Logger logger = LoggerFactory.getLogger(AbstractServiceImpl.class);

    @Autowired
    AbstractDao<E> dao;

    @Override
    @Transactional
    public void save(E e) {
        dao.save(e);
    }

    @Override
    @Transactional
    public void update(E e) {
        dao.update(e);
    }

    @Override
    @Transactional
    public void delete(E e) {
        dao.delete(e);
    }

    @Override
    @Transactional
    public List<E> list() {
        return dao.list();
    }

    @Override
    @Transactional
    public E getById(Serializable id) {
        return dao.getById(id);
    }
}
