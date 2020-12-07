package fx.dom.core;

import org.w3c.dom.Document;

class Token extends XmlNode {

  static final String TYPE          = "[TYPE]";

  static final String TYPE_CDATA    = "CDATA";
  static final String TYPE_ID       = "ID";
  static final String TYPE_IDREF    = "IDREF";
  static final String TYPE_IDREFS   = "IDREFS";
  static final String TYPE_NMTOKEN  = "NMTOKEN";
  static final String TYPE_NMTOKENS = "NMTOKENS";
  static final String TYPE_ENTITY   = "ENTITY";
  static final String TYPE_ENTITIES = "ENTITIES";
  static final String TYPE_NOTATION = "NOTATION";  // followed by text

  static final String MODE          = "[MODE]";

  static final String MODE_IMPLIED  = "#IMPLIED";
  static final String MODE_REQUIRED = "#REQUIRED";
  static final String MODE_FIXED    = "#FIXED";

  static final String MODEL         = "#MODEL";

  static final short NODETYPE = 0;

  String value;

  Token(String name, String value, Document owner) {
    super(name,NODETYPE,owner);
    this.value = value;
  }

  @Override
  public String getNodeValue() {
    return value;
  }

}
