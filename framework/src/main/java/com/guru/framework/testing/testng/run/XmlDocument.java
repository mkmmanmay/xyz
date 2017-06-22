package com.guru.framework.testing.testng.run;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlDocument {
	private static final Logger logger = Logger.getLogger(XmlDocument.class.getName());
	
	protected Document template;
	
	protected static  XPathFactory factory = XPathFactory.newInstance();
	protected static TransformerFactory tfactory = TransformerFactory.newInstance();
	
	public XmlDocument(final InputStream is) throws ParserConfigurationException, SAXException, IOException {		
		final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setIgnoringElementContentWhitespace(true);
		final DocumentBuilder builder = builderFactory.newDocumentBuilder();
		this.setDocument(builder.parse(is));
	}
	
	public XmlDocument(final File file) throws ParserConfigurationException, SAXException, IOException {		
		final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setIgnoringElementContentWhitespace(true);
		final DocumentBuilder builder = builderFactory.newDocumentBuilder();
		this.setDocument(builder.parse(file));
	}
	
	public XmlDocument(final String is) throws ParserConfigurationException, SAXException, IOException {		
		final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setIgnoringElementContentWhitespace(true);
		final DocumentBuilder builder = builderFactory.newDocumentBuilder();
		this.setDocument(builder.parse(is));
	}
	
	// deep copy
	public XmlDocument(final XmlDocument other) throws TransformerException {
		final Transformer tx   = tfactory.newTransformer();
		final DOMSource source = new DOMSource(other.getDocument());
		final DOMResult result = new DOMResult();
		tx.transform(source,result);
		this.setDocument((Document)(result.getNode()));
	}
	
	
	public Document getDocument() { return this.template; }
	
	public void setDocument(final Document document) { this.template = document; }
	
	// returns a list of node values
	public List<String> getNodeValues(String xpath) throws XPathExpressionException {
		return getNodeValues(getMatchingNodes(xpath));
	}
	
		
	public List<String> getElementsAsText(final String xpath, final String attrName, final String regex) throws XPathExpressionException   {
		if(xpath == null)
			{throw new IllegalArgumentException("Null xpath is not allowed");}
		final NodeList nodes = getMatchingNodes(xpath);
		final List<String> result = new ArrayList<String>();
		if(nodes == null) {return result;}
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			if(attrName == null && regex == null) {result.add(getNodeText(node));}
			else if(regex == null) {
				if(node.getAttributes().getNamedItem(attrName) != null) // copy all elements that have given attribute
					{result.add(getNodeText(node));}
			}			
			else if(node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) // copy only elements that have matching attribute and value
				{result.add(getNodeText(node));}
		}
		return result;
	}
	
		
	// Copies matching elements n times
	public XmlDocument copyElements(final String xpath, final int n) throws TransformerException, XPathExpressionException {
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes || n < 1) {return xml;} // no match}
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			xml.copyNodeNTimes(node, n);
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Copies matching elements n times
	public XmlDocument copyMatchingElements(final String xpath, final String attrName, final String regex, final int n) throws TransformerException, XPathExpressionException  {
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes || n < 1) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			if(attrName == null && regex == null) {xml.copyNodeNTimes(node, n);}	// copy all elements, do not filter on attributes
			else if(regex == null) {
				if(node.getAttributes().getNamedItem(attrName) != null) // copy all elements that have given attribute
					{xml.copyNodeNTimes(node, n);}
			}			
			else if(node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) // copy only elements that have matching attribute and value
				{xml.copyNodeNTimes(node, n);}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Copies non-matching elements n times
	public XmlDocument copyNonMatchingElements(final String xpath, final String attrName, final String regex, final int n) throws TransformerException, XPathExpressionException  {
		if(attrName == null && regex == null)
			{throw new IllegalArgumentException("One of attrName or regex is required");}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes || n < 1) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			if(regex == null) {
				if(node.getAttributes().getNamedItem(attrName) == null) // copy nodes that do not have an attribute
					{xml.copyNodeNTimes(node, n);}							
			}
			else if(!node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) // copy only elements that do not have matching attribute value
				{xml.copyNodeNTimes(node, n);}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Copies matching elements n times
	public XmlDocument removeElements(final String xpath) throws TransformerException, XPathExpressionException {
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes) {return xml; }// no match
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			xml.removeNode(node);
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Removes matching elements
	public XmlDocument removeMatchingElement(final String xpath, final String attrName, final String regex) throws TransformerException, XPathExpressionException {
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			if(attrName == null && regex == null) {xml.removeNode(node);}	// remove all elements, do not filter on attributes
			else if(regex == null) {
				if(node.getAttributes().getNamedItem(attrName) != null) // remove all elements that have given attribute
					{xml.removeNode(node);}
			}			
			else if(node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) // remove only elements that have matching attribute and value
				{xml.removeNode(node);}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Removes non-matching elements
	public XmlDocument removeNonMatchingElement(final String xpath, final String attrName, final String regex) throws TransformerException, XPathExpressionException {
		if(attrName == null && regex == null)
			{throw new IllegalArgumentException("One of attrName or regex is required");}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			if(regex == null) {
				if(node.getAttributes().getNamedItem(attrName) == null) // remove nodes that do not have an attribute
					{xml.removeNode(node);}							
			}
			else if(!node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) // remove only elements that have matching attribute and value
				{xml.removeNode(node);}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Adds an attribute to all elements that match elementXPath
	public XmlDocument addAttribute(final String elementXPath, final String attrName, final String attrValue) throws TransformerException, XPathExpressionException  {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName+","+attrValue);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ){ return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Element element  = (Element)(nodes.item(i));
			element.setAttribute(attrName, attrValue);
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	
	//Removes an attribute from all elements that match elementXPath
	public XmlDocument removeAttribute(final String elementXPath, final String attrName) throws TransformerException, XPathExpressionException {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Node node = nodes.item(i);
			if(node.getAttributes().getNamedItem(attrName) != null) 
				{node.getAttributes().removeNamedItem(attrName);}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	//Removes an attribute from all elements that match elementXPath and have matching value
	public XmlDocument removeAttribute(final String xpath, final String attrName, final String regex) throws TransformerException, XPathExpressionException {
		if(regex == null) {return removeAttribute(xpath, attrName);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(xpath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Node node = nodes.item(i);
			if(node.getAttributes().getNamedItem(attrName) != null) {
				if(node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex))
					{node.getAttributes().removeNamedItem(attrName);}
			}
		}
		xml.getDocument().normalize();
		return xml;
	}
		
	//Removes an attribute from all elements that match elementXPath and have non matching value
	public XmlDocument removeAttributeByNonMatchingValue(final String elementXPath, final String attrName, final String regex) throws TransformerException, XPathExpressionException {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ) {return xml; }// no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Node node = nodes.item(i);
			if(node.getAttributes().getNamedItem(attrName) != null) {
				if(regex == null)
					{node.getAttributes().removeNamedItem(attrName);}
				else if(!node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex))
					{node.getAttributes().removeNamedItem(attrName);}
			}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Updates attribute
	public XmlDocument updateAttribute(final String elementXPath, final String attrName, final String attrValue) throws TransformerException, XPathExpressionException {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName+","+attrValue);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Element element  = (Element)(nodes.item(i));
			element.setAttribute(attrName, attrValue);
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// Updates attribute only if it has matching values
	public XmlDocument updateAttributeByMatchingValue(final String elementXPath, final String attrName, final String regex, final String attrValue) throws TransformerException, XPathExpressionException {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName+","+attrValue);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Node node = nodes.item(i);
			if(node.getAttributes().getNamedItem(attrName) != null) {
				if(regex == null || node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) {
					final Element element  = (Element)(nodes.item(i));
					element.setAttribute(attrName, attrValue);									
				}
			}
		}
		xml.getDocument().normalize();
		return xml;
	}
		
	public XmlDocument updateAttributeByNonMatchingValue(final String elementXPath, final String attrName, final String regex, final String attrValue) throws TransformerException, XPathExpressionException {
		if(null == elementXPath || null == attrName)
			{throw new IllegalArgumentException("Missing required argument:" + elementXPath +","+attrName+","+attrValue);}
		final XmlDocument xml = new XmlDocument(this);
		final NodeList nodes = xml.getMatchingNodes(elementXPath);
		if(null == nodes ) {return xml;} // no match
		for(int i=0; i< nodes.getLength(); i++)  {
			final Node node = nodes.item(i);
			if(node.getAttributes().getNamedItem(attrName) != null) {
				if(regex == null || !node.getAttributes().getNamedItem(attrName).getNodeValue().matches(regex)) {
					final Element element  = (Element)(nodes.item(i));
					element.setAttribute(attrName, attrValue);									
				}
			}
		}
		xml.getDocument().normalize();
		return xml;
	}
	
	// adds an Element under a specified root to a specific position (0-based)
		public XmlDocument addElement(final String rootPath, final String name, final int position) throws TransformerException, XPathExpressionException, IOException  {
			final XmlDocument xml = new XmlDocument(this);
			final NodeList nodes = xml.getMatchingNodes(rootPath);
			if(nodes == null || nodes.getLength() == 0) {throw new IllegalArgumentException("Element not found using xpath=" + rootPath);}
			for(int i=0; i<nodes.getLength(); i++) { // append a new element under each matching root node
				final Element element = xml.getDocument().createElement(name);				
				final Node root = nodes.item(i);	
				final List<Element> childElements = getChildElements(root);
				if(childElements.size() == 0 || position >= childElements.size())	{root.appendChild(element);}
				else if(position <= 0)												{root.insertBefore(element, childElements.get(0));}
				else 																{root.insertBefore(element, childElements.get(position));}
			}		
			xml.getDocument().normalize();
			return xml;
		}
		
	
		
	public XmlDocument addDocumentFragment(final String rootPath, final String fragment, final int position) throws TransformerException, ParserConfigurationException, FactoryConfigurationError, SAXException, IOException, XPathExpressionException 	{
		final XmlDocument xml = new XmlDocument(this);
		final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Node n = builder.parse( new InputSource(new StringReader(fragment))).getDocumentElement();
		n = xml.getDocument().importNode(n, true);
		final NodeList nodes = xml.getMatchingNodes(rootPath);
		if(nodes == null || nodes.getLength() == 0) {throw new IllegalArgumentException("Element not found using xpath=" + rootPath);}
		for(int i=0; i<nodes.getLength(); i++) { // append a new element under each matching root node
			final Node root = nodes.item(i);	
			final List<Element> childElements = getChildElements(root);
			if(childElements.size() == 0 || position >= childElements.size())	{root.appendChild(n);}
			else if(position <= 0)												{root.insertBefore(n, childElements.get(0));}
			else 																{root.insertBefore(n, childElements.get(position));}
		}		
		xml.getDocument().normalize();		
		return xml;
	}
	
	
	
	// removes a node
	protected void removeNode(final Node node) {
		node.getParentNode().removeChild(node);
		this.getDocument().normalize();
	}
	
	// copies a node
	protected void copyNode(final Node node)  {
		final Node newNode = node.cloneNode(true);	
		node.getParentNode().insertBefore(newNode, node);
	}
	
	protected void copyNodeNTimes(final Node node, final int n) {
		for(int j=0; j<n; j++) 
			{copyNode(node);}
	}
	
	protected List<String> getNodeValues(final NodeList nodes) {		
		if(null == nodes) {return new ArrayList<String>();}
		final List<String> result  = new ArrayList<String>(nodes.getLength());
		for(int i=0; i<nodes.getLength(); i++) 
			{result.add(nodes.item(i).getNodeValue());}		
		return result;
	}
	
	protected List<Element> getChildElements(final Node node) {
		final List<Element> childElements = new ArrayList<Element>();
		if(null == node) {return childElements;}
		final NodeList allChildren = node.getChildNodes();		
		if(null == allChildren) {return childElements;}
		for(int j=0; j<allChildren.getLength(); j++) {
			final Node each = allChildren.item(j);
			if(each.getNodeType() == Node.ELEMENT_NODE)
				{childElements.add((Element)each);}
		}
		return childElements;
	}
	
	// returns NodeList that matches a regular expression
	protected NodeList getMatchingNodes(final String xpath) throws XPathExpressionException {		
		final  XPathExpression expr = factory.newXPath().compile(xpath);
		 return (NodeList)(expr.evaluate(template, XPathConstants.NODESET));	
	}
	
	protected static Transformer getTransformer() throws TransformerConfigurationException {
		final Transformer transformer = tfactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		return transformer;
	}
	
	
	
	
	
	public static void printNode(final Node doc, final OutputStream out) throws IOException, TransformerException {
	    getTransformer().transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}
	
	public static String getNodeText(final Node node) {
		final StringWriter writer = new StringWriter();
		try {
			getTransformer().transform(new DOMSource(node), new StreamResult(writer));
		} catch (TransformerConfigurationException e) {			
			logger.log(Level.SEVERE, e.getMessage());
		} catch (TransformerException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return writer.toString();
	}
	
	
	public String toString() {
		return getNodeText(this.getDocument());
	}
	
	
	
	public static void printNodeList(final NodeList list, final OutputStream out) throws IOException, TransformerException {
		for(int i=0; i<list.getLength(); i++) {
			printNode(list.item(i), out);			
		}
	}
	
	
	
	
}
