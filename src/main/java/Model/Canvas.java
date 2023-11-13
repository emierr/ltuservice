package Model;

import java.util.Date;

public class Canvas {
	public String betyg;
	public Date examinationsdatum;
}
CanvasQuery =
	"SELECT Betyg, Examinationsdatum
	+ "FROM Canvas
	+ "WHERE Canvas.StudentId = ";
