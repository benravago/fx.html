package fx.dom.core;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.NotationDeclaration;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fx.dom.parser.ScannerDT;

public class Builder extends ScannerDT {

  public Builder() {
    super();
  }

  @Override
  public void parse(InputStream source) throws XMLStreamException{
    reset();
    super.parse(source);
  }

  public void reset() {
    doc = null;  
    dtd = null;
    leader = null;
    referenceStack.clear();
    savedEntityText = null;
  }

  protected XmlDocument newDocument() { return new XmlDocument(null); }
  protected boolean compareName(String a, String b) { return a.equals(b); }
  
  XmlDocument doc;
  XmlDocumentType dtd;
  Node leader;

  public Document getDocument() { return doc; }
  public DocumentType getDocumentType() { return dtd; }

  Deque<Node> referenceStack = new ArrayDeque<>();
  String savedEntityText;

  static String location(XMLEvent e) {
    var l = e.getLocation();
    return l.getSystemId()+';'+l.getLineNumber()+','+l.getColumnNumber();
  }

  @Override
  protected void startDocument(StartDocument d) {
    doc = newDocument();
    leader = doc;
  }
  @Override
  protected void endDocument(EndDocument e) {
    if (leader != doc) {
      throw new DOMException((short)0,"unexpected end-of-documentat: " + location(e));
    }
  }

  @Override
  protected void startElement(StartElement e) {
    var element = doc.createElement(e.getName().getLocalPart());
    var i = e.getAttributes();
    while (i.hasNext()) {
      var a = i.next();
      var name = a.getName().getLocalPart();
      var value = a.getValue();
      if (!element.getAttribute(name).equals(value)) {
        element.setAttribute(name, value);
      }
    }
    leader.appendChild(element);
    leader = element;
  }
  @Override
  protected void endElement(EndElement e) {
    if (!compareName(e.getName().getLocalPart(), leader.getNodeName())) {
      throw new DOMException((short)0,"unexpected end-of-element at: " + location(e));
    }
    leader = leader.getParentNode();
  }

  @Override
  protected void characters(Characters e) {
    var text = e.getData();
    if (savedEntityText != null) {
      if (text.startsWith(savedEntityText)) {
        text = text.substring(savedEntityText.length());
      }
      savedEntityText = null;
    }
    leader.appendChild(doc.createTextNode(text));
  }
  @Override
  protected void cdata(Characters e) {
    leader.appendChild(doc.createCDATASection(e.getData()));
  }

  @Override
  protected void comment(Comment e) {
    leader.appendChild(doc.createComment(e.getText()));
  }

  @Override
  protected void processingInstruction(ProcessingInstruction e) {
    leader.appendChild(doc.createProcessingInstruction(e.getTarget(),e.getData()));
  }

  @Override
  protected void dtd(DTD d) {
    dtd = new XmlDocumentType("",doc);
    dtd.immutable = false;
    doc.appendChild(dtd);
    leader = dtd;

    super.dtd(d);

    XmlEntity.mute(dtd, true);
    XmlEntity.mute(dtd.entities.item(0), true);
    leader = leader.getParentNode();
  }

  @Override
  protected void notationDeclaration(NotationDeclaration n) {
    var x = new XmlNotation(n.getName(),n.getPublicId(),n.getSystemId(),doc);
    dtd.notations.setNamedItem(x);
  }

  @Override
  protected void entityDeclaration(EntityDeclaration e) {
    var x = new XmlEntity(e.getName(),e.getPublicId(),e.getSystemId(),e.getNotationName(),doc);
    dtd.entities.setNamedItem(x);
  }

  @Override
  protected void elementDeclaration(String name, String model) {
    var element = doc.createElement(name);
    if (model != null) element.appendChild(new Token(Token.MODEL,model,doc));
    dtd.elements.setNamedItem(element);
  }

  @Override
  protected void attributeDeclaration(String eName, String aName,String type, String mode, String value) {
    var attr = doc.createAttribute(aName);
    attr.setValue(value);
    if (type != null) attr.appendChild(new Token(Token.TYPE,type,doc));
    if (mode != null) attr.appendChild(new Token(Token.MODE,mode,doc));
    var element = (Element) dtd.elements.getNamedItem(eName);
    if (element != null) element.setAttributeNode(attr);
  }

  // void whitespace(Characters e)
  // void attribute(Attribute e)
  // void namespace(Namespace e)
  // void entityReference(EntityReference e)

}
