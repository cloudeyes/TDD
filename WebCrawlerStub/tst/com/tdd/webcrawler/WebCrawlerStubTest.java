package com.tdd.webcrawler;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class WebCrawlerStubTest {

  @Test
  public void testWebCrawler() {
    WebCrawlerStub wc = new WebCrawlerStub();
    String content = wc.retrieve("https://www.naver.com");
    assertNotNull(content);
  }
}
