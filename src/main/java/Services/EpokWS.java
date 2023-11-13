package Services;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;


public class EpokWS {

	public static Response get_Modul(String kurskod) {
		return priv_get_Modul(kurskod);
	}
	public static Response priv_get_Modul(String kurskod) {
		ResponseBuilder builder = Response.ok(kurskod, "text/plain");
		return builder.build();

	}
}
