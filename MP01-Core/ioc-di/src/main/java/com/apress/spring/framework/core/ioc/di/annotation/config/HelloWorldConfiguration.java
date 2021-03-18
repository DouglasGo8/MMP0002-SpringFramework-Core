package com.apress.spring.framework.core.ioc.di.annotation.config;

import com.apress.spring.framework.core.ioc.di.annotation.component.HelloWorldMsgProvider;
import com.apress.spring.framework.core.ioc.di.annotation.component.MessageProvider;
import com.apress.spring.framework.core.ioc.di.annotation.service.MessageRenderer;
import com.apress.spring.framework.core.ioc.di.annotation.service.StandardOutMsgRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// NoSuchBeanDefinitionException: No bean named 'renderer' available
// @ImportResource(locations = {"classpath:META-INF/spring/app-context.xml"})
public class HelloWorldConfiguration {

  @Bean
  MessageProvider provider() {
    return new HelloWorldMsgProvider();
  }

  @Bean
  MessageRenderer renderer() {
    return new StandardOutMsgRenderer(this.provider());
  }
}
