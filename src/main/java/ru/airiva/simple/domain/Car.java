package ru.airiva.simple.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@GenericGenerator(name = "car_gen", strategy = "ru.airiva.simple.domain.generator.CarNumberGenerator")
public class Car {

  @Id
  @Include
  @Column(name = "car_number", length = 6)
  @GeneratedValue(generator = "car_gen")
  private String carNumber;

  @Column(name = "manufacturer", nullable = false, length = 50)
  private String manufacturer;

  @Column(name = "model", nullable = false, length = 50)
  private String model;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false)
  private Person owner;

  public static Car randomCar(Person person) {
    return Car.builder()
      .manufacturer(randomAlphabetic(40))
      .model(randomAlphabetic(30))
      .owner(person)
      .build();
  }

}
