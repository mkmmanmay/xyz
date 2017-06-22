package com.guru.framework.testing.testng.run;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.testng.strategies.DataStrategy;
import com.guru.framework.testing.utils.objects.iterator.DataTableIterator;
import com.guru.framework.testing.utils.objects.value.Row;

public class Builder {

	// Defaults
		/** The default delimiter. */
		public static String DEFAULT_DELIMITER = ",";
		
		/** The default template. */
		public static String DEFAULT_TEMPLATE = "src/test/resources/test-suite.xml";
		
		/** The default output directory. */
		public static String DEFAULT_OUTPUT_DIRECTORY = ".";
		
		public static String DEFAULT_PRINT = "false";
		
		public static String DEFAULT_RUN_ONE_SUITE = "false";
		
		// Constants for building 
		/** The Constant BUILD_NONE. */
		public static final short BUILD_NONE = 0;
		
		/** The Constant BUILD_TESTS. */
		public static final short BUILD_TESTS = 1;
		
		/** The Constant BUILD_SUITES. */
		public static final short BUILD_SUITES = 2;
		
		/** The Constant BUILD_ALL. */
		public static final short BUILD_ALL = 3;
		
		XmlDocument inputTemplate;			// original testng suite template
		XmlDocument outputTemplate;		// a single suite template				
		List<XmlDocument> output;		// list of suites produced by this builder
		
		// data-driving strategies
		DataStrategy suiteStrategy = null;
		Map<String, DataStrategy> testStrategy = new HashMap<String, DataStrategy>();
		
		
		private String delimiter = DEFAULT_DELIMITER;
		
		
		/**
		 * Instantiates a new Builder from an xml template.
		 *
		 * @param document the template to be used with this builder
		 * @throws BuilderException the BuilderException exception if template can not be copied
		 */
		public Builder(final XmlDocument document) throws BuilderException  {
			try { 
				this.inputTemplate = new XmlDocument(document);
				this.outputTemplate = new XmlDocument(this.inputTemplate);
			} 
			catch (Exception e) { throw new BuilderException(e); }
		}
		
		/**
		 * Instantiates a new Builder from a string that contains an xml template.
		 *
		 * @param string the string that contains a template to be used with this builder
		 * @throws BuilderException the BuilderException exception if template can not be copied
		 */
		public Builder(final String string) throws BuilderException  {		
			try {
				this.inputTemplate  = new XmlDocument(new ByteArrayInputStream(string.getBytes("UTF-8"))); 
				this.outputTemplate = new XmlDocument(this.inputTemplate);
			}
			catch (Exception e) { throw new BuilderException(e); }
		}
		
		/**
		 * Instantiates a new Builder from a file that contains an xml template.
		 *
		 * @param file the file that contains a template to be used with this builder
		 * @throws BuilderException the BuilderException exception if template can not be copied
		 */
		public Builder(final File file) throws BuilderException {
			try { 
				this.inputTemplate  = new XmlDocument(file); 
				this.outputTemplate = new XmlDocument(this.inputTemplate);
			}
			catch (Exception e) { throw new BuilderException(e); }
		}
					
		/**
		 * Returns the xml template.
		 *
		 * @return the template
		 */
		public XmlDocument getInputTemplate() { return  this.inputTemplate; }
		
		/**
		 * Returns the suite xml template. 
		 *
		 * @return the suite xml template
		 */
		public XmlDocument getOutputTemplate() { return this.outputTemplate;	}	
		
		
		/**
		 * Gets the output as List of XmlDocuments.
		 *
		 * @return the output List of XmlDocuments
		 */
		public List<XmlDocument> getOutput() { return this.output;	}
		
			
		/**
		 * Sets the delimiter.
		 *
		 * @param delimiter the delimiter
		 * @return the Builder
		 */
		public Builder setDelimiter(final String delimiter) {
			if(delimiter != null && !delimiter.isEmpty()) {this.delimiter = delimiter;}
			return this;
		}
			
		/**
		 * Gets the delimiter.
		 *
		 * @return the delimiter
		 */
		public String getDelimiter() {
			return this.delimiter;
		}
		
		
		/**
		 * Includes into the suite template only tests that exactly match the provided names.
		 *
		 * @param testNames the test names to be included
		 * @return the Builder
		 * @throws BuilderException the Builder exception when filtering fails
		 */
			
