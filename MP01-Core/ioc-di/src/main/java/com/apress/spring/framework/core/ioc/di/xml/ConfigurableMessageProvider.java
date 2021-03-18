package com.apress.spring.framework.core.ioc.di.xml;

import com.apress.spring.framework.core.ioc.di.annotation.component.MessageProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfigurableMessageProvider implements MessageProvider {
  private final String message;
  @Override
  public String getMessage() {
    return message;
  }
}
