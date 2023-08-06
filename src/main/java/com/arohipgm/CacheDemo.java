package com.arohipgm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CacheDemo {
public static void main(String[] args) {
	add();
	cachedemo();
	
}
static void add() {
	Configuration con=new Configuration();
	SessionFactory sf=con.configure("hibernate.arohi.xml").buildSessionFactory();
	Session session=sf.openSession();

	Employee1 e1=new Employee1(1, "AAA", 1200);
	Employee1 e2=new Employee1(2, "BAA", 1300);
	Employee1 e3=new Employee1(3, "CAA", 1400);
	Employee1 e4=new Employee1(4, "DAA", 1500); 
	
	Transaction tr=session.beginTransaction();
	session.merge(e1);
	session.merge(e2);
	session.merge(e3);
	session.merge(e4);
	tr.commit();    // jr commit nhi kele tr te database madhe save nhi hot
	
}
static void cachedemo() {
	Configuration con=new Configuration();
	SessionFactory sf=con.configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=sf.openSession();
	Employee1 e1 = session.get(Employee1.class, 1); 
	System.out.println("e1====="+e1);
	Employee1 e2 = session.get(Employee1.class, 1);
	System.out.println("e2====="+e2);
	Employee1 e3 = session.load(Employee1.class, 2);
	System.out.println("e3====="+e3);
    Employee1 e4 = session.get(Employee1.class, 1);
    System.out.println("e4====="+e4);

	System.out.println("=========");
}
}

@Entity                        //simple java che obj save karu shakt nhi mhanun use kele jate
@Table(name="Employee_Info")   //table la custom name denya sathi able use kele jate
class Employee1{
@Id
	@Column(name="employee_id")
	int empId;
	
	@Column(name="employee_name")
	String empName;
	
	double empSalary;

	
// To override To Strings
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]\n";
	}

	
	//Generate constructor using fields

	/**
	 * @param empId
	 * @param empName
	 * @param empSalary
	 */
	public Employee1(int empId, String empName, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	
	

	//generates constructors from superclass

	/**
	 * 
	 */
	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}


	//Generate getters and setters

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

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	
	
	
	
}
