package com.apress.spring.framework.core.ioc.di.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimpleHardCoded")
public class InjectSimpleHardCoded {

  @Value("John Mayer")
  private String name;
  @Value("39")
  private int age;
  @Value("1.92")
  private float height;
  @Value("false")
  private boolean programmer;
  @Value("1241401112")
  private Long ageInSeconds;

  public String toString() {
    return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Programmer?: " + programmer;
  }
}
