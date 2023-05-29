package com.shadab.hibernate;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App  
    
{
	public static void main(String[] args) throws IOException {
		System.out.println("Project started..."); 
		//-----part1---------------
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Creating student object------
 		Student st=new Student(109,"touhid","mumbai");
// 		Adress ad=new Adress();
// 		ad.setAdressid(101);
// 		ad.setAddedDate(new Date());
// 		ad.setCity("lucknow");
// 		ad.setOpen(false);
// 		ad.setX(1.0);
// 		
// 		//Reading image
// 		FileInputStream fis=new FileInputStream("src/main/java/ac.jpg");
// 		byte[] data=new byte[fis.available()];
// 		fis.read(data);
// 		ad.setImage(data);
 		
 		//session and transcation---------------
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(st);
		tx.commit();
		session.close();
		
		

	}
     
}
