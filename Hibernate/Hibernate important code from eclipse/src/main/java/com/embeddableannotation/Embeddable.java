package com.embeddableannotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shadab.hibernate.Certificate;
import com.shadab.hibernate.Student;

public class Embeddable {

	public static void main(String[] args) {
 		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Student st=new Student();
		st.setCity("mumbai");
		st.setId(1);
		st.setName("oikawa");
		Certificate ct=new Certificate();
		ct.setCourse("Volleyball");
		ct.setDuration("20 hr");
		st.setCertificate(ct);
		
		 
		Transaction tx=session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
		
	}

}
