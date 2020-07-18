package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Review;
import hibernate.entity.classs.Student;

public class CreateCoursesAndStudentsDemo {

	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
	session.beginTransaction();
			
			Course tempCourse = new Course("How to Score One millions point");
			
			session.save(tempCourse);
			
			Student tempStudent1 = new Student("Sunil1","kumar1","sunil1@gmail.com");
			Student tempStudent2 = new Student("Sunil2","kumar2","sunil2@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
