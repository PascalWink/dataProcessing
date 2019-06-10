package hu.nl.hibernate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "REIZIGER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "REIZIGERID")
})
public class Reiziger {
	@Id
	@Column(name = "REIZIGERID")
	private int reizigerId;
	
	@Column(name = "VOORLETTERS", nullable = false)
	private String voorletters;
	
	@Column(name = "TUSSENVOEGSEL", nullable = false)
	private String tussenvoegsel;
	
	@Column(name = "ACHTERNAAM", nullable = false)
	private String achternaam;
	
	@Column(name = "GEBORTEDATUM", nullable = false)
	private Date gebortedatum;
	
    @OneToMany(targetEntity = OVChipkaart.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="reiziger")
	private List<OVChipkaart> OVChipkaarten= new ArrayList<OVChipkaart>();

	public Reiziger() {

	};

	public Reiziger(int id, String vl, String tv, String an, Date gb) {
		reizigerId = id;
		voorletters = vl;
		tussenvoegsel = tv;
		achternaam = an;
		gebortedatum = gb;
	}

	public void setOVChipkaarten(OVChipkaart ov) {
		OVChipkaarten.add(ov);
	}

	public List<OVChipkaart> getOVChipkaarten() {
		return OVChipkaarten;
	}

	public int getReizigerId() {
		return reizigerId;
	}

	public void setReizigerId(int id) {
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

	public Date getGebortedatum() {
		return gebortedatum;
	}

	public void setGebortedatum(Date datum) {
		gebortedatum = datum;
	}
}
