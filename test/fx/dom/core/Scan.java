package fx.dom.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;

import org.junit.jupiter.api.Test;

class Scan {

    @Test void core() throws Exception { run("testsuite/domts/level1/core/resource","staff"); }
    @Test void html() throws Exception { run("testsuite/domts/level1/core/resource","hc_staff"); }
    
    @Test void element() throws Exception { run("testsuite/domts/level2/html/resource","element"); }
    
    void run(String dir, String file) throws Exception {
        System.out.println("file "+dir+' '+file);
        var source = Files.newInputStream(Paths.get(dir,file+".xml"));
        var parser = new Printer();
        parser.setResolver(resolver(dir));
        parser.parse(source);
    }
    
    static XMLResolver resolver(String dir) {
        return new XMLResolver() {
            @Override
            public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
                System.out.println("resolve: "+publicID+' '+systemID+' '+baseURI+' '+namespace);
                try {
                    return Files.newInputStream(Paths.get(dir,systemID));
                } catch (IOException e) {
                    throw new XMLStreamException(e);    
                }
            }
        };
    }
}
