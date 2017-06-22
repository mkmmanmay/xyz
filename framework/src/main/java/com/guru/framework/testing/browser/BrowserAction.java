package com.guru.framework.testing.browser;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.selenium.WebDriverAction;

public class BrowserAction extends BrowserAccess{
	/**
	 * Click this element. If this causes a new page to load, this method will
	 * attempt to block until the page has loaded.
	 * 
	 * @param locator Enum objectMap locator of rainbow defined type
	 * @param style
	 * 
	 * @throws Exception
	 */
	public static void click(final Object locator, final String... style) throws Exception {
		WebDriverAction.click(getLocator(locator), style);
		
	}

	/**
	 * Double Click this element. If this causes a new page to load, this method
	 * will attempt to block until the page has loaded.
	 * 
	 * @param locator Enum objectMap locator of rainbow defined type
	 * 
	 * @throws Exception
	 */
	public static void doubleClick(final Object locator, final String... style) throws Exception {
		WebDriverAction.doubleClick(getLocator(locator));
		
	}

	/**
	 * Right Click this element. If this causes a new page to load, this method
	 * will attempt to block until the page has loaded.
	 * 
	 * @param locator Enum objectMap locator of rainbow defined type
	 * 
	 * @throws Exception
	 */
	public static void rightClick(final Object locator, final String... style) throws Exception {
		WebDriverAction.rightClick(getLocator(locator));
		
	}

	/**
	 * If this element is a text entry element, this will clear the value.
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param style
	 * 
	 * @throws Exception
	 */
	public static void clear(final Object locator, final String... style) throws Exception {
		WebDriverAction.clear(getLocator(locator), style);
		
	}

	/**
	 * Drags the element from its current position (or 0,0) by the given offset.
	 * If the coordinates provided are outside the viewport (the mouse will end
	 * up outside the browser window) then the viewport is scrolled to match.
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param xOffset
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param yOffset
	 *            vertical offset. A negative value means moving the mouse up.
	 * @throws Exception
	 */
	public static void drag(final Object locator, final int xOffset, final int yOffset) throws Exception {
		WebDriverAction.drag(getLocator(locator), xOffset, yOffset);
		
	}

	/**
	 * This performs click-and-hold at the location of the source element, moves
	 * to the location of the target element, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * 
	 * @throws Exception
	 */
	public static void dragAndDrop(final Object source, final String target) throws Exception {
		WebDriverAction.dragAndDrop(getElement(source), BrowserAccess.getElement(target));
	}

	/**
	 * This performs click-and-hold at the location of the source element, by
	 * given offset, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * @param xOffset
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param yOffset
	 *            vertical offset. A negative value means moving the mouse up.
	 * 
	 * @throws Exception
	 */
	public static void dragAndDrop(final Object source, final int xOffset, final int yOffset)
			throws Exception {
		WebDriverAction.dragAndDrop(getElement(source), xOffset, yOffset);
	}

	/**
	 * Use this method to simulate typing into an element.
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param value
	 *            Value to be set on the editable field
	 * @param styles
	 * 
	 * @throws Exception
	 */
	public static void enterFieldValue(final Object locator, final String value, final String... styles)
			throws Exception {
		WebDriverAction.enterFieldValue(getLocator(locator), value, styles);
		
	}

	/**
	 * Clicks on an element and clears the value if the element is editable
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param styles
	 * 
	 * @throws Exception
	 */
	public static void clickAndClear(final Object locator, final String... styles) throws Exception {
		WebDriverAction.clickAndClear(getLocator(locator), styles);
		
	}

	/**
	 * Select all options that have a value matching the argument. That is, when
	 * given "foo" this would select an option like:
	 * <option value="foo">Bar</option>
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param value
	 *            The value to match against
	 * 
	 * @throws Exception
	 */
	public static void selectDropdownOptionByValue(final Object locator, final String value) throws Exception {
		
		WebDriverAction.selectDropDownOptionByValue(getLocator(locator), value);
	}