		public Builder includeTests(final String... testNames) throws BuilderException {
		if(testNames.length == 0) {return this;}
		try { 			
			this.outputTemplate = this.outputTemplate.removeElements("//test");
			for(String testName : testNames) {
				final List<String> t = this.inputTemplate.getElementsAsText("//test", "name", testName);	
				for(String each : t)
					{this.outputTemplate = this.outputTemplate.addDocumentFragment("//suite", each, Integer.MAX_VALUE);}
			}
			return this;
		} 
		catch (Exception e) { throw new BuilderException(e); }		
		}
		
		/**
		 * Excludes from the suite template tests that exactly match the provided names.
		 *
		 * @param testNames the test names to be excluded
		 * @return the Builder
		 * @throws BuilderException the test ng builder exception
		 */
		public Builder excludeTests(final String... testNames) throws BuilderException {
			if(testNames.length == 0) {return this;}		
			try { 			
				for(String testName : testNames) 
					{this.outputTemplate = this.outputTemplate.removeMatchingElement("//test", "name", testName);}
				return this;
			} 
			catch (Exception e) { throw new BuilderException(e); }		
		}
		
		/**
		 * Sets the suite data-driving strategy.
		 *
		 * @param strategy the DataTableStrategy
		 * @return the Builder
		 */
		public Builder setSuiteStrategy(final DataStrategy strategy) {
			this.suiteStrategy = strategy;
			return this;
		}
		
				
		/**
		 * Returns the suite data-driving strategy.
		 * @return the suite DataTableStrategy
		 */
		public DataStrategy getSuiteStrategy() {
			return this.suiteStrategy;
		}
		
		/**
		 * Sets the test data-driving strategy.
		 *
		 * @param strategy the DataTableStrategy
		 * @return the Builder
		 */
		public Builder setTestStrategy(final Map<String, DataStrategy> strategy) {
			this.testStrategy = strategy;
			return this;
		}
		
		/**
		 * Adds the test strategy for a specific test.
		 *
		 * @param testName the test name
		 * @param strategy the DataTableStrategy
		 * @return the Builder
		 */
		public Builder addTestStrategy(final String testName, final DataStrategy strategy) {
			if(this.testStrategy == null)
				{this.testStrategy = new HashMap<String, DataStrategy>();}
			this.testStrategy.put(testName, strategy);
			return this;
		}
		
		/**
		 * Returns the test data-driving strategy.
		 *
		 * @return the test DataTableStrategy
		 */
		public Map<String, DataStrategy> getTestStrategies() {
			return this.testStrategy;
		}
		
	
		
		
		
		/**
		 * Builds the output as List of XmlDocuments.
		 *
		 * @param scope the scope (one of BUILD_NONE, BUILD_TESTS, BUILD_SUITES, BUILD_ALL)
		 * @return the Builder
		 * @throws BuilderException 
		 */
		public Builder build(final short scope, final List<String> suiteParameterNames, final Map<String, List<String>> testParameterNames, final boolean renameReport, final String forceConcat) throws BuilderException {
			if(scope < BUILD_NONE || scope > BUILD_ALL)
				{throw new IllegalArgumentException("Invalid build scope  = " + scope);}
			try {
				switch(scope) {
					case BUILD_NONE: 	return setTemplateAsOutput();
					case BUILD_TESTS: 	return buildTests(testParameterNames);
					case BUILD_SUITES:	return buildSuites(suiteParameterNames, renameReport, forceConcat);
					case BUILD_ALL:		return buildTests(testParameterNames).buildSuites(suiteParameterNames, renameReport,forceConcat);
					default:			return setTemplateAsOutput();		
				}
			}
			catch (Exception e) { throw new BuilderException(e); }
		}
		
