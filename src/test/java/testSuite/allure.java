package testSuite;

import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportAllure;
import testsCases.CPA_BorrarCliente;
import testsCases.CPA_CrearCliente;
import testsCases.CPA_CrearProducto;

import static driver.DriverContext.quitDriver;
import static driver.DriverContext.setUp;

public class allure {
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUP(){
        System.out.println("Iniciar Driver");
        setUp("emulatar-5554","Android","C:\\Users\\cifue\\Downloads\\RecursosCursoAppium\\registroDeUsuarios.apk","emulator-5554", true);
        ReportAllure.addStep("Levantar Device",true, Status.PASSED, false);

    }
    @AfterMethod
    public void quit(){
        System.out.println("Cierre Driver");
        quitDriver();
    }

    @Test(priority = 1)
    public void Test(){
        //      Assert.assertEquals("hola", "hola mundo", "ambos hola no son iguales");
        softAssert.assertEquals("hola mundo", "hola mundo", "ambos hola no son iguales");
        System.out.println("Test 1");
        softAssert.assertAll();
    }

    @Test
    public void CPA_CrearCliente(){
        CPA_CrearCliente cpa = new CPA_CrearCliente();
        cpa.flujoFront();
    }

    //Desde aqui empiezan Casos Evaluación

    @Test(priority = 2, description = "Caso Borrar Cliente")
    public void CPA_BorrarCliente(){
        CPA_BorrarCliente cpa = new CPA_BorrarCliente ();
        cpa.flujoFront();
    }

    @Test(priority = 1, description = "Caso Crear Producto")
    public void CPA_CrearProducto(){
        CPA_CrearProducto cpa = new CPA_CrearProducto();
        cpa.flujoFront();
    }


}
