package com.guru.framework.testing.testng.run;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import com.guru.framework.testing.objects.exceptions.DataTableException;
import com.guru.framework.testing.testng.strategies.DataStrategy;
import com.guru.framework.testing.testng.strategies.PermutationStrategy;
import com.guru.framework.testing.testng.strategies.RandomStrategy;
import com.guru.framework.testing.testng.strategies.SequentialStrategy;


public class Runner {
	private static final Logger logger = Logger.getLogger(Runner.class.getName());
	
	protected Configuration conf;
	protected  Map<String, List<String>> parameters;
	protected Builder builder;
	
	public Runner(final String... args) throws BuilderException {
		this.conf = buildBuilderConfigurationFromArgs(args);
		this.parameters = buildParametersFromArgs(this.conf.get(RunnerOptions.PROPERTY_DELIMITER.getValue()), args);
		if(this.conf.get(RunnerOptions.PROPERTY_SUITE_STRING.getValue()) != null)
			{this.builder = new Builder(this.conf.get(RunnerOptions.PROPERTY_SUITE_STRING.getValue()));}
		else	
			{this.builder = new Builder(new File(this.conf.get(RunnerOptions.PROPERTY_SUITE_TEMPLATE.getValue())));}
	}
	
	
	// processes optional test include/exclude
	public void includeExcludeTests(final boolean include) throws BuilderException {
		final String values = include ? this.conf.get(RunnerOptions.PROPERTY_TEST_INCLUDE.getValue()) : this.conf.get(RunnerOptions.PROPERTY_TEST_EXCLUDE.getValue());
		if(null != values && !values.isEmpty()) {
			String[] toProcess = values.split(this.builder.getDelimiter());
			for(int i = 0; i < toProcess.length; i++)
				{toProcess[i] = toProcess[i].trim();}
			if(include) {builder.includeTests(toProcess);}
			else 		{builder.excludeTests(toProcess);}
		}
	}
	
	// processes optional add/remove listener directives
	public void addRemoveListeners(final boolean add) throws BuilderException {
		final String values = add ? this.conf.get(RunnerOptions.PROPERTY_LISTENER_ADD.getValue()) : this.conf.get(RunnerOptions.PROPERTY_LISTENER_REMOVE.getValue());
		if(null != values && !values.isEmpty()) {
			final String[] listeners = values.split(this.builder.getDelimiter());
			for(String listener : listeners){
				if(add) 	{builder.addListener(listener.trim());}
				else 		{builder.removeListener(listener.trim());}
			}
		}
	}
	
	// sets optional suite strategy
	public void setSuiteStrategy() throws NumberFormatException, DataTableException, BuilderException {
		final DataStrategy suiteStrategy = getStrategy(conf.get(RunnerOptions.PROPERTY_SUITE_STRATEGY.getValue()), builder.getDelimiter(), true, null);
		if(null != suiteStrategy)
			{builder.setSuiteStrategy(suiteStrategy);}
	}
	
	
	
	// processes test strategies in the form: testName1=Permutation|testName2=Sequence,2
	public void setTestStrategies() throws NumberFormatException, DataTableException, BuilderException {
		final String testStrategies = conf.get(RunnerOptions.PROPERTY_TEST_STRATEGY.getValue());
		if(null != testStrategies) {
			final Map<String, DataStrategy> strategyMap = new HashMap<String, DataStrategy>();
			for(String each : testStrategies.split("\\|")) {
				final String[] split2 = each.split("=");
				if(split2.length == 2) {
					final DataStrategy testStrategy = getStrategy(split2[1], builder.getDelimiter(), false, split2[0]);
					strategyMap.put(split2[0], testStrategy);
				}					
			}
			builder.setTestStrategy(strategyMap);
		}
	}
	
	// returns only suite parameters that are defined at the suite level
	protected  Map<String, List<String>> extractSuiteParameters() throws BuilderException  {
		final Map<String, List<String>> result = new HashMap<String,  List<String>>();
		if(parameters != null && !parameters.isEmpty()) {	
			final List<String> suiteParamNames = builder.getSuiteParameterNames();
			for(String parameterName : parameters.keySet()) {
				if(suiteParamNames.contains(parameterName))
					{result.put(parameterName, parameters.get(parameterName));}
			}
		}
		return result;
	}
	
