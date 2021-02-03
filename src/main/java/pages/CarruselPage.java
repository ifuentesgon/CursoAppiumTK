package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class CarruselPage {
    private AppiumDriver driver;

    public CarruselPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement imagenInformativaCarrusel;

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement flechaNext;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnPermitir;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnHecho;

    public void vizualizaCarrucelInformativo(){
        if(esperarElemento(imagenInformativaCarrusel, 5)){
            addStep("Vista Carrucel Desplegada",true, Status.PASSED,false);
        }else{
            addStep("Vista Carrucel Desplegada",true, Status.FAILED,true);
        }
    }

    public void flujoCarrusel(){
        flechaNext.click();
        flechaNext.click();
        flechaNext.click();
        btnPermitir.click();
        btnHecho.click();

    }



}
