package com.guru.framework.testing.model.selenium;

import org.openqa.selenium.WebElement;

public class Radio {
	
	private WebElement element;
	private boolean isChecked;
	
	public Radio(){}

	public Radio(WebElement element, boolean isChecked) {
		this.element = element;
		this.isChecked = isChecked;
	}	
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	public boolean  getChecked() {
		return isChecked;
	}
	public void setChecked(boolean  isChecked) {
		this.isChecked = isChecked;
	}
	

	
}