	// returns test parameters
	protected Map<String, Map<String, List<String>>> extractTestParameters() throws BuilderException  { 
		final List<String> testNames = builder.getTestNames();				
		final Map<String, Map<String, List<String>>> result = new HashMap<String, Map<String, List<String>>>();			
			for(String testName : testNames)
				{result.put(testName, new HashMap<String, List<String>>());}
			if(parameters != null && !parameters.isEmpty()) {
				final List<String> p = builder.getTestParameterNames();			
				for(String parameterName :  parameters.keySet()) {
					for(String testName : testNames) {
						if(p != null && p.contains(parameterName) && builder.hasParameterInTest(testName, parameterName)) {					
							final Map<String, List<String>> map = result.get(testName);
							map.put(parameterName, parameters.get(parameterName));
						}
					}
				}
			}
			return result;
		}
	// suiteparam1,suiteparam2
	protected List<String> extractSuiteParametersForNamingFromConfiguration() throws BuilderException {
		final String names = conf.get(RunnerOptions.PROPERTY_SUITE_NAMING_PARAMETER.getValue());
		return names != null ? Arrays.asList(names.split(builder.getDelimiter())) : new ArrayList<String>();
	}
	
	
	// testname1=testparam1,testparam2|testname2=testparam3
	protected Map<String, List<String>> extractTestParametersForNamingFromConfiguration() throws BuilderException {
		final Map<String, List<String>> result = new HashMap<String, List<String>>();
		final String names = conf.get(RunnerOptions.PROPERTY_TEST_NAMING_PARAMETER.getValue());
		if(names != null) {
			for(String each : names.split("\\|")) {
				final String[] split2 = each.split("=");
				if(split2.length == 2) {
					result.put(split2[0], Arrays.asList(split2[1].split(builder.getDelimiter())));
				}					
			}
		}		
		return result;
	}
	
	
	
	protected Configuration buildBuilderConfigurationFromArgs(final String...args) {		
		final BaseConfiguration conf = new BaseConfiguration();
		// process arguments
		for(String arg : args) {
			final String[] split = arg.split("=", 2);
			if(split.length == 2 && null != RunnerOptions.getValueOf(split[0].trim()) ) { // configuration
				conf.add(split[0].trim(), split[1].trim());
			}
		}
		// ensure that required default values are provided
		if(conf.get(RunnerOptions.PROPERTY_DELIMITER.getValue()) == null) 			{conf.add(RunnerOptions.PROPERTY_DELIMITER.getValue(), Builder.DEFAULT_DELIMITER);}
		if(conf.get(RunnerOptions.PROPERTY_OUTPUT_DIRECTORY.getValue()) == null) 	{conf.add(RunnerOptions.PROPERTY_OUTPUT_DIRECTORY.getValue(), Builder.DEFAULT_OUTPUT_DIRECTORY);}
		if(conf.get(RunnerOptions.PROPERTY_SUITE_TEMPLATE.getValue()) == null) 		{conf.add(RunnerOptions.PROPERTY_SUITE_TEMPLATE.getValue(), Builder.DEFAULT_TEMPLATE);}
		if(conf.get(RunnerOptions.PROPERTY_BUILD_PRINT.getValue()) == null) 		{conf.add(RunnerOptions.PROPERTY_BUILD_PRINT.getValue(), Builder.DEFAULT_PRINT);}
		if(conf.get(RunnerOptions.PROPERTY_RUNNER_SINGLE.getValue()) == null) 		{conf.add(RunnerOptions.PROPERTY_RUNNER_SINGLE.getValue(), Builder.DEFAULT_RUN_ONE_SUITE);}
		
		return conf;
	}
	
	protected Map<String, List<String>> buildParametersFromArgs(final String delimiter, final String...args) {
		final Map<String, List<String>> parameters  = new HashMap<String, List<String>>(); 
		for(String arg : args) {
			final String[] split = arg.split("=", 2);
			if(null == RunnerOptions.getValueOf(split[0].trim())) {	// parameters
				if(split.length == 1)
					{parameters.put(split[0].trim(), Arrays.asList(""));}
				else {
					final String[] val = split[1].split(delimiter);
					final List<String> values = new ArrayList<String>();
					for(String each : val) {
						values.add(each.trim());
					}
					parameters.put(split[0].trim(), values);
				}					
			}
		}
		return parameters;
	}
	
