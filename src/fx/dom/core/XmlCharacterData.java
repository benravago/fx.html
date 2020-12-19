package fx.dom.core;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlCharacterData extends XmlNode implements CharacterData {

  StringBuilder data;

  protected XmlCharacterData(String name, String data, Document owner) {
    super(name,owner);
    setData(data);
  }

  // DOM Level 1

  @Override
  public void appendData(String arg) throws DOMException {
    mutable();
    if (arg != null) data.append(arg);
  }

  @Override
  public void deleteData(int offset, int count) throws DOMException {
    mutable();
    data.delete(offset,index(offset,count));
  }

  @Override
  public String getData() throws DOMException {
    return data.toString();
  }

  @Override
  public int getLength() {
    return data.length();
  }

  @Override
  public void insertData(int offset, String arg) throws DOMException {
    mutable();
    data.insert(index(offset,0),arg);
  }

  @Override
  public void replaceData(int offset, int count, String arg) throws DOMException {
    mutable();
    data.replace(offset,index(offset,count),arg);
  }

  @Override
  public void setData(String data) throws DOMException {
    mutable();
    this.data = new StringBuilder(data);
  }

  @Override
  public String substringData(int offset, int count) throws DOMException {
    return data.substring(offset, Math.min(index(offset,count),data.length()));
  }

  int index(int offset, int count) throws DOMException {
    if (offset < 0 || count < 0 || offset > getLength()) {
      throw new DOMException(DOMException.INDEX_SIZE_ERR,"");
    }
    return offset + count;
  }

  @Override public Node cloneNode(boolean deep) throws DOMException { return null; }
  @Override public String getNodeValue() throws DOMException { return getData(); }
  @Override public void setNodeValue(String nodeValue) throws DOMException { setData(nodeValue); }

}