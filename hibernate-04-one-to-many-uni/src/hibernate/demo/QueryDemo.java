package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Student;

public class QueryDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int tempid=6;
			
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, tempid);
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			
		
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
