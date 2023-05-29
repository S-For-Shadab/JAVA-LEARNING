package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mappingdemo.Question;
import com.resources.FactoryProvider;

public class SelectQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=FactoryProvider.getFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		//>>>>>>>>>>first query
//		String query="from Answer";
//		Query q=sess.createQuery(query);
//		List<Answer> list=q.getResultList();
//		for(Answer a:list) {
//			System.out.println(a.getAnswer()+"   "+a.getAid());
//		}
		
		//>>>>>>> second query
		
		String query1="from Question q1 where q1=:id";
		
		Query q1=sess.createQuery(query1);
  		
		List<Question> list1=q1.list();
		for(Question a:list1) {
			System.out.println(a.getQuestion()+"   "+a.getQid());
		}
		sess.close();
		FactoryProvider.closeFactory();
	}

}
