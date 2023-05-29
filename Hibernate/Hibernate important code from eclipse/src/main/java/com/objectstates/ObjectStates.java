package com.objectstates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shadab.hibernate.Certificate;
import com.shadab.hibernate.Student;

public class ObjectStates {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session sess=factory.openSession();
		
		Student st=new Student(111,"shadab khan","mumbai");
		st.setCertificate(new Certificate("kotlin","3 month"));
		//Now object is in transient state i.e not present in session as well as in database
		
		
		Transaction tx=sess.beginTransaction();
		
		sess.save(st);// it will fire insert query and will make object transition into persistent state
		//i.e now object is present in both session object and in database;
		
		st.setName("tohid");
		//it will fire update query and change the name from shadab to tohid and reflect this in the database 
		//until we close session every changes will reflect on database 
		 
		
		tx.commit();
		
		 
		
		sess.close();
		//now the student object is in detached state i.e changes will not reflect on database but will be there in session object
		
		 
 		
		
	}

}
