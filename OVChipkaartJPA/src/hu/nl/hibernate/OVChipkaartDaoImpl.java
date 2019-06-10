package hu.nl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OVChipkaartDaoImpl {
	 private Session currentSession;
	    private Transaction currentTransaction;

	    public Session openCurrentSession() {
	        currentSession = Hibernate.getSessionFactory().openSession();
	        return currentSession;
	    }

	    public Session openCurrentSessionwithTransaction() {
	        currentSession = Hibernate.getSessionFactory().openSession();
	        currentTransaction = currentSession.beginTransaction();
	        return currentSession;
	    }

	    public void closeCurrentSession() {
	        currentSession.close();
	    }

	    public void closeCurrentSessionwithTransaction() {
	        currentTransaction.commit();
	        currentSession.close();
	    }

	    public Session getCurrentSession() {
	        return currentSession;
	    }

	    public void setCurrentSession(Session currentSession) {
	        this.currentSession = currentSession;
	    }

	    public Transaction getCurrentTransaction() {
	        return currentTransaction;
	    }

	    public void setCurrentTransaction(Transaction currentTransaction) {
	        this.currentTransaction = currentTransaction;
	    }

	    public void persist(OVChipkaart entity) {
	        getCurrentSession().save(entity);
	    }

	    public void update(OVChipkaart entity) {
	        getCurrentSession().update(entity);
	    }

	    public OVChipkaart findById(int id) {
	        return getCurrentSession().get(OVChipkaart.class, id);
	    }

	    public void delete(OVChipkaart entity) {
	        getCurrentSession().delete(entity);
	    }

}