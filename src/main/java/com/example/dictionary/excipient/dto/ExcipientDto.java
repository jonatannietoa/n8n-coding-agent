package com.example.dictionary.excipient.dto;

import lombok.Data;

@Data
public class ExcipientDto {
    private Long excipientId;
    private String name;
    private String prettyName;
    private String canonicalName;
}
