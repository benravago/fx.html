package fx.dom.core;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

public class XmlDocumentFragment extends Parent implements DocumentFragment {

  protected XmlDocumentFragment(Document owner) {
    super("#document-fragment",owner);
  }

  @Override public short getNodeType() { return Node.DOCUMENT_FRAGMENT_NODE; }

  @Override
  boolean acceptable(Node child) {
    ownable(child);
    return switch (child.getNodeType()) {
      case Node.ELEMENT_NODE,
           Node.COMMENT_NODE,
           Node.TEXT_NODE,
           Node.CDATA_SECTION_NODE,
           Node.PROCESSING_INSTRUCTION_NODE -> true;
      default -> false;
    };
  }

}