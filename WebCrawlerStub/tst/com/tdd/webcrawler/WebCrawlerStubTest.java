package com.tdd.webcrawler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

import com.tdd.webcrawler.WebCrawler.Anchor;
import com.tdd.webcrawler.WebCrawler.SiteMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WebCrawlerStubTest {

  private static final String TEST_CONTENT_ROOT = """
      <html>
        <a href="https://www.site-a.com">A</a>
        <a href="https://www.site-b.com">B</a>
      </html>
  """;

  private static final String TEST_CONTENT_SITE_A = """
      <html>
        <a href="https://www.site-a1.com">A1</a>
        <a href="https://www.site-a2.com">A2</a>
        <a href="https://www.site-a3.com">A3</a>
      </html>
  """;

  private static final String TEST_CONTENT_SITE_B = """
      <html>
        <a href="https://www.site-b1.com">B1</a>
        <a href="https://www.site-b2.com">B2</a>
      </html>
  """;

  @Test
  public void walkThroughWebCrawlerHandleHangulOutput() {
    final WebCrawler wc = new WebCrawlerStub();
    final String content = wc.retrieve("https://www.naver.com");
    assertThat(content, Matchers.containsString("네이버"));
  }

  /** For learning usages of regular expression */
  @Test
  public void patternMatchingSingleGroup() {
    final String patternString = "<a.*?href=['\"]?(.*?)['\"]>(.*?)</a>";
    final String val = "  <a href='test.com'>test</a>  ";
    final Pattern pattern = Pattern.compile(patternString);
    final Matcher matcher = pattern.matcher(val);
    assertTrue(matcher.find());
    assertEquals("<a href='test.com'>test</a>", matcher.group());
    assertEquals("test.com", matcher.group(1));
  }

  /** For learning usages of regular expression */
  @Test
  public void patternMatchingNestedGroups() {
    final Pattern pattern = WebCrawler.DEFAULT_ANCHOR_PATTERN;
    final Matcher matcher = pattern.matcher(TEST_CONTENT_ROOT);
    assertTrue(matcher.find());
    assertEquals("<a href=\"https://www.site-a.com\">A</a>", matcher.group());
    assertEquals("<a href=\"https://www.site-a.com\">A</a>", matcher.group(1));
    assertEquals("https://www.site-a.com", matcher.group(2));
    assertEquals("A", matcher.group(3));
  }

  @Test
  public void parseAnchorTags() {
    // Given: WebCrawler
    final WebCrawler wc = new WebCrawlerStub();
    final WebCrawler wcDouble = Mockito.mock(WebCrawlerStub.class);
    Mockito.when(wcDouble.retrieve(anyString())).thenReturn(TEST_CONTENT_ROOT);

    // When:
    // - `retrive` a content
    // - `parseAnchors` from the content
    final String content = wcDouble.retrieve("https://www.naver.com");
    final List<Anchor> anchors = wc.parseAnchors(content);
    assertEquals(2, anchors.size());
  }

  @Test
  public void buildSiteTreeRecursively() {
    // Given: WebCrawler and mock

    // When:
    // - `retrive` a content from site root: www.naver.com
    // - then retrive anoter content from sub site: wwww.site-a.com
    final WebCrawler wc = new WebCrawlerStub();
    final WebCrawler wcDouble = Mockito.mock(WebCrawlerStub.class);
    Mockito.when(wcDouble.retrieve("https://www.naver.com")).thenReturn(TEST_CONTENT_ROOT);
    Mockito.when(wcDouble.retrieve("https://www.site-a.com")).thenReturn(TEST_CONTENT_SITE_A);
    Mockito.when(wcDouble.retrieve("https://www.site-b.com")).thenReturn(TEST_CONTENT_SITE_B);

    // Then:
    final String content = wcDouble.retrieve("https://www.naver.com");
    final List<Anchor> anchors = wc.parseAnchors(content);
    assertEquals(2, anchors.size());

    final SiteMap<Anchor> root = new SiteMap<>();

    for (Anchor it : anchors) {
      root.put(it.href(), new SiteMap<>());
      final String childContent = wcDouble.retrieve(it.href());
      final List<Anchor> childAnchors = wc.parseAnchors(childContent);
      final SiteMap<Anchor> child = root.get(it.href());

      for (Anchor itChild : childAnchors) {
        child.put(itChild.href(), new SiteMap<>());
      }
    }

    assertEquals(2, root.size());
    assertEquals(3, root.get("https://www.site-a.com").size());
  }

  @Test
  public void buildSiteTreeRecursivelyE22() {
    // Given: WebCrawler and mock

    // When: Only mock some methods. Use real methods for others.
    final WebCrawler wcDouble = Mockito.mock(WebCrawlerStub.class);
    Mockito.when(wcDouble.retrieve("https://www.naver.com")).thenReturn(TEST_CONTENT_ROOT);
    Mockito.when(wcDouble.retrieve("https://www.site-a.com")).thenReturn(TEST_CONTENT_SITE_A);
    Mockito.when(wcDouble.retrieve("https://www.site-b.com")).thenReturn(TEST_CONTENT_SITE_B);
    Mockito.when(wcDouble.buildSiteTree(anyString())).thenCallRealMethod();
    Mockito.when(wcDouble.parseAnchors(anyString())).thenCallRealMethod();
    Mockito.when(wcDouble.getAnchorPattern()).thenCallRealMethod();

    // Then:
    final SiteMap<Anchor> root = wcDouble.buildSiteTree("https://www.naver.com");

    assertEquals(2, root.size());
    assertEquals(3, root.get("https://www.site-a.com").size());
    assertEquals(2, root.get("https://www.site-b.com").size());
    assertTrue(root.get("https://www.site-a.com").containsKey("https://www.site-a1.com"));
    assertTrue(root.get("https://www.site-b.com").containsKey("https://www.site-b1.com"));
  }
}
