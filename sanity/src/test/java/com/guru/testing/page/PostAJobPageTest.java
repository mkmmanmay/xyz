package com.guru.testing.page;

import java.util.List;

import javax.script.ScriptException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAccess;
import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.objectmap.PostAJobPageObjectMap;

public class PostAJobPageTest {
	public static String RANDOM_TOKEN;
	public static String RANDOM_JOB_TITLE;
		
	@Test
	@Documentation(step = "Verify Post a Job Page", expected = "Verification should be successful.")
  	public static void verifyPostAJobPageTest() throws Exception {
		ScriptLogger.info();
		Boolean check;
		try {
			BrowserWait.waitUntilPageTitle("Post Freelance Jobs & Projects - Guru");
			BrowserWait.waitUntilText("Post a Job");
			BrowserWait.waitUntilText("It’s Free to Post a Job");
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_FIRST_PANE_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBTITLE_MIN_CHAR_CHECK_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBTITLE_TEXTBOX_VALID_CSS);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_VALID_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ADD_FILES_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_WEBCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_DESIGNCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_WRITINGCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_SALESCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ADMINCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_MANAGEMENTCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_LEGALCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ENGINEERINGCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ANYCATEGORY_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_VALID_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_WORLDWIDE_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_CITY_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ZIPCODE_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_FIXEDPRICE_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_HOURLY_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_FIXEDPRICE_BUDGET_LISTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_EXPOSURE_MAX_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_EXPOSURE_LIMITED_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_EXPOSURE_NONE_RADIOBUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_FEATURE_MY_JOB_CHECKBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_DEADLINE_CALENDAR_BOX_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Verification of Post a job page failed.");
		}
		try {
			check = BrowserAction.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_FEATURE_MY_JOB_CHECKBOX_ID).isSelected();
			System.out.println("Feature my jobCheckbox status: " +check);
		} catch (Exception e) {
			throw new Exception(e);
		}
		if(check) {
			throw new ApplicationException("Feature my Job Checkbox is checked by default.");
		}
	}
	
	@Test
	@Documentation(step = "Click Sign in on top navigation in the Post a Job page", expected = "Sign in should be clicked")
	public static void navigateToFindAGuruTest() throws Exception {
		ScriptLogger.info();
		try {
			HomePageTest.clickFindAGuruTopNavTest();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("jobTitle")
	@Documentation(step = "Enter title in the Job title field textbox", expected = "Able to enter data.")
	public static void enterJobTitleTest(String jobTitle) throws Exception {
		try {
			ScriptLogger.info();
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBTITLE_TEXTBOX_VALID_CSS, jobTitle);
			checkMinCharWarningTest();
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter data in the field, or invalid inputs were entered. Cross-verify.");
		}
	}
	
	
	@Test
	@Documentation(step = "Enter random title in the Job title field textbox", expected = "Title should be entered")
	public static void enterRandomJobTitleTest() throws Exception {
		try {
			ScriptLogger.info();
			RANDOM_TOKEN=StringUtils.generateRandomString(5);
			RANDOM_JOB_TITLE="Automation - Do not touch - " + RANDOM_TOKEN;
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBTITLE_TEXTBOX_VALID_CSS, RANDOM_JOB_TITLE);
			checkMinCharWarningTest();
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter data in the field, or invalid inputs were entered. Cross-verify.");
		}
	}
	
	private static void checkMinCharWarningTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBTITLE_MIN_CHAR_CHECK_ID); 
		} catch (Exception e) {
			throw new ApplicationException("Mininum character warning message not functioning according to norms.");
		}
	}

	@Test
	@Parameters("jobDetails")
	@Documentation(step = "Enter Job details in the Job Details textbox field", expected = "Able to enter data.")
	public static void enterJobDescriptionTest(
			@Optional("Test Project Title, testing. Test Project Title, testing. Test Project Title, testing. Test Project Title, testing.") String jobDetails) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_VALID_ID, jobDetails);
			BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_VALID_ID).sendKeys(Keys.TAB);
			checkIfEnteredDetailsAreValid();
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter data in the field, or invalid inputs were entered. Cross-verify.");
		}
	}
	
	private static void checkIfEnteredDetailsAreValid() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_JOBDETAILS_TEXTBOX_INVALID_CSS);
		} catch (Exception e) {			
			throw new ScriptException("Possible that entered data is invalid.");
		}
	}
	
	@Test
	@Parameters("category")
	@Documentation(step = "Click on a category.", expected = "Able to click the category, and it's selected.")
  	public static void clickCategoryTest(String category) throws Exception {
		ScriptLogger.info();
		try {
			List<WebElement> cat = BrowserAction.getElements(PostAJobPageObjectMap.POST_A_JOB_PAGE_CATEGORIES_XPATH);
			int size = cat.size();
			int i = 0;
			String name = null;
			do {
				name = cat.get(i).getText();
				i++;
			} while (!(name.equals(category)));
			cat.get(i-1).click();
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_CATEGORY_SELECTED_XPATH, 5);
		} catch (Exception e) {
			throw new ScriptException("Couldn't click; either the element wasn't present/enabled, and was unclickable for Selenium. Or perhaps it wasn't selected after being clicked on.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Web, Software & IT category.", expected = "Able to click the category, and it's selected.")
  	public static void clickWebCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_WEBCATEGORY_XPATH); 
			checkIfWebCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfWebCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_WEBCATEGORY_SELECTED_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Design, Art & Multimedia category.", expected = "Able to click the category, and it's selected.")
  	public static void clickDesignCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_DESIGNCATEGORY_XPATH);
			checkIfDesignCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfDesignCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_DESIGNCATEGORY_SELECTED_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Writing & Translation category.", expected = "Able to click the category, and it's selected.")
  	public static void clickWritingCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_WRITINGCATEGORY_XPATH);
			checkIfWritingCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfWritingCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_WRITINGCATEGORY_SELECTED_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Sales & Marketing category.", expected = "Able to click the category, and it's selected.")
  	public static void clickSalesCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_SALESCATEGORY_XPATH); 
			checkIfSalesCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfSalesCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_SALESCATEGORY_SELECTED_XPATH); 
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Admin Support category.", expected = "Able to click the category, and it's selected.")
  	public static void clickAdminCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_ADMINCATEGORY_XPATH); 
			checkIfAdminCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfAdminCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ADMINCATEGORY_SELECTED_XPATH); 
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Management & Finance category.", expected = "Able to click the category, and it's selected.")
  	public static void clickManagementCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_MANAGEMENTCATEGORY_XPATH);
			checkIfManagementCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfManagementCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_MANAGEMENTCATEGORY_SELECTED_XPATH); 
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Legal category.", expected = "Able to click the category, and it's selected.")
  	public static void clickLegalCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_LEGALCATEGORY_XPATH);
			checkIfLegalCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfLegalCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_LEGALCATEGORY_SELECTED_XPATH);
			
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on Engineering & Architecture category.", expected = "Able to click the category, and it's selected.")
  	public static void clickEngineeringCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_ENGINEERINGCATEGORY_XPATH); 
			checkIfEngineeringCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfEngineeringCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ENGINEERINGCATEGORY_SELECTED_XPATH); 
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Any Category' category.", expected = "Able to click the category, and it's selected.")
  	public static void clickAnyCategoryTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_ANYCATEGORY_XPATH);
			checkIfAnyCategoryIsSelected();
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	private static void checkIfAnyCategoryIsSelected() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ANYCATEGORY_SELECTED_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Selenium clicked, but the category wasn't selected still. Application issue.");
		}
	}
	
	@Test
	@Documentation(step = "Check if the skill match appeared, depending on the Job detail entered.", expected = "Skill match should appear with respect to Job details entered.")
	public static void didSkillMatchSuggestionAppear() throws Exception {
		ScriptLogger.info(); 
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_MATCHEDSKILLS_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Possible, Matched Skills suggestions didn't appear.");
		}
	}
	
	private static Boolean didAnySkillMatchAppear() {
		Boolean flag = null;
		ScriptLogger.info(); 
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_MATCHEDSKILLS_ID); 
			ScriptLogger.info("Matched skills appeared. Clicking on it.");
			flag = true;
		} catch (Exception e) {
			ScriptLogger.info("There were no matched skills. Or matched skills didn't appear in time for this validation.");
			flag = false;
		}
		return flag;
	}
	
	private static void clickSuggestedSkillMatch() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_SUGGESTED_SKILL_TOKEN_CLASS); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click suggested Skill match. Perhaps there was none, or Selenium was unable to.");
		}
	}

	@Test
	@Parameters("skill")
	@Documentation(step = "Enter keywords in the 'Essential keywords' textbox.", expected = "Able to enter data in the field.")
	public static void enterKeywordsTest(String skill) throws Exception {
		ScriptLogger.info();
		try {
			if(didAnySkillMatchAppear()) {
				clickSuggestedSkillMatch();
				enterKeyword(skill);
				checkValidKeywordEntry();
			} else {
				enterKeyword(skill);
				checkValidKeywordEntry();
			}
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or selenium failure.");
		}
	}
	
	private static void enterKeyword(String skill) throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_VALID_ID, skill);
			BrowserWait.waitUntilElementIsNotDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_SKILL_AUTOCOMPLETE_BOX_LOOKING_FOR_SKILL_TEXT_XPATH);
			BrowserWait.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_VALID_ID).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new ScriptException("Entered value is invalid.");
		}
	}
	
	private static void checkValidKeywordEntry() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_VALID_ID).sendKeys(Keys.TAB);
			BrowserWait.waitUntilElementIsNotDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_ESSENTIAL_KEYWORDS_TEXTBOX_INVALID_CSS); 
		} catch (Exception e) {
			throw new ScriptException("Entered value is invalid.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Worldwide' radio button.", expected = "Able to click the radio button.")
	public static void clickWorldwideRadioButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_WORLDWIDE_RADIOBUTTON_ID); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Country' radio button.", expected = "Able to click the radio button.")
	public static void clickCountryRadioButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_RADIOBUTTON_ID); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	@Test
	@Parameters("country")
	@Documentation(step = "Enter country name that appears after selecting 'Country' radio button.", expected = "Able to enter data in the field.")
	public static void enterCountryNameTest(String country) throws Exception {
		ScriptLogger.info();
		try {
			WebElement countryParent = BrowserAction.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_PARENT_ID);
			WebElement countryChild = countryParent.findElement(By.id(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_CHILD_ID.getValue()));
			countryChild.sendKeys(country);
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_DROPDOWN_XPATH); 
			BrowserWait.waitUntilElementIsNotDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_AUTOCOMPLETE_BOX_LOOKING_FOR_COUNTRY_TEXT_XPATH);
			BrowserWait.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_CHILD_ID).sendKeys(Keys.DOWN);
			BrowserWait.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_CHILD_ID).sendKeys(Keys.ENTER);
			checkIfCountryTokenAppearedTest();
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter, or select country from suggestions.");
		}
	}
	
	private static void checkIfCountryTokenAppearedTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(PostAJobPageObjectMap.POST_A_JOB_PAGE_COUNTRY_TEXTBOX_COUNTRY_TOKEN_CLASS); 
		} catch (Exception e) {
			throw new ApplicationException("Application issue: Country token didn't appear after selecting a country.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Fixed Price' radio button.", expected = "Able to click on the radio button.")
	public static void clickFixedPriceRadioButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_FIXEDPRICE_RADIOBUTTON_ID); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	@Test
	@Parameters("fixedBudget")
	@Documentation(step = "Select the fixed price budget from the dropdown options.", expected = "Able to select options from the dropdown list.")
	public static void selectFixedPriceBudgetTest(String budget) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_FIXEDPRICE_BUDGET_LISTBOX_ID)); 
			select.selectByVisibleText(budget);
			BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_FIXEDPRICE_BUDGET_LISTBOX_ID).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Documentation(step = "Click on the 'Hourly' radio button.", expected = "Able to click on the radio button.")
	public static void clickHourlyRadioButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_HOURLY_RADIOBUTTON_ID); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	@Test
	@Parameters("jobDuration")
	@Documentation(step = "Select Job duration from the dropdown list that appears after selecting 'Hourly' radio button.", expected = "Able to select duration from the list of options.")
	public static void selectJobDurationTest(String duration) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_JOB_DURATION_LISTBOX_ID)); 
			select.deselectByVisibleText(duration);
			BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_JOB_DURATION_LISTBOX_ID).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Parameters("hoursperweek")
	@Documentation(step = "Select Hours per week from the dropdown list.", expected = "Able to select the hours per week from the options.")
	public static void selectHoursPerWeekTest(String hoursperweek) throws Exception {
		ScriptLogger.info();
		try {
			Select select = new Select(BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_HOURS_PER_WEEK_LISTBOX_ID)); 
			select.deselectByVisibleText(hoursperweek);
			BrowserAccess.getElement(PostAJobPageObjectMap.POST_A_JOB_HOURS_PER_WEEK_LISTBOX_ID).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Parameters("minrate")
	@Documentation(step = "Enter Mininum rate/hour in the textbox.", expected = "Able to enter number values in the textbox.")
	public static void enterMinRatePerHourTest(String minrate) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_MIN_RATE_PERHOUR_TEXTBOX_ID, minrate);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Parameters("maxrate")
	@Documentation(step = "Enter Maximum rate/hour in the textbox.", expected = "Able to enter number values in the textbox.")
	public static void enterMaxRatePerHourTest(String maxrate) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_MAX_RATE_PERHOUR_TEXTBOX_ID, maxrate);
		} catch (Exception e) {
			throw new ScriptException("Possible error in script logic, or parameter passed wasn't recognized as a valid parameter.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Yes! Feature my job...' checkbox.", expected = "Able to click on the checkbox.")
	public static void clickFeatureMyJobTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.switchToDefaultContent();
			WebElement featureCheckbox = BrowserAction.getElement(PostAJobPageObjectMap.POST_A_JOB_PAGE_FEATURE_MY_JOB_CHECKBOX_ID);
			featureCheckbox.click(); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field value; either field was disable on the page, or Selenium issue.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Post Job' button.", expected = "Able to click on the button.")
	public static void clickPostJobButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_POST_JOB_BUTTON_ID); 
		} catch (Exception e) {
			throw new ScriptException("Couldn't click, either the element wasn't present/unclickable, and was unclickable for Selenium.");
		}
	}
	
	/* LANDING ON POST A JOB PAGE WITHOUT SIGNING INTO AN ACCOUNT; METHODS HANDLING THE SIGN IN OPTIONS IN THE PAGE BELOW ARE HERE */
	
	@Test
	@Documentation(step = "Verify Sign In options present when the user lands on Post a job page without signing into the application.", expected = "Able to verify.")
	public static void verifyForSignInToPostOptionsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Sign in to post");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Sign in section didn't appear on the page even though user isn't logged in.");
		}
	}
	
	@Test
	@Parameters("username")
	@Documentation(step = "Enter Username in the username textbox field.", expected = "Able to enter data in the field.")
	public static void enterUsernameTest(String username) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_EMAIL_OR_USERNAME_TEXTBOX_ID, username);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field value; either field was disable on the page, or Selenium issue.");
		}
	}
	
	@Test
	@Parameters("password")
	@Documentation(step = "Enter Password in the Password textbox field.", expected = "Able to enter data in the field.")
	public static void enterPasswordTest(String password) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.enterFieldValue(PostAJobPageObjectMap.POST_A_JOB_PAGE_PASSWORD_TEXTBOX_ID, password);
		} catch (Exception e) {
			throw new ScriptException("Couldn't enter field value; either field was disable on the page, or Selenium issue.");
		}
	}
	
	// Get 50% More Quotes: Feature Your Job POP UP
	
	@Test
	@Documentation(step = "Click on 'Feature My Job' checkbox in the popup.", expected = "Able to click on the checkbox.")
	public static void clickFeatureMyJobPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Get 50% More Quotes: Feature Your Job");
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_GET_MORE_QUOTES_POPUP_FEATURE_MY_JOB_RADIO_ID);
		} catch (Exception e) {
			throw new ScriptException("Couldn't click 'Feature My Job Radio' button.");
		}
	}
	
	@Test
	@Documentation(step = "Click on 'Continue' button in the popup.", expected = "Able to click on the button.")
	public static void clickContinueButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Get 50% More Quotes: Feature Your Job");
			BrowserAction.click(PostAJobPageObjectMap.POST_A_JOB_PAGE_AFTER_SIGNING_IN_CONTINUE_BUTTON_IN_GET_MORE_QUOTES_DIALOG_BOX_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Continue' button; either element wasn't there, or was unclickable.");
		}
	}
	
		
}
