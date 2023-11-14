package Epok;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/kurs")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class EpokService {

	@PersistenceContext(unitName="persis")
	EntityManager entityManager;
	@Context
	private UriInfo uriInfo;

	@GET
	@Path("{id}")
	public Response getKurs(@PathParam("id") int kursID) {
		EpokEntitet kurs = entityManager.find(EpokEntitet.class, kursID);
		if (kurs == null) {
			throw new NotFoundException();
		}
		return Response.ok(kurs).build();
	}

}
