package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Student;

public class CreateCoursesDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			 
			int tempId=1;
			Instructor instructor = session.get(Instructor.class, tempId);
			
			Course course1 = new Course("Java1");
			Course course2 = new Course("Java2");
			
			instructor.add(course1);
			instructor.add(course2);
			
			
			session.save(course1);
			session.save(course2);
			//session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
