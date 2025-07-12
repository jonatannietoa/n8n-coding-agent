package com.example.dictionary.excipient.mapper;

import com.example.dictionary.excipient.Excipient;
import com.example.dictionary.excipient.dto.ExcipientDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExcipientMapper {
    ExcipientDto toDto(Excipient excipient);

    List<ExcipientDto> toDtoList(List<Excipient> excipients);
}
