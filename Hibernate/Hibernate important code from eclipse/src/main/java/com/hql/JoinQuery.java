package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.resources.FactoryProvider;

public class JoinQuery {

	public static void main(String[] args) {
		SessionFactory factory=FactoryProvider.getFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery("select q.question,q.qid,a.answer from Question as q INNER JOIN q.answers as a");
		
		List<Object[]> list=q.getResultList();
		for(Object[] arr:list) {
			System.out.println(Arrays.toString(arr));
		}
	}

}
