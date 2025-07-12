package com.example.dictionary.excipient.mapper;

import com.example.dictionary.excipient.model.Excipient;
import com.example.dictionary.excipient.model.ExcipientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExcipientMapper {
    ExcipientDto toDto(Excipient excipient);
}
