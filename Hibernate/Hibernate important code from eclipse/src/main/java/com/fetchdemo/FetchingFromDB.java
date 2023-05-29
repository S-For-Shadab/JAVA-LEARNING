package com.fetchdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shadab.hibernate.Student;

public class FetchingFromDB {

	public static void main(String[] args) {
		//Using get() and load() function provided from hibernate
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session sess=factory.openSession();
		
		Student st=(Student)sess.get(Student.class, 109);
		System.out.println(st.toString());
		
		
		 
	}

}
