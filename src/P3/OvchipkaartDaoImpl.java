package P3;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OvchipkaartDaoImpl extends OracleBaseDao implements OvchipkaartDao {
	
	public ArrayList<OVChipkaart> getKaartenByReiziger(Reiziger reiziger) {
		ArrayList<OVChipkaart> alleChipkaarten = new ArrayList<OVChipkaart>();
		try {
			OracleBaseDao.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM OVCHIPKAART WHERE REIZIGERID = " + reiziger.getReizigerId());
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alleChipkaarten;
	}

	public boolean saveKaart(OVChipkaart OVChipkaart) {
		Date geldig = OVChipkaart.getGeldigTot();
		int kaartnummer = OVChipkaart.getKaartnummer();
		int klasse = OVChipkaart.getKlasse();
		double saldo = OVChipkaart.getSaldo();
		int id = OVChipkaart.getReizigerId();
		try {
			OracleBaseDao.getConnection();
			Statement stm = conn.createStatement();
			DateFormat d = new SimpleDateFormat("ddMMyyyy");
			String geldigTot = d.format(geldig);
			String saveOvQuery = "INSERT INTO OVCHIPKAART VALUES (" + kaartnummer + ", '" + geldigTot + "', " + klasse
					+ ", " + saldo + ", " + id + ")";
			stm.executeQuery(saveOvQuery);
			stm.close();
			OracleBaseDao.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveKaarten(Reiziger reiziger) {
		ArrayList<OVChipkaart> OVChipkaarten = reiziger.getOVChipkaarten();
		for (OVChipkaart OVChipkaart : OVChipkaarten) {
			System.out.println(OVChipkaart.getKaartnummer());
			Date geldig = OVChipkaart.getGeldigTot();
			int kaartnummer = OVChipkaart.getKaartnummer();
			int klasse = OVChipkaart.getKlasse();
			double saldo = OVChipkaart.getSaldo();
			int id = OVChipkaart.getReizigerId();
			Statement stm;
			try {
				OracleBaseDao.getConnection();
				stm = conn.createStatement();
				DateFormat d = new SimpleDateFormat("ddMMyyyy");
				String geldigTot = d.format(geldig);
				String saveOvQuery = "INSERT INTO OVCHIPKAART VALUES (" + kaartnummer + ", '" + geldigTot + "', "
						+ klasse + ", " + saldo + ", " + id + ")";
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

	public boolean delete(OVChipkaart OVChipkaart) {
		int kaartnummer = OVChipkaart.getKaartnummer();
		try {
			OracleBaseDao.getConnection();
			Statement stmt = conn.createStatement();
			String deleteOvQuery = "DELETE FROM OVCHIPKAART WHERE KAARTNUMMER = " + kaartnummer;
			stmt.executeUpdate(deleteOvQuery);
			stmt.close();
			OracleBaseDao.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteKaarten(Reiziger reiziger) {
		for (OVChipkaart OVChipkaart : reiziger.getOVChipkaarten()) {
			int kaartnummer = OVChipkaart.getKaartnummer();
			try {
				OracleBaseDao.getConnection();
				Statement stmt = conn.createStatement();
				String deleteOvQuery = "DELETE FROM OVCHIPKAART WHERE KAARTNUMMER = " + kaartnummer;
				stmt.executeUpdate(deleteOvQuery);
				stmt.close();
				OracleBaseDao.closeConnection();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
