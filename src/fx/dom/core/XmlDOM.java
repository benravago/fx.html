package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public class XmlDOM implements DOMImplementation {

  // DOM Level 1
  @Override public boolean hasFeature(String feature, String version) { return false; }

  // DOM Level 2
  @Override public Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype) throws DOMException { return null; }
  @Override public DocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException { return null; }
  @Override public Object getFeature(String feature, String version) { return null; }
}
