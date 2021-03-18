package com.apress.spring.framework.core.ioc.di.annotated;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration {

  private String lyric = "I can keep the door cracked open, to let light through";

  /**
   * Order 0
   * @param lyric will be injected with the @Value
   */
  public Inspiration(@Value("For all my running, I can understand") String lyric) {
    this.lyric = lyric;
  }

  public String getLyric() {
    return lyric;
  }

  public void setLyric(String lyric) {
    this.lyric = lyric;
  }

}
