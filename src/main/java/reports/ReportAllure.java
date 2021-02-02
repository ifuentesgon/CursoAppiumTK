package reports;

import driver.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class ReportAllure {
    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String nombreStep, Boolean screenshot, Status status, Boolean fatal){

        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().setName(nombreStep).setStatus(status);
        Allure.getLifecycle().startStep(uuid,result);
        if(screenshot){
            reportScreenShot();
        }
        Allure.getLifecycle().stopStep(uuid);
        softAssert.assertTrue(true, nombreStep);

        if(status.equals(Status.FAILED)){
            softAssert.fail(nombreStep);
        }
        if(fatal){
            Assert.fail("Fallo: "+nombreStep);
        }
        System.out.println("ReportAllure: "+nombreStep);

    }
    private static void reportScreenShot(){
        File srcFile;
        srcFile = DriverContext.getDriver().getScreenshotAs(OutputType.FILE);
        File foto = new File(srcFile.getPath());
        InputStream imagen = null;
        try {
            imagen = new FileInputStream(foto);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Allure.addAttachment("Imagen Adjunta", imagen);
    }

    public static void finalAssert(){
        softAssert.assertAll();
    }

}
