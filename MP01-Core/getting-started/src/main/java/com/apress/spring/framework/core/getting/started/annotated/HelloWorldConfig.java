package com.apress.spring.framework.core.getting.started.annotated;


import com.apress.spring.framework.core.getting.started.decoupled.in.MessageProvider;
import com.apress.spring.framework.core.getting.started.decoupled.in.MessageRenderer;
import com.apress.spring.framework.core.getting.started.decoupled.out.HelloWorldMsgProvider;
import com.apress.spring.framework.core.getting.started.decoupled.out.StandardOutMsgRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

  @Bean
  MessageProvider provider() {
    return new HelloWorldMsgProvider();
  }

  @Bean
  MessageRenderer renderer() {
    return new StandardOutMsgRenderer() {{
      setProvider(HelloWorldConfig.this.provider());
    }};
  }
}
