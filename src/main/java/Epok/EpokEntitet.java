package Epok;

import jakarta.persistence.*;

@Entity
@Table(name = "Epok", schema = "LTUServices")
public class EpokEntitet {
	private String kursId;
	private String kursKod;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "kursID", nullable = false)
	public String getKursId() {
		return kursId;
	}

	public void setKursId(String kursId) {
		this.kursId = kursId;
	}

	@Basic
	@Column(name = "kursKod", nullable = true, length = 45)
	public String getKursKod() {
		return kursKod;
	}

	public void setKursKod(String kursKod) {
		this.kursKod = kursKod;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final EpokEntitet that = (EpokEntitet) o;

		if (kursId != that.kursId) return false;
		if (kursKod != null ? !kursKod.equals(that.kursKod) : that.kursKod != null) return false;

		return true;
	}

/*	@Override
	public int hashCode() {
		String result = kursId;
		result = 31 * result + (kursKod != null ? kursKod.hashCode() : 0);
		return result;
	}*/
}
