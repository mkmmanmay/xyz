package com.guru.framework.testing.model.selenium;

import org.openqa.selenium.WebElement;

public class TextBox {
	private WebElement element;
	private String value;
	
	public TextBox(){}
	
	public TextBox(WebElement element,String value){
		this.element=element;
		this.value=value;
	}

	
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String text) {
		this.value = text;
	}
}
