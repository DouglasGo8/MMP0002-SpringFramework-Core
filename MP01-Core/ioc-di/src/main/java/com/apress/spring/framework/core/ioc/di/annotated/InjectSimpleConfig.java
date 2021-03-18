package com.apress.spring.framework.core.ioc.di.annotated;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
  private final String name = "John Mayer";
  private final int age = 39;
  private final float height = 1.92f;
  private final boolean programmer = false;
  private final Long ageInSeconds = 1_241_401_112L;
}
