package com.tdd.webcrawler;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public interface WebCrawler {

  Pattern DEFAULT_ANCHOR_PATTERN = Pattern.compile("(<a.*?href=['\"]?(.*?)['\"]>(.*?)</a>)");

  default Pattern getAnchorPattern() {
    return DEFAULT_ANCHOR_PATTERN;
  }

  String retrieve(String link);

  List<Anchor> parseAnchors(String content);

  SiteMap<Anchor> buildSiteTree(String link);

  record Anchor(String href, String text) {}

  class SiteMap<K> extends HashMap<String, SiteMap<K>> {}
}
