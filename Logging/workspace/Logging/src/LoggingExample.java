import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {

	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		log.trace("This is Trace Message");
		log.debug("This is Debug Message");
		log.info("This is Info Message");
		log.warn("This is Warn Message");
		log.error("This is Error Message");
		log.fatal("This is Fatal Message");
	}
}
