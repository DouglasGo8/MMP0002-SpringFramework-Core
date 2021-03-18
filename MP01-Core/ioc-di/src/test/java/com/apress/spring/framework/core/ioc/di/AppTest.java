package com.apress.spring.framework.core.ioc.di;

import com.apress.spring.framework.core.ioc.di.annotated.InjectSimpleHardCoded;
import com.apress.spring.framework.core.ioc.di.annotated.InjectSimpleSpEl;
import com.apress.spring.framework.core.ioc.di.annotated.Singer;
import com.apress.spring.framework.core.ioc.di.annotation.component.MessageProvider;
import com.apress.spring.framework.core.ioc.di.annotation.config.HelloWorldConfiguration;
import com.apress.spring.framework.core.ioc.di.annotation.service.MessageRenderer;
import com.apress.spring.framework.core.ioc.di.in.OracleDef;
import com.apress.spring.framework.core.ioc.di.xml.ConstructorConfusion;
import com.apress.spring.framework.core.ioc.di.xml.InjectSimple;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


@Slf4j
public class AppTest {

  @Test
  public void configWithBeanFactory() {
    var factory = new DefaultListableBeanFactory();
    var rdr = new XmlBeanDefinitionReader(factory);
    rdr.loadBeanDefinitions(new ClassPathResource("META-INF/spring/app-context.xml"));

    var oraDef = factory.getBean("oracle", OracleDef.class);

    log.info(oraDef.defineMeaningOfLife());
  }

  @Test
  public void configComponentAndAnnotations() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:META-INF/spring/app-annotation-context.xml");
      ctx.refresh();
      var mr = ctx.getBean("renderer", MessageRenderer.class);
      mr.render();
    }
  }

  @Test
  public void avoidHardCodedMsg() {
    var ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
    var mr = ctx.getBean("xmlMsg", MessageProvider.class);
    log.info(mr.getMessage());
  }

  @Test
  public void helloWorldWithAnnotated() {
    var ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    var mr = ctx.getBean("renderer", MessageRenderer.class);
    mr.render();
  }

  @Test
  public void constructorConfusion() {
    var ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
    var cc = ctx.getBean("confusion", ConstructorConfusion.class);

    System.out.println(cc);
  }

  @Test
  public void fieldInjection() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:/META-INF/spring/app-annotation-context.xml");
      ctx.refresh();
      //
      var singer = ctx.getBean("singer", Singer.class);
      singer.sing();
    }
  }

  @Test
  public void injectSimple() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:/META-INF/spring/app-context.xml");
      ctx.refresh();
      //
      var injectSimple = ctx.getBean("injectSimple", InjectSimple.class);
      System.out.println(injectSimple);
    }
  }

  @Test
  public void injectSimpleHardCoded() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:/META-INF/spring/app-annotation-context.xml");
      ctx.refresh();
      //
      var injectSimpleHardCoded = ctx.getBean("injectSimpleHardCoded", InjectSimpleHardCoded.class);
      System.out.println(injectSimpleHardCoded);
    }
  }

  @Test
  public void injectSimpleSpEl() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:/META-INF/spring/app-context.xml");
      ctx.refresh();
      //
      var injectSimpleSpEl = ctx.getBean("injectSimpleSpEl", InjectSimple.class);
      System.out.println(injectSimpleSpEl);
    }
  }

  @Test
  public void injectSimpleAnnotatedSpEl() {
    try (var ctx = new GenericXmlApplicationContext()) {
      ctx.load("classpath:/META-INF/spring/app-annotation-context.xml");
      ctx.refresh();
      //
      var injectSimpleSpEl = ctx.getBean("injectSimpleSpEl", InjectSimpleSpEl.class);
      System.out.println(injectSimpleSpEl);
    }
  }


}
