package com.parkerInc.xmlparsers.dom.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReservationDomParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/Reservation.xml"));
		document.getDocumentElement().normalize();
		Element node = document.getDocumentElement();
		NodeList mainlist = node.getChildNodes();
		for (int i = 0; i < mainlist.getLength(); i++) {
			NodeList list = mainlist.item(i).getChildNodes();
			for (int j = 0; j < list.getLength(); j++) {
				System.out.println(list.item(j).getTextContent());
			}
		}
	}

}
