package generateXML;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class test {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String... args) {

		Departments departaments = new Departments();
		departaments.addDepartament(new Department("abc"));
		departaments.addDepartament(new Department("ghi"));
		departaments.addEmployee("abc", new Employee(1, "gheorghe", "adrian",
				"19343239952", 150, new EmployeeAdress("Craiova",
						"Strada Aviatorilor", 25)));
		
		
		departaments.addEmployee("ghi", new Employee(1, "gheorghe", "adrian",
				"19343239952", 150, new EmployeeAdress("Craiova",
						"Strada Aviatorilor", 25)));

		System.out
				.println("Departments.xml validate against departments.xsd ? "
						+ validateXMLSchema("Departments.xsd",
								"Departments.xml"));

		File file = new File(
				"E:\\java workspace\\VirtualTownHall\\Departments.xml");

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Departments.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(departaments, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}
