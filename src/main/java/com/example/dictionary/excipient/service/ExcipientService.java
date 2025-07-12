package com.example.dictionary.excipient.service;

import com.example.dictionary.excipient.mapper.ExcipientMapper;
import com.example.dictionary.excipient.model.ExcipientDto;
import com.example.dictionary.excipient.repository.ExcipientRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExcipientService {

    private final ExcipientRepository excipientRepository;
    private final ExcipientMapper excipientMapper;

    @Transactional(readOnly = true)
    public List<ExcipientDto> searchExcipients(String term) {
        if (term == null || term.isBlank()) {
            return List.of();
        }
        return excipientRepository.search(term).stream().map(excipientMapper::toDto).toList();
    }
}
