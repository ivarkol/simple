package ru.airiva.simple.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.airiva.simple.repository.CarRepository;
import ru.airiva.simple.repository.PersonRepository;
import ru.airiva.simple.utils.CommonUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CommonUtils.class)
public class PersonServiceImplTest {

  @Mock
  private PersonRepository personRepository;

  @Mock
  private CarRepository carRepository;

  @InjectMocks
  private PersonServiceImpl personService;

  @Before
  public void setUp() {
  }

  @Test
  public void testTest() {
    PowerMockito.mockStatic(CommonUtils.class);

    personService.test("test");

    Mockito.verify(personRepository).findAll();
    PowerMockito.verifyStatic(CommonUtils.class);
    CommonUtils.someStaticMethod("test");
  }
}