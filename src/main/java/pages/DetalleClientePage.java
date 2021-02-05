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

public class DetalleClientePage {
    private AppiumDriver driver;
    public DetalleClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloVistaDetalleCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/layout_root")
    private MobileElement popUP;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Eliminar cliente')]")
    private MobileElement btnEliminar;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement inputBorrar;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOk;

    public void validarVistaDetalleCliente(String nombre){
        if(esperarElemento(tituloVistaDetalleCliente, 5)){
            addStep("Cliente Encontrado: "+nombre, true, Status.PASSED, false);
        }else{
            addStep("Cliente Encontrado: "+nombre,true, Status.FAILED,true);
        }
    }

    public void confirmarEliminacion(){

        inputBorrar.click();
        inputBorrar.setValue("BORRAR");
        this.driver.hideKeyboard();

        btnOk.click();
    }

    public void tapBtnEliminar(){
        if(esperarElemento(btnEliminar, 5)){
            addStep("Tap a Boton 'OK' ", true, Status.PASSED, false);
            btnEliminar.click();
        } else {
            addStep("Boton 'OK' no se encuentra.", true, Status.FAILED, true);
        }
    }

    public void vizualizaPopUpEliminacion(){
        if(esperarElemento(popUP, 5)){
            addStep("Se Vizualiza PopUp Confirmación Eliminación Cliente",true, Status.PASSED,false);
        }else{
            addStep("Se Vizualiza PopUp Confirmación Eliminación Cliente",true, Status.FAILED,true);
        }
    }




}
