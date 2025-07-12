package com.example.dictionary.excipient.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ExcipientDto {
    Long excipientId;
    String name;
    String prettyName;
    String canonicalName;
}
