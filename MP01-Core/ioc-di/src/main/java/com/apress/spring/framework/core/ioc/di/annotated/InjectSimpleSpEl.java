package com.apress.spring.framework.core.ioc.di.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("injectSimpleSpEl")
public class InjectSimpleSpEl {

  @Value("#{injectSimpleConfig.name}")
  private String name;

  @Value("#{injectSimpleConfig.age + 1}")
  private int age;
  @Value("#{injectSimpleConfig.height}")
  private float height;
  @Value("#{injectSimpleConfig.programmer}")
  private boolean programmer;
  @Value("#{injectSimpleConfig.ageInSeconds}")


  private Long ageInSeconds;


  public String toString() {
    return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Programmer?: " + programmer;
  }
}
