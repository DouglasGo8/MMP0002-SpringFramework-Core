package com.apress.spring.framework.core.getting.started;


import com.apress.spring.framework.core.getting.started.annotated.HelloWorldConfig;
import com.apress.spring.framework.core.getting.started.decoupled.in.MessageRenderer;
import com.apress.spring.framework.core.getting.started.decoupled.out.HelloWorldMsgProvider;
import com.apress.spring.framework.core.getting.started.decoupled.out.StandardOutMsgRenderer;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppTest {

  @Test
  public void standardMessageWithoutSpring() {

    var mr = new StandardOutMsgRenderer();
    var mp = new HelloWorldMsgProvider();

    mr.setProvider(mp);
    mr.render();

  }

  @Test
  public void standardMessageWithSpringDI() {

    var ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

    var mp = ctx.getBean("renderer", MessageRenderer.class);

    mp.render();
  }

  @Test
  public void standardMessageWithAnnotationConfigSpringDI() {
    var ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    var mp = ctx.getBean("renderer", MessageRenderer.class);

    mp.render();
  }


}
