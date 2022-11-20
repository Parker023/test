package com.parkerInc.xmlparsers.dom.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLWriter {
	private static final String namespace = "http://www.parkerInc.org";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setNamespaceAware(true);
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		Element root = document.createElementNS(namespace, "root");
		root.setPrefix("pk");
		document.appendChild(root);

		Element first = document.createElementNS(namespace, "first");
		first.appendChild(document.createTextNode("First Node"));
		Attr id = document.createAttribute("id");
		id.setValue("1");
		first.setAttributeNodeNS(id);
		root.appendChild(first);

		Element second = document.createElementNS(namespace, "second");
		second.appendChild(document.createTextNode("Second Node"));
		root.appendChild(second);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		StreamResult result = new StreamResult(new File(
				"C:\\Users\\U6070304\\OneDrive - Clarivate Analytics\\Desktop\\practice\\DomXMLParser\\src\\xml\\XmlWriter.xml"));
		transformer.transform(domSource, result);
	}
}
