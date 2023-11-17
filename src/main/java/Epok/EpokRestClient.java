package Epok;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.*;

import java.net.URI;

@Stateless
public class EpokRestClient {
	private final URI uri;
	private final Client client;

	public EpokRestClient() {
		uri = UriBuilder.fromUri("http://localhost:8080/LTUServices-1.0-SNAPSHOT/").port(8080).build();
		client = ClientBuilder.newClient();
	}

	public String nyKurs(EpokEntitet kurs) {
		Response response = client.target(uri).request()
				.post(Entity.entity(kurs, MediaType.APPLICATION_JSON_TYPE));
		return response.getStatusInfo().getReasonPhrase();
	}

	public EpokEntitet getKurs() {
		EpokEntitet kurs = client.target(uri).request().get(EpokEntitet.class);
		return kurs;
	}

	public void close() {
		client.close();
	}
}
