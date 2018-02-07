package com.task.delivery.service.helper;

import java.io.Serializable;
import java.util.List;

public interface AbstractService<E> {

    void save(E e);

    void update(E e);

    void delete(E e);

    E getById(Serializable id);

    List<E> list();
}