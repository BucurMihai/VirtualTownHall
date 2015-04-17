package generateXML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "departments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Departments {

	@XmlElement(name = "department")
	private List<Department> departments;

	public Departments() {
		departments = new ArrayList<Department>();
	}

	public void addEmployee(String departmentName, Employee newEmployee) {
		boolean foundDepartment = false;
		for(Department departmentIterator  : departments){
			if(departmentIterator.getDepartmentName().equals(departmentName)){
				departmentIterator.addNewEmployee(newEmployee);
				foundDepartment = true;
			}
		}
		if (!foundDepartment){
			System.out.println("Departament not found");
		}
	}

	public void addDepartament(Department department) {
		boolean foundDepartment = false;
		for(Department departmentIterator : departments){
			if(departmentIterator.getDepartmentName().equals(department.getDepartmentName())){
				foundDepartment = true;
			}
		}
		if(!foundDepartment){
			departments.add(department);
		}
	}

	public List<Department> getDepartaments() {
		return departments;
	}
}
