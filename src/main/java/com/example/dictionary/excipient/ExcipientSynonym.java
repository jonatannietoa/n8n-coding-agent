package com.example.dictionary.excipient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "excipientsynonym")
public class ExcipientSynonym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String synonym;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "excipientid", nullable = false)
    private Excipient excipient;
}
