package com.firstdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class FirstHibernateDemo {
     static void firstHibernateDemo() {
    	 Configuration con=new Configuration();
    	   SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Student s1=new Student(1, "Abc",20);
    	Student s2=new Student(1, "Abc111",30);
    	Student s3=new Student(3, "Abc2",40);
    	Student s4=new Student(4, "Abc3",50);
    	   
    	Transaction tr = session.beginTransaction();
    	      // session.merge(s1);
    	     //  session.merge(s2);
    	     //  session.merge(s3);
    	      // session.merge(s4);
    	       tr.commit();
    	       
    	       Criteria c = session.createCriteria(Student.class);
    	       //select * from student_info1 where student_id=1;
    	       // get + load
    	    Student sobj=session.get(Student.class,3);//null
    	    
    	    System.out.println("sobj===="+sobj);
    	    
    	    Student sobj1=session.load(Student.class,4);//ObectNotFoundException
    	    System.out.println("sobj1===="+sobj1);
    	       
    	       
    	       
    	       System.out.println("===EOP===");
     }
     
     public static void main(String[] args) {
    	 firstHibernateDemo();
	}
}

@Entity
@Table(name="STUDENT_INFO1")
class Student{
	
	@Id// to define the primary key in hibernate
	@Column(name = "student_id")
	int studentId;// primary key
	
	@Column(name = "student_name")
	String studentName;
	int mark;
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", mark=" + mark + "]\n";
	}
	/**
	 * @param studentId
	 * @param studentName
	 * @param mark
	 */
	public Student(int studentId, String studentName, int mark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.mark = mark;
	}
	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	
	
}
