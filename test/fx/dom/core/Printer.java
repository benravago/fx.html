package fx.dom.core;

import javax.xml.stream.events.*;

import fx.dom.parser.ScannerDT;

class Printer extends ScannerDT {
    
    @Override protected void startElement(StartElement e) {
        System.out.println(types[e.getEventType()]+' '+e.getName());
        var a = e.getAttributes();
        while (a.hasNext()) {
            var t = a.next();
            System.out.println("a "+t.getName()+' '+t.getValue()+' '+t.getDTDType()+' '+t.isSpecified());
        }
    }
    @Override protected void endElement(EndElement e) {
        System.out.println(types[e.getEventType()]+' '+e.getName());
    }  
    @Override protected void processingInstruction(ProcessingInstruction e) { print(e.getEventType()); }
    
    @Override protected void characters(Characters e) { 
        System.out.println(types[e.getEventType()]+' '+e.getData());
    }  
    @Override protected void cdata(Characters e) {
        System.out.println(types[12]+' '+e.getData());
    }  
    @Override protected void whitespace(Characters e) {
        System.out.println(types[6]+" ["+e.getData()+']');
    }  
        
    @Override protected void comment(Comment e) { print(e.getEventType()); }     

    @Override protected void startDocument(StartDocument e) { print(e.getEventType()); }
    @Override protected void endDocument(EndDocument e) { print(e.getEventType()); } 
    @Override protected void entityReference(EntityReference e) { print(e.getEventType()); }
    @Override protected void attribute(Attribute e) { print(e.getEventType()); }   
    
    @Override protected void dtd(DTD e) {
        System.out.println(types[e.getEventType()]);
        super.dtd(e);
    }
    
    @Override protected void namespace(Namespace e) { print(e.getEventType()); }
    
    @Override protected void notationDeclaration(NotationDeclaration e) {
        System.out.println(types[e.getEventType()]+' '+e.getName());
    }
    @Override protected void entityDeclaration(EntityDeclaration e) { 
        System.out.println(types[e.getEventType()]+' '+e.getName());
    }
    
    @Override protected void elementDeclaration(String name, String model) {
        System.out.println("elementDecl "+name+' '+model);
    }
    
    @Override protected void attributeDeclaration(String eName, String aName, String type, String mode, String value) {
        System.out.println("attrDecl "+eName+' '+aName+' '+type+' '+mode+' '+value);
    }

   
    void print(int type) {
        System.out.println(types[type]);
    }

    static String[] types = {
        "",                                    // 0 
        "START_ELEMENT", "END_ELEMENT",        // 1, 2
        "PROCESSING_INSTRUCTION",              // 3
        "CHARACTERS", "COMMENT",               // 4, 5
        "SPACE",                               // 6
        "START_DOCUMENT", "END_DOCUMENT",      // 7, 8
        "ENTITY_REFERENCE",                    // 9
        "ATTRIBUTE",                           // 10
        "DTD",                                 // 11
        "CDATA",                               // 12
        "NAMESPACE",                           // 13
        "NOTATION_DECLARATION",                // 14
        "ENTITY_DECLARATION"                   // 15
    };

}