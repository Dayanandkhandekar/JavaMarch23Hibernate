package com.poojapgm;

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

public class Thirdinheritancetableper {

	//table per concrete class

		public static void main(String[] args) {
			Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
			
			SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
			//Session factory he hibernate madhunch yete..      //check method ahe build session factory
			
			Session session = sf.openSession();// sessionfactorypasun session bheteto
			
			Transaction tr = session.beginTransaction();//Session pasun transaction bhete...begintransacton method ahe
			
			person3 p3=new person3(1,"Arnav");           //object create
			pperson3 pp3= new pperson3(2,"Kushi",3000,4000);
			cperson3 cp3= new cperson3(3,"sham",2000,3);
			
			session.merge(p3);                  //data save
			session.merge(pp3);
			session.merge(cp3);
			
			tr.commit();                      //tr stop kele
			
			System.out.println("======END OF PROGRAM========"); // successfully zale ki nahi yasthi meg 
		}

	}

	@Entity                          //hibernate madhe persist class che object  store hotat.  
	@Table(name="personinfo3")    
	@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //pretek class sathi seprate table create
	                                                //.
	class person3 {
		@Id
		@Column(name="pid")
		int id;
		@Column(name="Pername")
		String pname;
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return the pname
		 */
		public String getPname() {
			return pname;
		}
		/**
		 * @param pname the pname to set
		 */
		public void setPname(String pname) {
			this.pname = pname;
		}
		@Override
		public String toString() {
			return "person3 [id=" + id + ", pname=" + pname + "]\n";
		}
		/**
		 * @param id
		 * @param pname
		 */
		public person3(int id, String pname) {
			super();
			this.id = id;
			this.pname = pname;
		}
		public person3() {
			
		}
		
		
	}
	@Entity
	@Table(name="ppersoninfo3")
	class pperson3 extends person3 {
		double salary;
		double bonus;
		/**
		 * @return the salary
		 */
		public double getSalary() {
			return salary;
		}
		/**
		 * @param salary the salary to set
		 */
		public void setSalary(double salary) {
			this.salary = salary;
		}
		/**
		 * @return the bonus
		 */
		public double getBonus() {
			return bonus;
		}
		/**
		 * @param bonus the bonus to set
		 */
		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		@Override
		public String toString() {
			return "pperson3 [salary=" + salary + ", bonus=" + bonus + "]\n";
		}
		/**
		 * @param id
		 * @param pname
		 * @param salary
		 * @param bonus
		 */
		public pperson3(int id, String pname, double salary, double bonus) {
			super(id, pname);
			this.salary = salary;
			this.bonus = bonus;
		}
		public pperson3() {
			
		}
		
	}
	@Entity
	@Table(name="cpersoninfo3")
	class cperson3 extends person3 {
		double perhoursalary;
		int contractduration;
		/**
		 * @return the perhoursalary
		 */
		public double getPerhoursalary() {
			return perhoursalary;
		}
		/**
		 * @param perhoursalary the perhoursalary to set
		 */
		public void setPerhoursalary(double perhoursalary) {
			this.perhoursalary = perhoursalary;
		}
		/**
		 * @return the contractduration
		 */
		public int getContractduration() {
			return contractduration;
		}
		/**
		 * @param contractduration the contractduration to set
		 */
		public void setContractduration(int contractduration) {
			this.contractduration = contractduration;
		}
		@Override
		public String toString() {
			return "cperson3 [perhoursalary=" + perhoursalary + ", contractduration=" + contractduration + "]";
		}
		/**
		 * @param id
		 * @param pname
		 * @param perhoursalary
		 * @param contractduration
		 */
		public cperson3(int id, String pname, double perhoursalary, int contractduration) {
			super(id, pname);
			this.perhoursalary = perhoursalary;
			this.contractduration = contractduration;
		}
		public cperson3() {
			
		}
		
	}
