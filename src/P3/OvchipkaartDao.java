package P3;

import java.util.ArrayList;

public interface OvchipkaartDao {
	public boolean delete(OVChipkaart ovchipkaart);

	public boolean deleteKaarten(Reiziger reiziger);
	
	public ArrayList<OVChipkaart> getKaartenByReiziger(Reiziger reiziger);

	public boolean saveKaart(OVChipkaart ovChipkaart);
	
	public boolean saveKaarten(Reiziger reiziger);
}
