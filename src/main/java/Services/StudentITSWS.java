package Services;

import jakarta.ws.rs.core.Response;

public class StudentITSWS {

	public static Response get_Persnummer() {
		return Response.status(200).build();
	}
}
