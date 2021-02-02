package testSuite;

import io.qameta.allure.model.Status;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportAllure;

import static driver.DriverContext.setUp;

public class allure {
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suite");
        setUp("emulatar-5554","Android","C:\\Users\\cifue\\Downloads\\RecursosCursoAppium\\registroDeUsuarios.apk","emulator-5554", true);
        ReportAllure.addStep("Levantar Device",true, Status.PASSED, false);

    }
    @BeforeMethod
    public void metodo2(){
        System.out.println("Inicio de Test");
    }

    @Test(priority = 1)
    public void metodo3(){
        //      Assert.assertEquals("hola", "hola mundo", "ambos hola no son iguales");
        softAssert.assertEquals("hola mundo", "hola mundo", "ambos hola no son iguales");
        System.out.println("Test 1");
        softAssert.assertAll();
    }

}
