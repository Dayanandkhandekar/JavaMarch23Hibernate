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


public class SecondInheritanceDemo {
	public static void main(String[] args) {
		TablePerSubClassDemo (); 
	}
	static void TablePerSubClassDemo (){
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.arohi.xml").buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		   Emp12 e1=new Emp12(1, "AAAA");
		   pemp12 pe1=new pemp12(2, "BBBB", 4000, 2000);
		   cemp12 ce1=new cemp12(3, "CCCC", 6000, 2);
		   
		  session.merge(e1); 	   
		  session.merge(pe1);
		  session.merge(ce1);
		  tr.commit();
		  
		  System.out.println("====End Pgm====");
		   
		}    
		    
	}
	@Entity
	@Table (name="emp12info")
	@Inheritance(strategy = InheritanceType.JOINED)
	class Emp12{
		@Id
		@Column (name="EMP_ID")
		int empId;
		@Column (name="EMP_NAME")
		String empName;
		
		
		
		/**
		 * @param empId
		 * @param empName
		 */
		public Emp12(int empId, String empName) {
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
			return "Emp12 [empId=" + empId + ", empName=" + empName + "]\n";
		}



		/**
		 * 
		 */
		public Emp12() {
			 
		}
	}
	@Entity
	@Table(name="Permanat_Emp")
	class pemp12 extends Emp12{
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
				return "pemp1212 [salary=" + salary + ", bonus=" + bonus + "]\n";
			}
			/**
			 * @param empId
			 * @param empName
			 * @param salary
			 * @param bonus
			 */
			public pemp12(int empId, String empName, double salary, double bonus) {
				super(empId, empName);
				this.salary = salary;
				this.bonus = bonus;
			}
			
			public pemp12() {
				 
			}
	}
	@Entity
	@Table(name="Contarct_Emp")
	class cemp12 extends Emp12{
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
			return "cemp12 [perHourSalary=" + perHourSalary + ", contractDuration=" + contractDuration + "]\n";
		}
		
		
		/**
		 * @param empId
		 * @param empName
		 * @param perHourSalary
		 * @param contractDuration
		 */
		public cemp12(int empId, String empName, double perHourSalary, int contractDuration) {
			super(empId, empName);
			this.perHourSalary = perHourSalary;
			this.contractDuration = contractDuration;
		}
		
		
		public cemp12() {
			 
		}
	}





















