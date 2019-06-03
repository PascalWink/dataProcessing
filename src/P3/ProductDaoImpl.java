package P3;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductDaoImpl extends OracleBaseDao implements ProductDao{
	
	public boolean save(Product product) {
		String beschrijving = product.getBeschrijving();
		double prijs = product.getPrijs();
		String productNaam = product.getProductNaam();
		int productNummer = product.getProductNummer();
		try {
			OracleBaseDao.getConnection();
			Statement stm = conn.createStatement();
			String saveOvQuery = "INSERT INTO PRODUCT VALUES (" + productNummer + ", '" + productNaam + "', '" + beschrijving
					+ "', " + prijs + ")";
			stm.executeQuery(saveOvQuery);
			stm.close();
			OracleBaseDao.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
		
	public boolean delete(Product product) {
		int productNummer = product.getProductNummer();
		try {
			OracleBaseDao.getConnection();
			Statement stmt = conn.createStatement();
			String deleteProductQuery = "DELETE FROM PRODUCT WHERE PRODUCTNUMMER = " + productNummer;
			stmt.executeUpdate(deleteProductQuery);
			stmt.close();
			OracleBaseDao.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
