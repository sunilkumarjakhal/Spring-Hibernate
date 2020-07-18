package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		//url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		
		try {
			System.out.println("connecting to the database " +url);
			Connection myCon = DriverManager.getConnection(url,user,pass);
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
			
			System.out.println("connected to the database " +url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
