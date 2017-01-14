package com.crossover.project.repository.mapper.interfaces;

public interface IMapper<T, U> {

    U entityToDomain(T t);

    T domainToEntity(U u);
}
