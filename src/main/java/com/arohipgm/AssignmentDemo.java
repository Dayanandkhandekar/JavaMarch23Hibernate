package com.arohipgm;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class AssignmentDemo{
	public static void main(String[] args) {
		add();
	}
	static void add() {
		 boolean flag =false;

		do{
		Configuration con=new Configuration();
		SessionFactory sf=con.configure("hibernate.arohi.xml").buildSessionFactory();
		Session session=sf.openSession();
		//create object and pass the value
		Product p1=new Product(1,"Laptop",45000,20);
		Product p2=new Product(2,"Mobile",15000,30);
		Product p3=new Product(3,"TV",40000,10);
		Product p4=new Product(4,"Firdge",50000,5);
		
		Transaction tr=session.beginTransaction();
		session.merge(p1);// database madhe value merge kele
		session.merge(p2);
		session.merge(p3);
		session.merge(p4);
		
		Criteria c = session.createCriteria(Product.class);
		      List<Product> c1 = c.list(); //product chi list create keli
		      for(Product p:c1) { // for loop use kela 
		    	  System.out.println(p);
		      }
		  Scanner sc=new Scanner(System.in); // user kadun input ghenya sathi scanner class cha use kela
		  System.out.println("Enter Person ID");
		  int id=sc.nextInt();
		  System.out.println("Enter Person Name");
		  String name=sc.next();
		  System.out.println("Enter Product ID");
		  int Pid=sc.nextInt();
		  System.out.println("Enter Product Quantity");
		  int qty=sc.nextInt();
		  
		  Product pd=new Product();
		  
		  double price=0;
		  int q=0;
		  Product pd1=session.get(Product.class,Pid );
		  int pd2=pd1.getProduct_quantity()-qty;
		  pd1.setProduct_quantity(pd2);
		  price=pd1.getProduct_price();
		price= price * qty;
		System.out.println("Price==="+price);
		Person p11= new Person(id,name,price,Pid);//person ch object create kele ani tya madhe id,name,price,pid pass kele
		
		  Criteria cc = session.createCriteria(Person.class);
             List<Person> c6 = cc.list();
             for(Person p111:c6) {
            	 System.out.println(p111);
             }
            
		// donhi object database madhe merge kele 
		session.merge(pd);
		session.merge(p11);
		tr.commit();// ani commit kele database madhe save karnya sathi 
		System.out.println("do u want continue");
		 String msg=sc.next();
		 if(msg.equalsIgnoreCase("yes")) {
			 flag=true;
		 }else {
			 flag=false;
		 }
       }while(flag);
		System.out.println("=====Program End=====");
	}
}
@Entity
class Product{
	@Id
	int product_id;
	String product_name;
	int product_price;
	int product_quantity;
	/**
	 * @param product_id
	 * @param product_name
	 * @param product_price
	 * @param product_quantity
	 */
	public Product(int product_id, String product_name, double product_price, int product_quantity) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = (int) product_price;
		this.product_quantity = product_quantity;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + "]\n";
	}
	
	
	
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
}
@Entity
class Person{
	@Id
	int person_id;
	String person_name;
	double person_bill;
	int product_id;
	
	
	/**
	 * @param person_id
	 * @param person_name
	 * @param price
	 * @param product_id
	 */
	public Person(int person_id, String person_name, double price, int product_id) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_bill = price;
		this.product_id = product_id;
	}
	
	
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_bill=" + person_bill
				+ ", product_id=" + product_id + "]\n";
	}
	
	
	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public double getPerson_bill() {
		return person_bill;
	}
	public void setPerson_bill(int person_bill) {
		this.person_bill = person_bill;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}
























