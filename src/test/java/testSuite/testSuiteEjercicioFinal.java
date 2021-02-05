package testSuite;

import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportAllure;
import testsCases.CPA_BorrarCliente;
import testsCases.CPA_CrearCliente;
import testsCases.CPA_CrearProducto;

import static driver.DriverContext.quitDriver;
import static driver.DriverContext.setUp;

public class testSuiteEjercicioFinal {

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

    //Desde aqui empiezan Casos Evaluación

    @Test(priority = 2, description = "Caso 3: Borrar Cliente")
    public void CPA_BorrarCliente(){
        CPA_BorrarCliente cpa = new CPA_BorrarCliente ();
        cpa.flujoFront();
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "Caso 1: Crear Producto")
    public void CPA_CrearProducto(){
        CPA_CrearProducto cpa = new CPA_CrearProducto();
        cpa.flujoFront();
        softAssert.assertAll();
    }


}
