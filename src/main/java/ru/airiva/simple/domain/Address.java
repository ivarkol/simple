package ru.airiva.simple.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

  @Column(name = "city", nullable = false, length = 50)
  private String city;

  @Column(name = "street", nullable = false, length = 50)
  private String street;

  @Column(name = "home", nullable = false, length = 10)
  private String home;

  @Column(name = "apartment", length = 10)
  private String apartment;

}
