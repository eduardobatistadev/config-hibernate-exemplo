package com.qintess.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.qintess.hibernate.model.Student;
import com.qintess.hibernate.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Student student = new Student("Eduardo", "Batista", "dueduardoful@gmail.com");
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			
			// start transaction
			transaction = session.beginTransaction();
			// salvar o objeto student
			session.save(student);
			// commit transaction
			transaction.commit();
		}
		catch(Exception e) {
			if(transaction != null) {
					transaction.rollback();
			}
		}

	}

}
