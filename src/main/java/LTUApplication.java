import Epok.EpokService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class LTUApplication extends Application {
	private final Set<Class<?>> classes;

	public LTUApplication() {
		HashSet<Class<?>> c = new HashSet<>();
		try {
			Class<?> jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
					c.add(jsonProvider);
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(
							getClass().getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		c.add(EpokService.class);
		classes = Collections.unmodifiableSet(c);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
