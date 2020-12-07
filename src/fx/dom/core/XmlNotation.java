package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Notation;

public class XmlNotation extends XmlNode implements Notation {

  String publicId, systemId;

  XmlNotation(String name, String publicId, String systemId, Document owner) {
    super(name,Node.NOTATION_NODE,owner);
    this.publicId = publicId;
    this.systemId = systemId;
    immutable = true;
  }

  // DOM Level 1
  @Override public String getPublicId() { return publicId; }
  @Override public String getSystemId() { return systemId; }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    return new XmlNotation(getNodeName(),publicId,systemId,getOwnerDocument());
  }

}
