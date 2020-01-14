package com.ouhamza.hebr.demoJPA;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentName name = new StudentName();
    	name.setFname("OUHAMZA");
    	name.setLname("Lhouceine");
    	
    	Book book = new Book();
    	book.setId(1L);
    	book.setName("Laravel");

    	Student std = new Student();
		std.setId(101L); 
		std.setNom(name); 
		std.setEmail("ouhamza@gmail.com");
		std.getBook().add(book);
		  
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	con.addAnnotatedClass(Book.class);
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	//s.save(std);
    	//s.save(book);
    	//std = (Student) session.get(Student.class, 101L);
    	Query q1 = session.createQuery("from Student where id=101");
    	q1.setCacheable(true);
    	std = (Student) q1.uniqueResult();
    	System.out.println(std);
    	tx.commit();
        session.close();
    	
	    Session session2 = sf.openSession();
    	Transaction tx2 = session2.beginTransaction();
    	//std = (Student) session2.get(Student.class, 101L);
		
    	/*
		 * Query q2 = session2.createQuery("from Student where id=101");
		 * q2.setCacheable(true); std = (Student) q2.uniqueResult();
		 * System.out.println(std);
		 */
    	Query query = session2.createQuery("from Student");
    	List<Student> students = query.list();
    	for(Student s : students) {
    		System.out.println(s);
    	}
    	
    	
    	tx2.commit();
    	session2.close();
    	
    	
    	
    }
}
