package ru.airiva.simple.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
@SequenceGenerator(name = "authority_gen", sequenceName = "authority_seq", allocationSize = 1)
public class Authority {

  @Id
  @GeneratedValue(generator = "authority_gen", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "authority_name", nullable = false, length = 100)
  @Enumerated(EnumType.STRING)
  private SimpleAuthority authorityName;

}
