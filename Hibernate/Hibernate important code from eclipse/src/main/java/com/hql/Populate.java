package com.hql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.github.javafaker.Faker;
import com.mappingdemo.Answer;
import com.mappingdemo.Question;

public class Populate {

	public static void main(String[] args) {

		// This class is to put random values of question and answer in database;

		Faker faker = new Faker();
		Question q1 = new Question();
		q1.setQid(new Random().nextInt(1000));
		q1.setQuestion(faker.lorem().sentence());

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();

		List<Answer> list = new ArrayList<Answer>();
		for (int i = 0; i < 3; i++) {
			Answer ans = new Answer();
			ans.setAid(new Random().nextInt(1000));
			ans.setAnswer(faker.lorem().sentence());
			ans.setQuestion(q1);
			sess.save(ans);

		}
		q1.setAnswers(list);

		sess.save(q1);
		tx.commit();
		sess.close();
		factory.close();

	}

}
