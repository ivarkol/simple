package ru.airiva.simple.domain;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
@SequenceGenerator(name = "person_gen", sequenceName = "person_seq", allocationSize = 1)
public class Person {

  @Id
  @GeneratedValue(generator = "person_gen", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "last_name", length = 100)
  private String lastName;

  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Embedded
  private Address address;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Car> cars;

}
