package com.remit.email.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.remit.email.entity.User;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	com.remit.email.model.User toDTO(User user);

	User toEntity(com.remit.email.model.User userDTO);

}
