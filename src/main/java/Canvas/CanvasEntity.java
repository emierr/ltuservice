package Canvas;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Canvas", schema = "LTUServices")
//@NamedQuery(name = "query1", query = "SELECT canvasId, fNamn, eNamn, studentAnvandare FROM CanvasEntity")
public class CanvasEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "canvasID", nullable = false)
	private int canvasId;
	@Basic
	@Column(name = "fNamn", nullable = true)
	private Integer fNamn;
	@Basic
	@Column(name = "eNamn", nullable = true, length = 45)
	private String eNamn;
	@Basic
	@Column(name = "studentAnvandare", nullable = true, length = 45)
	private String studentAnvandare;

	public int getCanvasId() {
		return canvasId;
	}

	public void setCanvasId(int canvasId) {
		this.canvasId = canvasId;
	}

	public Integer getfNamn() {
		return fNamn;
	}

	public void setfNamn(Integer fNamn) {
		this.fNamn = fNamn;
	}

	public String geteNamn() {
		return eNamn;
	}

	public void seteNamn(String eNamn) {
		this.eNamn = eNamn;
	}

	public String getStudentAnvandare() {
		return studentAnvandare;
	}

	public void setStudentAnvandare(String studentAnvandare) {
		this.studentAnvandare = studentAnvandare;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final CanvasEntity that = (CanvasEntity) o;

		if (canvasId != that.canvasId) return false;
		if (!Objects.equals(fNamn, that.fNamn)) return false;
		if (!Objects.equals(eNamn, that.eNamn)) return false;
		return Objects.equals(studentAnvandare, that.studentAnvandare);
	}

	@Override
	public int hashCode() {
		int result = canvasId;
		result = 31 * result + (fNamn != null ? fNamn.hashCode() : 0);
		result = 31 * result + (eNamn != null ? eNamn.hashCode() : 0);
		result = 31 * result + (studentAnvandare != null ? studentAnvandare.hashCode() : 0);
		return result;
	}
}
