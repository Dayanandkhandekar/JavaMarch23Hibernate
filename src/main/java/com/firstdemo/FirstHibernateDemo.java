package com.firstdemo;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

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
     
     
     static void criteriaDemo() {
    	 Configuration con=new Configuration();
  	   SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
     	Session session = sf.openSession();
     	   
     	//   Criteria c = session.createCriteria(Student.class);
  	     //  c.add(Restrictions.eq("studentId", 1));//select * from student_info1 where student_id=1;
  	       
  	     //Student obj= (Student) c.uniqueResult();
  	     
     // Criteria c = session.createCriteria(Student.class);
 	    //  c.add(Restrictions.eq("mark", 30));//select * from student_info1 where mark=30;
     	//  List list = c.list();
     	
     	// Criteria c = session.createCriteria(Student.class);
 	   //  c.add(Restrictions.gt("mark", 35));//select * from  student_info1 where mark > 35;
      // List list = c.list();
     	
     	 Criteria c = session.createCriteria(Student.class);
     	 Criterion aa=Restrictions.ilike("studentName","%Z");
 	     c.add(aa);//select * from  student_info1 where mark > 35;
       List list = c.list();
  	   // System.out.println("list==="+list);
  	    
  	   Criteria c1 = session.createCriteria(Student.class);
  	 Criterion markc=Restrictions.eq("mark",30);
  	 Criterion namec=Restrictions.eq("studentName","xyz");
  	   c1.add(Restrictions.and(markc,namec));
  	 List list1 = c1.list();
	    System.out.println("list1==="+list1);
	    
	    Criteria cc = session.createCriteria(Student.class);
	    cc.add(Restrictions.ge("mark", 30));
	    cc.add(Restrictions.le("mark", 40));
	    List listGe = cc.list();
	    System.out.println("listGe==="+listGe);
     }
     
     static void projectionsDemo() {
    	 Configuration con=new Configuration();
    	   SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
       	Session session = sf.openSession();
       	
       	    Criteria c  =session.createCriteria(Student.class);
       	    
       	  //  c.setProjection(Projections.rowCount());//select count(*)  from student_info1;
       	  // Long count = (Long) c.uniqueResult();
       	  // System.out.println("count==="+count);
       	   
       	 //  c.setProjection(Projections.max("mark"));//select max(mark) from student_info1;
       	// int maxMark=(int) c.uniqueResult();
       //	 System.out.println("maxMark==="+maxMark);
       	 
         
     	 //  c.setProjection(Projections.min("mark"));
     	// int minMark=(int) c.uniqueResult();
     	// System.out.println("minMark==="+minMark);
     	 
     	 // c.setProjection(Projections.sum("mark"));
      	// Long sumMark=(Long) c.uniqueResult();
      	// System.out.println("sumMark==="+sumMark);
      	 
      	// c.setProjection(Projections.avg("mark"));
      	// double avgMark=(double) c.uniqueResult();
      	// System.out.println("avgMark==="+avgMark);
      	 
      	 // Projection  p=Projections.property("studentName");//select student_name from student_info1;
      	// Projection  markp=Projections.property("mark");
      	//  c.setProjection(p);
      	//c.setProjection(markp);
      	// List list = c.list();
      	 //System.out.println("list===="+list);
      	 
      	 c.addOrder(Order.desc("mark"));
      	 List list1 = c.list();
      	 System.out.println("Desc list===="+list1);
      	 
      	 c.setFirstResult(0);// kutun start krayche (kontya index pasun)
      	 c.setMaxResults(3);// kiti record pahijet
      	 
      	List list2 = c.list();
     	 System.out.println(" list2===="+list2);
       	      
     }
     
     static void display() {
    	 Emp e1=new Emp(1,"AA", "IT", 2000);
    	 Emp e2=new Emp(2,"AB", "Account", 5000);
    	 Emp e3=new Emp(3,"AC", "Finance", 4000);
    	 Emp e4=new Emp(4,"AD", "IT", 3000);
    	 
    	 List<Emp> list=new ArrayList<Emp>();
    	  list.add(e1);
    	  list.add(e2);
    	  list.add(e3);
    	  list.add(e4);
    	  
    	  List<Emp> list1=new ArrayList<Emp>();
    	  for(Emp obj:list) {
    		  if(obj.getDept().equalsIgnoreCase("IT")) {
    			  //obj.setSalary(obj.getSalary()+5000);
    			   double increSalary=obj.getSalary()+5000;
    			   obj.setSalary(increSalary);
    			  list1.add(obj) ;
    		  }else {
    			  list1.add(obj) ;
    		  }
    	  }
    	  
    	  
    	  System.out.println("After Increment Salary===="+list1);
    	 
    	  
     }
     
     static void cacheDemo() {
    	 Configuration con=new Configuration();
    	   SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
       	Session session = sf.openSession();
       	
      Student   s1=	session.get(Student.class,1);
      System.out.println("s1====="+s1);
      Student   s2=	session.get(Student.class,1);
      System.out.println("s2====="+s2);
     
   	Session session2 = sf.openSession();
    Student   s5=	session2.get(Student.class,1);
    System.out.println("s5====="+s5);
       	
     }
     
     public static void main(String[] args) {
    	// firstHibernateDemo();
    	 //projectionsDemo();
    	 cacheDemo();
    	 //display();
	}
}

@Entity
@Table(name="STUDENT_INFO1")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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

class Emp{
	
	int empId;
	String empName;
	String dept;
	double salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", salary=" + salary + "]\n";
	}
	/**
	 * @param empId
	 * @param empName
	 * @param dept
	 * @param salary
	 */
	public Emp(int empId, String empName, String dept, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.salary = salary;
	}
	
	
	
}
