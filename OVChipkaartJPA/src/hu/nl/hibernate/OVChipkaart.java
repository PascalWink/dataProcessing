package hu.nl.hibernate;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "OVCHIPKAART", uniqueConstraints = {
        @UniqueConstraint(columnNames = "KAARTNUMMER")
})
public class OVChipkaart {
	@Id
	@Column(name = "KAARTNUMMER")
	private int kaartnummer;
	
	@Column(name = "GELDIGTOT", nullable = false)
	private Date geldigTot;
	
	@Column(name = "KLASSE", nullable = false)
	private int klasse;
	
	@Column(name = "SALDO", nullable = false)
	private double saldo;
    
	@ManyToOne(targetEntity = Reiziger.class, cascade = CascadeType.ALL)
    @JoinColumn(name="REIZIGERID", nullable=false)
	private Reiziger reiziger;

	public OVChipkaart() {
	}

	public OVChipkaart(int kn, Date g, int k, double sal, Reiziger ri) {
		kaartnummer = kn;
		geldigTot = g;
		klasse = k;
		saldo = sal;
		reiziger = ri;
	}

	public void setKaartnummer(int nr) {
		kaartnummer = nr;
	}

	public int getKaartnummer() {
		return kaartnummer;
	}

	public void setGeldigTot(Date gt) {
		geldigTot = gt;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setKlasse(int k) {
		klasse = k;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setSaldo(double sal) {
		saldo = sal;
	}

	public double getSaldo() {
		return saldo;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger rz) {
		reiziger = rz;
	}
}
