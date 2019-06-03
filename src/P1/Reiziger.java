package P1;

import java.util.ArrayList;
import java.util.Date;

import P2.OVChipkaart;

public class Reiziger {
	private String naam;
	private Date gbdatum;
	private ArrayList<OVChipkaart> ovChipkaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger() {
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGBdatum() {
		return gbdatum;
	}

	public void setGBdatum(String datum) {
		gbdatum = java.sql.Date.valueOf(datum);
	}
	
	public void addKaarten(OVChipkaart kaart) {
		ovChipkaarten.add(kaart);
	}
	
	public ArrayList<OVChipkaart> getovChipkaarten(){
		return ovChipkaarten;
	}
}
