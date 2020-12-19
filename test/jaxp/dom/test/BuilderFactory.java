package jaxp.dom.test;

import domts.TestDocumentBuilder;

public class BuilderFactory implements domts.TestDocumentBuilderFactory {

  @Override
  public TestDocumentBuilder getBuilder(String contentType) {
    if ("text/xml".equals(contentType)) {
      return new Builder();
    }
    return null;
  }
}
