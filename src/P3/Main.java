package P3;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] arg) throws SQLException{		
		//maak de DAO objecten
		OvchipkaartDaoImpl ovChipkaartDao = new OvchipkaartDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		ReizigerDaoImpl reizigerDao = new ReizigerDaoImpl();
		OVChipkaart_productDaoImpl ovChipkaartProduct = new OVChipkaart_productDaoImpl();
		
		//maakt producten aan
		Product standaartProduct = new Product(1, "standaart", "normale tarieven", 20);
		Product studentenProduct = new Product(2, "studentenReisproduct", "studenten krijgen korting", 0.0);
		Product ouderenProduct = new Product(3, "ouderenProduct", "ouderen krijgen korting", 0.0);
		productDao.save(standaartProduct);
		productDao.save(ouderenProduct);
		productDao.save(studentenProduct);
		
		//maakt reizigers aan
		Reiziger r2 = new Reiziger(2, "A", null, "Andonova", java.sql.Date.valueOf( "2000-08-24" ));
		reizigerDao.save(r2);
		Reiziger r3 = new Reiziger(3, "m", "van", "wisadnk", java.sql.Date.valueOf( "2005-03-21" ));
		reizigerDao.save(r3);
		Reiziger r4 = new Reiziger(4, "p", "den", "asd", java.sql.Date.valueOf( "2009-01-25" ));
		reizigerDao.save(r4);
		Reiziger r5 = new Reiziger(5, "z", null, "arthur", java.sql.Date.valueOf( "2009-02-05" ));
		reizigerDao.save(r5);

		//maakt ov kaarten aan
			//geeft reiziger 2 kaarten
		OVChipkaart ov2 = new OVChipkaart(2, java.sql.Date.valueOf( "2019-09-14" ), 1, 0.00, r2);
		OVChipkaart ov3 = new OVChipkaart(3, java.sql.Date.valueOf( "2039-10-24" ), 1, 0.00, r2);
		OVChipkaart ov4 = new OVChipkaart(4, java.sql.Date.valueOf( "2029-09-24" ), 1, 0.00, r2);
		ov2.addProduct(studentenProduct);
		ov2.addProduct(standaartProduct);
		ov3.addProduct(standaartProduct);
		ov4.addProduct(ouderenProduct);
		ov2.addProduct(standaartProduct);
		r2.addOVChipkaart(ov2);
		r2.addOVChipkaart(ov3);
		r2.addOVChipkaart(ov4);
		ovChipkaartDao.saveKaart(ov2);
		ovChipkaartDao.saveKaart(ov3);
		ovChipkaartDao.saveKaart(ov4);
		ovChipkaartProduct.saveOvProducten(ov2);
		ovChipkaartProduct.saveOvProducten(ov3);
		ovChipkaartProduct.saveOvProducten(ov4);
			//geeft reiziger 3 kaarten
		OVChipkaart ov5 = new OVChipkaart(5, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r3);	
		OVChipkaart ov6 = new OVChipkaart(6, java.sql.Date.valueOf( "2020-10-23" ), 2, 0.00, r3);
		ov5.addProduct(standaartProduct);
		ov5.addProduct(standaartProduct);
		ov6.addProduct(ouderenProduct);
		r3.addOVChipkaart(ov5);
		r3.addOVChipkaart(ov6);
		ovChipkaartDao.saveKaart(ov5);
		ovChipkaartDao.saveKaart(ov6);
		ovChipkaartProduct.saveOvProducten(ov5);
		ovChipkaartProduct.saveOvProducten(ov6);
			//geeft reiziger 4 kaarten
		OVChipkaart ov7 = new OVChipkaart(7, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r4);		
		OVChipkaart ov8 = new OVChipkaart(8, java.sql.Date.valueOf( "2020-10-23" ), 1, 0.00, r4);
		ov7.addProduct(standaartProduct);
		ov8.addProduct(studentenProduct);
		r4.addOVChipkaart(ov7);
		r4.addOVChipkaart(ov8);
		ovChipkaartDao.saveKaart(ov8);
		ovChipkaartDao.saveKaart(ov7);
		ovChipkaartProduct.saveOvProducten(ov7);
		ovChipkaartProduct.saveOvProducten(ov8);

		for (Reiziger reiziger : reizigerDao.findAll()){
			System.out.println("reiziger "+reiziger.getReizigerId());
			for (OVChipkaart ov : reiziger.getOVChipkaarten()) {
				System.out.println(ov.getKaartnummer());
			}
		}

		for (Reiziger reiziger : reizigerDao.findByGBdatum(r4.getGBdatum())){
			System.out.println("OV's van de reiziger "+reiziger.getReizigerId());
			for (OVChipkaart ov : reiziger.getOVChipkaarten()) {
				System.out.println(ov.getKaartnummer());
			}
		}
	}
}
