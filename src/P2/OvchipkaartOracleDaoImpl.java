package P2;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OvchipkaartOracleDaoImpl extends OracleBaseDao {

	public static ArrayList<OVChipkaart> GetKaartenByReiziger(Reiziger reiziger) throws SQLException {
		OracleBaseDao.getConnection();
		ArrayList<OVChipkaart> alleChipkaarten = new ArrayList<OVChipkaart>();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OVCHIPKAART WHERE REIZIGERID = " + reiziger.getReizigerId());
		while (rs.next()) {
			int kaartnummer = rs.getInt("KAARTNUMMER");
			Date geldigTot = rs.getDate("GELDIGTOT");
			int klasse = rs.getInt("KLASSE");
			double saldo = rs.getDouble("SALDO");
			OVChipkaart ov = new OVChipkaart(kaartnummer, geldigTot, klasse, saldo, reiziger);
			alleChipkaarten.add(ov);
		}
		rs.close();
		stmt.close();
		OracleBaseDao.closeConnection();
		return alleChipkaarten;
	}

	public static OVChipkaart save(OVChipkaart OVChipkaart) throws SQLException {
		Date geldig = OVChipkaart.getGeldigTot();
		int kaartnummer = OVChipkaart.getKaartnummer();
		int klasse = OVChipkaart.getKlasse();
		double saldo = OVChipkaart.getSaldo();
		int id = OVChipkaart.getReizigerId();
		Statement stm = conn.createStatement();
		DateFormat d = new SimpleDateFormat("ddMMyyyy");
		String geldigTot = d.format(geldig);
		String saveOvQuery = "INSERT INTO OVCHIPKAART VALUES (" + kaartnummer + ", '" + geldigTot + "', " + klasse
				+ ", " + saldo + ", " + id + ")";
		stm.executeQuery(saveOvQuery);
		stm.close();
		return OVChipkaart;
	}
	public static boolean delete(OVChipkaart OVChipkaart) throws SQLException{
		int kaartnummer = OVChipkaart.getKaartnummer();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String deleteOvQuery = "DELETE FROM OVCHIPKAART WHERE KAARTNUMMER = " + kaartnummer;
		stmt.executeUpdate(deleteOvQuery);
		stmt.close();
		OracleBaseDao.closeConnection();
		return true;
	}
}
