package com.retailShop.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.retailShop.utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClaseBase {
	
	public static	WebDriver driver;
	public static	Properties pro ;

	public ClaseBase(){
//
		try {
			pro = new Properties();
			File src = new File("./src/main/java/com/retailShop/config/config.propiedades");
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		}catch (FileNotFoundException ex){
			ex.printStackTrace();

		}catch (IOException e){
			e.printStackTrace();
		}
	}


		public static void iniciar() {
			String browser = pro.getProperty("browser");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", pro.getProperty("chromepath"));
				driver = new ChromeDriver();
			}

			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(pro.getProperty("baseURL"));
		}
		


}
