package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Entity;
import org.w3c.dom.Node;

public class XmlEntity extends Parent implements Entity {

  String publicId, systemId;
  String notationName;

  protected XmlEntity(String name, String publicId, String systemId, String notationName, Document owner) {
    super(valid(name),Node.ENTITY_NODE,owner);
    this.publicId = publicId;
    this.systemId = systemId;
    this.notationName = notationName;
    // immutable = true;  // let the loader set this
  }

  @Override
  boolean acceptable(Node child) {
    ownable(child);
    return switch (child.getNodeType()) {
      case Node.ELEMENT_NODE,
           Node.COMMENT_NODE,
           Node.TEXT_NODE,
           Node.CDATA_SECTION_NODE,
           Node.PROCESSING_INSTRUCTION_NODE,
           Node.ENTITY_REFERENCE_NODE -> true;
      default -> false;
    };
  }

  // DOM Level 1
  @Override public String getNotationName() { return notationName; }
  @Override public String getPublicId() { return publicId; }
  @Override public String getSystemId() { return systemId; }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    var e = new XmlEntity(getNodeName(),publicId,systemId,notationName,getOwnerDocument());
    e.immutable = false;
    cloneChildrenTo(e,deep);
    mute(e,true);
    return e;
  }

  static void mute(Node node, boolean mode) {
    if (node instanceof XmlNode) {
      ((XmlNode)node).immutable = mode;
      mute(node.getFirstChild(),mode);
      mute(node.getNextSibling(),mode);
    }
  }

  // DOM Level 2
  @Override public String getInputEncoding() { return null; }
  @Override public String getXmlEncoding() { return null; }
  @Override public String getXmlVersion() { return null; }
}
