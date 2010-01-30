package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLogWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloLogWorld.class);
    logger.info("Hello World");
  }
}