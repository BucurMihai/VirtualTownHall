package generateXML;

import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This class describes the Employee
 * members like firstName lastName describe an employee and have references in the XML document
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlElement
	private Integer id;
	@XmlElement
	private String firstName;
	@XmlElement
	private String lastName;
	@XmlElement
	private String cnp;
	@XmlElement
	private double income;
	@XmlElement
	private GregorianCalendar startingDay;
	@XmlElement(name = "adress")
	private EmployeeAdress employeeAdress;

	public Employee(Integer id, String firstName, String lastName,String cnp,
			double income, GregorianCalendar startingDay,
			EmployeeAdress employeeAdress) {
		this(id, firstName, lastName,cnp, income, employeeAdress);
		this.startingDay = startingDay;
	}

	public Employee(Integer id, String firstName, String lastName, String cnp,
			double income, EmployeeAdress employeeAdress) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.income = income;
		this.employeeAdress = employeeAdress;
		this.cnp = cnp;
	}

	public Employee() {
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.income = 0;
		this.startingDay = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public GregorianCalendar getStartingDay() {
		return startingDay;
	}
	
	public String getCnp() {
		return cnp;
	}
	
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	
	public EmployeeAdress getEmployeeAdress() {
		return employeeAdress;
	}
	
	public void setEmployeeAdress(EmployeeAdress employeeAdress) {
		this.employeeAdress = employeeAdress;
	}

	public void setStartingDay(GregorianCalendar startingDay) {
		this.startingDay = startingDay;
	}
	
	public String formatAdressForMailing(){
		return employeeAdress.formatForMailing();
	}

}
