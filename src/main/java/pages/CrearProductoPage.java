package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class CrearProductoPage {
    private AppiumDriver driver;

    private static SoftAssert softAssert= new SoftAssert();

    public CrearProductoPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Crear Producto')]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement inputPrecio;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PRODUCTOS')]")
    private MobileElement btnTabProductos;

    public void validarVistaCrearProducto() {
        softAssert.assertAll();
        if (esperarElemento(tituloVistaCrearProducto, 10)) {
            addStep("Validar Vista Crear Producto Desplegada", true, Status.PASSED, false);
        } else {
            addStep("Validar Vista Crear Producto Desplegada", true, Status.FAILED, true);
        }
    }

    public void completarFormulario(String nombreProducto, String precio) {
        inputNombreProducto.click();
        inputNombreProducto.setValue(nombreProducto);
        this.driver.hideKeyboard();

        inputPrecio.click();
        inputPrecio.setValue(precio);
 //       inputPrecio.setValue( String.valueOf( precio) );
        this.driver.hideKeyboard();

    }

    public void tapConfirmar() {
        btnConfirmar.click();
    }



}


