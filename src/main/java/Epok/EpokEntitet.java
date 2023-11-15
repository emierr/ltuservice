package Epok;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Epok", schema = "LTUServices")
public class EpokEntitet {
	private int kursId;
	private String kursKod;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "kursID", nullable = false)
	public int getKursId() {
		return kursId;
	}

	public void setKursId(int kursId) {
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
		return Objects.equals(kursKod, that.kursKod);
	}

	@Override
	public int hashCode() {
		int result = kursId;
		result = 31 * result + (kursKod != null ? kursKod.hashCode() : 0);
		return result;
	}
}
