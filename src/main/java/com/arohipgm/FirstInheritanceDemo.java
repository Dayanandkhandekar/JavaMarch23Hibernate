
package com.arohipgm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstInheritanceDemo {
	public static void main(String[] args) {
		TablePerClassDemo ();
	}
	static void TablePerClassDemo (){
	Configuration con=new Configuration();
	SessionFactory sf=con.configure("hibernate.arohi.xml").buildSessionFactory();
	Session session=sf.openSession();
	Transaction tr=session.beginTransaction();
	
	   Employee e1=new Employee(1, "AAAA");
	   Pemp pe1=new Pemp(2, "BBBB", 4000, 2000);
	   Cemp ce1=new Cemp(3, "CCCC", 6000, 2);
	   
	  session.merge(e1); 	   
	  session.merge(pe1);
	  session.merge(ce1);
	  tr.commit();
	  
	  System.out.println("====End Pgm====");
	   
	}    
	    
}
@Entity
@Table (name="e1info")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Employee{
	@Id
	@Column (name="EMP_ID")
	int empId;
	@Column (name="EMP_NAME")
	String empName;
	
	
	
	/**
	 * @param empId
	 * @param empName
	 */
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}



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
		return "Employee [empId=" + empId + ", empName=" + empName + "]\n";
	}



	/**
	 * 
	 */
	public Employee() {
		 
	}
}
@Entity
@Table(name="Permanat_Emp")
class Pemp extends Employee{
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
		@Override
		public String toString() {
			return "Pemp [salary=" + salary + ", bonus=" + bonus + "]\n";
		}
		/**
		 * @param empId
		 * @param empName
		 * @param salary
		 * @param bonus
		 */
		public Pemp(int empId, String empName, double salary, double bonus) {
			super(empId, empName);
			this.salary = salary;
			this.bonus = bonus;
		}
		
		public Pemp() {
			 
		}
}
@Entity
@Table(name="Contarct_Emp")
class Cemp extends Employee{
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

	
	@Override
	public String toString() {
		return "Cemp [perHourSalary=" + perHourSalary + ", contractDuration=" + contractDuration + "]\n";
	}
	
	
	/**
	 * @param empId
	 * @param empName
	 * @param perHourSalary
	 * @param contractDuration
	 */
	public Cemp(int empId, String empName, double perHourSalary, int contractDuration) {
		super(empId, empName);
		this.perHourSalary = perHourSalary;
		this.contractDuration = contractDuration;
	}
	
	
	public Cemp() {
		 
	}
}





















