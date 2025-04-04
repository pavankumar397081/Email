package com.remit.email.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.remit.email.entity.Sent;

/**
 * SentMapper
 */
@Mapper
public interface SentMapper {

	SentMapper INSTANCE = Mappers.getMapper(SentMapper.class);

	com.remit.email.model.Sent toDTO(Sent sent);

	Sent toEntity(com.remit.email.model.Sent sentDTO);
}
