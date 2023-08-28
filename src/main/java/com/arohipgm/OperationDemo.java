package com.arohipgm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OperationDemo {
	public static void main(String[] args) {
		SaveMethod();
		UpdateMethod();
		DeleteMethod();
		GetMethod();
	}
	
	static void SaveMethod() {
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		
		Emp e1=new Emp(1,"abc",3000);
		Emp e2=new Emp(2,"pqr",4000);
		Emp e3=new Emp(3,"xyz",5000);
		Emp e4=new Emp(4,"opq",6000);
		
		Transaction tr=session.beginTransaction();
		session.merge(e1);
		session.merge(e2);
		session.merge(e3);
		session.merge(e4);
		tr.commit();
	}
	
	
	static void UpdateMethod() {
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Emp Emp = (Emp)session.get(Emp.class, 2);
		Emp.setEmpName("Arohi");
		  
		  tr.commit();
		  System.out.println("Updated Successfully");

	}
	
	static void DeleteMethod() {
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Emp Emp = (Emp)session.load(Emp.class, 4);
		  session.delete(Emp);
		  tr.commit();
		  System.out.println("Deleted Successfully");
		     
	}
	
	static void GetMethod() {
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Emp Emp = (Emp)session.get(Emp.class, 3);
        System.out.println("Emp==="+Emp);
		tr.commit();
		
		System.out.println("Get Successfully");
	}

}
@Entity
@Table(name="Emp_INFO11")
class Emp{
    @Id
    @Column(name="Emp_ID")
	int empID;
  
    @Column(name="Emp_NAME")
	String empName;
   
    @Column(name="Emp_SALARY")
	double empSalary;
	
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	@Override
	public String toString() {
		return "Emp [empID=" + empID + ", empName=" + empName + ", empSalary=" + empSalary + "]\n";
	}
	
	
	/**
	 * 
	 */
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param empID
	 * @param empName
	 * @param empSalary
	 */
	public Emp(int empID, String empName, double empSalary) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	

	
	
}
