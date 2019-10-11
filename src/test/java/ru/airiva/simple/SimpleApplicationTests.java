package ru.airiva.simple;

import java.util.Set;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.airiva.simple.domain.Person;
import ru.airiva.simple.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleApplicationTests {

	@Autowired
	private PersonService personService;

	@Ignore
	@Test
	public void contextLoads() {
	}

	@Ignore
	@Test
	public void addPersons() {
		for (int i = 0; i < 100; i++) {
			personService.addPerson();
		}
	}

	@Ignore
	@Test
	public void addCars() {
		Set<Person> persons = personService.getPersons();
		persons.forEach(person -> personService.addCars(person, RandomUtils.nextInt(0, 5)));
	}

}
