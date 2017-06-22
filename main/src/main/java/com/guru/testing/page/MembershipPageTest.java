package com.guru.testing.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru.framework.testing.browser.BrowserAction;
import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.documentation.Documentation;
import com.guru.framework.testing.objects.exceptions.ApplicationException;
import com.guru.framework.testing.objects.exceptions.HTMLElementNotFoundException;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.testing.objectmap.MembershipPageObjectMap;

public class MembershipPageTest {

	@Test
	@Documentation(step = "Verify the Membership page", expected = "Membership page should be verified")
	public static void verifyMembershipPageTest() throws Exception {
		ScriptLogger.info();
		try {
			BrowserWait.waitUntilPageTitle("Membership - Build Profile - Freelancers - Guru");
			
			BrowserWait.waitUntilElementIsDisplayed(MembershipPageObjectMap.MEMBERSHIP_PAGE_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(MembershipPageObjectMap.MEMBERSHIP_PAGE_PURCHASE_DIV_ID);
			BrowserWait.waitUntilElementIsDisplayed(MembershipPageObjectMap.MEMBERSHIP_PAGE_SELECT_MEMBERSHIP_DIV_XPATH);
			BrowserWait.waitUntilText("Annual Plans","12 months for the price of 10, plus 600 bids at once!","Monthly Plans","More flexible, 50 bids per month");
		} catch (Exception e) {
			throw new HTMLElementNotFoundException(e, "Membership page elements are not loaded in time");
		}
	}	
	
	@Test
	@Parameters("currentMembership")
	@Documentation(step = "Verify current membership is selected on the Membership page", expected = "Current membership should be present on the page")
	public static void verifyCurrentMembershipTest(String mem) throws Exception {
		ScriptLogger.info();
		List<WebElement> elements=new ArrayList<>();
		try {
			elements=BrowserAction.getElements(MembershipPageObjectMap.MEMBERSHIP_PAGE_MEMBERSHIP_SELECTION_OPTIONS_XPATH);
			elements.remove(0);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
			switch (mem) {
			
			case "Basic":if(!"CURRENT".equals(elements.get(0).getText())){
							throw new ApplicationException("Basic Membership is not current membership. Expected:CURRENT Actual:"+elements.get(0).getText());
							}
						elements.remove(0);
						for (WebElement webElement : elements) {
							if(!"Select".equals(webElement.getText())){
								throw new ApplicationException("Expected:- Select Actual:- "+webElement.getText());
								}
						}
						
				break;
			case "Basic+":	
				if(!"Unable to downgrade".equals(elements.get(0).getText())){
					throw new ApplicationException("Basic Membership not disabled Expected:Unable to downgrade Actual:"+elements.get(0).getText());
				}
				if(!"CURRENT".equals(elements.get(1).getText())){
					throw new ApplicationException("Basic+ Membership is not current membership. Expected:CURRENT Actual:"+elements.get(1).getText());
				}
				elements.remove(0);
				elements.remove(0);
				for (WebElement webElement : elements) {
					if(!"Select".equals(webElement.getText())){
						throw new ApplicationException("Expected:- Select Actual:- "+webElement.getText());
					}
				}
				
				break;
			case "Professional":
				if(!"Unable to downgrade".equals(elements.get(0).getText())&&"Unable to downgrade".equals(elements.get(1).getText())){
					throw new ApplicationException("Memberships before Professional are not disabled Expected:Unable to downgrade Actual: "+elements.get(0).getText()+", "+elements.get(1).getText());
				}
				if(!"CURRENT".equals(elements.get(2).getText())){
					throw new ApplicationException("Professional Membership is not current membership. Expected:CURRENT Actual:"+elements.get(1).getText());
				}
				
				if(!"Select".equals(elements.get(3).getText())&&"Select".equals(elements.get(4).getText())){
					throw new ApplicationException("Expected:- Select Actual:- "+elements.get(3).getText()+" "+elements.get(4).getText());
				}
				
				
				
				break;
			case "Business":
				if(!"Unable to downgrade".equals(elements.get(0).getText())&&"Unable to downgrade".equals(elements.get(1).getText())&& "Unable to downgrade".equals(elements.get(2).getText())){
					throw new ApplicationException("Memberships before Business are not disabled Expected:Unable to downgrade Actual: "+elements.get(0).getText()+",  "+elements.get(1).getText()+", "+elements.get(2).getText());
				}
				if(!"CURRENT".equals(elements.get(3).getText())){
					throw new ApplicationException("Business Membership is not current membership. Expected:CURRENT Actual:"+elements.get(1).getText());
				}
				
				
				if(!"Select".equals(elements.get(4).getText())){
					throw new ApplicationException("Expected:- Select Actual:- "+elements.get(4).getText());
				}
				
				break;
			case "Executive":
				if(!"CURRENT".equals(elements.get(4).getText())){
					throw new ApplicationException("Executive Membership is not current membership. Expected:CURRENT Actual:"+elements.get(4).getText());
				}
				elements.remove(4);
				for (WebElement webElement : elements) {
					if(!"Unable to downgrade".equals(webElement.getText())){
						throw new ApplicationException("Memberships before Business are not disabled Expected:Unable to downgrade Actual: "+webElement.getText());
					}
				}				
				break;

			default:
				break;
			}
			
	}
	
	@Test
	@Parameters("selectMembership")
	@Documentation(step = "Select membership by name", expected = "Membership provided should be selected")
	public static void selectMembershipByNameTest(String mem) throws Exception {
		ScriptLogger.info();
		List<WebElement> elements=new ArrayList<>();
		String css=null;
		try {
			elements=BrowserAction.getElements(MembershipPageObjectMap.MEMBERSHIP_PAGE_MEMBERSHIP_SELECTION_OPTIONS_XPATH);
			elements.remove(0);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
			switch (mem) {
			case "Basic+":
					css="a[class='btnGreenFlat'][onclick*='Basic+']";
		
					verifyCurrentMembershipTest("Basic");
					if(elements.get(1).findElement(By.cssSelector(css))==null){
						throw new ApplicationException("Basic+ is not having Select Option");
					}
					else{
						elements.get(1).findElement(By.cssSelector(css)).click();
					}					
				
				
				
				break;
			case "Professional":
					css="a[class='btnGreenFlat'][onclick*='Professional']";
			
					if(elements.get(2).findElement(By.cssSelector(css))==null){
						throw new ApplicationException("Professional is not having Select Option");
					}
					else{
						elements.get(2).findElement(By.cssSelector(css)).click();
					}
					
					
				
				
				break;
			case "Business":
					css="a[class='btnGreenFlat'][onclick*='Business']";
				
					if(elements.get(3).findElement(By.cssSelector(css))==null){
						throw new ApplicationException("Business is not having Select Option");
					}
					else{
						elements.get(3).findElement(By.cssSelector(css)).click();
					}
				
				
				
				break;
			case "Executive":
					css="a[class='btnGreenFlat'][onclick*='Executive']";					
					if(elements.get(4).findElement(By.cssSelector(css))==null){		
										
					
						throw new ApplicationException("Executive is not having Select Option");
					}
					else{
						elements.get(4).findElement(By.cssSelector(css)).click();
						
					}		
				 
				break;

			default:
				break;
			}
		}	

}
