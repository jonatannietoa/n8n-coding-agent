package com.example.dictionary.excipient;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "excipient")
public class Excipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excipientid")
    private Long excipientId;

    private String name;

    @Column(name = "prettyname")
    private String prettyName;

    @Column(name = "canonicalname")
    private String canonicalName;

    private boolean deprecated;

    @OneToMany(mappedBy = "excipient", fetch = FetchType.LAZY)
    private Set<ExcipientSynonym> synonyms;
}
