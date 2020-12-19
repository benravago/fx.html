package fx.dom.parser;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import static javax.xml.stream.XMLInputFactory.*;
import static javax.xml.stream.XMLStreamConstants.*;

public class Scanner {

    protected final XMLInputFactory factory;

    protected Scanner() {
        factory = XMLInputFactory.newInstance();
        factory.setProperty(IS_NAMESPACE_AWARE,false); // default = True
        factory.setProperty(ZEPHYR_PROPERTY_PREFIX + STAX_REPORT_CDATA_EVENT, true);
    }

    // from com.sun.org.apache.xerces.internal.impl.Constants

    static final String ZEPHYR_PROPERTY_PREFIX = "http://java.sun.com/xml/stream/properties/";
    static final String STAX_REPORT_CDATA_EVENT = "report-cdata-event";

    public void setCoalescing(boolean coalescing) { factory.setProperty(IS_COALESCING,coalescing); }
    public void setNamespaceAware(boolean awareness) { factory.setProperty(IS_NAMESPACE_AWARE,awareness); }
    public void setExpandEntityReferences(boolean expandEntityRef) { factory.setProperty(IS_REPLACING_ENTITY_REFERENCES,expandEntityRef); }

    public void setReporter(XMLReporter reporter) { factory.setProperty(REPORTER,reporter); }
    public void setResolver(XMLResolver resolver) { factory.setProperty(RESOLVER,resolver); }

    public void parse(InputStream source) throws XMLStreamException {
        var reader = factory.createXMLEventReader(source);
        while (reader.hasNext()){
            var e = reader.nextEvent();
            switch (e.getEventType()) {
                case START_ELEMENT -> startElement((StartElement)e);
                case END_ELEMENT -> endElement((EndElement)e);
                case PROCESSING_INSTRUCTION -> processingInstruction((ProcessingInstruction)e);
                case CHARACTERS -> text((Characters)e);
                case COMMENT -> comment((Comment)e);
                case SPACE -> whitespace((Characters)e);
                case START_DOCUMENT -> startDocument((StartDocument)e);
                case END_DOCUMENT -> endDocument((EndDocument)e);
                case ENTITY_REFERENCE -> entityReference((EntityReference)e);
                case ATTRIBUTE -> attribute((Attribute)e);
                case DTD -> dtd((DTD)e);
                case CDATA -> cdata((Characters)e);
                case NAMESPACE -> namespace((Namespace)e);
                case NOTATION_DECLARATION -> notationDeclaration((NotationDeclaration)e);
                case ENTITY_DECLARATION -> entityDeclaration((EntityDeclaration)e);
                default -> throw new XMLStreamException("unsupported event: "+e);
            }
        }
        reader.close();
    }

    protected void dtd(DTD d) {
        var n = d.getNotations();
        if (n != null) for (var i:n) notationDeclaration(i);
        var e = d.getEntities();
        if (e != null) for (var i:e) if (i.getName().charAt(0) != '%') entityDeclaration(i);
    }

    void text(Characters e) {
        if (e.isCData()) cdata(e);
        else if (e.isWhiteSpace()) whitespace(e);
        else characters(e);
    }

    protected void startElement(StartElement e) {}
    protected void endElement(EndElement e) {}
    protected void processingInstruction(ProcessingInstruction e) {}
    protected void characters(Characters e) {}
    protected void comment(Comment e) {}
    protected void whitespace(Characters e) {}
    protected void startDocument(StartDocument e) {}
    protected void endDocument(EndDocument e) {}
    protected void entityReference(EntityReference e) {}
    protected void attribute(Attribute e) {}
    protected void cdata(Characters e) {}
    protected void namespace(Namespace e) {}
    protected void notationDeclaration(NotationDeclaration e) {}
    protected void entityDeclaration(EntityDeclaration e) {}

}
