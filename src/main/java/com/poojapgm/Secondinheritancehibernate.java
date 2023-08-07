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

public class Secondinheritancehibernate {
	
	//table per sub class

	public static void main(String[] args) {
		Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		Session session = sf.openSession();// sessionfactorypasun session bheteto
		
		Transaction tr = session.beginTransaction();//Session pasun transaction bhete...begintransacton method ahe
		
		person2 p2=new person2(1,"Arnav");           //object create
		pperson2 pp2= new pperson2(2,"Kushi",3000,4000);
		cperson2 cp2= new cperson2(3,"sham",2000,3);
		
		session.merge(p2);                  //data save
		session.merge(pp2);
		session.merge(cp2);
		
		tr.commit();                      //tr stop kele
		
		System.out.println("======END OF PROGRAM========"); // successfully zale ki nahi yasthi meg 
	}

}

@Entity                          //hibernate madhe persist class che object  store hotat.  
@Table(name="personinfo2")    
@Inheritance(strategy = InheritanceType.JOINED) //pretek class sathi seprate table create.parent class chi primary key child class
                                                //madhe as foreign key manun jate.
class person2 {
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
		return "person2 [id=" + id + ", pname=" + pname + "]\n";
	}
	/**
	 * @param id
	 * @param pname
	 */
	public person2(int id, String pname) {
		super();
		this.id = id;
		this.pname = pname;
	}
	public person2() {
		
	}
	
	
}
@Entity
@Table(name="ppersoninfo")
class pperson2 extends person2 {
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
		return "pperson2 [salary=" + salary + ", bonus=" + bonus + "]\n";
	}
	/**
	 * @param id
	 * @param pname
	 * @param salary
	 * @param bonus
	 */
	public pperson2(int id, String pname, double salary, double bonus) {
		super(id, pname);
		this.salary = salary;
		this.bonus = bonus;
	}
	public pperson2() {
		
	}
	
}
@Entity
@Table(name="cpersoninfo")
class cperson2 extends person2 {
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
		return "cperson2 [perhoursalary=" + perhoursalary + ", contractduration=" + contractduration + "]";
	}
	/**
	 * @param id
	 * @param pname
	 * @param perhoursalary
	 * @param contractduration
	 */
	public cperson2(int id, String pname, double perhoursalary, int contractduration) {
		super(id, pname);
		this.perhoursalary = perhoursalary;
		this.contractduration = contractduration;
	}
	public cperson2() {
		
	}
	
}