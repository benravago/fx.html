package domts;

import java.io.InputStream;
import java.util.function.Function;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public interface TestDocumentBuilder {
  
  default boolean isCoalescing() { return false; }
  default boolean isExpandEntityReferences() { return false; }
  default boolean isIgnoringComments() { return false; }
  default boolean isIgnoringElementContentWhitespace() { return false; }
  default boolean isNamespaceAware() { return false; }
  default boolean isValidating() { return false; }

  default void setCoalescing(boolean coalescing) {}
  default void setExpandEntityReferences(boolean expandEntityRef) {}
  default void setIgnoringComments(boolean ignoreComments) {}
  default void setIgnoringElementContentWhitespace(boolean whitespace) {}
  default void setNamespaceAware(boolean awareness) {}
  default void setValidating(boolean validating) {}

  DOMImplementation getImplementation() throws Exception ;
  Document parse(String uri, Function<String,InputStream> er) throws Exception;

  String getContentType();
  String getFileType();

}
