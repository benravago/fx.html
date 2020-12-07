package fx.dom.core;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class XmlDocument extends Parent implements Document {

  protected XmlDocument(String root) {
    super("#document",Node.DOCUMENT_NODE,null);
    if (root != null) appendChild(createElement(root));
  }

  @Override
  boolean acceptable(Node child) {
    return switch (child.getNodeType()) {
      case Node.ELEMENT_NODE -> (getDocumentElement() == null);
      case Node.DOCUMENT_TYPE_NODE -> (getDoctype() == null);
      case Node.COMMENT_NODE,
           Node.PROCESSING_INSTRUCTION_NODE -> true;
      default -> false;
    };
  }

  // DOM Level 1

  @Override public Attr createAttribute(String name) throws DOMException { return new XmlAttr(name,this); }
  @Override public CDATASection createCDATASection(String data) throws DOMException { return new XmlCDATASection(data,this); }
  @Override public Comment createComment(String data) { return new XmlComment(data,this); }
  @Override public DocumentFragment createDocumentFragment() { return new XmlDocumentFragment(this); }
  @Override public Element createElement(String tagName) throws DOMException { return new XmlElement(tagName,this); }
  @Override public EntityReference createEntityReference(String name) throws DOMException { return new XmlEntityReference(name,this); }
  @Override public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException { return new XmlProcessingInstruction(target,data,this); }
  @Override public Text createTextNode(String data) { return new XmlText(data,this); }

  @Override public DOMImplementation getImplementation() { return new XmlDOM(); }
  @Override public NodeList getElementsByTagName(String tagname) { return XmlElement.byTag(childNodes,tagname); }

  @Override public DocumentType getDoctype() { return (DocumentType) getUnique(DocumentType.class); }
  @Override public Element getDocumentElement() { return (Element) getUnique(Element.class); }

  Node getUnique(Class<?> type) {
    for (var n : childNodes) {
      if (type.isInstance(n)) return n;
    }
    return null;
  }

  // DOM Level 2
  @Override public Node importNode(Node importedNode, boolean deep) throws DOMException { return null; }
  @Override public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException { return null; }
  @Override public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException { return null; }
  @Override public NodeList getElementsByTagNameNS(String namespaceURI, String localName) { return null; }
  @Override public Element getElementById(String elementId) { return null; }
  @Override public String getInputEncoding() { return null; }
  @Override public String getXmlEncoding() { return null; }
  @Override public boolean getXmlStandalone() { return false; }
  @Override public void setXmlStandalone(boolean xmlStandalone) throws DOMException {}
  @Override public String getXmlVersion() { return null; }
  @Override public void setXmlVersion(String xmlVersion) throws DOMException {}
  @Override public boolean getStrictErrorChecking() { return false; }
  @Override public void setStrictErrorChecking(boolean strictErrorChecking) {}
  @Override public String getDocumentURI() { return null; }
  @Override public void setDocumentURI(String documentURI) {}
  @Override public Node adoptNode(Node source) throws DOMException { return null; }
  @Override public DOMConfiguration getDomConfig() { return null; }
  @Override public void normalizeDocument() {}
  @Override public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException { return null; }
}
