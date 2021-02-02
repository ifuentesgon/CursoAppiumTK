package driver;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManneger driverManneger = new DriverManneger();

    public static void setUp(String nombreDispositivo, String sistemaOperativo, String rutaApp, String udID, Boolean emulador){
        driverManneger.setUp(nombreDispositivo,sistemaOperativo,rutaApp,udID, emulador);
    }

    public static AppiumDriver getDriver (){
        return driverManneger.getDriver();
    }

    public static void quitDriver(){
        driverManneger.getDriver().quit();
    }
}
