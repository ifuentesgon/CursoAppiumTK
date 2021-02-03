package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class RegistroPage {
    private AppiumDriver driver;
    public RegistroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Registro')]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

  //@AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
  // private MobileElement btnCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> clientes;





    public void validarListaDesplegada(){
        if(esperarElemento(tituloVistaRegistro, 5)){
            addStep("Validar Vista registro Desplegada",true, Status.PASSED,false);
        }else{
            addStep("Validar Vista registro Desplegada",true, Status.FAILED,true);
        }
    }

    public void validarCliente(String nombreCliente){
        boolean clienteEncontrado = false;
        for (int i = 0 ; 1<clientes.size();i++){
            if(clientes.get(i).getText().equals(nombreCliente)){
                clienteEncontrado = true;
                addStep("Cliente Encontrado: "+nombreCliente, true, Status.PASSED, false);
                break;
            }
        }
        if(!clienteEncontrado){
            addStep("Cliente NO Encontrado: "+nombreCliente, true, Status.FAILED, true);
        }
//        MobileElement cliente = (MobileElement) DriverContext.getDriver().findElement(By.xpath("//*[contains(@text,'"+nombreCliente+"')]"));
//        if(cliente.getText().equals(nombreCliente)){
//            addStep("validar Cliente Registrado: "+nombreCliente, true, Status.PASSED, false);
//        }else{
//            addStep("validar Cliente Registrado: "+nombreCliente, true, Status.FAILED, true);
//        }
    }

    public void tapBtnMas(){
        btnMas.click();
    }

    public void tapBtnCrearCliente(){
        btnCrearCliente.click();
    }

    public void tapSeleccionarCliente(String nombreCliente){
        boolean clienteEncontrado = false;
        for (int i = 0 ; 1<clientes.size();i++){
            if(clientes.get(i).getText().equals(nombreCliente)){
                clienteEncontrado = true;

                addStep("Cliente Encontrado: "+nombreCliente, true, Status.PASSED, false);
                MobileElement cliente = (MobileElement) DriverContext.getDriver().findElement(By.xpath("//*[contains(@text,'"+nombreCliente+"')]"));
                cliente.click();

                break;
            }
        }
        if(!clienteEncontrado){
            addStep("Cliente NO Encontrado: "+nombreCliente, true, Status.FAILED, true);
        }

    }

}
