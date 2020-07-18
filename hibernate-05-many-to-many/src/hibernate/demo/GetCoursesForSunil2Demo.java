package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Review;
import hibernate.entity.classs.Student;

public class GetCoursesForSunil2Demo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int studentId = 2;
			Student student = session.get(Student.class, studentId);

			System.out.println(student);
			System.out.println(student.getCourse());
		

			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
