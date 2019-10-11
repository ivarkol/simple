package ru.airiva.simple.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.airiva.simple.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}
