package P3;

import java.sql.Date;
import java.util.ArrayList;

public interface ReizigerDao {
	public boolean delete(Reiziger reiziger);

	public ArrayList<Reiziger> findAll();

	public ArrayList<Reiziger> findByGBdatum(Date date);

	public Reiziger save(Reiziger reiziger);
}
