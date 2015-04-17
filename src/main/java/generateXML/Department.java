package generateXML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

	@XmlElement
	String departmentName;
	@XmlElement
	Integer departmentSize;
	@XmlElement(name = "employee")
	List<Employee> departmentEmployees;

	public Department(String departmentName) {
		departmentEmployees = new ArrayList<Employee>();
		departmentSize = 0;
		this.departmentName = departmentName;

	}

	public Department() {
		departmentEmployees = new ArrayList<Employee>();
		departmentSize = 0;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentSize() {
		return departmentSize;
	}

	/*
	 * Method to add a new employee in the list boolean. local variable checkCnp
	 * checks if there is allready an employee with that cnp
	 */
	public void addNewEmployee(Employee newEmployee) {
		
			departmentEmployees.add(newEmployee);
			departmentSize++;
	
	}

}