	/**
	 * Select all options that display text matching the argument. That is, when
	 * given "Bar" this would select an option like:
	 * <option value="foo">Bar</option>
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param text
	 *            The visible text to match against
	 * 
	 * @throws Exception
	 */
	public static void selectDropdownOptionByText(final Object locator, final String text) throws Exception {		
		WebDriverAction.selectDropDownOptionByText(getLocator(locator), text);
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view.
	 * 
	 * @param locator Enum objectMap locator of rainbow defined type
	 * @param styles
	 * 
	 * @throws Exception
	 */
	public static void hoverOverElement(final Object locator, final String... styles) throws Exception {
		
		WebDriverAction.hoverOverElement(getLocator(locator));
	}

	/**
	 * Switches the future commands to a different frame by selecting a frame by
	 * its name or ID. Frames located by matching name attributes are always
	 * given precedence over those matched by ID.
	 * 
	 * @param frameName
	 *            nameOrId the name of the frame window, the id of the frame or
	 *            iframe element
	 * 
	 * @throws Exception
	 */
	public static void switchToFrame(final String frameName) throws Exception {
		
		WebDriverAction.switchToFrame(frameName);
	}

	/**
	 * Switches the future commands to a different frame by selecting a frame by
	 * its zero-based frame index
	 * 
	 * @param frameNumber
	 *            zero-based frame index
	 * 
	 * @throws Exception
	 */
	public static void switchToFrame(final int frameNumber) throws Exception {
		
		WebDriverAction.switchToFrame(frameNumber);
	}

	/**
	 * Selects either the first frame on the page, or the main document when a
	 * page contains iframes.
	 * 
	 * @throws Exception
	 */
	public static void switchToDefaultContent() throws Exception {
		
		WebDriverAction.switchToDefaultContent();
	}

	/**
	 * Load a new web page in the current browser window. The method will block
	 * until the load is complete.
	 * 
	 * @param appUrl
	 *            The URL to load.
	 * @throws Exception
	 */
	public static void openBrowser(final String appUrl) throws Exception {
		
		WebDriverAction.openBrowser(appUrl);
	}
	
	public static String getCurrentUrl() throws Exception {
		return WebDriverAction.getCurrentUrl();
	}
	
	public static void closeBrowser() throws Exception {
		WebDriverAction.closeBrowser();
	}

	/**
	 * Maximizes the current window if it is not already maximized
	 * 
	 * @throws Exception
	 */
	public static void maximizeCurrentWindow() throws Exception {

		WebDriverAction.maximizeCurrentWindow();
	}

	/**
	 * Refresh the current page
	 * 
	 * @throws Exception
	 */
	public static void refresh() throws Exception {
		
		WebDriverAction.refresh();
	}

	/**
	 * Close the current window, quitting the browser if it's the last window
	 * currently open. This Method uses Javascript to close the window or Tab
	 * because Chrome has changed the way tabs and windows are managed. This
	 * should work for all browsers
	 * 
	 * @throws Exception
	 */
	public static void closeActiveWindow(Boolean useJS) throws Exception {
		if (useJS) {
			
			int startWindowCount = WebDriverAction.getDriver().getWindowHandles().size();
			ScriptLogger.debug("Window Count before close:" + startWindowCount);
			JavascriptExecutor js = (JavascriptExecutor) WebDriverAction.getDriver();
			String script = "window.onbeforeunload = null;" + "window.close();";
			js.executeScript(script);
			int maxCloseAttempts = 10;
			while (WebDriverAction.getDriver().getWindowHandles().size() == startWindowCount && maxCloseAttempts > 0) {
				ScriptLogger.debug("Window Count before close:" + startWindowCount
						+ " Is the same after close attempt, trying again...");
				ScriptLogger.debug("Sleeping 10 ms...");
				Thread.sleep(10);
				ScriptLogger.debug("...Attempt: " + maxCloseAttempts);
				js.executeScript(script);
				maxCloseAttempts -= 1;
			}
			if (maxCloseAttempts < 0) {
				ScriptLogger.debug("Failed to close window after 10 attempts");
			}
		} else {
			closeActiveWindow();
		}
	}

	public static void closeActiveWindow() throws Exception {
		WebDriverAction.closeActiveWindow();
	}

	/**
	 * Switch the focus of future commands for this driver to the window with
	 * the given name/handle.
	 * 
	 * @param handle
	 *            The name of the window or the handle as returned by
	 *            WebDriver.getWindowHandle()
	 * @throws Exception
	 */
	public static void switchTo(final String handle) throws Exception {
		WebDriverAction.switchTo(handle);
	}

	/**
	 * Switch the focus of future commands for this driver to the window with
	 * the given Page title.
	 * 
	 * @param title
	 *            The html title of the window
	 * @throws Exception
	 */
	public static void switchToPageByTitle(final String title) throws Exception {
		Thread.sleep(3000);
		Set<String> handles = WebDriverAction.getWindowHandles();
		String currentPageTitle;
		ScriptLogger.debug("Switching to window with title : '" + title + "'.");
		for (String handle : handles) {
			WebDriverAction.switchTo(handle);
			currentPageTitle = WebDriverAction.getPageTitle();
			if (currentPageTitle.contains(title)) {
				ScriptLogger.debug("Switched to window with title : '" + title + "'.");
				return;
			} else {
				ScriptLogger.debug(currentPageTitle + " does not match : '" + title + "'.");
			}

		}
		throw new Exception(title + " Not found in current windows");
	}

	/**
	 * Delete all the cookies for the current domain.
	 * 
	 * @throws Exception
	 */
	public static void deleteAllCookies() throws Exception {
		WebDriverAction.deleteAllCookies();
	}

	/**
	 * Tries to switch the focus of future commands for this driver to the
	 * window until a specified time
	 * 
	 * @param handles
	 *            The name of the window or the handle as returned by
	 *            WebDriver.getWindowHandle()
	 * @param time
	 *            The maximum wait time
	 * 
	 * @throws Exception
	 */
	public static void switchToNewWindow(final Set<String> handles, int time) throws Exception {
		WebDriverAction.switchToNewWindow(handles, time);
	}
	
	public static void switchToNewTab() throws Exception {
		WebDriverAction.switchToNewTabTest();
	}

	/**
	 * Scroll the page to specified offset
	 * 
	 * @param x
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param y
	 *            vertical offset. A negative value means moving the mouse up.
	 * @throws Exception
	 */
	public static void scrollWindow(final int x, final int y) throws Exception {
		ScriptLogger.debug("Scrolling the window to horizontal offset (X-axis) by " + x
				+ " co-ordinates and vertical offset (Y-axis) by " + y + " co-ordinates.");
		WebDriverAction.scrollWindow(x, y);
	}

	/**
	 * Select Multiple items in a multi control
	 * 
	 * @param locator
	 *            Enum objectMap locator of rainbow defined type
	 * @param items
	 *            List of items in the list to select
	 * 
	 * @throws Exception
	 */
	public static void selectMultiple(final Object locator, String... items) throws Exception {
		WebDriverAction.multiSelect(getLocator(locator), items);
	}	

	public static Alert switchToAlertBox() throws Exception {
		return WebDriverAction.switchToAlertBox();
	}

	public static void scrollElementUp(String locator) throws Exception {
		WebDriverAction.scrollElementUp(BrowserAccess.getElement(locator));
	}

	public static void scrollElementDown(String locator) throws Exception {
		WebDriverAction.scrollElementDown(BrowserAccess.getElement(locator));
	}

	

}
