package P3;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OVChipkaart_productDaoImpl extends OracleBaseDao implements OVChipkaart_productDao {
	private static int OVProductId;

	public boolean saveOvProducten(OVChipkaart OVChipkaart) {
		for (Product product : OVChipkaart.getProducten()) {
			int productNummer = product.getProductNummer();
			int kaartNummer = OVChipkaart.getKaartnummer();
			OVProductId += 1;
			try {
				OracleBaseDao.getConnection();
				Statement stm = conn.createStatement();
				// create a java calendar instance
				Calendar calendar = Calendar.getInstance();
				java.util.Date currentDate = calendar.getTime();
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				DateFormat d = new SimpleDateFormat("ddMMyyyy");
				String nu = d.format(date);
				String saveOvQuery = "INSERT INTO OVCHIPKAART_PRODUCT VALUES (" + OVProductId + ", " + kaartNummer + ", " + productNummer
						+ ", '" + "idk" + "', '" + nu + "')";
				stm.executeQuery(saveOvQuery);
				stm.close();
				OracleBaseDao.closeConnection();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteOvProducten(OVChipkaart ovChipkaart) {
		int kaartnummer = ovChipkaart.getKaartnummer();
		try {
			OracleBaseDao.getConnection();
			Statement stm = conn.createStatement();
			String deleteOvQuery = "DELETE FROM OVCHIPKAART_PRODUCT WHERE KAARTNUMMER = " + kaartnummer;
			stm.executeQuery(deleteOvQuery);
			stm.close();
			OracleBaseDao.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
