package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Student;

public class CreateInstructorDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("create Object");
			
			Instructor instructor = new Instructor("Sunil55" , "Kumar55" , "suniljakhal55.skj@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("channel55" , "Listening song 55");
			
			session.beginTransaction();
			
			instructor.setInstructorDetail(instructorDetail);
			
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
