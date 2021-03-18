package com.apress.spring.framework.core.ioc.di.annotation.service;

import com.apress.spring.framework.core.ioc.di.annotation.component.MessageProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("renderer")
@RequiredArgsConstructor
public class StandardOutMsgRenderer implements MessageRenderer {

  private final MessageProvider provider;

  @Override
  public void render() {

    if (provider == null) {
      throw new RuntimeException(
              "You must set the property messageProvider of class:"
                      + StandardOutMsgRenderer.class.getName());
    }
    log.info(provider.getMessage());
  }
}
