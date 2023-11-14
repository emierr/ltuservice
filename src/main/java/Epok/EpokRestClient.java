package Epok;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Stateless
public class EpokRestClient {
	private URI uri;
	private Client client;

	public EpokRestClient() {
		uri = UriBuilder.fromUri("http://localhost:8080/LTUServices-1.0-SNAPSHOT/").port(8080).build();
		client = ClientBuilder.newClient();
	}

	public EpokEntitet getKurs() {
		EpokEntitet kurs = client.target(uri).request().get(EpokEntitet.class);
		return kurs;
	}

	public void close() {
		client.close();
	}
}
