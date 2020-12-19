package jaxp.dom.test;

import java.io.InputStream;
import java.util.function.Function;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import domts.TestDocumentBuilder;

public class Builder implements TestDocumentBuilder {

  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

  @Override public boolean isCoalescing() { return factory.isCoalescing(); }
  @Override public boolean isExpandEntityReferences() { return factory.isExpandEntityReferences(); }
  @Override public boolean isIgnoringComments() { return factory.isIgnoringComments(); }
  @Override public boolean isIgnoringElementContentWhitespace() { return factory.isIgnoringElementContentWhitespace(); }
  @Override public boolean isNamespaceAware() { return factory.isNamespaceAware(); }
  @Override public boolean isValidating() { return factory.isValidating(); }

  @Override public void setCoalescing(boolean coalescing) { factory.setCoalescing(coalescing); }
  @Override public void setExpandEntityReferences(boolean expandEntityRef) { factory.setExpandEntityReferences(expandEntityRef); }
  @Override public void setIgnoringComments(boolean ignoreComments) { factory.setIgnoringComments(ignoreComments); }
  @Override public void setIgnoringElementContentWhitespace(boolean whitespace) { factory.setIgnoringElementContentWhitespace(whitespace); }
  @Override public void setNamespaceAware(boolean awareness) { factory.setNamespaceAware(awareness); }
  @Override public void setValidating(boolean validating) { factory.setValidating(validating); }

  @Override
  public DOMImplementation getImplementation() throws Exception {
      return factory.newDocumentBuilder().getDOMImplementation();
  }

  @Override
  public Document parse(String uri, Function<String,InputStream> er) throws Exception {
    var builder = factory.newDocumentBuilder();
    builder.setEntityResolver((publicId,systemId) -> new InputSource(er.apply(systemId)) );
    var is = er.apply(uri);
    return builder.parse(is);
  }

  @Override public String getContentType() { return "text/xml"; }
  @Override public String getFileType() { return ".xml"; }

}
