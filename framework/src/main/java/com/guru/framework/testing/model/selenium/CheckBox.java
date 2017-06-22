package com.guru.framework.testing.model.selenium;

import org.openqa.selenium.WebElement;

public class CheckBox {
	private WebElement element;
	private boolean isChecked;
	
	public CheckBox(){}
	public CheckBox(WebElement element) {
		this.element = element;
		
	}

	public CheckBox(WebElement element, boolean isChecked) {
		this.element = element;
		this.isChecked = isChecked;
	}	
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	public void setChecked(boolean  isChecked) {
		this.isChecked = isChecked;
	}
	
	public boolean isChecked(WebElement element) {
		if(element.isSelected()){
			return isChecked;
		}
		else{
			return false;
		}
		
	}

	
}
