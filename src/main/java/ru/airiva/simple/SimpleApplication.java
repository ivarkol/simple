package ru.airiva.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import ru.airiva.simple.config.SwaggerConfig;
import ru.airiva.simple.controller.TestController;
import ru.airiva.simple.domain.Person;
import ru.airiva.simple.repository.PersonRepository;
import ru.airiva.simple.service.impl.PersonServiceImpl;

@EntityScan(basePackageClasses = {Person.class})
@Import({SwaggerConfig.class})
@SpringBootApplication(scanBasePackageClasses = {
  PersonServiceImpl.class, PersonRepository.class, TestController.class
})
public class SimpleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleApplication.class, args);
  }

}
