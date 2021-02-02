package testSuite;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static driver.DriverContext.setUp;

public class ejercicioTestNG {

    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();


    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suite");
        setUp("emulatar-5554","Android","C:\\Users\\cifue\\Downloads\\RecursosCursoAppium\\registroDeUsuarios.apk","emulator-5554", true);
    }

    @BeforeMethod
    public void metodo2(){
        System.out.println("Inicio de Test");
    }

    @Test(priority = 1)
    public void metodo3(){
  //    Assert.assertEquals("hola", "hola mundo", "ambos hola no son iguales");
        softAssert.assertEquals("hola mundo", "hola mundo", "ambos hola no son iguales");
        System.out.println("Test 1");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void metodo4(){
        System.out.println("Test 2");
    }

    @AfterMethod
    public void metodo5(){
        System.out.println("Termino de Test");
    }
}
