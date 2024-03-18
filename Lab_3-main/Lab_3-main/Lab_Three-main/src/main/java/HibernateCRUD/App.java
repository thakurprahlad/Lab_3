package HibernateCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import servletHib.Student;

import java.util.List;

import javax.persistence.Query;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		// Insert/update the table
		student s1 = new student(); // Transient
		/*
		 * s1.setId(04); s1.setName("Golu"); s1.setAge(21); s1.setMarks(69);
		 * s1.setGender("Male");
		 */

		Transaction tx = session.beginTransaction();
//		session.save(s1); // persistent

		// Fetch

//		student fetchedStudent = session.get(student.class, 1); //
//		System.out.println(fetchedStudent);

		// Create Query
		
		/*
		 * List<student> students = session.createQuery("from student").list(); for
		 * (student s : students) { System.out.println(s); }
		 */
		 

		// Edit or modify the data (transaction commit)
//        student sToUpdate = session.get(student.class, 4);
//        sToUpdate.setName("Golu");
//        sToUpdate.setAge(22);
//        session.saveOrUpdate(sToUpdate);

//         Delete (transaction commit)
//        student sToDelete = session.get(student.class, 11);
//        session.delete(sToDelete);
			

        String hql = "from student where marks > 60";
        Query query = session.createQuery(hql);
        List<student> list = query.getResultList();

        for (student s : list) {
            System.out.println(s);
        }

//        
		tx.commit();
		session.close(); // detached
		sf.close();
	}
}