/*package com.guru.framework.testing.helpers;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.utils.PathHelper;

public class EmailGenerator extends PDFReporter{

	private static boolean isThisTestFailed=false;
	private static Properties expectedDurationProp=null;
	private String to[]=null;
	private String attachmentLocation=null;
	private String testNGResultFileLocation=null;
	private String expectedExeuctionTimeFileName=null;
	private String healthCheckName=null;

	public EmailGenerator() throws Throwable {
		super();
	}

	public EmailGenerator(String s) throws Throwable{
		
	}
	 
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,String arg2)  {
		try {
		 super.generateReport(arg0, arg1, arg2);
		
		  XmlSuite xmlSuite=arg1.get(0).getXmlSuite();
		  healthCheckName=xmlSuite.getParameter("reportName");
		  to=xmlSuite.getParameter("mailTo").split(":");
		  expectedExeuctionTimeFileName=xmlSuite.getParameter("expectedExecutionTimeFileName");
		  String pdfName=  xmlSuite.getParameter("reportName");
		  String rootPath=PathHelper.getRootPath();
		  attachmentLocation=rootPath+File.separator+pdfName+".pdf";
		  testNGResultFileLocation=rootPath+File.separator+"test-run-result.xml";
		  
	     this.generateMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  generateMail() throws Exception{
		
		
		expectedDurationProp=new Properties();
		expectedDurationProp.load(new FileReader(new File("target/test-classes/"+expectedExeuctionTimeFileName)));
		
		String messageBody=this.getBodyContent(testNGResultFileLocation);

		this.sendMail(messageBody,attachmentLocation);
	}
	
	
	public void sendMail(String messageBody,String attachmentLocation) throws Exception{

		ScriptLogger.debug();
		
		
		Properties prop=new Properties();
		//prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.host","mail.ad.ge.com");

		Session session=Session.getInstance(prop);

		Message msg=new MimeMessage(session);

		msg.setFrom(new InternetAddress("automatedtest.nafleet@ge.com"));
		
		
		InternetAddress[] toAddress=new InternetAddress[to.length];
		for(int i=0;i<to.length;i++){
			ScriptLogger.debug("To: "+to[i]);
			toAddress[i]=new InternetAddress(to[i]);
		}
		
		msg.setRecipients(Message.RecipientType.TO,toAddress);
		
		ScriptLogger.debug("Mail Subject: "+getSubject());
		msg.setSubject(getSubject());

		MimeBodyPart mp1=new MimeBodyPart();
		ScriptLogger.debug(messageBody);
		mp1.setContent(messageBody, "text/html");
		
		MimeBodyPart mp2=new MimeBodyPart();
		ScriptLogger.debug(attachmentLocation);
		mp2.attachFile(attachmentLocation);


		Multipart mp=new MimeMultipart();
		mp.addBodyPart(mp1);
		mp.addBodyPart(mp2);

		msg.setContent(mp);
		Transport.send(msg);

		ScriptLogger.debug("Mail Sent Successfully");
	}


	public String getSubject() throws Exception{
		
		if(isThisTestFailed){
			return healthCheckName+" - Failed";
		}
		else{
			return healthCheckName+"  - Passed";
		}
	}
	
	public  String getBodyContent(String testNGResultFileName) throws Exception{

		StringBuilder builder=new StringBuilder("<HTML>");
		builder.append("<BODY>");
		
		long totaltimetaken=getTotalExecutionTime(testNGResultFileName, "/test-run-result/@duration-ms");
		
		builder.append("<h4>Total Test Duration: "+totaltimetaken+" secs</h4>");
		builder.append("<table border=\"1\">");
		builder.append("<tr>");
		builder.append("<th>Test Name</th>");
		builder.append("<th>Method Executed </th>");
		builder.append("<th>Status </th>");
		builder.append("<th>Duration in secs</th>");
		builder.append("<th>Execution time threshold in secs</th>");
		builder.append("<th> Reason for failure </th>");
		builder.append("</tr>");
		List<TestDetails> list=this.getTestDetails(testNGResultFileName,  "//test-method");
		for (TestDetails testDetails : list) {
			
			builder.append("<tr>");

			builder.append(testDetails.getTestName());
            builder.append(testDetails.getMethodExecuted());
            builder.append(testDetails.getStatus());
			builder.append(testDetails.getDuration());
			builder.append(testDetails.getExpectedDuration());
			builder.append(testDetails.getReasonForFailure());
			
			builder.append("</tr>");
		}

		builder.append("</table>");
		builder.append("<BODY>");
		builder.append("</HTML>");

		return builder.toString();
	}

	public  List<TestDetails> getTestDetails(String source,String xPathExpression) throws Exception{

		List<TestDetails> testDetailsList=new ArrayList<TestDetails>();

		XPathFactory factory=XPathFactory.newInstance();
		XPath xPath=factory.newXPath();
		XPathExpression expression=xPath.compile(xPathExpression);
		
		NodeList nodeList=(NodeList) expression.evaluate(parse(new File(source)),XPathConstants.NODESET);
		for(int i=0;i<nodeList.getLength();i++){
			Node node=nodeList.item(i);
			NamedNodeMap nodeMap=node.getAttributes();

			String testName=nodeMap.getNamedItem("class").getTextContent();
			String methodExecuted=nodeMap.getNamedItem("name").getTextContent();
			String status=nodeMap.getNamedItem("status").getTextContent();
			long duration=Long.parseLong(nodeMap.getNamedItem("duration-ms").getTextContent());
			String reasonForFailure="";
			if(status.equalsIgnoreCase("FAIL")){
				reasonForFailure=getReasonForFailure(node);
			}
			
			EmailGenerator currentObject=this;
			EmailGenerator.TestDetails testobj=currentObject.new TestDetails();
			testobj.setTestName(testName);
			testobj.setMethodExecuted(methodExecuted);
			testobj.setStatus(status);
			testobj.setDuration(testName,methodExecuted,duration);
			testobj.setExpectedDuration(testName,methodExecuted);
			testobj.setReasonForFailure(reasonForFailure);
			testDetailsList.add(testobj);
		}

		return testDetailsList;
	}

	public static String getReasonForFailure(Node node) throws Exception{
		
		String reasonForFailure="";
		try{
			Node exceptionode=null;
			NodeList childNodesList=node.getChildNodes();
			for(int i=0;i<childNodesList.getLength();i++){
				Node childNode=childNodesList.item(i);
				if(childNode.getNodeName().equalsIgnoreCase("exception")){
					exceptionode=childNode;
					break;
				}
			}
			if(exceptionode!=null){
				NamedNodeMap exceptionodeattr=exceptionode.getAttributes();
				String exceptionClass=exceptionodeattr.getNamedItem("class").getTextContent();
				Node messagenode=exceptionode.getFirstChild();
				String message=messagenode.getTextContent();
				reasonForFailure=exceptionClass+":"+message;
			}
			
		}catch(Exception e){ e.printStackTrace();}
		return reasonForFailure;
	}
	
	public static long getTotalExecutionTime(String source,String xPathExpression) throws Exception{
		 
		XPathFactory factory=XPathFactory.newInstance();
		XPath xPath=factory.newXPath();
		XPathExpression expression=xPath.compile(xPathExpression);
		Double duration=(Double)expression.evaluate(parse(new File(source)),XPathConstants.NUMBER);
		long totalExecutionTime=(long)(duration/1000.0);
		return totalExecutionTime;
	}
	
	public static Document parse(File xmlSource) throws Exception{

		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.parse(xmlSource);
		return document;
	}

	class TestDetails{

		private String testName;
		private String methodExecuted;
		private String status;
		private String duration;
		private String expectedDuration;
		private String reasonForFailure;
		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName) {
			this.testName = "<td>"+testName+"</td>";
		}
		public String getMethodExecuted() {
			return methodExecuted;
		}
		public void setMethodExecuted(String methodExecuted) {
			this.methodExecuted = "<td>"+methodExecuted+"</td>";
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			if(status.equalsIgnoreCase("PASS"))
			  this.status = "<td bgcolor='lightgreen'>"+status+"</td>";
			else if(status.equalsIgnoreCase("FAIL")){
				this.status = "<td bgcolor='red'>"+status+"</td>";
				isThisTestFailed=true;
			}
			else if((status.equalsIgnoreCase("SKIP"))) 
				this.status = "<td bgcolor='orange'>"+status+"</td>";
		}
		public String getExpectedDuration() {
			return expectedDuration;
		}
		public void setExpectedDuration(String testName,String methodName) {
			this.expectedDuration = "<td>"+getExecutionTimeThresholdValue(testName, methodName)+"</td>";
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String testName,String methodName,long duration) {
			double executedDuration=(duration/1000.0);
			if(checkExecutedTimeCrossedExpectedThresholdValue(testName, methodName, executedDuration))
			 this.duration="<td bgcolor='orange'>"+executedDuration+"</td>";
			else
			 this.duration="<td>"+executedDuration+"</td>";	
					
		}
		public String getReasonForFailure() {
			return reasonForFailure;
		}
		public void setReasonForFailure(String reasonForFailure) {
			this.reasonForFailure = "<td>"+ reasonForFailure+ "</td>";
		}

		@Override
		public String toString() {
			return getTestName()+" "+getMethodExecuted()+" "+getStatus()+" "+getDuration()+" "+getReasonForFailure();
		}
		
	}
	
	public static String getExecutionTimeThresholdValue(String testName,String methodName){
		ScriptLogger.debug();
        String key=testName+"-"+methodName;
        String value=(String)expectedDurationProp.get(key);
        ScriptLogger.debug(key+": "+value);
        return value;
	}
	
	public static boolean checkExecutedTimeCrossedExpectedThresholdValue(String testName,String methodName,double executedDuration){
		ScriptLogger.debug();
		boolean isCrossed=false;
		String key=testName+"-"+methodName;
		String value=(String)expectedDurationProp.get(key);
		ScriptLogger.debug(key+": "+expectedDurationProp.get(key));
		double expectedDuration=0.0;
		if(StringUtils.isNumeric(value)){
          expectedDuration=Double.parseDouble(value);
		}
		
        if(executedDuration>expectedDuration){
        	isCrossed=true;
        }
        return isCrossed;
	}
	
}
*/