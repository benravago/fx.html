package fx.dom.core;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class XmlText extends XmlCharacterData implements Text {

  XmlText(String name, short type, String data, Document owner) {
    super(name,type,data,owner);
  }

  XmlText(String data, Document owner) {
    this("#text",Node.TEXT_NODE,data,owner);
  }

  void normalizeText() {
    Node n;
    while ((n = getNextSibling()) instanceof XmlText) {
      var t = (XmlText)n;
      data.append(t.data);
      XmlNodeList.unlink(t); // cNodeList.nodeOp(cNodeList.REMOVE,(cNode)n,null);
    }
  }

  // DOM Level 1

  @Override
  public Text splitText(int offset) throws DOMException {
    if (list == null) return null; // no-op if not in list
    if (offset < 0 || offset > getLength()) {
      throw new DOMException(DOMException.INDEX_SIZE_ERR,"");
    }
    var trailing = getLength() - offset;
    var data2 = substringData(offset,trailing);
    deleteData(offset,trailing);
    var text2 = new XmlText(data2,getOwnerDocument());
    list.insert(index+1,text2); // cNodeList.nodeOp(cNodeList.AFTER,(cNode)text2,this);
    return text2;
  }

  @Override
  public Node cloneNode(boolean deep) throws DOMException {
    return new XmlText(getData(),getOwnerDocument());
  }

  // DOM Level 2
  @Override public boolean isElementContentWhitespace() { return false; }
  @Override public String getWholeText() { return null; }
  @Override public Text replaceWholeText(String content) throws DOMException { return null; }
}
