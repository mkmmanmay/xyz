package com.guru.framework.testing.testng.run;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

public interface Configuration extends Serializable {
	
	public String get(final String key);
	
	public Iterator<String> getKeys();
	
	public void merge(final Configuration other);
	
	public Map<String, String> toMap();

}
