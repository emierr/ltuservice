package Epok;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

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

	public String nyKurs() {
		String status = "";
		try {
			if (validate()) {
				status = restClient.nyKurs(kurs);
				facesContext.addMessage(status, new FacesMessage
						(FacesMessage.SEVERITY_INFO,"Ny kurs tillagd.",kurs.toString()));
			}
		} catch (Exception exception) {
			facesContext.addMessage(status, new FacesMessage
					(FacesMessage.SEVERITY_ERROR,"New Book cannot be added", exception.getMessage()));
		}
		return status;
	}

	public void getKursById() {
		kurs = restClient.getKurs();
	}

	private boolean validate() {
		if ((kurs.getKursId() < 1) || (kurs.getKursKod() == null) || (kurs.getKursKod().trim().isEmpty())) {
			facesContext.addMessage("form:kursID", new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Felaktigt kursID", "Ange giltigt kursID!!!!!!!!!"));
		}
		return facesContext.getMessageList().isEmpty();
	}
}