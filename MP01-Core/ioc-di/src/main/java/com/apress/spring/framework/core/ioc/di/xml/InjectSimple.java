package com.apress.spring.framework.core.ioc.di.xml;

import lombok.Data;

@Data
public class InjectSimple {

  private int age;
  private float height;
  private long ageInSeconds;
  private boolean programmer;

  private String name;


  @Override
  public String toString() {
    return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Programmer?: " + programmer;
  }
}
