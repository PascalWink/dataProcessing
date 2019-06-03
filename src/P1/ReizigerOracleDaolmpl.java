package P1;

import java.sql.Date;
import java.util.ArrayList;


public class ReizigerOracleDaolmpl implements ReizigerDao{
	private static ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
	
	public static ArrayList<Reiziger> findAll(){
		return reizigers;
	}
	
	public static Reiziger save(Reiziger reiziger){
		reizigers.add(reiziger);
		return reiziger;
	}
	
	//format voor de datum is nog niet hetzelfde voor de vergelijking
	public static ArrayList<Reiziger> findByGBdatum(Date GBdatum){
		ArrayList<Reiziger> reizigersMetDatum = new ArrayList<Reiziger>();
		for (int i = 0; i < reizigers.size(); i++) {
			Reiziger reiziger = reizigers.get(i);
			if (reiziger.getGBdatum().equals(GBdatum)) {
				reizigersMetDatum.add(reiziger);
			}
		}
		return reizigersMetDatum;
	}
		
	//geen idee wat hij moet updaten
	public static Reiziger update(Reiziger reiziger) {
		for (int i = 0; i < reizigers.size(); i++) {
			if (reizigers.get(i).getNaam().equals(reiziger.getNaam()) && 
					reizigers.get(i).getGBdatum().equals(reiziger.getGBdatum())) {
				return reiziger;
			}
		}
		return reiziger;
	}
	
	public static boolean delete(Reiziger reiziger) {
		for (int i = 0; i < reizigers.size(); i++) {
			if (reizigers.get(i).getNaam().equals(reiziger.getNaam()) && reizigers.get(i).getGBdatum().equals(reiziger.getGBdatum())) {
				reizigers.remove(i);
				Reiziger r = reizigers.get(i);
				r = null;
				return true;
			}
		}
		return false;
	}
}
