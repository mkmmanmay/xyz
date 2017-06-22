package com.guru.framework.testing.helpers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.guru.framework.testing.browser.BrowserWait;
import com.guru.framework.testing.logger.ScriptLogger;
import com.guru.framework.testing.objects.exceptions.ScriptException;
import com.guru.framework.testing.selenium.WebDriverAction;

public class WindowHandler {

	private static Map<String,String> windowHandles=new ConcurrentHashMap<String,String>();
    
	public static List<String> getAllWindowHandles() throws Exception{
		
		List<String> windowHandles=new ArrayList<String>();
		for (String string : WindowHandler.windowHandles.values()) {
			windowHandles.add(string);
		}
		return windowHandles;
	}
	
	public static String getWindowHandle(String pageid) throws Exception{
		String windowHandle=null;
		ScriptLogger.debug();
		if(windowHandles.containsKey(pageid)){
			windowHandle=windowHandles.get(pageid);
			ScriptLogger.debug("Window Handle for "+pageid+":"+windowHandle);
			return windowHandle;
		}	
		else{
			windowHandle=getNewWindowHandle();
		    windowHandles.put(pageid, windowHandle);
		    ScriptLogger.debug("Window Handle for "+pageid+":"+windowHandle);
		    return windowHandle;
		}
	}
	
	public static String getNewWindowHandle() throws Exception{
		
		String newWindowHandle=null;
		waitForNewWindowToBeLoaded();
		Set<String> currentWindowHandles=WebDriverAction.getDriver().getWindowHandles();
		currentWindowHandles.removeAll(getAllWindowHandles());
		Iterator<String> iterator=currentWindowHandles.iterator();
		if(iterator.hasNext()){
			newWindowHandle=iterator.next();
		}
		return newWindowHandle;
	}
	
	public static void waitForNewWindowToBeLoaded() throws Exception{
		BrowserWait.waitUntilNewWindowIsLoaded(getAllWindowHandles());
	}
	
	public static void removeWindowHandle(String pageID){
		windowHandles.remove(pageID);
	}
	
	public static void closeAllWindowsExcept(String ... pageIDs) throws Exception{
		ScriptLogger.info(Arrays.asList(pageIDs).toString());
		ScriptLogger.debug();
		try{
			List<String> list=Arrays.asList(pageIDs);
			Set<String> keys=windowHandles.keySet();
			for (String key : keys) {
				if(!list.contains(key)){
					ScriptLogger.debug("Closing: "+key);
					Class<?> clazz=Class.forName(key);
					Method method=clazz.getMethod("closeThisWindow");
					method.invoke(null);
				}
			}
			
		}catch(Exception e){
			throw new ScriptException(e);
		}
	}
	
}
