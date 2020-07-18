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
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, tempid);
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			// Delete from both table if cascade type is all
			//if we exclude remove from cascade than it returns only instructor_details
			//session.delete(instructorDetail);
			
			
			// it remove associated link bw table
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
			
		
			
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
