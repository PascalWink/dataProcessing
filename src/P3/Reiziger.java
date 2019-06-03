package P3;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
	private ArrayList<OVChipkaart> OVChipkaarten = new ArrayList<OVChipkaart>();
	private int reizigerId;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;

	public Reiziger(int id, String vl, String tv, String an, Date gb) {
		reizigerId = id;
		voorletters = vl;
		tussenvoegsel = tv;
		achternaam = an;
		gbdatum = gb;
	}

	public void addOVChipkaart(OVChipkaart ov) {
		OVChipkaarten.add(ov);
	}
	
	public ArrayList<OVChipkaart> getOVChipkaarten() {
		return OVChipkaarten;
	}
	
	public int getReizigerId() {
		return reizigerId;
	}

	public void setReizigersId(int id) {
		reizigerId = id;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String vl) {
		voorletters = vl;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String ts) {
		tussenvoegsel = ts;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String an) {
		achternaam = an;
	}

	public Date getGBdatum() {
		return gbdatum;
	}

	public void setGBdatum(Date datum) {
		gbdatum = datum;
	}


}
