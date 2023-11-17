package Epok;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class EpokService {
	/*@EJB
	private EpokEntitet kursen;*/
	@PersistenceContext(name="epok")
	EntityManager entityManager;
	@Context
	UriInfo uriInfo;

	@GET
	@Path("/kurs={id}")
	public Response getKurs(@PathParam("id") int kursID) {
	EpokEntitet kurs = entityManager.find(EpokEntitet.class, kursID);
		if (kurs == null) {
			throw new NotFoundException();
		} else {
			return Response.ok(kurs).build();
		}
	}

	@POST
	@Path("{kod}")
	public Response insertKurs(@PathParam("kod") String nyKursKod) {
		EpokEntitet kurs = new EpokEntitet();
		kurs.setKursKod(nyKursKod);
		entityManager.persist(kurs);
		URI uri = uriInfo.getAbsolutePathBuilder().path(kurs.getClass()).build();
		if (kurs == null) {
			throw new InternalServerErrorException();
		} else {
			return Response.created(uri).build();
		}
	}
}
