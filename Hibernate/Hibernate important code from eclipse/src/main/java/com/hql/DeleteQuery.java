package com.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.resources.FactoryProvider;

public class DeleteQuery {

	public static void main(String[] args) {
		SessionFactory factory=FactoryProvider.getFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery("delete from Question where qid=:c");
		q.setParameter("c", 2);
		int r=q.executeUpdate();
		
		tx.commit();
		sess.close();
	}

}
