package com.guru.testing.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverWaits;
import com.guru.framework.testing.testng.Documentation;
import com.guru.testing.constants.SortOptionsFindJobs;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.FindJobsPageObjectMap;
import com.guru.testing.objectmap.HomePageObjectMap;

public class FindJobsPageTest {
	
	private static String urlId;
	
	private static List<String> stringList1 = new ArrayList<>();;
	
	@Test
	@Documentation(step = "Verify the find Jobs page.", expected = "Find jobs page should be loaded")
	public static void verifyFindJobsPageTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Search Freelance Jobs & Projects Online - Guru");
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_REFINEMENTS_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_RESULTS_DIV_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more of the elements required to be verified wasn't found.");
		}
	}
	
	// When not Logged in method handling ; the following method is only applicable when user goes to find jobs page without signing in.
	// ----------------- STARTS ---------------------
	
	@Test
	@Documentation(step="Click 'Sign In' on top of the Find Jobs page.", expected="User is able to click, and is redirected to the Login page.")
	public static void clickSignInTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(HomePageObjectMap.HOME_PAGE_SIGN_IN_TOP_NAV_BUTTON_PLINK);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Sign in' not found, or wasn't clickable.");
		}
		
	}
	
	// ------------------ ENDS ----------------
	
	@Test
	@Documentation(step = "Verify appearance of Pagination links.", expected = "Pagination links should be present at the bottom of the search results.")
	public static void verifyPaginationTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_PAGINATION_UL_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Pagination element was not found.");
		}
	}
	
	@Test
	@Documentation(step = "Verify Radio Buttons under Budget Type in Refinement Section.", expected = "Radio buttons are present.")
	public static void verifyBudgetTypesTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_ALL_JOBS_RADIO_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_HOURLY_RADIO_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_FIXED_PRICE_RADIO_BUTTON_ID);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more Elements required for verification not found.");
		}
	}
	
	//  METHODS HANDLING THE CLICKING SKILL CATEGORIES
	// ------------ START ----------------
	
	@Test
	@Parameters("skillRefinement")
	@Documentation(step="Click on a category listed under the 'Skill Categories' Filter.", expected="User is able to click a category to filter according to 'Skill Categories'.")
	public static void clickSkillRefinementTest(String skill) throws Exception {
		ScriptLogger.info();
		try {
			switch (skill) {
			case "WEB_SOFTWARE_AND_IT": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_WEB_SOFTWARE_IT_PLINK);
			break;
			
			case "DESIGN_ART_MULTIMEDIA": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_DESIGN_ART_MULTIMEDIA_PLINK);
			break;
			
			case "WRITING_AND_TRANSLATION": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_WRITING_TRANSLATION_PLINK);
			break;
			
			case "SALES_AND_MARKETING": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_SALES_MARKETING_PLINK);
			break;
			
			case "OTHER": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_OTHER_PLINK);
			break;
			
			case "ADMIN_SUPPORT": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_ADMIN_SUPPORT_PLINK);
			break;
			
			case "ENGINEERING_AND_ARCHITECTURE": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_ENGINEERING_ARCHITECTURE_PLINK);
			break;
			
			case "MANAGEMENT_AND_FINANCE": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_MANAGEMENT_FINANCE_PLINK);
			break;
			
			case "LEGAL": BrowserAction.click(CommonObjectMap.COMMON_GURU_SKILL_LEGAL_PLINK);
			break;
			
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Refinement: " +skill+ " wasn't found; or was unable to click on it.");
		}
	}
	
	// --------------- END ----------------------
	
	@Test
	@Documentation(step = "Click 'Hourly' radio button under 'Budget Type'.", expected = "Search results are refined as per 'Hourly' refinement.")
	public static void clickHourlyTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_HOURLY_RADIO_BUTTON_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Hourly Radio Button wasn't found, or wasn't clickable.");
		}
	}

	@Test
	@Documentation(step = "Click 'Fixed Price' radio button under 'Budget Type'.", expected = "Search results are refined as per 'Fixed Price' refinement.")
	public static void clickFixedPriceTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_FIXED_PRICE_RADIO_BUTTON_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Fixed Price Radio Button wasn't found, or wasn't clickable.");
		}
	}
	
	// METHODS HANDLING CLICKING CHECKBOXES UNDER SHOW ONLY FILTER
	// --------------------- START ----------------
	
	@Test
	@Documentation(step="Click on the 'Featured Jobs' checkbox under 'Show Only' refinement filter.", expected="User is able to click the checkbox.")
	public static void clickFeaturedJobsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_FEATURED_JOBS_CHECKBOX_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Featured Jobs' Checkbox wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Has Verified Payment Method' checkbox under 'Show Only' refinement filter.", expected="User is able to click the checkbox.")
	public static void clickHasVerifiedPaymentTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_HAS_VERIFIED_PAYMENT_METHOD_CHECKBOX_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Has Verified Payment Method' Checkbox wasn't found, or wasn't clickable.");
		}
	}
	
	// ------------- END -----------------
	
	// METHODS HANDLING CLICKING CHECKBOXES UNDER HIDE FILTER
	// --------------------- START ----------------
	
	@Test
	@Documentation(step="Click on the 'Jobs I have viewed' checkbox under 'Hide' refinement filter.", expected="User is able to click the checkbox.")
	public static void clickJobsViewedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_JOBS_I_HAVE_VIEWED_CHECKBOX_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Jobs I have viewed' checkbox wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Jobs I have applied to' checkbox under 'Hide' refinement filter.", expected="User is able to click the checkbox.")
	public static void clickJobsAppliedToTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_JOBS_I_HAVE_APPLIED_TO_CHECKBOX_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Jobs I have applied to' checkbox wasn't found, or wasn't clickable.");
		}
	}
	
	// ------------- END -----------------
	
	// METHODS HANDLING EVERYTHING RELATED TO SAVED SEARCHES (NAME, RENAME, DELETE, DROPDOWN SELECT)
	// ------------------ START --------------------
	@Test
	@Documentation(step = "Click 'Save Search'.", expected = "'Save Search' should be clicked, and Save Search pop up dialog should appear.")
	public static void clickSaveSearchTopTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_BUTTON_XPATH);
			verifySaveSearchPopupTest();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Save Search' next to 'RSS feed subscribe' button not found, or wasn't clickable.");
		}
	}
	
	private static void verifySaveSearchPopupTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_BOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_SAVE_BUTTON_ID);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "One or more elements necessary for verifying the 'Save Search' popup was not found");
		}
	}
	
	@Test
	@Parameters("saveSearchName")
	@Documentation(step = "Enter new name for Saved Search", expected = "Able to enter the name in the 'Enter a new name...' textbox.")
	public static void enterNewNameForSearchTest(String name) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID, name);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Name' textbox in Save Search popup was not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Save Search'.", expected = "'Save Search' should be clicked, saving the name entered.")
	public static void clickSaveSearchInPopUpTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_SAVE_BUTTON_ID);
			BrowserWait.waitForPageToBeLoaded();
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_RENAME_LINK_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Save Search' button in 'Save Search' popup was not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Rename'.", expected = "'Rename' should be clicked.")
	public static void clickRenameTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Rename", 5);
			Thread.sleep(2000); // Included, otherwise the code throws an 'element not clickable' exception.
								//  mostly happens because the  page is getting refreshed before it is clicking the element.
								// RESOLUTION IS: For this, make the page to wait for few seconds.
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_RENAME_LINK_XPATH);
			verifySaveSearchPopupTest();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Rename' link under the Saved Searches dropdown not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Parameters("newName")
	@Documentation(step = "Enter new name for Saved Search", expected = "Able to enter the name in the 'Enter a new name...' textbox.")
	public static void enterNewNameInRenameTextBoxTest(String newName) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_NEW_NAME_TEXTBOX_ID, newName);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Name' textbox in Rename Search popup was not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Rename Search'.", expected = "'Rename Search' should be clicked, saving the new name entered.")
	public static void clickRenameSearchInPopUpTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVE_SEARCH_POP_UP_SAVE_BUTTON_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Rename Search' button in 'Rename Search' popup was not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Delete' link to delete saved search.", expected = "'Delete' should be clicked, opening a pop up to confirm deletion.")
	public static void clickDeleteTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Delete", 5);
			Thread.sleep(2000); // Included, otherwise the code throws an 'element not clickable' exception.
								//  mostly happens because the  page is getting refreshed before it is clicking the element.
								// RESOLUTION IS: For this, make the page to wait for few seconds.
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_DELETE_LINK_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_DELETE_SAVED_SEARCH_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Delete' link next to 'Rename' was not found, or wasn't clickable; or the delete pop up didn't appear.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Delete Save Search' button to delete saved search.", expected = "'Delete Saved Search' should be clicked, deleting the saved search.")
	public static void clickDeleteSaveSearchTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_DELETE_SAVED_SEARCH_BUTTON_ID);
			BrowserWait.waitUntilElementIsNotDisplayed(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVED_SEARCHES_DROPDOWN_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Delete Saved Search button in the Delete search popup was not found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Saved Searches' dropdown, and select 'Select One'.", expected = "Search results corresponding to 'Select One' loads.")
	public static void selectSelectOneTest() throws Exception{
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVED_SEARCHES_DROPDOWN_ID)); 
			select.selectByVisibleText("Select One");
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Select One under Saved Searches dropdown not found, or wasn't clickable; or the dropdown itself wasn't appearing.");
		}
	}
	
	@Test
	@Parameters("newName")
	@Documentation(step = "Click 'Saved Searches' dropdown, and select 'Select One'.", expected = "Search results corresponding to 'Select One' loads.")
	public static void selectSavedSearchTest(String newName) throws Exception{
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SAVED_SEARCHES_DROPDOWN_ID)); 
			select.selectByVisibleText(newName);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Wasn't able to select '"+newName+"' from the dropdown; either it was missing, or the dropdown itself wasn't appearing.");
		}
	}
	
	// ----------------------- END ------------------------
	
	@Test
	@Documentation(step = "Verify whether the 'Hourly' Radio button is selected.", expected = "User is able to verify if the 'Hourly' radio button is selected.")
	public static void verifyHourlyIsCheckedTest() throws Exception{
		String status;
		ScriptLogger.info();
		try {
			status = BrowserAction.getElementAttributeValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_HOURLY_RADIO_BUTTON_ID, "checked");
			if(status.equalsIgnoreCase("checked")) {
				ScriptLogger.info("Passed.");
			} else {
				ScriptLogger.info("Failed.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Hourly' Radio button was not selected, or not found.");
		}
	}
	
	@Test
	@Documentation(step = "Verify whether the 'Fixed Price' Radio button is selected.", expected = "User is able to verify if the 'Fixed Price' radio button is selected.")
	public static void verifyFixedPriceIsCheckedTest() throws Exception{
		String status;
		ScriptLogger.info();
		try {
			status = BrowserAction.getElementAttributeValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_BUDGET_TYPE_FIXED_PRICE_RADIO_BUTTON_ID, "checked");
			if(status.equalsIgnoreCase("checked")) {
				ScriptLogger.info("Passed.");
			} else {
				ScriptLogger.info("Failed.");
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "'Fixed Price' Radio button not selected, or not found.");
		}
	}
	
	// METHODS HANDLING SORTING OPTIONS UNDER DIFFERENT KINDS OF JOB FILTERS.
	// ---------------------- START -----------------------
	
	@Test
	@Documentation(step = "Verify all the 'Sorting Options' available when 'All Jobs' filter is selected.", expected = "User is able to verify all the listings in sorting dropdown for the particular filter.")
	public static void verifySortingOptionsAllJobsTest() throws Exception {
		ScriptLogger.info();
		try {
			Select sortingDropDown = new Select(
					BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SORT_BY_DROPDOWN_ID));
			String firstOption = sortingDropDown.getFirstSelectedOption().getText();
			if (!firstOption.equals(SortOptionsFindJobs.NEWEST.getValue())) {
				throw new ApplicationException("Application Issue: Newest is not default option on sorting dropdown ");
			}

			List<WebElement> sortingOptions = sortingDropDown.getOptions();
			for (WebElement webElement : sortingOptions) {
				String visibleText = webElement.getText();
				if (!visibleText.equals(SortOptionsFindJobs.NEWEST.getValue())) {
					if (!visibleText.equals(SortOptionsFindJobs.OLDEST.getValue())) {
						if (!visibleText.equals(SortOptionsFindJobs.EXPIRING_SOON.getValue())) {
							throw new ApplicationException("Application Issue: Invalid SORTING OPTION found on page");
						}
					}
				}
			}

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify all the 'Sorting Options' available when 'Hourly' filter is selected.", expected = "User is able to verify all the listings in sorting dropdown for the particular filter.")
	public static void verifySortingOptionsHourlyTest() throws Exception {
		ScriptLogger.info();
		try {
			Select sortingDropDown = new Select(BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SORT_BY_DROPDOWN_ID));
			String firstOption = sortingDropDown.getFirstSelectedOption().getText();
			if (!firstOption.equals(SortOptionsFindJobs.NEWEST.getValue())) {
				throw new ApplicationException(
						"Application Issue: Newest is not default option on sorting dropdown ");
			}
			
			List<WebElement> sortingOptions = sortingDropDown.getOptions();
			for (WebElement webElement : sortingOptions) {
				String visibleText = webElement.getText();
				if (!visibleText.equals(SortOptionsFindJobs.NEWEST.getValue())) {
					if (!visibleText.equals(SortOptionsFindJobs.OLDEST.getValue())) {
						if (!visibleText.equals(SortOptionsFindJobs.EXPIRING_SOON.getValue())) {
							if (!visibleText.equals(SortOptionsFindJobs.HOURLY_RATE_HIGHEST_FIRST.getValue())) {
								if (!visibleText.equals(SortOptionsFindJobs.HOURLY_RATE_LOWEST_FIRST.getValue())) {
									throw new ApplicationException("Application Issue: Invalid SORTING OPTION found on page");
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "Verify all the 'Sorting Options' available when 'Fixed Price' filter is selected.", expected = "User is able to verify all the listings in sorting dropdown for the particular filter.")
	public static void verifySortingOptionsFixedPriceTest() throws Exception {
		ScriptLogger.info();
		try {
			Select sortingDropDown = new Select(BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SORT_BY_DROPDOWN_ID));
			String firstOption = sortingDropDown.getFirstSelectedOption().getText();
			if (!firstOption.equals(SortOptionsFindJobs.NEWEST.getValue())) {
				throw new ApplicationException(
						"Application Issue: Newest is not default option on sorting dropdown ");
			}
			
			List<WebElement> sortingOptions = sortingDropDown.getOptions();
			for (WebElement webElement : sortingOptions) {
				String visibleText = webElement.getText();
				if (!visibleText.equals(SortOptionsFindJobs.NEWEST.getValue())) {
					if (!visibleText.equals(SortOptionsFindJobs.OLDEST.getValue())) {
						if (!visibleText.equals(SortOptionsFindJobs.EXPIRING_SOON.getValue())) {
							if (!visibleText.equals(SortOptionsFindJobs.BUDGET_HIGHEST_FIRST.getValue())) {
								if (!visibleText.equals(SortOptionsFindJobs.BUDGET_LOWEST_FIRST.getValue())) {
									throw new ApplicationException("Application Issue: Invalid SORTING OPTION found on page");
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// ---------------------- EMD -----------------------

	@Test
	@Parameters("searchContent")
	@Documentation(step = "Enter data in Search Jobs Textbox", expected = "Able to enter data in 'Search jobs' textbox.")
	public static void enterDataInSearchJobsTest(String searchContent) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_JOBS_TEXT_BOX_ID, searchContent);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the textbox wasn't found, or was unable to take data input.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Search' Icon situated in the Search Jobs Textbox of Find Jobs page.", expected = "User is able to click on the 'search' icon.")
	public static void clickSearchIconTest() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_ICON_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Search Icon not found, or wasn't clickable.");
		}
	}

	// Deals with extracting job id of first search result, searching for the same id in the search box,
	// and clicking/verifying the search result after searching for that particular job id: 
	// ---------------------- START -----------------------
	
	private static String getProjectUrlTest(int count) throws Exception {
		ScriptLogger.info();
		try {
			WebElement searchResult = BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_RESULTS_DIV_ID)
					.findElements(By.tagName("input")).get(count+1); // +1 and not -1 (as per array indexing) because there are two other "input" tags prior 
			// to the ones that correspond to the search results
			// So basically, 2nd input tag corresponds to first result, 3rd input tag to the second, and so on...
			urlId = searchResult.getAttribute("value");
			System.out.println(urlId);
			return urlId;
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("resultIndex")
	@Documentation(step="Enter a valid Project Id in the Search Jobs Textbox", expected="User is able to enter data into the textbox")
	public static void enterProjectIdInSearchTest(int count) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_JOBS_TEXT_BOX_ID, getProjectUrlTest(count));
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't enter data in the Search field, or the search field itself wasn't present.");
		}
	}
	
	@Test
	@Parameters("resultIndex")
	@Documentation(step="Verify the search result as a result of searching jobs using a valid project id.", expected="User is able to verify search result.")
	public static void verifyFirstSearchResultTest() throws Exception {
		ScriptLogger.info();
		try {
			WebElement searchResult = BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_RESULTS_DIV_ID)
					.findElements(By.tagName("input")).get(0);
			String jobId = searchResult.getAttribute("value");
			System.out.println(jobId);
			if(jobId.equalsIgnoreCase(urlId)) {
				ScriptLogger.info("Passed.");
			} else {
				throw new ApplicationException("Job ID Mismatch");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	// ---------------------- END -----------------------
	
	// METHODS HANDLING REFINE BY: HEADING HAVING THE SELECTED FILTERS LISTED 
	// ---------------------- START -----------------------
	
	@Test
	@Documentation(step="Check for the Refinements selected, which are listed under 'Refine by:' header. after saving a search", expected="User to able to get the data from the Refine by: header listings.")
	public static void getRefinementsSelectedBeforeTest() throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> lists = BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_REFINE_BY_PANEL_XPATH).findElements(By.tagName("li"));
			for (WebElement webElement : lists) {
				stringList1.add(webElement.getText());
			}		
		}
		catch(Exception e){
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step="After the page is reloaded, check if the saved search still has the same number of refinements selected as before.", expected="Refinements selected should match to the corresponding saved search name.")
	public static void compareRefinementsTest() throws Exception {
		List<String> stringList2 = new ArrayList<>();
		ScriptLogger.info();
		try {
			try {
				List<WebElement>lists = BrowserAction.getElement(FindJobsPageObjectMap.FIND_JOBS_PAGE_REFINE_BY_PANEL_XPATH).findElements(By.tagName("li"));
				for (WebElement webElement : lists) {
					stringList2.add(webElement.getText());
				}		
			}
			catch(Exception e){
				throw new ScriptException(e);
			}
			for (int i = 0; i < stringList1.size(); i++) {			
				if(!stringList2.get(i).equals(stringList1.get(i))){
					throw new ApplicationException("Refinements Mismatch.");
				}
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// --------------------------- END ------------------------
	

	@Test
	@Documentation(step="", expected="")
	public static void searchAndApplyJobByTokenTest() throws Exception {
		ScriptLogger.info();
		searchJobByNameTest(PostAJobPageTest.RANDOM_TOKEN);
		BrowserWait.waitUntilText(PostAJobPageTest.RANDOM_TOKEN);
		applyJobByIndexTest(1);	
	}

	@Test
	@Parameters("jobIndex")
	@Documentation(step="", expected="")
	public static void applyJobByIndexTest(int jobIndex) throws Exception {
	try {
		BrowserWait.waitUntilAtLeastOneElementPresent(FindJobsPageObjectMap.FIND_JOBS_PAGE_ALL_APPLY_BUTTONS_XPATH);
	} catch (Exception e) {
		throw new ApplicationException(e,"Atleast 1 Apply button is not present in Find Jobs page.");
	}
	try {
		List<WebElement> applyList=BrowserAction.getElements(FindJobsPageObjectMap.FIND_JOBS_PAGE_ALL_APPLY_BUTTONS_XPATH);
		applyList.get(jobIndex-1).click();
	} catch (Exception e) {
		throw new ApplicationException("Apply wasn't clickable.");
	}
		
	}

	@Test
	@Documentation(step="", expected="")
	public static void searchJobByNameTest(String jobTitle) throws Exception {
		try {
			BrowserAction.enterFieldValue(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_JOBS_TEXT_BOX_ID,jobTitle);
			BrowserAction.click(FindJobsPageObjectMap.FIND_JOBS_PAGE_SEARCH_ICON_ID);
			BrowserWait.waitForPageToBeLoaded();
			WebDriverWaits.waitUntilElementIsDisplayed(By.partialLinkText(jobTitle),5);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}
}
