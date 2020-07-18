package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Student;

public class DeleteDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int tempid=6;
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, tempid);
			if(instructor!=null)
			session.delete(instructor);
			
			
		
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
	}
}
