package fx.dom.test;

import java.io.InputStream;
import java.util.function.Function;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import domts.DOMTestDocumentService;

import fx.dom.core.Builder;

public class XmlBuilder implements DOMTestDocumentService {

    @Override public String getContentType() { return "text/xml"; }
    @Override public String getFileType() { return ".xml"; }

    @Override
    public Document parse(String uri, Function<String,InputStream> er) throws Exception {
        var builder = new Builder();
        builder.setResolver((publicID,systemID,baseURI,namespace) -> er.apply(systemID) );
        var source = er.apply(uri);
        builder.parse(source);
        return builder.getDocument();
    }

    // DOM Level 2
    @Override public DOMImplementation getImplementation() { return null; }
    
}
