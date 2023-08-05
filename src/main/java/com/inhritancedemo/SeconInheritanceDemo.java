package com.inhritancedemo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SeconInheritanceDemo {

	   public static void main(String[] args) {
		   Configuration con=new Configuration();
		   SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		    Transaction tr = session.beginTransaction();
		    Emp1 e1=new Emp1(1,"A");
		    PEmp1 pe1=new PEmp1(2,"B",2000,3000);
		    CEmp1 ce1=new CEmp1(3,"C",3000,2);
		    session.merge(e1);
		    session.merge(pe1);
		    session.merge(ce1);
		    tr.commit();
		    System.out.println("===EOP===");
	}
	}

	@Entity
	@Table(name = "EMP_INFO1")
	@Inheritance(strategy = InheritanceType.JOINED)
	class Emp1{
		    
		     @Id
		     @Column(name="emp_id")
		    int empId;
		     @Column(name="emp_name")
		    String empName;
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
			@Override
			public String toString() {
				return "Emp [empId=" + empId + ", empName=" + empName + "]\n";
			}
			/**
			 * @param empId
			 * @param empName
			 */
			public Emp1(int empId, String empName) {
				super();
				this.empId = empId;
				this.empName = empName;
			}
		     
			public Emp1() {
				
			}  
		     
		    
		    

		 }

	     @Entity
	     @Table(name = "PEMP_INFO1")
		class PEmp1 extends Emp1{
		    double salary;
		    double bonus;
			public double getSalary() {
				return salary;
			}
			public void setSalary(double salary) {
				this.salary = salary;
			}
			public double getBonus() {
				return bonus;
			}
			public void setBonus(double bonus) {
				this.bonus = bonus;
			}
			/**
			 * @param empId
			 * @param empName
			 * @param salary
			 * @param bonus
			 */
			public PEmp1(int empId, String empName, double salary, double bonus) {
				super(empId, empName);
				this.salary = salary;
				this.bonus = bonus;
			}
			@Override
			public String toString() {
				return "PEmp [salary=" + salary + ", bonus=" + bonus + "]\n";
			}
		    
		    public PEmp1() {
		    	
		    }

		 }
	     @Entity
	     @Table(name = "CEMP_INFO1")
		class CEmp1 extends Emp1{
		   double perHourSalary;
		      int contractDuration;
			public double getPerHourSalary() {
				return perHourSalary;
			}
			public void setPerHourSalary(double perHourSalary) {
				this.perHourSalary = perHourSalary;
			}
			public int getContractDuration() {
				return contractDuration;
			}
			public void setContractDuration(int contractDuration) {
				this.contractDuration = contractDuration;
			}
			/**
			 * @param empId
			 * @param empName
			 * @param perHourSalary
			 * @param contractDuration
			 */
			public CEmp1(int empId, String empName, double perHourSalary, int contractDuration) {
				super(empId, empName);
				this.perHourSalary = perHourSalary;
				this.contractDuration = contractDuration;
			}
			@Override
			public String toString() {
				return "CEmp [perHourSalary=" + perHourSalary + ", contractDuration=" + contractDuration + "]\n";
			}
			public CEmp1() {
				
			}
		      

		   }