package P6;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
	public static void main(String[] arg) throws SQLException{		
		Reiziger r2 = new Reiziger(2, "A", null, "Andonova", java.sql.Date.valueOf( "2000-08-24" ));
		OVChipkaart ov2 = new OVChipkaart(2, java.sql.Date.valueOf( "2019-09-14" ), 1, 0.00, r2);
		OVChipkaart ov3 = new OVChipkaart(3, java.sql.Date.valueOf( "2039-10-24" ), 1, 0.00, r2);
		OVChipkaart ov4 = new OVChipkaart(4, java.sql.Date.valueOf( "2029-09-24" ), 1, 0.00, r2);
		r2.addOVChipkaart(ov2);
		r2.addOVChipkaart(ov3);
		r2.addOVChipkaart(ov4);
		ReizigerOracleDaolmpl.save(r2);
		
		Reiziger r3 = new Reiziger(3, "m", "van", "wisadnk", java.sql.Date.valueOf( "2005-03-21" ));
		OVChipkaart ov5 = new OVChipkaart(5, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r3);	
		OVChipkaart ov6 = new OVChipkaart(6, java.sql.Date.valueOf( "2020-10-23" ), 2, 0.00, r3);		
		r3.addOVChipkaart(ov5);
		r3.addOVChipkaart(ov6);
		ReizigerOracleDaolmpl.save(r3);
		
		Reiziger r4 = new Reiziger(4, "p", "den", "asd", java.sql.Date.valueOf( "2009-01-25" ));
		OVChipkaart ov7 = new OVChipkaart(7, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r4);		
		OVChipkaart ov8 = new OVChipkaart(8, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r4);
		r4.addOVChipkaart(ov7);
		r4.addOVChipkaart(ov8);
		ReizigerOracleDaolmpl.save(r4);
		
		Reiziger r5 = new Reiziger(5, "z", null, "arthur", java.sql.Date.valueOf( "2009-02-05" ));
		ReizigerOracleDaolmpl.save(r5);
		
		ReizigerOracleDaolmpl.delete(r3);
		
		for (Reiziger reiziger : ReizigerOracleDaolmpl.findAll()){
			System.out.println("OV's van de reiziger "+reiziger.getReizigerId());
			for (OVChipkaart ov : reiziger.getOVChipkaarten()) {
				System.out.println(ov.getKaartnummer());
			}
		}
		Date datumR3 = r4.getGBdatum();
		for (Reiziger reiziger : ReizigerOracleDaolmpl.findByGBdatum(datumR3)){
			System.out.println("OV's van de reiziger "+reiziger.getReizigerId());
			for (OVChipkaart ov : reiziger.getOVChipkaarten()) {
				System.out.println(ov.getKaartnummer());
			}
		}
	}
}