		protected Builder setTemplateAsOutput() throws TransformerException {
			final List<XmlDocument> result = new ArrayList<XmlDocument>();
			result.add(new XmlDocument(this.outputTemplate));
			this.output = result;
			return this;
		}
		
		
		protected Builder buildSuites(final List<String> parameterNaming, final boolean renameReport, final String forceConcat) throws DataTableException, XPathExpressionException, TransformerException, BuilderException, IOException {
			if(null == this.suiteStrategy) {return setTemplateAsOutput();}
			final DataTableIterator it = this.suiteStrategy.getIterator();	
			final List<String> parameterNames = it.getColumnNames();
			final String suiteName = this.getSuiteName();
			final List<XmlDocument> result = new ArrayList<XmlDocument>();
			final List<Row> rows = new ArrayList<Row> ();
			while(it.hasNext()) 
				rows.add(it.next());
			for(int i=1; i<= rows.size(); i++) {
				XmlDocument newSuite = new XmlDocument(this.outputTemplate);
								
				//listeners are loaded by testng and applied to all suites
				//once loaded, they dont need to be duplicated
				//at least for the tracker and alm handlers
				//the pdf reporter needs its own threads to be handled properly for each suite
				//however we only remove these listeners when runner-single is true, 
				//which then means that renameReport is false
				
				//when running as a single, then every suite after the first does not need to duplicate the listeners below
				//when running individually then every suite must have its own listener
				if (i>1 && renameReport == false) {
					newSuite = newSuite.removeElements("//listener[@class-name='com.ge.capital.rainbow.testng.FunctionalResultsTrackerListener']");
					newSuite = newSuite.removeElements("//listener[@class-name='com.ge.capital.rainbow.alm.ALMListenerCreateALMConfig']");
				}
				
				final Row row  = rows.get(i-1);
				for(int j=0; j<parameterNames.size(); j++) {
					final String p = parameterNames.get(j);
					newSuite = newSuite.updateAttribute("//suite/parameter[@name='" + p + "'][1]", "value", row.getCell(j).getValue().toString());
				}
			if(rows.size() > 1 || forceConcat.toLowerCase().equals("true")) 	
				{
				final List<String> names = validateSuiteParameterNames(parameterNaming);
					if(!names.isEmpty()) {
						final StringBuilder suffix = new StringBuilder();
						for(String name : names)
							{suffix.append("_").append(newSuite.getNodeValues("//suite/parameter[@name='" + name + "']/@value").get(0));}		
						newSuite = newSuite.updateAttribute("//suite[@name='" + suiteName + "']", "name", suiteName + suffix);
						if(renameReport)
						{newSuite = newSuite.updateAttribute("//suite[@name='" + suiteName + suffix + "']/parameter[@name='reportName']", "value", suiteName + suffix);}
					}
					else {
						newSuite = newSuite.updateAttribute("//suite[@name='" + suiteName + "']", "name", suiteName + "_" + i);
						if(renameReport)
						{newSuite = newSuite.updateAttribute("//suite[@name='" + suiteName + "_" + i + "']/parameter[@name='reportName']", "value", suiteName + "_" + i);}
					}
				}
				result.add(newSuite);			
			}		
			this.output = result;
			return this;
		}
		
		
		protected List<String> validateSuiteParameterNames(final List<String> parameterNames) throws BuilderException {
			final List<String> result = new ArrayList<String>();
			final List<String> suiteParameters = this.getSuiteParameterNames();
			if(null == parameterNames || parameterNames.isEmpty() || null == suiteParameters || suiteParameters.isEmpty())
				{return result;}
			for(String paramName : parameterNames)
				{if(suiteParameters.contains(paramName))
					{result.add(paramName);}}
			return result;
		}
	
		
		protected Builder buildTests(final Map<String, List<String>> paramMap) throws XPathExpressionException, TransformerException, DataTableException, IOException, BuilderException {
			if(null == this.testStrategy) {return this;}
			for(String testName : this.testStrategy.keySet()) {
				final DataTableIterator it = this.testStrategy.get(testName).getIterator();	
				final List<String> parameterNames = it.getColumnNames();
				final List<Row> rows = new ArrayList<Row> ();
				while(it.hasNext()) 
					rows.add(it.next());
				if(rows.size() > 1) 
					{this.outputTemplate = this.outputTemplate.copyMatchingElements("//suite/test", "name", testName, rows.size()-1);}
				for(int i=1; i<= rows.size(); i++) {
					final Row row  = rows.get(i-1);
					for(int j=0; j<parameterNames.size(); j++) {
						final String p = parameterNames.get(j);						
						this.outputTemplate = this.outputTemplate.updateAttribute("//suite/test[@name='" + testName + "'][1]/parameter[@name='" + p + "']", "value", row.getCell(j).getValue().toString());
					}
					if(rows.size() > 1) {
						if(null != paramMap && !paramMap.isEmpty() && paramMap.get(testName) != null && !paramMap.get(testName).isEmpty()){
							final List<String> paramNames = paramMap.get(testName);
							final StringBuilder suffix = new StringBuilder();
							for(String name : paramNames)
								{suffix.append("_").append(this.outputTemplate.getNodeValues("//suite/test[@name='" + testName + "'][1]/parameter[@name='" + name + "']/@value").get(0));}
							this.outputTemplate = this.outputTemplate.updateAttribute("//suite/test[@name='" + testName + "'][1]", "name", testName + suffix);
						}
						else {
							this.outputTemplate = this.outputTemplate.updateAttribute("//suite/test[@name='" + testName + "'][1]", "name", testName + "_" + i);
						}
					}
											
				}			
			}
			return setTemplateAsOutput();
		}
		
				
		
