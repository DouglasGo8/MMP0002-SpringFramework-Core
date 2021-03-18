package com.apress.spring.framework.core.ioc.di.xml;

import lombok.Data;
import lombok.Getter;

@Data
public class ConstructorConfusion {


  private int someNumber;


  private String someText;


  public ConstructorConfusion(int someNumber) {
    this.someNumber = someNumber;
  }

  public ConstructorConfusion(String someText) {
    this.someText = someText;
  }

}
