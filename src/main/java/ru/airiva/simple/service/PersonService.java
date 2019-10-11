package ru.airiva.simple.service;

import java.util.Set;
import ru.airiva.simple.domain.Person;

public interface PersonService {

  Set<Person> getPersons();

  void addPerson();

  void addCar(Person person);

  void addCars(Person person, int carCount);

}
