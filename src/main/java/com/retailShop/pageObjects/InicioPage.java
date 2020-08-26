package com.retailShop.pageObjects;

import com.retailShop.base.ClaseBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InicioPage extends ClaseBase {

	
	public InicioPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class=\"login\"]")
	@CacheLookup
	WebElement signIn;
	
	
	public String validaTituloInicioPage(){
		String titulo = driver.getTitle();
		return titulo;
	}

	public AuthenticationPage clickSigIn(){
		signIn.click();

		return new AuthenticationPage();
	}



}
