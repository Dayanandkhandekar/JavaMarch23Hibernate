package com.poojapgm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class firsthibernatedemo {
	
 static	void firstdemo() {
	Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
	
	SessionFactory sf = con.configure("hibernate.pooja.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
	//Session factory he hibernate madhunch yete..      //check method ahe build session factory
	
	Session session = sf.openSession();// sessionfactorypasun session bheteto
	
	student1 s1=new student1(1, "Pradya", 50);//Object Created
	student1 s2=new student1(2, "Guddi", 40);
	student1 s3=new student1(3, "Manu", 50);
	student1 s4=new student1(4, "Pooja", 80);
	student1 s5=new student1(5, "Komal", 60);
	
	Transaction tr = session.beginTransaction();//Session pasun transaction bhete...begintransacton method ahe
	
    //session.merge(s1);    // session.update(s1);//session chya method ahe merge session.update(s1);use kele tr error yete nonuniqueobjectexception
	//session.merge(s2);//hibernate through data merge
	//session.merge(s3);
	//session.merge(s4);
	//session.merge(s5);
	//tr.commit();        //transaction commit karaych
	
	 
	    
	    //get + load session chya method ahet particalar id  database  ghenaysathi
	//id persent nasel tr get method retrun null karate
	  student1 sobj= session.get(student1.class,1);//get method session chi
	  
	  System.out.println("sobj======="+sobj);
	  
	  student1 sobj1= session.load(student1.class,6);//load method use kart asal tr database madhe id present nasel tr retrun 
	                                //exception yete objectnot found
	  
	  System.out.println("sobj1======="+sobj1);
	
	System.out.println("=====End Of Program");
	
	
	}
 
 static void criteriademo()
 {
	 Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		Session session = sf.openSession();
		
		//Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		 
		
		//c.add(Restrictions.eq("sid",1));      //add method madhe restriction class use kela ahe tyat eq method madhe 
		                                 //property name manje java che fields db che nahi use karyche, value manje id dili ahe
		//select * from student1 where id=1;   
		
	// student1 obj=	(student1) c.uniqueResult();// criteria madhun result ghetela to store kela obj madhe ....single object sathi unique method
	 //System.out.println("obj======"+obj);
	 
	 
	// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
	 //c.add(Restrictions.eq("marks",50)); //select * from student1 where mark=60
	 //List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
	 //System.out.println("list======"+list);
	 
	// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
	// c.add(Restrictions.gt("marks",60)); //select * from student1 where mark >80;
	// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
	// System.out.println("list======"+list);
	 
	// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
	// c.add(Restrictions.lt("marks",60)); //select * from student1 where mark < 60;
	// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
	 //System.out.println("list======"+list);
		
		// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		// c.add(Restrictions.ge("marks",50)); //select * from student1 where mark>=50;
		// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
		// System.out.println("list======"+list);
		
		
		// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		// c.add(Restrictions.le("marks",50)); //select * from student1 where mark<=50;
		// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
		// System.out.println("list======"+list);
		
		// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		// c.add(Restrictions.ilike("sname","%a")); //select * from student1 where sname ilike'%a'; (end a ne honare)
		// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
		// System.out.println("list======"+list);// ilike ha bgnar nahi ki word(%a) captial madhe ahe ki lowercase madhe to display karel
		 
		// Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		// c.add(Restrictions.like("sname","%a")); //select * from student1 where sname like'%a'; (end a ne honare)
		// List list = c.list();              //criteria madhun list ghetli mulltiple record display kryla
		// System.out.println("list======"+list);
	
		// Criteria c1 = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		// Criterion marks1=Restrictions.eq("marks",60);  //criterion use karun marks1object create
		// Criterion name1=Restrictions.eq("name","Pooja");
		// c1.add(Restrictions.or(marks1)); //select * from student1  marks=60 or name='pooja';
		 
		 
		Criteria c2 = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		 Criterion marks1=Restrictions.eq("marks",30);  //criterion use karun marks1object create
		 Criterion name1=Restrictions.eq("name","Pooja");
		 c2.add(Restrictions.and(marks1)); //select * from student1  marks=60 and name='pooja';
		  
		 
		 
	 
	 
 }
	
 
 static void projectiondemo() {
	 Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(student1.class);//session pasun criteria create kela persist class ghetle class ch name
		 
	//  c.setProjection(Projections.rowCount());  //criteria la set projections karave lagte tymadhe projections class ahe tychi method rowcount ahe 
	                                    //select count(*) from studinfo;  kiti record ahet table madhe te count karte
	 //  long count=(long) c.uniqueResult();
	  //  System.out.println("Count========"+count);
	    
	    
	  
	     //  c.setProjection(Projections.max("marks"));  //criteria la set projections karave lagte tymadhe projections class ahe tychi method rowcount ahe 
        //select max(marks) from studinfo; maximum value return krte
         //  int maxrecord=(int) c.uniqueResult();
          //  System.out.println("maxrecord========"+maxrecord);
            
            
         //   c.setProjection(Projections.min("marks"));  //criteria la set projections karave lagte tymadhe projections class ahe tychi method rowcount ahe 
            //select min(marks) from studinfo;  minimum value return karte
          //   int minrecord=(int) c.uniqueResult();
          //    System.out.println("minrecord========"+minrecord);
              
              
            //  c.setProjection(Projections.sum("marks"));  //criteria la set projections karave lagte tymadhe projections class ahe tychi method rowcount ahe 
              //select sum(marks) from studinfo;  sum karte marks chi
              // long sumrecord=(long) c.uniqueResult();
               // System.out.println("sumrecord========"+sumrecord);
                
                
                //c.setProjection(Projections.avg("marks"));  //criteria la set projections karave lagte tymadhe projections class ahe tychi method rowcount ahe 
                //select avg(marks) from studinfo;  averge kadte marks chi
               //  double avg=(double) c.uniqueResult();
             //     System.out.println("avg========"+avg);
                  
                  
                  
                //  Projection p =Projections.property("sname");//particular column use karun record display
                  //select sname from studinfo;               //one column at time use karu shkto (snameonly one)e.g select sname,marks(he nahi karu shkat) from studinfo;
                //  c.setProjection(p);
                 // List namelist=c.list();                 //list display
                 // System.out.println("NameList======"+namelist);
                  

                    c.addOrder(Order.desc("marks"));//select * from studinfo order by marks desc;
                    List desclist1=c.list();                 //list display
                    System.out.println("DescendingList======"+desclist1);
                    
            c.setFirstResult(1);     //start kontya index pasun karych 0,1,2,3,4
            c.setMaxResults(3);   //kiti records pahijet te
            List li=c.list();
            System.out.println("list======"+li);

 }
 
 //first level cache example
 static void cacheingdemo()
 {
	 Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		//First level of caching scope ha session purta asto ..by default caching aste ..enable aste 
		//session purt work krte only one other session sathi nahi
		Session session = sf.openSession();
	
		student1 stud1=session.get(student1.class,1); // get method pretek veli hit marte db la record ghenysathi
		System.out.println(" stud1============="+ stud1);//same record asli tri hit marte
		
		student1 stud2=session.get(student1.class,1);
		System.out.println(" stud2============="+ stud2);
		
		student1 stud3=session.load(student1.class,3);//load method he ekdach hit marte ani te record cache memory madhe store karun ghtete
		System.out.println(" stud3============="+ stud3);//cache memory madhun ch te access krete
		
	//	student1 stud4=session.get(student1.class,6);//get method record nasel tr return null karel
	//	System.out.println(" stud4============="+ stud4);
		
	//	student1 stud5=session.load(student1.class,6);//load method record nasel tr return objectnotfoundexception karel
	//	System.out.println(" stud5============="+ stud5);
		
		
		//jast record astil tr session close karych
		//session.close();
		
		////////////////////////////getcurrentsession ch use karych ani //////////////////////////////////////
		//////////<property name="current_session_context_class">thread</property> he propery add karaychi////////////
		///second  session different session ahe
		Session session2=sf.openSession();
		student1 stud4=session2.get(student1.class,1);
		System.out.println(" stud4============="+ stud4);
		
		student1 stud5=session2.load(student1.class,3);
		System.out.println(" stud5============="+ stud5);
		
		}
 //Second Level Cache Example
 static void secondlevelcache()
 {
	 Configuration con=new Configuration();// configuration ghetle class create kele configuration cha
		
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory(); //configuration file la configure  kele ki session factory milte(filename)
		//Session factory he hibernate madhunch yete..      //check method ahe build session factory
		
		//second level cache cha scope ha session factory parynt asto
		//session factory madhe multiple session astat
		//id ekda hit karun record cache memory store krun ghetle asel tr te part db la hit mart nahi
		//two session asli tri te db la ekdach hit marte
		Session session = sf.openSession();
	
		student1 stud1=session.get(student1.class,1); 
		System.out.println(" stud1============="+ stud1);
		
		student1 stud2=session.get(student1.class,1);
		System.out.println(" stud2============="+ stud2);
		
		
		Session session2=sf.openSession();
		student1 stud4=session2.get(student1.class,1);
		System.out.println(" stud4============="+ stud4);
 }
 
 
 
 
 
 
	public static void main(String[] args) {
		//firstdemo();
		//criteriademo();
		//projectiondemo();
		//cacheingdemo();
		secondlevelcache();
	}

}
@Entity //Persist class
@Table(name="StudentInform")//custom name table create hotana database madhe studentinfo ya name ne create hoel
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
class student1 //simple classobject
{
	@Id                          //anotation for primary key(duplicate record insert hou naye manun)
	@Column(name="StudId")          // database ya name ne column create honar
	int sid;
	@Column(name="Studname")
	String sname;
	int marks;
	
	//constructor
	/**
	 * @param sid
	 * @param sname
	 * @param marks
	 */
	public student1(int sid, String sname, int marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
	}
	//To string
	@Override
	public String toString() {
		return "student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + "]\n";
		
	}
	
	//getter setter 
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	//No org constructor
	/**
	 * 
	 */
	public student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}