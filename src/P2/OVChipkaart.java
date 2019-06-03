package P2;

import java.sql.Date;

public class OVChipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;

	public OVChipkaart(int kn, Date g, int k, double sal, Reiziger r) {
		kaartnummer = kn;
		geldigTot = g;
		klasse = k;
		saldo = sal;
		reiziger = r;
	}
	
	public void setReiziger(Reiziger rz) {
		reiziger = rz;
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

	public int getReizigerId() {
		return reiziger.getReizigerId();
	}
}