		/**
		 * Returns the test names from the suite.
		 *
		 * @return the List<String>
		 * @throws BuilderException 
		 */
		public List<String> getTestNames() throws BuilderException {
			try { return this.outputTemplate.getNodeValues("//suite/test/@name"); }
			catch (Exception e) { throw new BuilderException(e); }
		}
		
		/**
		 * Gets the suite parameter names.
		 *
		 * @return the List<String>
		 * @throws BuilderException 
		 */
		public List<String> getSuiteParameterNames() throws BuilderException {
			try { return this.outputTemplate.getNodeValues("//suite/parameter/@name"); }
			catch (Exception e) { throw new BuilderException(e); }		
		}
		
		/**
		 * Gets the suite name.
		 *
		 * @return the String
		 * @throws BuilderException 
		 */
		public String getSuiteName() throws BuilderException {
			try { return this.outputTemplate.getNodeValues("//suite/@name").get(0); }
			catch (Exception e) { throw new BuilderException(e); }		
		}
		
		/**
		 * Gets the test parameter names.
		 *
		 * @return the List<String>
		 * @throws BuilderException
		 */
		public List<String> getTestParameterNames() throws BuilderException {
			try { return this.outputTemplate.getNodeValues("//suite/test/parameter/@name"); }
			catch (Exception e) { throw new BuilderException(e); }		
		}
		
		/**
		 * Checks if parameter exists in the test test.
		 *
		 * @param testName the test name
		 * @param parameterName the parameter name
		 * @return true, if successful
		 * @throws BuilderException
		 */
		public boolean hasParameterInTest(final String testName, final String parameterName) throws BuilderException {		
			if(null == testName || null == parameterName) {return false;}
			try {
				final List<String> nodes = this.outputTemplate.getNodeValues("//suite/test[@name='" + testName + "']/parameter[@name='" + parameterName + "']");
				return nodes != null && nodes.size() > 0;
			}
			catch (Exception e) { throw new BuilderException(e); }	
		}
		
		/**
		 * Adds a listener to the test.
		 *
		 * @param className the class name of the listener
		 * @return the Builder
		 * @throws BuilderException
		 */
		public Builder addListener(final String className) throws BuilderException {
			if(null == className || className.isEmpty()) 
				{return this;}
			try {
				// override listener if the listener is there and return
				if(!this.outputTemplate.getNodeValues("//suite/listeners/listener[@class-name='" + className + "']").isEmpty()) {
					this.outputTemplate = this.outputTemplate.updateAttribute("//suite/listeners/listener[@class-name='" + className + "']", "class-name", className);
				}		
				// create a listener tag if it is not there
				if(this.outputTemplate.getNodeValues("//suite/listeners").isEmpty()) 
					{this.outputTemplate = this.outputTemplate.addElement("//suite", "listeners", 0);}
				this.outputTemplate = this.outputTemplate.addElement("//suite/listeners", "listener", 0);
				this.outputTemplate = this.outputTemplate.addAttribute("//suite/listeners/listener[1]", "class-name", className);		
				return this;
			}
			catch (Exception e) { throw new BuilderException(e); }	
		}
		
		/**
		 * Removes a listener from the test
		 *
		 * @param className the class name
		 * @return the Builder
		 * @throws BuilderException
		 */
		public Builder removeListener(final String className) throws BuilderException {
			if(null == className || className.isEmpty()) 
				{return this;}
			try {
				// remove listeners if they are not present
				if(!this.outputTemplate.getNodeValues("//suite/listeners/listener[@class-name='" + className + "']").isEmpty())
					{this.outputTemplate = this.outputTemplate.removeElements("//suite/listeners/listener[@class-name='" + className + "']");}
				return this;
			}
			catch (Exception e) { throw new BuilderException(e); }	
		}
		
				
				
	}

	class BuilderException extends Exception {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -9208275300373257167L;

		BuilderException(final String message) { super(message); }
		
		BuilderException(final Throwable t) { super(t); }
		
		BuilderException(final String message, final Throwable t) { super(message, t); }
		
	}