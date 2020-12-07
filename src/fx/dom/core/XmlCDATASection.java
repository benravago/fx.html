package fx.dom.core;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlCDATASection extends XmlText implements CDATASection {

  protected XmlCDATASection(String data, Document owner) {
    super("#cdata-section",Node.CDATA_SECTION_NODE,data,owner);
  }

  @Override void normalizeText() {} // no-op for CDATA

}