package com.poojapgm;

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


//table per class(types of inheritance

public class Hibernateinheritance {
	
	
	public static void main(String[] args) {
		Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		Session session = sf.openSession();// sessionfactorypasun session bheteto
		
		Transaction tr = session.beginTransaction();//Session pasun transaction bhete...begintransacton method ahe
		
		person1 p1=new person1(1,"Arnav");           //object create
		pperson1 pp1= new pperson1(2,"Kushi",3000,4000);
		cperson1 cp1= new cperson1(3,"sham",2000,3);
		
		session.merge(p1);                  //data save
		session.merge(pp1);
		session.merge(cp1);
		
		tr.commit();                      //tr stop kele
		
		System.out.println("======END OF PROGRAM========"); // successfully zale ki nahi yasthi meg 
	}

}
@Entity                          //hibernate madhe persist class che object  store hotat.  
@Table(name="personinfo")    
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Table per class
//@DiscriminatorValue(value="Persondata")  //datbase madhil dtype ch name change karysathi 

class person1                                          //parent class
{
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
		return "person1 [id=" + id + ", pname=" + pname + "]\n";
	}
	/**
	 * @param id
	 * @param pname
	 */
	public person1(int id, String pname) {
		super();
		this.id = id;
		this.pname = pname;
	}
	
	public person1() {      //no org constructor
		
	}
	
	
	
}
@Entity
@Table(name="ppersoninfo")
class pperson1 extends person1   //child class        //extends parent class
{
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
		return "pperson1 [salary=" + salary + ", bonus=" + bonus + "]\n";
	}
	/**
	 * @param id
	 * @param pname
	 * @param salary
	 * @param bonus
	 */
	public pperson1(int id, String pname, double salary, double bonus) {
		super(id, pname);
		this.salary = salary;
		this.bonus = bonus;
	}
	public pperson1() {   //no org constructor
		
	}
	
	
	
}
@Entity
@Table(name="cpersoninfo")
class cperson1 extends person1    //child class       //extends parent class
{
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
		return "cperson1 [perhoursalary=" + perhoursalary + ", contractduration=" + contractduration + "]\n";
	}
	/**
	 * @param id
	 * @param pname
	 * @param perhoursalary
	 * @param contractduration
	 */
	public cperson1(int id, String pname, double perhoursalary, int contractduration) {
		super(id, pname);
		this.perhoursalary = perhoursalary;
		this.contractduration = contractduration;
	}
	public  cperson1()  //no org constructor
	{
		
	}
	
	
}
