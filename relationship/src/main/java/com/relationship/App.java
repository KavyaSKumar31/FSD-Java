package com.relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).addAnnotatedClass(Review.class).
   			   addAnnotatedClass(Instructor.class). addAnnotatedClass(Details.class).buildSessionFactory();
    	  
   	   Session session=factory.getCurrentSession();
        Details d = new Details();
        d.setYoutube("http://youtube.com/master");
        d.setTwitter("http://twitter.com/master");
        //Course course = new Course("FSD");
        session.getTransaction().begin();
        Course course = session.get(Course.class, 2);
        Student tempStudent1 = new Student();
        tempStudent1.setFirstName("deepraj");
        tempStudent1.setLastName("p");
        tempStudent1.setEmail("deep@pm.com");
        tempStudent1.addCourse(course);
        Instructor i = new Instructor();
        i.setFirstName("santha");
        i.setLastName("acharya");
        i.setEmail("master@gmail.com");
        i.setDetails(d);
        i.add(course);
        course.addReview(new Review("Great Course"));
        course.addReview(new Review("Awesome!"));
        d.setInstructor(i);
        
      //  session.persist(d);
       session.persist(tempStudent1);
       session.persist(i);
        session.getTransaction().commit();
        session.close();
    	 
  			
      /*	session.getTransaction().begin();
      	Details customer=session.get(Details.class, 1);
      	if(customer!=null)
      	{
      		session.remove(customer);
      		session.getTransaction().commit();
      		System.out.println("removed.");
      	}
      	else
      	{
      		System.out.println("no such id.");
      	}*/
      
      	
        
        
    }
}