	protected DataStrategy getStrategy(final String strategy, final String delimiter, final boolean suite, final String testName) throws NumberFormatException, DataTableException, BuilderException {
		if(null == parameters || null == strategy || strategy.isEmpty())
			{return null;}		
		final Map<String, List<String>> params = extractParameters(suite, testName);
		final String[] split = strategy.split(delimiter);
		if(split.length == 2) {			
			if(strategy.matches("(?i)Sequential.*")) 	{return new SequentialStrategy(params, Integer.parseInt(split[1]));}
			if(strategy.matches("(?i)Permutation.*")) 	{return new PermutationStrategy(params, Integer.parseInt(split[1]));}
			if(strategy.matches("(?i)Random.*")) 		{return new RandomStrategy(params, Integer.parseInt(split[1]));}
		}
		else {
			if(strategy.matches("(?i)Sequential.*")) 	{return new SequentialStrategy(params);}
			if(strategy.matches("(?i)Permutation.*")) 	{return new PermutationStrategy(params);}
			if(strategy.matches("(?i)Random.*")) 		{return new RandomStrategy(params);}
		}		
		return new SequentialStrategy(params);	// default
	}
	
	
	protected Map<String, List<String>> extractParameters(final boolean suite, final String testName) throws BuilderException {
		final Map<String, List<String>> result = new HashMap<String, List<String>>();
		if(parameters.isEmpty()) {return result;}
		final List<String> names = suite ? builder.getSuiteParameterNames() : builder.getTestParameterNames();
		for(String key : parameters.keySet()) {
			if(names.contains(key)) {
				if(suite || builder.hasParameterInTest(testName, key))
					{result.put(key, parameters.get(key));}					
			}
		}
		return result;
	}
	
	// returns xml suites
	protected List<XmlSuite> getXmlSuites() throws ParserConfigurationException, SAXException, IOException {
		final List<XmlDocument> suites = builder.getOutput();
		final List<XmlSuite> runSuites = new ArrayList<XmlSuite>();
			for(XmlDocument suite : suites)
				{runSuites.addAll(new Parser(new ByteArrayInputStream(suite.toString().getBytes("UTF-8"))).parse());}
			return runSuites;
		}
	
	protected void runXmlSuites(final boolean runOneSuite) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, URISyntaxException {
		final List<XmlSuite> suites =  getXmlSuites();
		if(runOneSuite) {
			final TestNG testNG = new TestNG(); 
			testNG.setXmlSuites(suites);
			testNG.setOutputDirectory(conf.get(RunnerOptions.PROPERTY_OUTPUT_DIRECTORY.getValue()));
			testNG.run();
		}
		else {
			int i = 1;
			for(XmlSuite suite : suites) {				
				final TestNG testNG = new TestNG();  
				testNG.setXmlSuites(Arrays.asList(suite));
				testNG.setOutputDirectory(conf.get(RunnerOptions.PROPERTY_OUTPUT_DIRECTORY.getValue()) + (i++));
				testNG.run();
			}
		}
		
		builder = null;
	}
	
	protected void print() {
		final List<XmlDocument> suites = this.builder.getOutput();
		for(XmlDocument suite :suites)
			{System.out.println(suite);}
	}
	
	public static void main(final String... args) throws BuilderException, NumberFormatException, DataTableException, ClassNotFoundException, ParserConfigurationException, SAXException, IOException, URISyntaxException {
	    //String[] args1 = {"build=3", "browser=ie,chrome,firefox", "jenkinsJobLink=none","suite-template=C:/Users/issharma/workspace/demo/src/test/resources/testDemo.xml","print=true","runner-single=true","suite-name-parameter=browser","suite-strategy=Sequential"};
	    //final Runner runner = new Runner(args1);
	    
		final Runner runner = new Runner(args);
		runner.includeExcludeTests(true);
		runner.includeExcludeTests(false);		
		runner.addRemoveListeners(true);
		runner.addRemoveListeners(false); 
		runner.setSuiteStrategy();
		runner.setTestStrategies();
		
		boolean runOneRunner = false;
		try { runOneRunner = Boolean.parseBoolean(runner.conf.get(RunnerOptions.PROPERTY_RUNNER_SINGLE.getValue())); }
		catch(Exception e) {logger.log(Level.SEVERE, e.getMessage());}
		
		String what = runner.conf.get(RunnerOptions.PROPERTY_BUILD_SCOPE.getValue());
		if(null == what) {what = Builder.BUILD_NONE + "";}
		String forceConcat = runner.conf.get(RunnerOptions.PROPERTY_SUITE_NAME_PARAMETER_CONCAT.getValue());
		if(forceConcat == null) {forceConcat = "false";}
		runner.builder.build(Short.parseShort(what), runner.extractSuiteParametersForNamingFromConfiguration(), runner.extractTestParametersForNamingFromConfiguration(), !runOneRunner, forceConcat);		
		
		boolean printFlag = false;
		try { printFlag = Boolean.parseBoolean(runner.conf.get(RunnerOptions.PROPERTY_BUILD_PRINT.getValue())); }
		catch(Exception e) {logger.log(Level.SEVERE, e.getMessage());}
		if(printFlag) {runner.print();}
		
		
				
		runner.runXmlSuites(runOneRunner);
	}
	
}
