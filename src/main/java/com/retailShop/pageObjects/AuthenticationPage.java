package com.retailShop.pageObjects;

import com.retailShop.base.ClaseBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends ClaseBase {
	

	
	public AuthenticationPage(){

		PageFactory.initElements(driver, this);
		
	}	
	
	
	@FindBy(id ="email_create")
	@CacheLookup
	WebElement txtCorreo;
	
	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement btnSubmit;



	public String validaTitulo(){
		String titulo = driver.getTitle();
		return titulo;
	}

	public void ingresaCorreo(String correo){

	    txtCorreo.sendKeys(correo);
	}
	
	public CreateAnAccountPage clickBtnSubmit(){
		btnSubmit.click();

		return new CreateAnAccountPage();
	}

}
