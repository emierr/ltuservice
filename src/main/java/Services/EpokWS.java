package Services;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;


public class EpokWS {

	public Response get_Modul(String kurskod) {
		return priv_get_Modul(kurskod);
	}
	private Response priv_get_Modul(String kurskod) {
		ResponseBuilder builder = Response.ok(kurskod, "text/plain");
		return builder.build();

	}
}

/**
 *  Testa OscarFish!
 */