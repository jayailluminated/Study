package com.roadrantz.dao.hibernate;

import com.roadrantz.dao.RantDao;
import com.roadrantz.domain.Motorist;
import com.roadrantz.domain.Rant;
import com.roadrantz.domain.Vehicle;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Date;
import java.util.List;

/**
 * Hibernate-based implementation of the RantDao interface.
 * <p/>
 * Initially defined in Listing 5.8. But the initial implementation of
 * HibernateRantDao evolves in section 5.4.3 to extend HibernateDaoSupport.
 * <p/>
 * If you're looking for the version from section 5.4.2, have a look at
 * HibernateRantDaoUsingTemplate.java.
 *
 * @author wallsc
 */
public class HibernateRantDao extends HibernateDaoSupport implements RantDao {

	private static final String MOTORIST = Motorist.class.getName();
	private static final String RANT = Rant.class.getName();
	private static final String VEHICLE = Vehicle.class.getName();

	public HibernateRantDao () {
	}

	public Vehicle findVehicleByPlate (String state, String plateNumber) {
		List results = getHibernateTemplate()
				.find(
						"from "
						+ VEHICLE
						+ " where state = ? and plateNumber = ?",
						new Object[] {state, plateNumber});

		if (results.size() > 0) {
			return (Vehicle) results.get(0);
		}

		return null; // TODO - Should I throw an exception instead?
	}

	public List<Rant> getAllRants () {
		return getHibernateTemplate().find("from " + RANT);
	}

	public Motorist getMotoristByEmail (String email) {
		List results = getHibernateTemplate().find(
				"from " + MOTORIST + " where email = ?", email);

		if (results.size() > 0) {
			return (Motorist) results.get(0);
		}
		return null; // TODO - Should I throw an exception instead?
	}

	public void saveRant (Rant rant) {
		getHibernateTemplate().saveOrUpdate(rant);
	}

	public void saveVehicle (Vehicle vehicle) {
		getHibernateTemplate().saveOrUpdate(vehicle);
	}

	public List<Rant> getRantsForDay (Date day) {
		return getHibernateTemplate().find("from " + RANT + " where postedDate = ?", day);
	}


	//getRantsForDay() using cache :
	// if you use  ?Spring Modules Cache.?
	// Your code will not change

	//public List<Rant> getRantsForDay(Date day) {
	//	List<Rant> cacheResult = rantCache.lookup("getRantsForDay", day);
	//	if(cachedResult != null) {
	//		return cacheResult;
	//	}
	//	cacheResult = getHibernateTemplate().find("fron "+ RANT + " where postedDate = ?", day);
	//	rantCache.store("getRantsForDay", day, cachedResult);
	//	return cacheResult;
	//}


	public void saveMotorist (Motorist driver) {
		getHibernateTemplate().saveOrUpdate(driver);
	}

	public Motorist getDriverById (Integer id) {
		return (Motorist) getHibernateTemplate().load(Motorist.class, id);
	}

	public int getMotoristCount () {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Motorist getMotoristById (long l) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
