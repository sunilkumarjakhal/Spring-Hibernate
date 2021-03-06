package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.classs.Course;
import hibernate.entity.classs.Instructor;
import hibernate.entity.classs.InstructorDetail;
import hibernate.entity.classs.Review;
import hibernate.entity.classs.Student;

public class GetCoursesAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);

			System.out.println(tempCourse);

			System.out.println(tempCourse.getReviews());
 
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
