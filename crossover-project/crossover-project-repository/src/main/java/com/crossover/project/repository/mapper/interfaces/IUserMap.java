package com.crossover.project.repository.mapper.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.crossover.project.domain.entities.User;
import com.crossover.project.repository.mapper.implementations.entities.UserEntity;

@Mapper
public interface IUserMap extends IMapper<UserEntity, User> {

	public static final IUserMap INSTANCE = Mappers.getMapper(IUserMap.class);

	UserEntity entityToDomain(User user);

	User domainToEntity(UserEntity userEntity);
}
