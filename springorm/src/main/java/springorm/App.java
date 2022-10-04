package springorm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.InflaterInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/*@ Author
 *
Abhihek lacheta*/

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao stDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student = new Student(1, "Abhishek", "indore"); int r =
		 * stDao.insert(student); System.out.println("Done .........." + r);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean Go = true;
		while (Go) {
			System.out.println("PRESS 1 FOR ADD NEW STUDENT");
			System.out.println("PRESS 2 DISPLAY ALL STUDENT");
			System.out.println("PRESS 3 FOR GET DETAILS OF SINGLE STUDENT");
			System.out.println("PRESS 4 FOR DELET STUDENT");
			System.out.println("PRESS 5 FOR UPDATE STUDENT");
			System.out.println("PRESS 6 FOR EXIT.....");
			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// Add a new Student
					// taking input from user
					System.out.println("Enter User Id:");
					int uId = Integer.parseInt(br.readLine());
					System.out.println("Enter User Name:");
					String uName = br.readLine();
					System.out.println("Enter User City:");
					String uCity = br.readLine();
					Student s = new Student();
					s.setId(uId);
					s.setName(uName);
					s.setCity(uCity);
					int r = stDao.insert(s);
					System.out.println(r + "STUDENT ADDED...");
					System.out.println("**********************************");
					System.out.println();

					break;
				case 2: // display all student

					System.out.println("**************************");
					List<Student> allStudent = stDao.getAllStudent();

					for (Student st : allStudent) {
						System.out.println("_________________________________________");
						System.out.println("ID:" + st.getId());
						System.out.println("Name" + st.getName());
						System.out.println("City:" + st.getCity());
						System.out.println("_________________________________________");
					}
					System.out.println("*****************************************");
					break;

				case 3:
					// for get details of single student
					System.out.println("Enter User Id:");
					int userId = Integer.parseInt(br.readLine());
					Student st1 = stDao.getStudent(userId);
					System.out.println("ID:" + st1.getId());
					System.out.println("Name" + st1.getName());
					System.out.println("City:" + st1.getCity());
					System.out.println("_________________________________________");
					break;
				case 4:
					// for delete Student
					System.out.println("Enter User Id:");
					int id = Integer.parseInt(br.readLine());
					stDao.deletStudent(id);
					System.out.println("STUDENT DELETED SUCCESSFULLY.........!!");

					break;
				case 5:
					// for update student
					System.out.println("Enter Update User Id:");
					int uId1 = Integer.parseInt(br.readLine());
					System.out.println("Enter Update User Name:");
					String uName1 = br.readLine();
					System.out.println("Enter Update User City:");
					String uCity1 = br.readLine();
					Student s1 = new Student();
					s1.setId(uId1);
					s1.setName(uName1);
					s1.setCity(uCity1);
					stDao.updateStudent(s1);
					System.out.println("USER RECORD UPDATE SUCCESSFULLY.........!!!");

					break;
				case 6: // exit
					Go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("INVALID INPUT TRY WITH ANOTHER ONE.......!!!!!!!!!!");
				System.out.println(e);
			}

		}
		System.out.println("THANK'S FOR USING MY APPLICATION......!!!!!!!!!!");
		System.out.println("SEE YOU SOON.........!!!!!!!!");

	}
}
