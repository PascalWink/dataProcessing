package P2;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao {

	public ArrayList<Reiziger> findAll() throws SQLException {
		System.out.println("findAll()");
		OracleBaseDao.getConnection();
		ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
		Statement stmt = conn.createStatement(); // hiermee kunnen querys gemaakt worden
		ResultSet rs = stmt.executeQuery("SELECT * FROM reiziger");
		while (rs.next()) {
			int id = rs.getInt("REIZIGERID");
			String voorletters = rs.getString("VOORLETTERS");
			String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
			String achternaam = rs.getString("ACHTERNAAM");
			Date gebortedatum = rs.getDate("GEBORTEDATUM");
			Reiziger reiziger = new Reiziger(id, voorletters, tussenvoegsel, achternaam, gebortedatum);
			alleReizigers.add(reiziger);
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleReizigers;
	}

	// format voor de datum is nog niet hetzelfde voor de vergelijking
	public ArrayList<Reiziger> findByGBdatum(Date GBdatum) throws SQLException {
		System.out.println("findByGbDatum()");
		ArrayList<Reiziger> reizigersOpGebortedatum = new ArrayList<Reiziger>();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement(); // hiermee kunnen querys gemaakt worden
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		String gb = df.format(GBdatum);
		ResultSet rs = stmt.executeQuery("SELECT * FROM REIZIGER WHERE gebortedatum = '" + gb + "'");
		while (rs.next()) {
			int id = rs.getInt("REIZIGERID");
			String voorletters = rs.getString("VOORLETTERS");
			String tussenvoegsel = rs.getString("TUSSENVOEGSEL");
			String achternaam = rs.getString("ACHTERNAAM");
			Date gebortedatum = rs.getDate("GEBORTEDATUM");
			Reiziger reiziger = new Reiziger(id, voorletters, tussenvoegsel, achternaam, gebortedatum);
			reizigersOpGebortedatum.add(reiziger);
		}
		rs.close();
		stmt.close();
		System.out.println();
		conn.close();
		return reizigersOpGebortedatum;
	}

	public Reiziger save(Reiziger reiziger) throws SQLException {
		OracleBaseDao.getConnection();
		int reizigerId = reiziger.getReizigerId();
		String voorletters = reiziger.getVoorletters();
		String tussenvoegsel = reiziger.getTussenvoegsel();
		String achternaam = reiziger.getAchternaam();
		Date gebortedatum = reiziger.getGBdatum();
		
		DateFormat df = new SimpleDateFormat("ddMMyy");
		String gb = df.format(gebortedatum);
		String saveReizigersQuery = "INSERT INTO REIZIGER VALUES (" + reizigerId + ", '" + voorletters + "', '"
				+ tussenvoegsel + "', '" + achternaam + "', '" + gb + "')";

		Statement stmt = conn.createStatement();
		stmt.executeQuery(saveReizigersQuery);
		stmt.close();
		OracleBaseDao.closeConnection();
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		// idk wat er moet worden upgedate
		return reiziger;
	}

	public boolean delete(Reiziger reiziger) throws SQLException {
		int id = reiziger.getReizigerId();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String deleteOvQuery = "DELETE FROM OVCHIPKAART WHERE REIZIGERID = " + id;
		stmt.executeUpdate(deleteOvQuery);
		String deleteReizigerQuery = "DELETE FROM REIZIGER WHERE REIZIGERID = " + id;
		stmt.executeUpdate(deleteReizigerQuery);
		stmt.close();
		OracleBaseDao.closeConnection();
		return true;
	}
}
