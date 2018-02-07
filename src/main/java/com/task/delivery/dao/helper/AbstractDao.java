package com.task.delivery.dao.helper;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<E> {

    void save(E e);

    void update(E e);

    void delete(E e);

    E getById(Serializable id);

    List<E> list();
}

