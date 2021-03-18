package com.apress.spring.framework.core.ioc.di.annotated;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("singer")
@AllArgsConstructor
public class Singer {
  private final Inspiration bean;

  public void sing() {
    log.info("... " + bean.getLyric());
  }
}
