package com.parkerInc.xmlparsers.dom.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.parkerInc.xmlparsers.dom.dto.Address;
import com.parkerInc.xmlparsers.dom.dto.DriverLicense;

public class DomParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream("xml/DriverLicense.xml"));
		DriverLicense license = new DriverLicense();

		NodeList numberList = document.getElementsByTagName("Number");
		Node number = numberList.item(0);
		license.setNumber(Integer.parseInt(number.getTextContent().trim()));

		NodeList firstNameList = document.getElementsByTagName("firstName");
		Node firstName = firstNameList.item(0);
		license.setFirstName(firstName.getTextContent());

		NodeList lastNameList = document.getElementsByTagName("lastName");
		Node lastName = lastNameList.item(0);
		license.setLastName(lastName.getTextContent());
		// gives root element
		Element element = document.getDocumentElement();
		license.setStatus(element.getAttribute("status"));

		NodeList addressList = document.getElementsByTagName("Address");
		Node address = addressList.item(0);
		NodeList addressChildNodes = address.getChildNodes();
		Address address2 = new Address();
		for (int i = 0; i < addressChildNodes.getLength(); i++) {
			Node item = addressChildNodes.item(i);
			if (item instanceof Element) {
				switch (item.getNodeName()) {
				case "street": {
					address2.setStreet(item.getTextContent());
					break;
				}
				case "city": {
					address2.setCity(item.getTextContent());
					break;
				}
				case "state": {
					address2.setState(item.getTextContent());
					break;
				}
				case "country": {
					address2.setCountry(item.getTextContent());
					break;
				}
				case "pincode": {
					address2.setZipcode(Integer.parseInt(item.getTextContent().trim()));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + item.getNodeName());
				}
			}
		}

		System.out.println(license.getNumber());
		System.out.println(license.getFirstName());
		System.out.println(license.getLastName());
		System.out.println(license.getStatus());
		System.out.println(address2);
	}

}
