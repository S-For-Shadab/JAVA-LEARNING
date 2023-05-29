package com.mappingdemo;

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
		q1.setQid(1);
		q1.setQuestion("what is java???");
		 
		
		Answer a1=new Answer();
		a1.setAid(101);
		a1.setAnswer("Java is an oop language!");
		a1.setQuestion(q1);
		
		Answer a2=new Answer();
		a2.setAid(102);
		a2.setAnswer("Its is used for developing enterprise edition software");
		a2.setQuestion(q1);
		
		Answer a3=new Answer();
		a3.setAid(103);
		a3.setAnswer("it is the most leading software programming language");
		a3.setQuestion(q1);
		List<Answer> ans=new ArrayList<Answer>();
		ans.add(a1);
		ans.add(a2);
		ans.add(a3);
		q1.setAnswers(ans);
		
		sess.save(a1);
		sess.save(a2);
		sess.save(a3);
		 
		sess.save(q1); 
		 
		tx.commit();
		Question qqq=(Question)sess.get(Question.class, 1);
		System.out.println(qqq.getQuestion());
		for(Answer a:qqq.getAnswers()) {
			System.out.println(a.getAnswer());
		}
 

		 
		sess.close();
		
		
		 
		

	}

}
