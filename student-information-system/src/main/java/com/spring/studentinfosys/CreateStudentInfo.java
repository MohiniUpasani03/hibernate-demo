package com.spring.studentinfosys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.spring.studentinfosys.entity.Department;
import com.spring.studentinfosys.entity.MailingAddress;
import com.spring.studentinfosys.entity.Student;
import com.spring.studentinfosys.entity.Subjects;

public class CreateStudentInfo {

	public static void main(String[] args) {
		Configuration configObj = new Configuration();

		configObj.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
		.addAnnotatedClass(Department.class)
		.addAnnotatedClass(MailingAddress.class)
		.addAnnotatedClass(Subjects.class);

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 

		SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);

		Session sessionObj =  sessionFactoryObj.getCurrentSession();
		String theDateOfBirthStr = "03/06/1991";
		
		try {
			sessionObj.beginTransaction();
			
			//save Students details
			
//			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
		
							
			Query query = sessionObj.createQuery("from Student s");
            List<Student>  tempStudent = query.getResultList();
			
			System.out.println("Student Information System : ");
			
			System.out.println("emp size: "+tempStudent.size());
	        System.out.println("---------------------------");
	        tempStudent.stream().forEach(e -> {
	            System.out.println(e);
	            System.out.println("-- Name of Student :: "+e.getFirstName()+" --");
	            e.getSub().stream().forEach(System.out::println);
	            System.out.println("---------------------------");
	        });
	    
			sessionObj.getTransaction().commit();
			
			System.out.println("Saving the Student data...");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactoryObj.close();
		}

	}

}
