package P2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OVChipkaartDao {
	public boolean delete(OVChipkaart ovchipkaart) throws SQLException;

	public ArrayList<OVChipkaart> GetKaartenByReiziger(Reiziger reiziger) throws SQLException;

	public OVChipkaart save(OVChipkaart ovchipkaart) throws SQLException;
}
