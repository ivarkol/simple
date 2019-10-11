package ru.airiva.simple.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.airiva.simple.domain.Car;
import ru.airiva.simple.domain.Person;
import ru.airiva.simple.repository.CarRepository;
import ru.airiva.simple.repository.PersonRepository;
import ru.airiva.simple.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;
  private final CarRepository carRepository;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
    this.personRepository = personRepository;
    this.carRepository = carRepository;
  }

  @Override
  public Set<Person> getPersons() {
    Iterable<Person> all = personRepository.findAll();
    Set<Person> persons = new HashSet<>();
    all.forEach(persons::add);
    return persons;
  }

  @Override
  public void addPerson() {

    personRepository.save(Person.randomPerson());

  }

  @Override
  public void addCar(Person person) {

    carRepository.save(Car.randomCar(person));

  }

  @Override
  public void addCars(Person person, int carCount) {
    for (int i = 0; i < carCount; i++) {
      this.addCar(person);
    }
  }
}
