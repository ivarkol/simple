package ru.airiva.simple.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.airiva.simple.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
