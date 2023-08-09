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

public class ThirdInheritanceDemo {
	public static void main(String[] args) {
		TablePerConcreteClassDemo ();
	}
	static void TablePerConcreteClassDemo (){
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.arohi.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		   Emp34 e1=new Emp34(1, "AAAA");
		   pEmp34 pe1=new pEmp34(2, "BBBB", 4000, 2000);
		   cEmp34 ce1=new cEmp34(3, "CCCC", 6000, 2);
		   
		  session.merge(e1); 	   
		  session.merge(pe1);
		  session.merge(ce1);
		  tr.commit();
		  
		  System.out.println("====End Pgm====");
		   
		}    
		    
	}
	@Entity
	@Table (name="Emp34info")
	@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	class Emp34{
		@Id
		@Column (name="EMP_ID")
		int empId;
		@Column (name="EMP_NAME")
		String empName;
		
		
		
		/**
		 * @param empId
		 * @param empName
		 */
		public Emp34(int empId, String empName) {
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
			return "Emp34 [empId=" + empId + ", empName=" + empName + "]\n";
		}



		/**
		 * 
		 */
		public Emp34() {
			 
		}
	}
	@Entity
	@Table(name="P34_Emp")
	class pEmp34 extends Emp34{
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
				return "pEmp3412 [salary=" + salary + ", bonus=" + bonus + "]\n";
			}
			/**
			 * @param empId
			 * @param empName
			 * @param salary
			 * @param bonus
			 */
			public pEmp34(int empId, String empName, double salary, double bonus) {
				super(empId, empName);
				this.salary = salary;
				this.bonus = bonus;
			}
			
			public pEmp34() {
				 
			}
	}
	@Entity
	@Table(name="C34_Emp")
	class cEmp34 extends Emp34{
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
			return "cEmp34 [perHourSalary=" + perHourSalary + ", contractDuration=" + contractDuration + "]\n";
		}
		
		
		/**
		 * @param empId
		 * @param empName
		 * @param perHourSalary
		 * @param contractDuration
		 */
		public cEmp34(int empId, String empName, double perHourSalary, int contractDuration) {
			super(empId, empName);
			this.perHourSalary = perHourSalary;
			this.contractDuration = contractDuration;
		}
		
		
		public cEmp34() {
			 
		}
	}























