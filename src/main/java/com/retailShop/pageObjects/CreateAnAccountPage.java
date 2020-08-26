package com.retailShop.pageObjects;

import com.retailShop.base.ClaseBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends ClaseBase {
	

	public CreateAnAccountPage(){

		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "id_gender1")
	@CacheLookup
	WebElement txtMr;
	
	@FindBy(id = "id_gender2")
	@CacheLookup
	WebElement txtMrs;

	@FindBy(id="customer_firstname")
	WebElement txtFName;

	@FindBy(id="customer_lastname")
	WebElement txtLName;

	@FindBy(id="email")
	WebElement txtEmail;

	@FindBy(id="passwd")
	WebElement txtPass;
	
	@FindBy(id = "days")
	@CacheLookup
	WebElement txtDay;

	public String validaTitulo(){
		String tituoCreate = driver.getTitle();
		return tituoCreate;

	}
	
	public void selectTitle(String genero){
		
		if (genero.equalsIgnoreCase("Mr")){
			txtMr.click();
		}else{
			txtMrs.click();
		}
	}
	
	
	public void selectDay(String dia){
		Select day = new Select(txtDay);
		day.selectByValue(dia);
	}

	public void registro(String genero,String name, String apellido,  String pass){
		if (genero.equalsIgnoreCase("Mr")){
			txtMr.click();
		}else{
			txtMrs.click();
		}

		txtFName.sendKeys(name);
		txtLName.sendKeys(apellido);
		txtPass.sendKeys(pass);

	}
	
}
