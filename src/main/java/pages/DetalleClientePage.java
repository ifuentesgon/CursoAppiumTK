package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DetalleClientePage {
    private AppiumDriver driver;
    public DetalleClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Eliminar cliente')]")
    private MobileElement btnEliminar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement inputBorrar;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOk;

    public void setConfirmarEliminacion(){


    }


    public void tapBtnEliminar(){
        btnEliminar.click();
    }


}
