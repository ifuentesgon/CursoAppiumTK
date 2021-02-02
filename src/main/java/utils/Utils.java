package utils;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.collections.functors.ExceptionClosure;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static boolean esperarElemento(MobileElement elemento, int segudos){
        try {
            System.out.println("[Utils - esperarElemento] Se busca elemento: "+elemento);
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segudos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            return true;
        }catch (Exception e){
            System.out.println("[Utils - esperarElemento] Elemento: "+elemento+" no se econtro.");
            return false;
        }

    }

    public static void swipeAbajo(){
        int anchor = (int) (DriverContext.getDriver().manage().window().getSize().width *0.008D);
        int startPoint = (int) (DriverContext.getDriver().manage().window().getSize().height *0.009D);
        int endPoint = (int) (DriverContext.getDriver().manage().window().getSize().width *0.65D);
        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(anchor,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(anchor,endPoint)).release().perform();
        System.out.println("Se hace swipe abajo");

    }

}
