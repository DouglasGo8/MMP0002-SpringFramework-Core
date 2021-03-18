package com.apress.spring.framework.core.ioc.di.annotation.component;

import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMsgProvider implements MessageProvider {
  @Override
  public String getMessage() {
    return "Hello World!!";
  }
}
