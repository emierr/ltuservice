package Controller;

import Services.LadokWS;
import Services.StudentITSWS;
import Services.EpokWS;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationPath("/")
public class LTUApplication extends Application {

	@Path("/Registreraresultat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get_Persnummer() {
		return StudentITSWS.get_Persnummer();
	}
	@Produces
	public Response get_Modul(){
		return EpokWS.get_Modul("");
		}
		@Produces
		public Response reg_Resulat(){
		return LadokWS.reg_Resultat();
		}
	@Path("/Resultatregistrerat")
	@Produces ()
	public String ResulatatRegistrerat(){
		return "Resultaten är registrerade i Ladok";
	}
}
