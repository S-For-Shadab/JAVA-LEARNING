package com.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.resources.FactoryProvider;

public class UpdateQuery {

	public static void main(String[] args) {
		SessionFactory factory=FactoryProvider.getFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery("update Question set question=:ques where qid=:id");
		q.setParameter("ques", "what is python can you explain with reference with software development");
		q.setParameter("id", 5);

		int r=q.executeUpdate();
		System.out.println(r+"  "+"is updated");
		
		tx.commit();
		sess.close();
	}

}
