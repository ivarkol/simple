package ru.airiva.simple.domain;

import java.time.LocalDate;
import java.util.HashSet;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextLong;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
  private Set<Car> cars = new HashSet<>();

  public static Person randomPerson() {
    return Person.builder()
      .name(randomAlphabetic(9))
      .lastName(randomAlphabetic(10))
      .birthDate(LocalDate.ofEpochDay(nextLong(LocalDate.now().minusYears(30L).toEpochDay(), LocalDate.now().toEpochDay())))
      .address(Address.builder()
        .city(randomAlphabetic(30))
        .street(randomAlphabetic(30))
        .home(randomAlphabetic(5))
        .apartment(randomAlphabetic(5))
        .build())
      .build();
  }

}
