package com.guru.testing.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.testng.Documentation;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.constants.FeedbackStarRating;
import com.guru.testing.constants.SortOptionsFindGurus;
import com.guru.testing.constants.Location;
import com.guru.testing.constants.RatePerHour;
import com.guru.testing.constants.Reviews;
import com.guru.testing.constants.ServicesCategory;
import com.guru.testing.objectmap.FindGurusPageObjectMap;

public class FindGurusPageTest {
	
	@Test
	@Documentation(step = "Verify the find Gurus page.", expected = "Find gurus page should be loaded")
	public static void verifyFindGurusPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_FIND_AND_HIRE_TALENTED_GURUS_TEXT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINEMENTS_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_SEARCH_RESULTS_DIV_ID);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Find Gurus Page elemets not found");
		}
	}
	
	@Test
	@Documentation(step = "Verify Refinements for Category, Location, Show only, Feedback, Rate per hour, Budget and Tested Skills", 
					expected = "All the refinements should be loaded")
	public static void verifyRefinementsTest() throws Exception {
		ScriptLogger.info();
		try {
			verifyCategoryRefinementTest();
			verifyAnyLocationTest();
			verifyShowOnlyTest();
			verifyFeedbackTest();
			verifyRatePerHourTest();
			verifyBudgetTest();
			verifyTestedSkillsTest();			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Refinements elements not found");
		}
	}
	
	@Test
	@Documentation(step = "Verify category refinements", expected = "All Category refinements with text should be loaded")
	public static void verifyCategoryRefinementTest() throws Exception {
		ScriptLogger.info();
		String element=null;
		try {
			
			BrowserWait.waitUntilText("Refine by:");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_CATEGORY_PANE_ID);
		List<WebElement> categories=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_CATEGORY_PANE_ID).findElements(By.tagName("li"));
		for (WebElement webElement : categories) {
			
			element=webElement.findElement(By.tagName("a")).getText();
			
			if (!element.equals(ServicesCategory.ANY_CATEGORY.getValue())) {
				if (!element.contains(ServicesCategory.WEB_SOFTWARE_AND_IT.getValue())) {
					if (!element.contains(ServicesCategory.DESIGN_ART_MULTIMEDIA.getValue())) {
						if (!element.contains(ServicesCategory.WRITING_AND_TRANSLATION.getValue())) {
							if (!element.contains(ServicesCategory.ADMIN_SUPPORT.getValue())) {
							if (!element.contains(ServicesCategory.MANAGEMENT_AND_FINANCE.getValue())) {
								if (!element.contains(ServicesCategory.SALES_AND_MARKETING.getValue())) {
									if (!element.contains(ServicesCategory.ENGINEERING_AND_ARCHITECTURE.getValue())) {
										if (!element.contains(ServicesCategory.LEGAL.getValue())) {
											if (!element.contains(ServicesCategory.OTHER.getValue())) {
												throw new ApplicationException("Application Issue: Invalid category "+element+" found on page");

												}}}}}}}}}}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify Location refinements", expected = "All location refinements with text should be loaded")
	public static void verifyAnyLocationTest() throws Exception {
		ScriptLogger.info();
		String element=null;
		try {
			
			BrowserWait.waitUntilText("Location");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_LOCATION_PANE_ID);
			WebElement anyLocationElement=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_LOCATION_PANE_ID).findElements(By.tagName("li")).get(0);
			element=anyLocationElement.findElement(By.tagName("a")).getText();
			if (!element.equals(Location.ANY_LOCATION.getValue())) {
				throw new ApplicationException("Application Issue: ANY LOCATION is not found instead "+element+" found on page");
			}
			
			List<WebElement> otherLocationElement=BrowserAction.getElements(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_LOCATION_LINKS_DRILLDOWN_XPATH);
						
			
			for (WebElement webElement : otherLocationElement) {
					element=webElement.getText();
				if (!element.equals(Location.CITY_STATE.getValue())) {
					if (!element.equals(Location.ZIP.getValue())) {
						if (!element.equals(Location.COUNTRY.getValue())) {
							if (!element.equals(Location.REGION.getValue())) {
								throw new ApplicationException("Application Issue:Invalid location "+element+" found on page");
								}}}}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify Show only refinement without login", expected = "Show only refinement with Services with Portfolio should be present")
	public static void verifyShowOnlyTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Show Only");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_SHOW_ONLY_PANE_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_SERVICES_WITH_PORTFOLIO_CHECKBOX_ID);	
			BrowserWait.waitUntilText("Services with portfolio");
			
		} catch (Exception e) {
			
			throw new HTMLElementNotFoundException(e,"Show only section elements not found");
		}
	}
	
	
	@Test
	@Documentation(step = "Verify Feedback section refinement", expected = "Feedback rating and review refinements with text should be loaded")
	public static void verifyFeedbackTest() throws Exception {
		ScriptLogger.info();
		String element=null;
		try {
			
			BrowserWait.waitUntilText("Feedback");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_FEEDBACK_PANE_ID);
		List<WebElement> categories=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_FEEDBACK_PANE_ID).findElements(By.tagName("li"));
		for (WebElement webElement : categories) {
			
			element=webElement.findElement(By.tagName("a")).getText();
			
			if (!element.equals(FeedbackStarRating.ANY_STAR_RATINGS.getValue())) {
				if (!element.equals(FeedbackStarRating.STAR_5.getValue())) {
					if (!element.equals(FeedbackStarRating.STAR_4_PLUS.getValue())) {
						if (!element.equals(FeedbackStarRating.STAR_3_PLUS.getValue())) {
							throw new ApplicationException("Application Issue:Invalid Feedback "+element+" found on page");
							}}}}
			}	
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
		try {
			
			
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_REVIEWS_PANE_ID);
		List<WebElement> categories=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_REVIEWS_PANE_ID).findElements(By.tagName("li"));
		for (WebElement webElement : categories) {
			
			element=webElement.findElement(By.tagName("a")).getText();
			
			if (!element.equals(Reviews.ANY_REVIEWS.getValue())) {
				if (!element.equals(Reviews.REVIEWS_3_PLUS.getValue())) {
					if (!element.equals(Reviews.REVIEWS_10_PLUS.getValue())) {
						if (!element.equals(Reviews.REVIEWS_20_PLUS.getValue())) {
							if (!element.equals(Reviews.REVIEWS_50_PLUS.getValue())) {
								throw new ApplicationException("Application Issue:Invalid "+element+" found on page");
								}}}}}
			}
		
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify Rate per hour section refinement", expected = "Rate per hour refinements with text should be loaded")
	public static void verifyRatePerHourTest() throws Exception {
		ScriptLogger.info();
		String element=null;
		try {
			
			BrowserWait.waitUntilText("Rate / Hr");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_RATE_PER_HOUR_PANE_ID);
			List<WebElement> categories=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_RATE_PER_HOUR_PANE_ID).findElements(By.tagName("li"));
			for (WebElement webElement : categories) {
			
			element=webElement.findElement(By.tagName("a")).getText();
			
			if (!element.equals(RatePerHour.ANY_RATE.getValue())) {
				if (!element.equals(RatePerHour.RATE_0_TO_25_DOLLARS.getValue())) {
					if (!element.equals(RatePerHour.RATE_25_TO_50_DOLLARS.getValue())) {
						if (!element.equals(RatePerHour.RATE_50_TO_100_DOLLARS.getValue())) {
							if (!element.equals(RatePerHour.RATE_100_TO_200_DOLLARS.getValue())) {
								if (!element.equals(RatePerHour.RATE_100_TO_200_DOLLARS.getValue())) {
									if (!element.equals(RatePerHour.RATE_200_DOLLARS_PLUS.getValue())) {
										throw new ApplicationException("Application Issue:Invalid RATE PER HOUR  "+element+" found on page");
										}}}}}}}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify budget section refinement", expected = "Budget refinements with text should be loaded")
	public static void verifyBudgetTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Budget");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_MIN_BUDGET_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_MAX_BUDGET_TEXTBOX_ID);	
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_BUDGET_GO_BUTTON_ID);	
			
			
		} catch (Exception e) {
			
			throw new HTMLElementNotFoundException(e,"Budget section elements not found");
		}
	}
	
	
	@Test
	@Documentation(step = "Verify Tested Skills section refinement", expected = "Tested Skills refinements with text should be loaded")
	public static void verifyTestedSkillsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Tested Skills");
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_SKILLS_DROPDOWN_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Tested skills elements not found");
		}
	}
	
	
	
	
	@Test
	@Documentation(step = "Verify 'Services With Portfolio' Is Unchecked", expected = "'Services With Portfolio' should be Unchecked")
	public static void verifyServicesWithPortfolioIsUncheckedTest() throws Exception {
		ScriptLogger.info();
		try {
			WebElement element=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_SERVICES_WITH_PORTFOLIO_CHECKBOX_ID);	
			if(element.isSelected()){
				throw new ApplicationException("Application Issue:Services with Portfolio checkbox is Not Unchecked by default");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Click 'Post a job (FREE)' link on top right side of the search results.", expected = "'Post a job (FREE)' link should be clicked")
	public static void clickPostAJobFreeLinkTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindGurusPageObjectMap.FIND_GURUS_PAGE_POST_A_JOB_FREE_PLINK);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify 'Get Quotes' checkbox is unchecked", expected = "'Get Quotes' checkbox should be unchecked")
	public static void verifyGetQuotesCheckBoxIsUncheckedTest() throws Exception {

		ScriptLogger.info();

		try {
			WebElement element = BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SELECT_ALL_CHECKBOX_ID);
			if (element.isSelected()) {
				throw new ApplicationException("Application Issue:Services with Portfolio checkbox is Not Unchecked");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}

	}
	
	@Test
	@Documentation(step = "Verify 'Get Quotes' button is present", expected = "'Get Quotes' button is present")
	public static void verifyGetQuotesButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_GET_QUOTES_TOP_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Get quotes button is not found");
		}
	}
	
	
	@Test
	@Documentation(step = "Click sorting dropdown", expected = "Sorting options should be loaded")
	public static void clickSortingOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindGurusPageObjectMap.FIND_GURUS_PAGE_SORTING_OPTIONS_DROPDOWN_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify sorting options are loaded", expected = "All sorting options should be loaded")
	public static void verifySortingOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			
			
			Select sortingDropDown=new Select(BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SORTING_OPTIONS_DROPDOWN_ID));
			String firstOption=sortingDropDown.getFirstSelectedOption().getText();
			
			if(!firstOption.equals(SortOptionsFindGurus.RELEVANCE)){
				throw new ApplicationException("Application Issue:Relevance is not default option on sorting dropdown ");
			}
			List<WebElement> sortingOptions=sortingDropDown.getOptions();
			
			for (WebElement webElement : sortingOptions) {
				
				String visibleText=webElement.getText();
				
				if (!visibleText.equals(SortOptionsFindGurus.RELEVANCE.getValue())) {
					if (!visibleText.equals(SortOptionsFindGurus.TOTAL_EARNINGS_HIGHEST_FIRST.getValue())) {
						if (!visibleText.equals(SortOptionsFindGurus.REVIEW_HIGHEST_FIRST.getValue())) {
							if (!visibleText.equals(SortOptionsFindGurus.RATE_HIGHEST_FIRST.getValue())) {
								if (!visibleText.equals(SortOptionsFindGurus.RATE_LOWEST_FIRST.getValue())) {
									if (!visibleText.equals(SortOptionsFindGurus.BUDGET_LOWEST_FIRST.getValue())) {
										if (!visibleText.equals(SortOptionsFindGurus.BUDGET_HIGHEST_FIRST.getValue())) {
											throw new ApplicationException("Application Issue:Invalid SORTING OPTION "+visibleText+" found on page");
											}}}}}}}

			}
			
		}catch (Exception e) {
				throw new ScriptException(e);
			}
			
	
	}
	
	
	
	
	@Test
	@Parameters("sortOption")
	@Documentation(step = "Select sort option in the dropdown", expected = "Sort option should be applied")
	public static void sortByTest(String sortOption) throws Exception {
		ScriptLogger.info();
		try {
			Select sortingDropDown=new Select(BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SORTING_OPTIONS_DROPDOWN_ID));
			
			
			switch (sortOption) {
			case "RELEVANCE":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.RELEVANCE.getValue());

				break;
			case "TOTAL_EARNINGS_HIGHEST_FIRST":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.TOTAL_EARNINGS_HIGHEST_FIRST.getValue());

				break;
			case "REVIEW_HIGHEST_FIRST":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.REVIEW_HIGHEST_FIRST.getValue());
										BrowserWait.waitForPageToBeLoaded();

				break;
			case "RATE_HIGHEST_FIRST":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.RATE_HIGHEST_FIRST.getValue());

				break;
			case "RATE_LOWEST_FIRST":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.RATE_LOWEST_FIRST.getValue());

				break;
			case "BUDGET_LOWEST_FIRST":sortingDropDown.selectByVisibleText(SortOptionsFindGurus.BUDGET_LOWEST_FIRST.getValue());

				break;
			default:
				break;
			}
			ScriptLogger.debug("OPTION Selected "+sortOption);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters({"sortOption","jobIndexToCompare"})
	@Documentation(step = "Verify and validate results loaded as per the sortoption applied", expected = "Results should be loaded as per the sort option applied")
	public static void verifySortResultsTest(String sortOption,int jobIndexToCompare) throws Exception {
		ScriptLogger.info();
		try {
			Select sortingDropDown=new Select(BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SORTING_OPTIONS_DROPDOWN_ID));
			
			switch (sortOption) {
			case "RELEVANCE"://TODO

				break;
			case "TOTAL_EARNINGS_HIGHEST_FIRST": //TODO
																		

				break;
			case "REVIEW_HIGHEST_FIRST":sortingDropDown.getFirstSelectedOption().getText();
										if(!sortingDropDown.getFirstSelectedOption().getText().equals(SortOptionsFindGurus.REVIEW_HIGHEST_FIRST.getValue())){
										throw new ApplicationException("Application Issue: "+sortingDropDown+"is not selected");
										}
										verifyReviewHighestFirstSort(jobIndexToCompare);

				break;
			case "RATE_HIGHEST_FIRST"://TODO

				break;
			case "RATE_LOWEST_FIRST"://TODO

				break;
			case "BUDGET_LOWEST_FIRST"://TODO

				break;
			default:
				break;
			
		}
		}catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	private static void verifyReviewHighestFirstSort(int jobIndexToCompare) throws Exception {
		try {
			
			WebElement serviceList=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SERVICES_LIST_PANE_ID);
			List<WebElement> reviewInfoList=serviceList.findElements(By.xpath("//div[@class ='fb']"));			
			String higherReviewInfo= reviewInfoList.get(jobIndexToCompare-1).getText().trim();
			String lowerReviewInfo= reviewInfoList.get(jobIndexToCompare).getText().trim();
			int higherReview=Integer.parseInt(StringUtils.stringBetween(higherReviewInfo,"(",")",1));			
			int lowerReview=Integer.parseInt(StringUtils.stringBetween(lowerReviewInfo,"(",")",1));

			
			if((higherReview<lowerReview)){
				throw new ApplicationException("Application Issue:: The reviews are not loading as per highest sort option");
			}
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}

	
	
	@Test
	@Parameters("country")
	@Documentation(step = "Select the given country from country  dropdown", expected = "Country should be selected")
	public static void refineByCountryTest(String country) throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserAction.click(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_COUNTRY_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_COUNTRY_DROPDOWN_ID);		
			
			Select selectCountry= new Select(BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_COUNTRY_DROPDOWN_ID));
			selectCountry.selectByVisibleText(country);	
			BrowserWait.waitForPageToBeLoaded();
			try {
				BrowserWait.waitUntilText("Searching with",country);
				BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_CLEAR_ALL_PLINK);
			} catch (Exception e) {
				throw new ApplicationException("Application Issue:: Unable to apply refinement as per COUNTRY :"+country);
			}
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Parameters("country")
	@Documentation(step = "Verify country as per the selection applied", expected = "Country should be selected")
	public static void verifyCountryRefinedResultsTest(String country) throws Exception {
		ScriptLogger.info();
		try {
			
			BrowserWait.waitUntilText("Searching with",country);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_CLEAR_ALL_PLINK);
			List<WebElement> countryListInfo=BrowserAction.getElements(FindGurusPageObjectMap.FIND_GURUS_PAGE_SERVICES_LIST_COUNTRY_TEXT_XPATH);
			for (WebElement webElement : countryListInfo) {
				if(!webElement.getText().contains(country)){
					throw new ApplicationException("Application Issue:: The refinement is not loading as per COUNTRY :"+country+" refinement");
				}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Sign in on top navigation in the Find gurus page", expected = "Sign in should be clicked")
	public static void clickSignInTest() throws Exception {
		ScriptLogger.info();
		try {
			HomePageTest.clickSignInTopNavTest();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	

	@Test
	@Documentation(step = "Verify pagination on Find gurus page", expected = "There should be 1 page for 1-20 results and more than 1 for >20 results ")
	public static void verifyPaginationTest() throws Exception {
		ScriptLogger.info();
		int sum=0;
		try {
			List <WebElement> element=BrowserAction.getElements(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_CATEGORY_COUNT_XPATH);
			for (WebElement webElement : element) {
				String countInfo=webElement.getText().trim();
				countInfo=StringUtils.getStringBetween(countInfo, "(", ")", 1);
				countInfo=countInfo.replace(",", "");
				
				sum+=Integer.parseInt(countInfo);				
			}
			WebElement element2=BrowserAction.getElement(FindGurusPageObjectMap.FIND_GURUS_PAGE_SERVICES_LIST_PAGINATION_PANE_ID);
			List<WebElement> elements=element2.findElements(By.tagName("li"));
			int noOfPages=elements.size()-2;
			
			if(sum>20){
				if(noOfPages<=1){
					throw new ApplicationException("Application Issue: Results are greater than 20: "+sum+" but pages are showing "+noOfPages);
					
				}
				
			}
			
			else if (sum<=20) {
				if(noOfPages!=1 || noOfPages>1){
					throw new ApplicationException("Application Issue: Results are "+sum+" so pageination should be 1 but its is showing "+noOfPages);
					
				}
				
			}
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Check availability of 'My Guru' checkbox while logged in ", expected = "'My Guru' checkbox should be present")
	public static void verifyMyGurusRefinementTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_MY_GURUS_PANE_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_PAGE_REFINE_MY_GURUS_CHECKBOX_ID);
			BrowserWait.waitUntilText("My Gurus");
            
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Elements not found for my gurus");
		}
	}
	
	@Test
	@Parameters("getAQuoteIndex")
	@Documentation(step = "Click Get a Quote for the first guru in the find gurus page.",expected="Able to click.")
	public static void clickGetAQuoteByIndexTest(int index) throws Exception {
		ScriptLogger.info();
		try{
			BrowserWait.waitUntilElementIsDisplayed(FindGurusPageObjectMap.FIND_GURUS_GET_A_QUOTE_BUTTON_XPATH, 15);
			List<WebElement> quoteBtns = BrowserAction.getElements(FindGurusPageObjectMap.FIND_GURUS_GET_A_QUOTE_BUTTON_XPATH);
			quoteBtns.get(index-1).click();
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new ScriptException("Possible locator issue, or Selenium was unable to click; or element not found.");
		}
	}
	
	


}
