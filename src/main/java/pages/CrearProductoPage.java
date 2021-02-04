package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CrearProductoPage {
    private AppiumDriver driver;
    public CrearProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio\n")
    private MobileElement inputPrecio;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar\n")
    private MobileElement btnConfirmar;







}
