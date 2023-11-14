package Ladok;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class LadokWS {

	@POST
		@Path("/regres")
		@Consumes(MediaType.APPLICATION_JSON)
		public static Response reg_Resultat() {

			return Response.status(200).build();
		}
}
