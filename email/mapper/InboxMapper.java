package com.remit.email.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.remit.email.entity.Inbox;

/**
 * InboxMapper
 */
@Mapper
public interface InboxMapper {

	InboxMapper INSTANCE = Mappers.getMapper(InboxMapper.class);

	com.remit.email.model.Inbox toDTO(Inbox inbox);

	Inbox toEntity(com.remit.email.model.Inbox inboxDTO);
}
