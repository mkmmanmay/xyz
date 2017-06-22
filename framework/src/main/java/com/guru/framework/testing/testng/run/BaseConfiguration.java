package com.guru.framework.testing.testng.run;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseConfiguration implements Configuration {


	private static final long serialVersionUID = -6208913892438558983L;
	protected Map<String, String> data = new java.util.HashMap<String, String>();

	public BaseConfiguration() {
		
	}
	
	public BaseConfiguration(final Map<String, String> map) {
		for(String key : map.keySet())
			{data.put(key, map.get(key));}
	}
	
	public BaseConfiguration(final Configuration other) {
		final Iterator<String> it = other.getKeys();
		while(it.hasNext()) {
			final String key = it.next();
			data.put(key, other.get(key));
		}
	}
	 

	public Map<String, String> toMap() {
		return this.data;
	}
	
	public void add(final String key, final String value) {
		data.put(key, value);
	}
	
	public String get(final String key) {		
		return data.get(key);
	}

	public Iterator<String> getKeys() {
		return data.keySet().iterator();
	}

	public void merge(final Configuration other) {
		if(null == other){ return;}
		final Iterator<String> it = other.getKeys();
		while(it.hasNext()) {
			final String key = it.next();
			data.put(key, other.get(key));
		}
	}

	
	public List<String> toList() {
		final List<String> result = new ArrayList<String>(data.size());
		for(String key : data.keySet())
			{result.add(key + "=" + data.get(key));}
		return result;	
	}
	
	@Override
	public String toString() {
		return toList().toString();
	}
	
}
