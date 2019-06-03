package P1;

public class Main {
	public static void main(String[] arg){
		Reiziger r1 = new Reiziger();
		r1.setNaam("faka");
		ReizigerOracleDaolmpl.save(r1);
		for (Reiziger reiziger : ReizigerOracleDaolmpl.findAll()) {
			System.out.println(reiziger.getNaam());
		}
	}
}
