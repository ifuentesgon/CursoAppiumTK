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

public class CrearClientePage {
    private AppiumDriver driver;
    public CrearClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Crear Cliente')]")
    private MobileElement tituloVistaCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement inputNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement inputID;

    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement inputTelefono;

    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement inputDireccion;

    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement inputNotas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;


    public void validarListaDesplegada(){
        if(esperarElemento(tituloVistaCrearCliente, 5)){
            addStep("Validar Vista Crear Cliente Desplegada",true, Status.PASSED,false);
        }else{
            addStep("Validar Vista Crear Cliente Desplegada",true, Status.FAILED,true);
        }
    }

    public void completarFormulario(String nombre,String id, String fono, String direccion, String notas){
        inputNombre.click();
        inputNombre.setValue(nombre);
        this.driver.hideKeyboard();

        inputID.click();
        inputID.setValue(id);
        this.driver.hideKeyboard();

        inputTelefono.click();
        inputTelefono.setValue(fono);
        this.driver.hideKeyboard();

        inputDireccion.click();
        inputDireccion.setValue(direccion);
        this.driver.hideKeyboard();

        inputNotas.click();
        inputNotas.setValue(notas);
        this.driver.hideKeyboard();

    }

    public void tapGuardar(){
        btnGuardar.click();
    }





}
