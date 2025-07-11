// filename: src/main/java/com/example/dictionary/excipient/model/Excipient.java
package com.example.dictionary.excipient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "excipient")
@Getter
@Setter
@ToString(exclude = "synonyms")
public class Excipient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "excipientid")
  private UUID excipientId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "prettyname")
  private String prettyName;

  @Column(name = "canonicalname")
  private String canonicalName;

  @Column(name = "deprecated", nullable = false)
  private boolean deprecated;

  @OneToMany(mappedBy = "excipient", fetch = FetchType.LAZY)
  private Set<ExcipientSynonym> synonyms;
}
