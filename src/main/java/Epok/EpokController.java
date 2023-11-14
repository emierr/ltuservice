
package Epok;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static Epok.EpokService.*;

import javax.management.ObjectInstance;
import java.util.ArrayList;
import java.util.Objects;

@Named(value = "kurs")
@RequestScoped
public class EpokController {
	@Inject
	private EpokRestClient restClient;
	private EpokEntitet kurs = new EpokEntitet();
	FacesContext facesContext = FacesContext.getCurrentInstance();

	public EpokController() {
	}
	public EpokEntitet getKurs(){
		return kurs;
	}

	public void setKurs(EpokEntitet kurs) {
		this.kurs = kurs;
	}

	public void getKursById() {
		kurs = restClient.getKurs();
	}

	private boolean validate() {
		if ((kurs.getKursId() == null) || (kurs.getKursId().trim().isEmpty())) {
			facesContext.addMessage("form:kursID", new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Felaktigt kursID", "Ange giltigt kursID!!!!!!!!!"));
		}
		if (!facesContext.getMessageList().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}

