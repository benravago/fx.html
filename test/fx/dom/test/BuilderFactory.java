package fx.dom.test;

import domts.TestDocumentBuilder;

public class BuilderFactory implements domts.TestDocumentBuilderFactory {

    @Override
    public TestDocumentBuilder getBuilder(String contentType) {
        return switch (contentType) {
            case "text/xml" -> new XmlBuilder();
            case "text/html" -> new HtmlBuilder();
            default -> null;
        };
    }
}
