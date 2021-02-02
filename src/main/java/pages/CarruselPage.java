package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CarruselPage {
    private AppiumDriver driver;

    public CarruselPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement flechaNext;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnPermitir;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnHecho;

    public void flujoCarrusel(){
        flechaNext.click();
        flechaNext.click();
        flechaNext.click();
        btnPermitir.click();
        btnHecho.click();

    }

}
