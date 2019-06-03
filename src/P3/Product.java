package P3;


public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	
	public Product(int pn, String nm, String bes, double pr) {
		productNummer = pn;
		productNaam = nm;
		beschrijving = bes;
		prijs = pr;	}

	public int getProductNummer() {
		return productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setProductNaam(String nm) {
		productNaam = nm;
	}
	
	public void setBeschrijving(String bs) {
		beschrijving = bs;
	}
	public void setPrijs(double pr) {
		prijs = pr;
	}
}
