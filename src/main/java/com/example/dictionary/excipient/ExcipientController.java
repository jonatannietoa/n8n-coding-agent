package com.example.dictionary.excipient;

import com.example.dictionary.excipient.dto.ExcipientDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionaries/api-salt")
@RequiredArgsConstructor
public class ExcipientController {

    private final ExcipientService excipientService;

    @GetMapping("/search")
    public ResponseEntity<List<ExcipientDto>> searchExcipients(
            @RequestParam(name = "term") String term) {
        List<ExcipientDto> results = excipientService.searchExcipients(term);
        return ResponseEntity.ok(results);
    }
}
