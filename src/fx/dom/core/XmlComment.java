package fx.dom.core;

import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlComment extends XmlCharacterData implements Comment {

  protected XmlComment(String data, Document owner) {
    super("#comment",Node.COMMENT_NODE,data,owner);
  }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
	return new XmlComment(getData(),getOwnerDocument());
  }

}
