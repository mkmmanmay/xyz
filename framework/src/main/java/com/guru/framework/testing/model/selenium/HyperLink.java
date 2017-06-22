package com.guru.framework.testing.model.selenium;

import org.openqa.selenium.WebElement;

public class HyperLink {

	private WebElement element;
	private String text;
	//Constructor OverLoading
	
	public HyperLink(){
		
	}
	public HyperLink(WebElement element,String text){
		this.element=element;
		this.text=text;
	}

	
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
