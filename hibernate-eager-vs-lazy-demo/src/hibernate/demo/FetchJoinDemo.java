package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Student;

public class FetchJoinDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			 
			int tempId=1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId",Instructor.class);
			
			query.setParameter("theInstructorId", tempId);
			Instructor instructor = query.getSingleResult();
			System.out.println("instructor "+instructor);
			
			
			
			session.getTransaction().commit();
			System.out.println("instructor.getCourses() "+instructor.getCourses());
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
