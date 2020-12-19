package domts;

import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public interface TestDocumentBuilderFactory {

  TestDocumentBuilder getBuilder(String contentType);

  static TestDocumentBuilderFactory getInstance() {
    var cn = System.getProperty(TestDocumentBuilderFactory.class.getName());
    if (cn == null || cn.isBlank()) {
      return ServiceLoader.load(TestDocumentBuilderFactory.class).findFirst().get();
    }
    try {
      return (TestDocumentBuilderFactory) Class.forName(cn).getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new ServiceConfigurationError("no document builder factory", e);
    }
  }
}
