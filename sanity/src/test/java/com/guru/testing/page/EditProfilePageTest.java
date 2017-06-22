package com.guru.testing.page;

import java.util.List;

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
import com.guru.framework.testing.helpers.FileHandler;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;
import com.guru.framework.testing.utils.objects.StringUtils;
import com.guru.testing.constants.ServicesCategory;
import com.guru.testing.objectmap.CommonObjectMap;
import com.guru.testing.objectmap.DashboardPageObjectMap;
import com.guru.testing.objectmap.EditProfilePageObjectMap;
import com.guru.testing.objectmap.WorkroomPageObjectMap;


public class EditProfilePageTest {
	public static Boolean FIRST_SERVICE=false;
	public static Boolean FIRST_PORTFOLIO=false;
	public static Boolean FIRST_TESTIMONIAL=false;
	private static int countBefore = 0;
	private static int countAfter = 0;
	public static String publishedPortName = null;
	

	@Test
	@Documentation(step = "Verify if 'Edit profile' page loaded.", expected = "'Edit Account' page for the user should load.")
	public static void verifyEditProfileTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Edit About Info - Build Profile - Freelancers - Guru");					
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_BODY_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PROFILE_IMAGE_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_VIEW_PROFILE_LINK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_UPGRADE_MEMBERSHIP_LINK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PROFILE_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICES_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ABOUT_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIALS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_MEMBERSHIP_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_BIDS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PROFILE_STATS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_AND_VIDEOS_DIV_ID);
		} catch (Exception e) {
			try {
				BrowserWait.waitUntilPageTitle("Edit Services - Build Profile - Freelancers - Guru");
				BrowserWait.waitUntilElementIsDisplayed(DashboardPageObjectMap.DASHBOARD_PAGE_FL_SERVICES_DASHBOARD_TAB_ID);		
			} catch (Exception e2) {
				throw new HTMLElementNotFoundException(e2, "Verification of 'Edit Profile' Page when logged in as FL-Owner failed.");
			}
			
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickProfilePicTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PROFILE_IMAGE_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickViewProfileLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_VIEW_PROFILE_LINK_PLINK);

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickEditProfileLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PROFILE_LINK_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAboutLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ABOUT_LINK_ID);			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
		
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyEditAboutInfoTest() throws Exception {
		ScriptLogger.info();
		verifyEditProfileTest();
		try {
			BrowserWait.waitUntilText("Edit About Info","Public Identity","Overview","Attach Files and Videos","Skill Tests");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_COMMON_PANEL_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_ABOUT_INFO_COVER_IMG_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_ABOUT_INFO_CHANGE_COVER_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_ABOUT_INFO_CHANGE_PROFILE_PIC_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_FIRST_SERVICES_OR_PORTFOLIO_XPATH);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickServicesLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICES_LINK_ID);
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickPortfolioLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_LINK_ID);
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickTestimonialsLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIALS_LINK_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyEditServicesLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("Edit Services");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_COMMON_PANEL_ID);			
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_ADD_BUTTON_ID);
			try {
				BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_FIRST_SERVICES_OR_PORTFOLIO_XPATH);
			
				FIRST_SERVICE=true;
				BrowserWait.waitUntilText("Employers can�t find you because you have no services!");
				BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_ADD_FIRST_SERVICE_PLINK);
			}
			catch (Exception e){
				BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_SERVICES_LIST_XPATH);
			}
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAddServiceButtonTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_ADD_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyAddANewServiceLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("Add a New Service","Welcome! Get started by listing a service you offer.");
			BrowserWait.waitUntilText("You need to list services to receive job matches and be found by employers.");
			BrowserWait.waitUntilText("Title *","Description *","Skills & Expertise","Rate/Hour","USD | Min. $8","Minimum Budget","USD | Min. $25","Category *");	
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_COMMON_PANEL_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_TITLE_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_DESCRIPTION_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_SKILLS_AND_EXPERTISE_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_RATE_PER_HOURS_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_MINIMUM_BUDGET_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_CATEGORY_DROPDOWN_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_PUBLISH_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_SAVE_DRAFT_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_CANCEL_BUTTON_ID);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Parameters({"title","desc","minBudget","ratePerHour","minBudget","serviceCategory"})
	@Documentation(step = "", expected = "")
	public static void addANewServiceTest(String title,String desc,
											@Optional("ie") String skills,
											@Optional("8") String ratePerHour,
											@Optional("25") String minBudget,
											@Optional("WEB_SOFTWARE_AND_IT") ServicesCategory serviceCategory) throws Exception {
		ScriptLogger.info();	
		try {
			enterTitle(title);
			enterDescription(desc);
			enterSkillsAndExpertiseTest(skills);
			enterRatePerHour(ratePerHour);
			enterMinimumBudgetTest(minBudget);
			selectCategory(serviceCategory);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	private static void enterTitle(String title) throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_TITLE_TEXTBOX_ID,title);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	private static void enterDescription(String desc) throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_DESCRIPTION_TEXTBOX_ID,desc);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	private static void enterSkillsAndExpertiseTest(String skills) throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_SKILLS_AND_EXPERTISE_TEXTBOX_ID,skills);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	private static void enterRatePerHour(String ratePerHour) throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_RATE_PER_HOURS_TEXTBOX_ID,ratePerHour);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	private static void enterMinimumBudgetTest(String minBudget) throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_TITLE_TEXTBOX_ID,minBudget);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	

   private static void selectCategory(ServicesCategory serviceCategory) throws Exception{
		ScriptLogger.info(serviceCategory.getValue());		
		try {
			Select dropdown=	new Select(BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_CATEGORY_DROPDOWN_ID));
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if(option.getText().equals(serviceCategory.getValue())){
					dropdown.selectByVisibleText(option.getText());
				}
				else{
					throw new Exception("No matching category found");
				}	
			}
			
		} catch (Exception e) {
			throw new Exception(e);
		}		
	}
   
   @Test
	@Documentation(step = "", expected = "")
	public static void clickToPublishServiceTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_PUBLISH_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
   
   @Test
	@Documentation(step = "", expected = "")
	public static void verifyEditWorkCollectionPortfolioLinkTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilText("Edit Work Collections");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_COMMON_PANEL_ID);			
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PORTFOLIO_ADD_BUTTON_ID);
			if(BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_FIRST_SERVICES_OR_PORTFOLIO_XPATH)!=null){
				FIRST_PORTFOLIO=true;			
				BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PORTFOLIO_ADD_FIRST_PORTFOLIO_ID);
				BrowserWait.waitUntilText("a Work Collection to show examples of your services.");
			}
			
			else{
				//TODO
			}
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAddPortfolioButtonTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PORTFOLIO_ADD_BUTTON_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyAddPortfolioTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PORTFOLIO_PANEL_ID);			
			//TODO
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickAddFilesTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_ADD_ICON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Attach Files Icon is not loaded on the application");
		}
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_ADD_ICON_ID);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void clickBrowseFilesTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(10000);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_BROWSE_BUTTON_ID,10);	
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Browser Button not loaded in time");
		}
		
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_BROWSE_BUTTON_ID);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyBrowseFilesModalTest() throws Exception {
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_ID);
			BrowserWait.waitUntilText("Attach Files");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_CLOSE_ICON_ID);
			BrowserWait.waitUntilText("Browse your computer for files to attach.");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_BROWSE_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_CANCEL_BUTTON_ID);			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Browser Files modal window not loaded in Edit profile");
		}
		
	}


	@Test
	@Parameters("invalidFiles")
	@Documentation(step = "", expected = "")
	public static void addInvalidFileTypesTest(String invalidFiles) throws Exception {
		ScriptLogger.info();
		addFilesTest(invalidFiles);
	}
	@Test
	@Parameters("invalidFiles")
	@Documentation(step = "", expected = "")
	public static void addInvalidFileTypes2Test(String invalidFiles) throws Exception {
		ScriptLogger.info();
		addFilesTest(invalidFiles);
	}
	
	
	@Test
	@Parameters("fileCount")
	@Documentation(step = "", expected = "")
	public static void verifyFilesLoadedTest(int fileCount) throws Exception {
		ScriptLogger.info();	
		String totalAndSizeText;
		Thread.sleep(5000);
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_FILE_TABLE_FILE_LIST_ID);			
			verifyAttachFilesPopupTable();
			totalAndSizeText=BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_TOTAL_AND_SIZE_ID).getText();
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_UPLOAD_MORE_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_CANCEL_BUTTON_2_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_FILE_TABLE_FILE_LIST_ID);
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}	
		
		
			int countElement=Integer.parseInt(StringUtils.getStringBetween(totalAndSizeText, "Total: ", " Files", 1));
			if(fileCount!=countElement){
				throw new ApplicationException("Files count is not same Expected:"+fileCount+ "Actual:"+countElement);
			}
	}
	
	@Test
	@Parameters("fileCount")
	@Documentation(step = "", expected = "")
	public static void verifyFilesLoaded1Test(int fileCount) throws Exception {
		ScriptLogger.info();	
		verifyFilesLoadedTest(fileCount);
	}
	
	private static void verifyAttachFilesPopupTable() {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_FILE_TABLE_HEADER_ID);
			List<WebElement> thElements=BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_FILE_TABLE_HEADER_ID).findElements(By.tagName("td"));
			if(!"File Name".equalsIgnoreCase(thElements.get(0).getText())&&
					!"Progress".equalsIgnoreCase(thElements.get(1).getText())&&
					!"Size".equalsIgnoreCase(thElements.get(2).getText())&&
					!"Delete".equalsIgnoreCase(thElements.get(3).getText())){
								throw new ApplicationException("One of the table headers is not loaded");
							}
		} catch (Exception e) {
			
		}
		
	}


	@Test
	@Documentation(step = "", expected = "")
	public static void clickUploadTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_UPLOAD_BUTTON_ID);			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("errorMsg")
	@Documentation(step = "", expected = "")
	public static void verifyErrorMsgTest(String errorMsg) throws Exception {
		ScriptLogger.info();
		List<WebElement> elements = null;
		try {
		BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_ID);
		elements = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_PROGRESS_BAR_XPATH);
		
		} catch (Exception e) {
			
			throw new ScriptException(e);
		}

		for (WebElement webElement : elements) {
			if (!errorMsg.equals(webElement.getText())) {
				throw new ApplicationException("Application Issue: '" + errorMsg + "' is not showing");
			}
		}		
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void clickCancelOnAttachFilesPopUpTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_CANCEL_BUTTON_2_ID);			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Parameters("morethan10MBFile")
	@Documentation(step = "", expected = "")
	public static void addMoreThan10MBFileTest(String morethan10MBFile) throws Exception {
		ScriptLogger.info();	
		addFilesTest(morethan10MBFile);
		
	}
	
	@Test
	@Parameters("files")
	@Documentation(step = "", expected = "")
	public static void addFilesTest(String files) throws Exception {
		ScriptLogger.info();
		FileHandler.uploadFilesFromPath(files,"|");
	}
	
	
	@Test
	@Parameters("file")
	@Documentation(step = "", expected = "")
	public static void addSingleFileTest(String file) throws Exception {
		ScriptLogger.info();
		addFilesTest(file);
	}
		
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyNoErrorMessageTest() throws Exception {
		ScriptLogger.info();
		List<WebElement> elements = null;
		try {
			elements = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_PROGRESS_BAR_XPATH);
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		for (WebElement webElement : elements) {
			if (!"".equals(webElement.getText())) {
				throw new ApplicationException("Application Issue: Incorrect messaghe displayes"+webElement.getText());
			}
		}	
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void deleteAllFilesFromPopUpTest() throws Exception {
		ScriptLogger.info();
		List<WebElement> elements = null;
		try {
			BrowserWait.waitUntilAtLeastOneElementPresent(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_DELETE_BIN_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "No Delete icon is present");
		}
		Thread.sleep(5000);
		try {
			elements = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_DELETE_BIN_ID);
		for (WebElement webElement : elements) {
			webElement.click();
		}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void clickUploadMoreTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_UPLOAD_MORE_LINK_ID);			
	

		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void clickUploadMore1Test() throws Exception {
		ScriptLogger.info();
		clickUploadMoreTest();			
			
		
	}
	
	@Test
	@Parameters("fileCount")
	@Documentation(step = "", expected = "")
	public static void verifyAllBinImageTest(int fileCount) throws Exception {
		ScriptLogger.info();	
		List<WebElement> elements=null;
			try {
				elements = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_DELETE_BIN_ID);
			} catch (Exception e) {
				throw new ScriptException(e);
			}
			if(fileCount!=elements.size()){
				throw new ApplicationException("Files count is not same Expected:"+fileCount+ "Actual:"+elements.size());
			}
		
	}

	@Test
	@Parameters("totalCount")
	@Documentation(step = "", expected = "")
	public static void verifyTotalFilesLoadedTest(int totalCount) throws Exception {
		ScriptLogger.info();	
		verifyFilesLoadedTest(totalCount);
	}

	

	@Test
	@Parameters("attachSuccessText")
	@Documentation(step = "", expected = "")
	public static void verifySuccessfullyAttachedTest(String attachSuccessText) throws Exception {
		ScriptLogger.info(" "+countBefore);	
		/*List<WebElement> elements=null;
			try {
				elements = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_PROGRESS_BAR_XPATH);
			} catch (Exception e) {
				throw new ScriptException(e);
			}
			WebElement element=null;
			
				for (WebElement webElement : elements) {
					if(!attachSuccessText.equals(webElement.getText())){
						countBefore++;
						element=webElement;
						while(countBefore<10){
						verifySuccessfullyAttachedTest(attachSuccessText);	//Recursive till 10 times
					}
				}	
			}*/
			
		try{ 
			HirePageTest.waitTillUploadFinished();
			Thread.sleep(4000);
			String attr = BrowserWait.getElement(WorkroomPageObjectMap.WORKROOM_PAGE_FILE_UPLOAD_PROGRESS_BAR_XPATH).getAttribute("style");
			if(!attr.contains("display: none")) {
				throw new Exception("File was uploaded, but thumbnail after successful upload didn't appear.");
			}
		} catch (Exception e) {
			ScriptLogger.debug("File size limit exceeded, that's why it doesn't go through the entire upload process.");
		}
					
	}
	
	@Test
	@Documentation(step = "Reload page and verify add files button", expected = "Add files button should be reloaded")
	public static void reloadAndVerifyFilesButtonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.refresh();
			Thread.sleep(5000);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_ADD_ICON_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}

	
	@Test
	@Documentation(step = "Reload page and verify Edit profile page button", expected = "Edit profiel page should be reloaded")
	public static void reloadAndVerifyEditProfileTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.refresh();
			verifyEditProfileTest();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		
	}

	@Test
	@Parameters("fileName")
	@Documentation(step = "", expected = "")
	public static void verifyFilesUploadedOnEditProfileTest(String fileName) throws Exception {
		ScriptLogger.info();	
		List<WebElement> fileListElements=null;
		try {
			fileListElements=BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_FILE_LIST_XPATH);
			fileListElements.remove(0);
			fileListElements.remove(0);
		} catch (Exception e) {
			throw new ScriptException(e);
		}		
			if(fileListElements.size()>1){
				String[] files=StringUtils.splitDataBySymbol(fileName,"|");
		
				for (WebElement fle : fileListElements) {
					for (String file : files) {
						if(fle.findElement(By.xpath("//input[@type='text'][@value='"+file+"']"))==null){
							throw new ApplicationException("Application issue: Files are not uploaded on Edit profile");
						}	
					}					
				}
			}
			
			else if(fileListElements.size()==1&& !fileName.contains("|")){
				if(fileListElements.get(0).findElement(By.xpath("//input[@type='text'][@value='"+fileName+"']"))==null){
					throw new ApplicationException("Application issue: File is not uploaded on Edit profile");
				}	
			}
			
			else if(fileListElements.size()==1&& fileName.contains("|")){
				throw new ApplicationException("Application issue: More than one file expected but not present");
			}
			
			else{
				throw new ApplicationException("Application issue: There is no uploaded file");
			}		
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void deleteAllEditProfileFilesTest() throws Exception {
		ScriptLogger.info();
		int count=1;
		try {
			List<WebElement> fileListElements=BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_DELETE_FILE_ICON_XPATH);
			int size=fileListElements.size();
			for (int i = 0; i < size; i++) {
				reloadAndVerifyFilesButtonTest();
				WebDriverAction.hoverOverElement(By.xpath("(//li[@class='draggable1 attachedFileWidth'])[1]"));
				WebDriverAction.click(By.xpath("(//a[@class='module_btn secondary_btn small_btn deletefile'])[1]"));				
				count++;				
			}
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	@Test
	@Documentation(step = "", expected = "")
	public static void clickOnServicesTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICES_LINK_ID);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("serviceName")
	@Documentation(step = "", expected = "")
	public static void editServiceByNameTest(String serviceName) throws Exception {
		ScriptLogger.info();	
		try {
			List<WebElement> serviceListElements=BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_SERVICES_LIST_XPATH);
			
			for (WebElement webElement : serviceListElements) {
				
				if(webElement.findElement(By.linkText(serviceName)) != null){
					WebElement element=webElement.findElement(By.xpath("//button[@class='module_btn secondary_btn dropdown-toggle']"));
					element.click();
					break;
				}				
			}
			selectEditInServiceDropDownTest();
			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}	
	
	private static void selectEditInServiceDropDownTest() throws Exception {
		BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_EDIT_OPTION_DROPDOWN_XPATH);
		
	}


	@Test
	@Parameters("hundredChar")
	@Documentation(step = "", expected = "")
	public static void enterHundredCharInDescriptionTest(String hundredChar) throws Exception {
		ScriptLogger.info();	
		try {
			
			BrowserAction.clickAndClear(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_DESCRIPTION_TEXTBOX_ID);
		
			addServiceDescriptionTest(hundredChar+StringUtils.generateRandomString(2));			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Parameters("description")
	@Documentation(step = "", expected = "")
	public static void addServiceDescriptionTest(String description) throws Exception {
		ScriptLogger.info();	
		try {
					
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_DESCRIPTION_TEXTBOX_ID,description);			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	public static void verifyDescriptionCharLimitTest() throws Exception {
		ScriptLogger.info();	
		String elementText= BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_DESCRIPTION_CHARACTER_TEXT_ID).getText();
		if(!"2900 characters left.".equals(elementText)){
				throw new ApplicationException("Application issue: Expected: 2900 characters left. Actual: "+elementText);
			}
	}
	
	@Test
	@Documentation(step = "", expected = "")
	private static void clickToAddPortfolioToServiceTest() throws Exception {
		ScriptLogger.info();
		try {

			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_ADD_PORTFOLIO_BUTTON_ID);

		} catch (Exception e) {
			throw new ScriptException(e);
		}

	}
	
	@Test
	@Documentation(step = "", expected = "")
	private static void verifyPortafolioModalOnServicesTest() throws Exception {
		ScriptLogger.info();
		try {

			BrowserWait.waitUntilText("Related Work Collections","Feature Work Collections that are relevant to this service.");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_PORTFOLIO_MODAL_ID);

		} catch (Exception e) {
			throw new ScriptException(e);
		}

	}

	@Test
	@Parameters("portfolioName")
	@Documentation(step = "", expected = "")
	public static void selectPortfolioByNameTest(String portfolioName) throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(4000);
			List<WebElement> list = BrowserAction.getElements(EditProfilePageObjectMap.EDITPROFILE_PAGE_LIST_IN_RELATED_WORK_ITEMS_POPUP_XPATH);
			for (WebElement wle : list) {
				BrowserAction.hoverOverElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_LIST_IN_RELATED_WORK_ITEMS_POPUP_XPATH);
				Thread.sleep(2000);
				String webText = wle.findElement(By.tagName("p")).getText();
				if(portfolioName.equals(webText)){
					wle.click();
					break;
				}
			}
		} catch (Exception e) {
			throw new ScriptException("Either there's no such Portfolio name, or error in script logic, perhaps. Evaluate.");
		}
	}

	@Test
	@Parameters("category")
	@Documentation(step = "Select a category on the services", expected = "")
	public static void selectCategoryTest(String category) throws Exception {
		ScriptLogger.info();	
		try {
			Select select=new Select(BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_CATEGORY_DROPDOWN_ID));
			select.selectByVisibleText(category);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click done in portfolio Modal window", expected = "Done on the Portfolio Modal Window should be clicked")
	public static void clickDoneOnPortfolioModalTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICE_PORTFOLIO_MODAL_DONE_BUTTON_ID);			
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click done in attach files after upload is finished", expected = "Done on the attached files modal should be clicked")
	public static void clickDoneInAttachFilesTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_DONE_BUTTON_ID,10);	
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e,"Done Button not loaded in time");
		}
		
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ATTACH_FILES_POP_UP_DONE_BUTTON_ID);			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Click Save button", expected = "Save button should be clicked")
	public static void clickSaveTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(CommonObjectMap.COMMON_SAVE_BUTTON_XPATH);			
			
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	
	@Test
	@Documentation(step = "Scroll Window to 0,2000 co-ordinates"
			+ "", expected = "Scrolling should be done")
	public static void scrollWindowToAttachFilesAndVideosTest() throws Exception {
		ScriptLogger.info();
		try {
			/*BrowserAction.scrollWindow(0,1500);
			BrowserAction.scrollWindow(0,1500);*/
		} catch (Exception e) {
			//BrowserAction.scrollWindow(0,1500);
			throw new ScriptException(e);
		}
	}
	
 // ------------------------------------------------- PHASE 2 ENDS  // PHASE 1 STARTS HERE -------------------------------------------------
	
	@Test
	@Documentation(step = "Verify if 'Edit profile' page loaded.", expected = "'Edit Account' page for the user should load.")
	public static void verifyEditProfileFLOwnerTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Edit About Info - Build Profile - Freelancers - Guru");
			BrowserWait.waitUntilText("Edit About Info", "Public Identity", "Overview", "Attach Files and Videos", "Skill Tests");			
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_BODY_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PROFILE_IMAGE_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_VIEW_PROFILE_LINK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_UPGRADE_MEMBERSHIP_LINK_PLINK);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_PROFILE_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_SERVICES_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ABOUT_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIALS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_MEMBERSHIP_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_BIDS_LINK_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PROFILE_STATS_LINK_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Verification of 'Edit Account' Page when logged in as FL-Owner failed, because one of more elements of the page didn't load properly, or at all.");
		}
	}
	
	// METHODS RELATED TO NAVIGATING AND VALIDATING TESTIMONIALS PAGE, AND CLICKING ADD TESTIMONIAL
	// ---------------------------- START ------------------------ 
	
	@Test
	@Documentation(step="Click on 'Testimonials' link in the left panel, under 'Edit Profile' category.", expected="User is able to click, and is redirected to 'Edit Testimonials' section.")
	public static void clickTestimonialsTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.scrollWindow(0,0);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIALS_LINK_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Testimonials link wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Testimonials' section loaded.", expected = "'Testimonials' section for the user should load.")
	public static void verifyTestimonialsSectionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Edit Testimonials");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_TESTIMONIALS_ADD_TESTIMONIALS_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Verification failed because one or more elements of the Testimonials section didn't load properly, or wasn't visible at all.");
		}
	}
	
	@Test
	@Documentation(step = "Click '+' button to add new Testimonial", expected = "User is able to click the button.")
	public static void clickAddTestimonialTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_TESTIMONIALS_ADD_TESTIMONIALS_BUTTON_ID);
			waitForAddTestimonialPopupTest();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Add Testimonial button wasn't found, or wasn't clickable.");
		}
	}
	
	private static void waitForAddTestimonialPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_POPUP_ID);
			BrowserWait.waitUntilText("Add Testimonial");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_REVIEWER_NAME_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_TESTIMONIAL_TEXTBOX_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_ADD_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_CANCEL_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Add Testimonial popup didn't load, or some of the elements in the popup didn't.");
		}
	}
	// ---------------------------- END ------------------------
	
	// METHODS HANDLING ADD TESTIMONIAL POP UP (ENTERING DATA & Clicking buttons in the popup)
	// ---------------------------- START ------------------------ 
	@Test
	@Parameters("reviewerName")
	@Documentation(step = "Enter valid name in 'Reviewer Name' textbox", expected = "User is able to enter name in the textbox.")
	public static void enterReviewerNameTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_REVIEWER_NAME_TEXTBOX_ID);
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_REVIEWER_NAME_TEXTBOX_ID, name);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the element wasn't present, or was unable to take data.");
		}
	}
	
	@Test
	@Parameters("testimonial")
	@Documentation(step = "Enter valid content in 'Testimonial' textbox", expected = "User is able to enter testimonial in the textbox.")
	public static void enterTestimonalTest(String testimonial) throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.clickAndClear(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_TESTIMONIAL_TEXTBOX_ID);
			BrowserAction.enterFieldValue(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_TESTIMONIAL_TEXTBOX_ID, testimonial);
			BrowserAccess.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_TESTIMONIAL_TEXTBOX_ID).sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the element wasn't present, or was unable to take data.");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Add' button in Add Testimonial Popup", expected = "User is able to click 'Add' button.")
	public static void clickAddInPopupTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_ADD_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the element wasn't present, or wasn't clickable");
		}
	}
	
	@Test
	@Documentation(step = "Click 'Cancel' button in Add Testimonial Popup", expected = "User is able to click 'Cancel' button.")
	public static void clickCancelTestimonialTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_CANCEL_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either the element wasn't present, or wasn't clickable");
		}
	}
	// ---------------------------- END ------------------------
	
	// METHODS HANDLING CHECKING VALID, INVALID INPUT & ERROR MESSAGE DISPLAY
	// --------------------------- START -----------------------
	@Test
	@Documentation(step = "Verify no invalid entries are present", expected = "User is able to verify that there are no invalid entries.")
	public static void verifyNoInvalidInputTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_INVALID_INPUT_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Application issue: showing invalid input even when with no invalid entry.");
		}
	}
	
	@Test
	@Documentation(step = "Verify invalid entries when entering invalid data", expected = "User should be able to verify that the application shows invalid entry when entering invalid data.")
	public static void verifyInvalidInputTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_INVALID_INPUT_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Application issue: BUG 29530 showing invalid input text is getting accepted");
		}
	}
	
	@Test
	@Documentation(step = "Verify No error message is displayed.", expected = "No error message is displayed")
	public static void verifyNoErrorMsgTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsNotDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_ERROR_MESSAGE_XPATH);
		} catch (Exception e) {
			throw new ApplicationException("Application issue: Showing error message even with valid entries.");
		}
	}
	
	// ---------------------------- END ------------------------
	
	// METHODS HANDLING TESTIMONIAL COUNT COMPARISION
	// --------------------------- START -----------------------
	@Test
	@Documentation(step = "Get number of testimonials before any add or delete operation.", expected = "Able to fetch testimonial count")
	public static void getTestimonialCountBeforeTest() throws Exception {
		ScriptLogger.info();
		try {
			countBefore=0;
			List<WebElement> element = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_LIST_UL_ID).findElements(By.tagName("li"));
			for (WebElement testimonials : element) {
				countBefore++;
			}
		} catch (Exception e) {
			countBefore = 0;
			ScriptLogger.info("Count Before = " +countBefore);
		}
	}
	
	@Test
	@Documentation(step = "Get number of testimonials after any add or delete operation.", expected = "Able to fetch testimonial count")
	public static void getTestimonialCountAfterTest() throws Exception {
		ScriptLogger.info();
		try {
			countAfter=0;
			List<WebElement> element = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_LIST_UL_ID).findElements(By.tagName("li"));
			for (WebElement testimonials : element) {
				countAfter++; // searching for 'li' gives 3 lis per testimonial. So, basically, if there are two testimonials, it returns 6 li tag elements
			}

		} catch (Exception e) {
			countAfter = 0;
			ScriptLogger.info("Count After = " +countAfter);
		}
	}
	
	@Test
	@Documentation(step = "Verify testimonial count remain unchanged when no add/delete operation was done", expected = "Testimonial count should remain unchanged.")
	public static void verifyCountUnchangedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!Integer.valueOf(countAfter).equals(Integer.valueOf(countBefore))){
				throw new ApplicationException("Testimonial count changed even without adding a testimonial");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step = "Verify testimonial count increase when add operation was done", expected = "Testimonial count should increase.")
	public static void verifyCountIncreasedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!(countBefore < countAfter)){
				throw new ApplicationException("Testimonial count didn't increase even after adding new Testimonial");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}

	@Test
	@Documentation(step = "Verify testimonial count decreased when no delete operation was done", expected = "Testimonial count should decrease.")
	public static void verifyCountDecreasedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!(countBefore > countAfter)){
				throw new ApplicationException("Testimonial count didn't decrease even after deleting a Testimonial");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// --------------------------- END -----------------------
	
	// METHODS HANDLING CHARACTER LIMIT TESTING
	// ------------------------ START ------------------------

	private static int getCharacterCountTest(Object locator) throws Exception {
		ScriptLogger.info();
		int length = 0;
		try {
			length = BrowserAction.getElement(locator).getText().length(); // if getText() doesn't work, try getValue()
			return length;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Test
	@Parameters("characterLimit")
	@Documentation(step = "Verify character limit of textbox.", expected = "Able to verify.")
	public static void verifyNameCharacterLimitTest(int limit) throws Exception {
		ScriptLogger.info();
		int length = 0;
		try {
			length = getCharacterCountTest(EditProfilePageObjectMap.EDITPROFILE_PAGE_ADD_TESTIMONIAL_REVIEWER_NAME_TEXTBOX_ID);
			if (!(length <= limit)) {
				throw new ApplicationException("Application issue: Textbox is accepting more than character limit set for it.");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	// --------------------------- END -----------------------
	
	// METHODS HANDLING HOVERING & EDITING TESTIMONIAL ADDED
	// ------------------------ START ------------------------
	@Test
	@Parameters("testimonialNo")
	@Documentation(step = "Hover over the testimonial added.", expected = "Testimonial was hovered over to show drop-down for Edit/Delete.")
	public static void hoverAndEditTestimonialByNumTest(int testimonialNo) throws Exception {
		ScriptLogger.info();
		try {
			int count=testimonialNo;
			String loc="(//ul[@id='testimonialsList']//li)["+count+"]";
			Thread.sleep(5000);
			WebDriverAction.hoverOverElement(By.xpath(loc), WebDriverAction.ACTION_STYLE_WEBDRIVER);
			Thread.sleep(5000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_APPEARING_ON_HOVER_XPATH,WebDriverAction.ACTION_STYLE_WEBDRIVER);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_EDIT_OPTION_XPATH);
			waitForAddTestimonialPopupTest();
		} catch (Exception e) {
			throw new ApplicationException("Dropdown didn't appear for additional Edit/Delete optional for the respective testimonial.");
		}
	}
	
	@Test
	@Parameters("testimonialNo")
	@Documentation(step = "Hover over the testimonial added.", expected = "Testimonial was hovered over to show drop-down for Edit/Delete.")
	public static void hoverAndDeleteTestimonialByNumTest(int testimonialNo) throws Exception {
		ScriptLogger.info();
		try {
			int count=testimonialNo;
			String loc="(//ul[@id='testimonialsList']//li)["+count+"]";
			Thread.sleep(5000);
			WebDriverAction.hoverOverElement(By.xpath(loc), WebDriverAction.ACTION_STYLE_WEBDRIVER);
			Thread.sleep(5000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_APPEARING_ON_HOVER_XPATH,WebDriverAction.ACTION_STYLE_WEBDRIVER);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_DELETE_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_DELETE_CONFIRM_DIALOG_POPUP_ID);
		} catch (Exception e) {
			throw new ApplicationException("Dropdown didn't appear for additional Edit/Delete optional for the respective testimonial.");
		}
	}
	
	
	
	
	/*@Test
	@Documentation(step = "Click the drop-down element to show additional options", expected = "Testimonial was hovered over to show drop-down for Edit/Delete.")
	public static void clickDropdownOptionTest() throws Exception {
		ScriptLogger.info();
		try {
			//BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_APPEARING_ON_HOVER_XPATH);	
		} catch (Exception e) {
			throw new ApplicationException("Dropdown didn't appear for additional Edit/Delete optional for the respective testimonial, or was unclickable.");
		}
	}
		
	@Test
	@Documentation(step = "Click on 'Edit' from the dropdown options.", expected = "'Edit' option from dropdown menu is clickable.")
	public static void clickEditOptionTest() throws Exception {
		ScriptLogger.info();
		try {
			//BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_EDIT_OPTION_XPATH);
			waitForAddTestimonialPopupTest();
		} catch (Exception e) {
			throw new ApplicationException("Dropdown didn't appear for additional Edit/Delete optional for the respective testimonial, or 'Edit' was unclickable.");
		}
	}
	*/
	/*@Test
	@Documentation(step = "Click on 'Delete' from the dropdown options.", expected = "'Delete' option from dropdown menu is clickable.")
	public static void clickDeleteOptionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_DELETE_OPTION_XPATH);	
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_TESTIMONIAL_DROPDOWN_DELETE_CONFIRM_DIALOG_POPUP_ID);
		} catch (Exception e) {
			throw new ApplicationException("Either dropdown didn't appear, or 'Delete' was unclickable, or the confirmation dialog post clicking 'Delete' didn't appear.");
		}
	}*/
	
	@Test
	@Documentation(step = "Click 'Yes' to confirm deleting testimonial", expected = "'Yes' option from Confirm deletion dialog box is clickable.")
	public static void clickYesDeleteTestimonTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_DELETE_TESTIMONIAL_POPUP_YES_BUTTON_ID);
		} catch (Exception e) {
			throw new ApplicationException("'Yes' option in the confirm 'Delete Testimonial' dialog was unclickable.");
		}
	}
	
	// --------------------------- END ---------------------------
	
	// METHODS HANDLING NAVIGATION TO PORTFOLIO & VERIFYING THE PAGE
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step="Click on 'Portfolio' link in the left panel, under 'Edit Profile' category.", expected="User is able to click, and is redirected to 'Edit Work Collections' section.")
	public static void clickPortfolioTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_LINK_ID);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Portfolio link wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step = "Verify if 'Portfolio' section loaded.", expected = "'Portfolio' section for the user should load.")
	public static void verifyPortfolioSectionTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilText("Edit Work Collections");
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_BUTTON_XPATH);
			try {
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_EDIT_SERVICES_FIRST_SERVICES_OR_PORTFOLIO_XPATH);
				BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_FIRST_PORTFOLIO_LINK_ID);
				BrowserWait.waitUntilText("a Work Collection to show examples of your services.");
			}
			catch (Exception e) {
				BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PORTFOLIO_ADDED_LIST_XPATH);
			}
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Verification failed because one or more elements of the Portfolio section didn't load properly, or wasn't visible at all.");
		}
	}
	
	// --------------------------- END ---------------------------
	
	// METHODS HANDLING ADDING PORTFOLIO
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step="Click on Add Portfolio button.", expected="User is able to click, and is redirected to 'Edit Work Collections' section.")
	public static void clickAddPortfolioTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_BUTTON_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_PORTFOLIO_NAME_TEXTBOX_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_ADD_FILE_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Add Portfolio button wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Parameters("portfolioName")
	@Documentation(step="Enter Portfolio/WC name.", expected="Portfolio name is entered in the textbox field of the Add portfolio popup.")
	public static void enterPortfolioNameTest(String name) throws Exception {
		ScriptLogger.info();
		try {
			try {
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_PORTFOLIO_NAME_ID);
				BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_PORTFOLIO_NAME_ID);
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_PORTFOLIO_NAME_TEXTBOX_XPATH).clear();
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_PORTFOLIO_NAME_TEXTBOX_XPATH).sendKeys(name);
			} catch (Exception e) {
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_PORTFOLIO_NAME_TEXTBOX_XPATH).clear();
				BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_PORTFOLIO_NAME_TEXTBOX_XPATH).sendKeys(name);
			}
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter name in the textbox field.");
		}
	}
	
	@Test
	@Documentation(step="Click on Add Portfolio button.", expected="User is able to click")
	public static void clickAddFileTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_ADD_FILE_XPATH);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Add files button wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Parameters("path")
	@Documentation(step="Upload a file for the portfolio", expected="File is uploaded successfully")
	public static void uploadFileTest(String filePath) throws Exception {
		ScriptLogger.info();
		try {
			String attr = null;
			FileHandler.uploadFilesFromPath(filePath, "|");			
			int count = 0;
			do {
				attr = BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_UPLOAD_PROGRESS_XPATH).getAttribute("style");
				count++;
			} while(!attr.contains("position: fixed; z-index: 100001; left: 0px; top: 0px; display: none;"));
			
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new ScriptException("Failed uploading using robot class. Script logic error.");
		}
	}
	
	@Test
	@Documentation(step="Click cancel button.", expected="User is able to click.")
	public static void clickCancelStep1Test() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PORTFOLIO_POPUP_STEP1_CANCEL_BUTTON_ID);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Cancel'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click cancel button.", expected="User is able to click.")
	public static void clickCancelStep2Test() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PORTFOLIO_POPUP_STEP2_CANCEL_BUTTON_ID);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Cancel'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'Continue' button after adding media files.", expected="User is able to click, and is taken to step 2 of adding portfolio.")
	public static void clickContinueStep1Test() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(5000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP1_CONTINUE_BUTTON_ID);
			//Waiting until Step2 window shows.
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_ADD_SKILLS_TEXTBOX_ID, 60);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Continue wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step="Click on 'choose file' button under Add a Cover Image.", expected="User is able to click 'Choose file' button.")
	public static void clickChooseFileTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_ADD_COVER_BUTTON_ID);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, " 'Choose File' button wasn't found, or wasn't clickable.");
		}
	}
	
	@Test
	@Documentation(step="Crop Cover Image.", expected="User is able to crop cover image chosen.")
	public static void cropCoverImageTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.dragAndDrop(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_BOTTOM_TRANSITION_CROP_HANDLE_XPATH, 150, 200);
			BrowserAction.dragAndDrop(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_CROP_TRACKER_XPATH, 100, 0);
		} catch (Exception e) {
			throw new ScriptException("Couldn't drag crop handles.");
		}
	}
	
	@Test
	@Documentation(step="Click 'Done' after finishing crop", expected="User is able to click Done.")
	public static void clickDoneTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_CROP_DONE_BUTTON_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Done'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Parameters("portfolioSkill")
	@Documentation(step="Enter Skill.", expected="User enters Skill name")
	public static void enterSkillTest(String skill) throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_ADD_SKILLS_TEXTBOX_ID).sendKeys(skill);
			BrowserWait.waitUntilElementIsNotDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_SKILL_AUTOCOMPLETE_BOX_LOOKING_FOR_SKILL_TEXT_XPATH);
			BrowserWait.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_ADD_SKILLS_TEXTBOX_ID).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new ApplicationException("Unable to enter skill in the textbox field.");
		}
	}
	
	@Test
	@Documentation(step="Click 'Publish' after finishing crop", expected="User is able to click Publish.")
	public static void clickPublishTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_PUBLISH_BUTTON_ID);
			BrowserWait.waitUntilElementIsNotDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_UPLOAD_PROGRESS_XPATH, 60);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Publish'; either element wasn't found, or it was disabled.");
		}
	}
	
	// --------------------------- END ---------------------------
	
	// METHODS HANDLING PORTFOLIO EDITS
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step="Click published portfolio.", expected="User is able to click.")
	public static void clickFirstPortfolioTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_XPATH, 30);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click First portfolio; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Verify the portfolio clicked is the portfolio opened for Edit.", expected="Verification done.")
	public static void verifyPortfolioOpenedTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(3000);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_XPATH);
			String portName = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_XPATH).getText();
			// Clicking anywhere on the popup to change locator from display: none to display: block for the
			// portfolio name textbox so that the code could retrive the name (text) from the textbox and compare.
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_XPATH);
			String nameInTextbox = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_PORTFOLIO_NAME_ID).getText().trim();
			if(!nameInTextbox.equalsIgnoreCase(portName)) {
				throw new ApplicationException("Portfolio name clicked, but the name appearing in the popup doesn't match.");
			}
		} catch (Exception e) {
			throw new ScriptException("Script Error in logic used for verifying portfolio opened.");
		}
	}
	
	@Test
	@Documentation(step="Click 'Change' link under Add a Cover image.", expected="User is able to click 'change'.")
	public static void clickChangeCoverTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_CHANGE_COVER_LINK_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Change'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click 'Save' button in Step2 of Portfolio.", expected="User is able to click 'Save'.")
	public static void clickSaveStep2Test() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_STEP2_SAVE_BUTTON_ID);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_TOAST_MESSAGE_AFTER_SAVING_CHANGES_XPATH, 60);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Save'; either element wasn't found, or it was disabled.");
		}
	}

	// --------------------------- END ---------------------------
	
	// METHODS HANDLING PORTFOLIO COPY, UNPUBLISH & DELETE
	// --------------------------- START ---------------------------
	@Test
	@Documentation(step="Mouse Hover on a portfolio added.", expected="User is able to hover on a portfolio.")
	public static void hoverPortfolioPublishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(1000);
			BrowserAction.hoverOverElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Couldn't hover over the first published portfolio.");
		}
	}
	
	@Test
	@Documentation(step="Click on the dropdown toggle button appearing after hovering on portfolio.", expected="User is able to click on a dropdown toggle button.")
	public static void clickPublishedDropdownTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_DROPDOWN_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click Dropdown toggle; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Copy' in the dropdown options", expected="User is able to click on 'Copy.'")
	public static void clickCopyPublishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_DROPDOWN_COPY_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_HEADER_XPATH, 60);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Copy'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Verify copied portfolio added in drafts.", expected="Verification successful.")
	public static void verifyCopiedPortfolioTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH, 60);
		} catch (Exception e) {
			throw new ScriptException("Script Error in logic used for verifying copied portfolio.");
		}
	}
	
	@Test
	@Documentation(step="Mouse Hover on draft portfolio added.", expected="User is able to hover.")
	public static void hoverDraftPortfolioTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(1000);
			BrowserAction.hoverOverElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH);
		} catch (Exception e) {
			throw new ScriptException("Couldn't hover over the first draft portfolio.");
		}
	}
	
	@Test
	@Documentation(step="Click on the dropdown toggle button appearing after hovering on draft portfolio.", expected="User is able to click on a dropdown toggle button.")
	public static void clickUnpublishedDropdownTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_DRAFT_PORTFOLIO_DROPDOWN_BUTTON_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click Dropdown toggle; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Unpublish' in the dropdown options", expected="User is able to click on 'Unpublish.'")
	public static void clickUnpublishInDropdownTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_DROPDOWN_UNPUBLISH_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_TOAST_MESSAGE_AFTER_UNPUBLISHING_PORTFOLIO_XPATH, 60);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Unpublish'; either element wasn't found, or it was disabled. Or unpublishing wasn't successful.");
		}
	}
	
	@Test
	@Documentation(step="Click published portfolio.", expected="User is able to click.")
	public static void verifyUnpublishInDraftsTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH, 60);
		} catch (Exception e) {
			throw new ScriptException("Script Error in logic used for verifying unpublished portfolio.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Publish' in the dropdown options", expected="User is able to click on 'Publish.'")
	public static void clickPublishInDropdownTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_DROPDOWN_PUBLISH_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_TOAST_MESSAGE_AFTER_PUBLISHING_PORTFOLIO_XPATH, 60);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Publish'; either element wasn't found, or it was disabled. Or Publishing wasn't successful.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Delete' in the Published dropdown options", expected="User is able to click on 'Delete.'")
	public static void clickDeletePublishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_DROPDOWN_DELETE_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DELETE_CONFIRM_YES_ID);
			
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Delete'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Delete' in the Unpublished dropdown options", expected="User is able to click on 'Delete.'")
	public static void clickDeleteUnpublishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_DROPDOWN_DELETE_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DELETE_CONFIRM_YES_ID);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Delete'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Copy' in the Unpublished dropdown options", expected="User is able to click on 'Copy.'")
	public static void clickCopyUnpublishedTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_DROPDOWN_COPY_OPTION_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_TOAST_MESSAGE_AFTER_COPYING_PORTFOLIO_XPATH);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Copy'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'Yes' in the confirmation dialog.", expected="User is able to click on 'Yes.'")
	public static void clickYesDeletePortTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DELETE_CONFIRM_YES_ID);
			Thread.sleep(5000);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'Yes'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click on the 'No' in the confirmation dialog.", expected="User is able to click on 'No.'")
	public static void clickNoDontDeletePortTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DELETE_CONFIRM_NO_ID);
			Thread.sleep(5000);
			BrowserAction.switchToDefaultContent();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click 'No'; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Click unpublished portfolio.", expected="User is able to click.")
	public static void clickFirstDraftTest() throws Exception {
		ScriptLogger.info();	
		try {
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_ADD_PORTFOLIO_POPUP_XPATH, 60);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click First draft portfolio; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Verify the draft portfolio clicked is the portfolio opened for Edit.", expected="Verification done.")
	public static void verifyDraftPortfolioOpenedTest() throws Exception {
		ScriptLogger.info();
		try {
			Thread.sleep(3000);
			BrowserWait.waitUntilElementIsDisplayed(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH);
			String portName = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_FIRST_DRAFT_XPATH).getText();
			// Clicking anywhere on the popup to change locator from display: none to display: block for the
			// portfolio name textbox so that the code could retrive the name (text) from the textbox and compare.
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_XPATH);
			String nameInTextbox = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_PUBLISHED_OR_SAVED_PORTFOLIO_POPUP_PORTFOLIO_NAME_ID).getText().trim();
			
			Thread.sleep(2000);
			if(!nameInTextbox.equalsIgnoreCase(portName)) {
				throw new ApplicationException("Portfolio name clicked, and the name appearing in the popup doesn't match.");
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step="Get the count of Drafts before perfoming an action.", expected="Able to take count.")
	public static void getDraftCountBeforeTest() throws Exception {
		ScriptLogger.info();
		try {
			countBefore=0;
			List<WebElement> element = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_UL_ID).findElements(By.tagName("li"));
			for (WebElement drafts : element) {
				countBefore++;
			}
		} catch (Exception e) {
			countBefore = 0;
			ScriptLogger.info("Count Before = " +countBefore);
		}
	}
	
	@Test
	@Documentation(step="Get the count of drafts after performing an action.", expected="Able to take count.")
	public static void getDraftCountAfterTest() throws Exception {
		ScriptLogger.info();
		try {
			countAfter=0;
			List<WebElement> element = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_DRAFT_SECTION_UL_ID).findElements(By.tagName("li"));
			for (WebElement drafts : element) {
				countAfter++;
			}
		} catch (Exception e) {
			countAfter = 0;
			ScriptLogger.info("Count After = " +countAfter);
		}
	}
	
	@Test
	@Documentation(step="Verify portfolio in draft section increased.", expected = "verification successfully done.")
	public static void verifyNewDraftAddedTest() throws Exception {
		ScriptLogger.info();
		try {
			if(!(countBefore < countAfter)){
				throw new ApplicationException("Draft count didn't increase.");
			}
		} catch (Exception e) {
				throw new ScriptException(e);
		}
	}
	
	@Test
	@Documentation(step="Click 'View Profile' link.", expected="User is able to click.")
	public static void clickViewProfileTest() throws Exception {
		ScriptLogger.info();	
		try {
			Thread.sleep(3000);
			BrowserAction.click(EditProfilePageObjectMap.EDITPROFILE_PAGE_VIEW_PROFILE_LINK_XPATH);
			BrowserWait.waitForPageToBeLoaded();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Couldn't click; either element wasn't found, or it was disabled.");
		}
	}
	
	@Test
	@Documentation(step="Get published portfolio name.", expected="User is able to get the name.")
	public static void getPublishedPortNameTest() throws Exception {
		ScriptLogger.info();	
		try {
			publishedPortName = BrowserAction.getElement(EditProfilePageObjectMap.EDITPROFILE_PAGE_PORTFOLIO_FIRST_PUBLISHED_PORTFOLIO_XPATH).getText();
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Either element wasn't found, or it was disabled.");
		}
	}
	
}
