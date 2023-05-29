package com.manytomanymapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingAnnotation {

	public static void main(String[] args) {
		 
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		
		Question q1=new Question();
		q1.setQid(4);
		q1.setQuestion("what is java???");
		
		Question q2=new Question();
		q2.setQid(5);
		q2.setQuestion("what is python???");
		 
		
		Answer a1=new Answer();
		a1.setAid(104);
		a1.setAnswer("Java is an oop language!");
 		
		Answer a2=new Answer();
		a2.setAid(105);
		a2.setAnswer("Its is used for developing enterprise edition software");
 		
		Answer a3=new Answer();
		a3.setAid(106);
		a3.setAnswer("It is used in machine learning application!");
		
 		List<Answer> ans=new ArrayList<Answer>();
 		List<Answer> ans1=new ArrayList<Answer>();

		ans.add(a1);
		ans.add(a2);
		ans1.add(a3);
		
		
 		q1.setAnswers(ans);
 		q2.setAnswers(ans1);
 		
 		List<Question> q=new ArrayList<Question>();
 		q.add(q2);
 		
 		a1.setQuestion(q);
 		a2.setQuestion(q);
 		a3.setQuestion(q);
 		
		
		sess.save(a1);
		sess.save(a2);
		sess.save(a3);
		 
		sess.save(q1);
		sess.save(q2);
		 
		tx.commit();
		 
 

		 
		sess.close();
		
		
		 
		

	}

}
