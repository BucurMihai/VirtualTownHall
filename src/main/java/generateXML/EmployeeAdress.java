package generateXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="adress")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeAdress {
	@XmlElement
	private String city;
	@XmlElement
	private String street;
	@XmlElement
	private Integer number;
	
	public EmployeeAdress(String city, String street, Integer number){
		this.city = city;
		this.street = street;
		this.number = number;
		
	}
	
	public EmployeeAdress(){
		this.city = null;
		this.street = null;
		this.number = null;
	}
	
	public String formatForMailing(){
			return street + "\n"  + city + ", " + number.toString();

	}
}
