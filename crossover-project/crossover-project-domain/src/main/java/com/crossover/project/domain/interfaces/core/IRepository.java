package com.crossover.project.domain.interfaces.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public interface IRepository<T> extends Serializable {

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(Serializable id);

    T getById(Serializable id);

    T get(String namedQuery, Map<String, Object> map);
    
    Collection<T> getAll();

    Collection<T> getMany(String namedQuery, Map<String, Object> map);

}
