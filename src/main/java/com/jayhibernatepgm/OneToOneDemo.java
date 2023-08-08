package com.jayhibernatepgm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

	static void oneToOneDemo() {
		Configuration con = new Configuration();
		SessionFactory sf = con.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();
		AadharCard a1 = new AadharCard(1, "1111111111");
		AadharCard a2 = new AadharCard(2, "2221111111");
		Citizen c1 = new Citizen(1, "ABC", "8957457847", a2);
		Citizen c2 = new Citizen(2, "PQR", "8967574744", a1);
		session.merge(c1);
		session.merge(c2);
		tr.commit();
		System.out.println("_____EOP______");

	}

	public static void main(String[] args) {
		oneToOneDemo();

	}

}

@Table(name = "CITIZEN_DETAILS")
@Entity
class Citizen {
	@Id
	@Column(name = "CITIZEN_ID")
	int cId;

	// @notnull ask ...not showing annotation
	@Column(name = "CITIZEN_NAME")
	String cName;

	@Column(name = "CONTACT_NUMBERS")
	String mobileNumber;

	@javax.persistence.OneToOne // ask
	@Cascade(CascadeType.ALL) // to save automatically objects of aadhar with citizen object without manually
								// insert,when we insert object of cittizen that time automatically adhar object
								// will be saved by using cascade all
	AadharCard aCard;

	public Citizen(int cId, String cName, String mobileNumber, AadharCard aCard) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.mobileNumber = mobileNumber;
		this.aCard = aCard;
	}

	@Override
	public String toString() {
		return "Citizen [cId=" + cId + ", cName=" + cName + ", mobileNumber=" + mobileNumber + ", aCard=" + aCard + "]";
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AadharCard getaCard() {
		return aCard;
	}

	public void setaCard(AadharCard aCard) {
		this.aCard = aCard;
	}

	public Citizen() {

	}
}

@Entity
@Table(name = "ADHARCARD_DETAILS")
class AadharCard {
	@Id
	@Column(name = "AADHAR_ID")
	int aadharId;
	@Column(name = "AADHAR_NUMBER")
	String aadharNumber;

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Override
	public String toString() {
		return "AadharCard [aadharId=" + aadharId + ", aadharNumber=" + aadharNumber + "]";
	}

	public AadharCard(int aadharId, String aadharNumber) {
		super();
		this.aadharId = aadharId;
		this.aadharNumber = aadharNumber;
	}

	public AadharCard() {

	}
}