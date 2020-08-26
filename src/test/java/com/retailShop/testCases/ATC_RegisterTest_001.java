package com.retailShop.testCases;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.retailShop.base.ClaseBase;
import com.retailShop.pageObjects.AuthenticationPage;
import com.retailShop.pageObjects.CreateAnAccountPage;
import com.retailShop.pageObjects.InicioPage;
import com.retailShop.utilities.XlsUtils;

public class ATC_RegisterTest_001 extends ClaseBase{

    InicioPage paginaInicio;
    AuthenticationPage paginaAuthentication;
    CreateAnAccountPage paginaCreate;

    public ATC_RegisterTest_001(){

        super();
    }

   @BeforeClass
    public void setUp(){
       iniciar();
       paginaInicio = new InicioPage();
       paginaAuthentication = new AuthenticationPage();
       paginaCreate = new CreateAnAccountPage();
   }


    @Test(dataProvider="LoginData")
   public void validaRegistro( String correo, String genero, String name, String apellido, String pass) throws InterruptedException {
        paginaInicio.clickSigIn();
        paginaAuthentication.ingresaCorreo(correo);
        paginaAuthentication.clickBtnSubmit();
        Thread.sleep(5000);
        paginaCreate.registro(genero, name, apellido, pass);
        Thread.sleep(5000);


   }



   @AfterClass
    public void tearDown(){
        driver.quit();
   }


   @DataProvider(name="LoginData")
    Object [][] getData() throws IOException{

        String path = System.getProperty("user.dir")+ "/src/main/java/com/retailShop/testData/registerData.xlsx";
        int rownum = XlsUtils.getRowCount(path, "Sheet1");
        int colcount = XlsUtils.getCellCount(path, "Sheet1", 1);

        String logindata[][] =new String[rownum][colcount];


        for(int i=1;i<=rownum;i++){
            for(int j=0;j<colcount;j++){

                logindata[i-1][j]= XlsUtils.getCellData(path, "Sheet1", i, j);
            }
        }

        return logindata;

    }
}
