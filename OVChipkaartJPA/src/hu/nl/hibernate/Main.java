package hu.nl.hibernate;

import java.sql.SQLException;

import java.text.ParseException;

public class Main {		
	public static void main(String[] args) throws SQLException, ParseException {
		
		Reiziger r1 = new Reiziger(1, "P.M.", "van", "Wink", java.sql.Date.valueOf("2005-03-21"));
		OVChipkaart ov1 = new OVChipkaart(1, java.sql.Date.valueOf("2005-03-21"), 1, 23.1, r1);
		OVChipkaart ov2 = new OVChipkaart(2, java.sql.Date.valueOf("2005-03-21"), 1, 23.1, r1);
		
		r1.setOVChipkaarten(ov1);
		r1.setOVChipkaarten(ov2);
		
        ReizigerService.getInstance().persist(r1);
	}
}
