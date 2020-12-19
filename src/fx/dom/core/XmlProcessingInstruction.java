package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public class XmlProcessingInstruction extends XmlCharacterData implements ProcessingInstruction {

  XmlProcessingInstruction(String target, String data, Document owner) {
    super(valid(target),data,owner);
  }

  @Override public short getNodeType() { return Node.PROCESSING_INSTRUCTION_NODE; }

  // DOM Level 1
  @Override public String getTarget() { return getNodeName(); }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    return new XmlProcessingInstruction(getTarget(),getData(),getOwnerDocument());
  }

}
