package fx.dom.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public class XmlNode extends NamedItem implements Node {

  Document ownerDocument;
  boolean immutable = false;

  protected XmlNode(String nodeName, Document ownerDocument) {
    if (nodeName == null) {
      throw new DOMException(DOMException.INVALID_CHARACTER_ERR,nodeName);
    }
    this.nodeName = nodeName;
    this.ownerDocument = ownerDocument;
  }

  Node sibling(int offset) {
    assert list.nodes[index] == this;
    var i = index + offset;
    return (-1 < i && i < list.size) ? list.nodes[i] : null;
  }

  void mutable() {
    if (immutable) {
      throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR,"");
    }
  }

  void ownable(Node node) {
    if (getOwnerDocument() != node.getOwnerDocument()) {
      throw new DOMException(DOMException.WRONG_DOCUMENT_ERR,"");
    }
  }

  static final Pattern namePattern = Pattern.compile("[:|\\w][:|\\w|\\d|.|-]*");
  static final Matcher nameMatcher = namePattern.matcher("");

  static String valid(String nodeName) throws DOMException {
    if (nodeName != null && nameMatcher.reset(nodeName).matches()) {
      return nodeName;
    }
    throw new DOMException(DOMException.INVALID_CHARACTER_ERR,nodeName);
  }

  // DOM Level 1
  @Override public Node appendChild(Node newChild) throws DOMException { throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,""); }
  @Override public Node cloneNode(boolean deep) { throw new DOMException(DOMException.NOT_SUPPORTED_ERR,""); }
  @Override public NamedNodeMap getAttributes() { return null; }
  @Override public NodeList getChildNodes() { return XmlNodeList.EMPTY; }
  @Override public Node getFirstChild() { return null; }
  @Override public Node getLastChild() { return null; }
  @Override public Node getNextSibling() { return list != null ? sibling(1) : null; }
  @Override public String getNodeName() { return nodeName; }
  @Override public short getNodeType() { return -1; }
  @Override public String getNodeValue() throws DOMException { return null; }
  @Override public Document getOwnerDocument() { return ownerDocument; }
  @Override public Node getParentNode() { return list != null ? ((XmlNodeList)list).owner : null; }
  @Override public Node getPreviousSibling() { return list != null ? sibling(-1) : null; }
  @Override public boolean hasChildNodes() { return false; }
  @Override public Node insertBefore(Node newChild, Node refChild) throws DOMException { throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,""); }
  @Override public Node removeChild(Node oldChild) throws DOMException { throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,""); }
  @Override public Node replaceChild(Node newChild, Node oldChild) throws DOMException { throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,""); }
  @Override public void setNodeValue(String string) throws DOMException {}

  // DOM level 2
  @Override public void normalize() {}
  @Override public boolean isSupported(String feature, String version) { return false; }
  @Override public String getNamespaceURI() { return null; }
  @Override public String getPrefix() { return null; }
  @Override public void setPrefix(String prefix) throws DOMException {}
  @Override public String getLocalName() { return null; }
  @Override public boolean hasAttributes() { return false; }
  @Override public String getBaseURI() { return null; }
  @Override public short compareDocumentPosition(Node other) throws DOMException { return 0; }
  @Override public String getTextContent() throws DOMException { return null; }
  @Override public void setTextContent(String textContent) throws DOMException {}
  @Override public boolean isSameNode(Node other) { return false; }
  @Override public String lookupPrefix(String namespaceURI) { return null; }
  @Override public boolean isDefaultNamespace(String namespaceURI) { return false; }
  @Override public String lookupNamespaceURI(String prefix) { return null; }
  @Override public boolean isEqualNode(Node arg) { return false; }
  @Override public Object getFeature(String string, String string1) { return null; }
  @Override public Object setUserData(String key, Object data, UserDataHandler handler) { return null; }
  @Override public Object getUserData(String key) { return null; }
}
