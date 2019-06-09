package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      
	  //de factory wordt aangemaakt
	  try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }
	  //de session en transaction  worden aangemaakt
      Session session = factory.openSession();
      Transaction t = session.beginTransaction();

      //voorbeeld van school
      Log log = new Log(2,"Hibernate works!");
      session.save(log);
      
      //insert () Create
      Employee employee = new Employee(2, "Pascal", "Wink");
      session.save(employee);
      //Read
      Query query = session.createQuery("from Employee");
      java.util.List list = query.list();
      System.out.println(list);

      //Update kan ook met session.saveOrUpdate gedaan worden
      Employee employee1 = new Employee(1, "Jasper", "wink");
      session.update(employee1);
      //delete van CRUD
      session.delete(employee);
      t.commit(); 
     
      factory.close();  
      session.close();   
  	}
}
