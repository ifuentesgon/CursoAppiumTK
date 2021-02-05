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

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CLIENTES')]")
    private MobileElement btnTabClientes;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PRODUCTOS')]")
    private MobileElement btnTabProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> clientes;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/nombre_producto']")
    private List<MobileElement> listaProductos;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/precio_producto']")
    private List<MobileElement> listaPrecioProductos;


    public void validarListaDesplegada(){
        if(esperarElemento(tituloVistaRegistro, 5)){
            addStep("Se Vizualiza Vista Registro Desplegada",true, Status.PASSED,false);
        }else{
            addStep("Se Vizualiza Vista Registro Desplegada",true, Status.FAILED,true);
        }
    }

    public void validarListaProdutosDesplegada(){
        if(esperarElemento(tituloVistaRegistro, 5)){
            addStep("Se Vizualiza Pantalla Productos",true, Status.PASSED,false);
        }else{
            addStep("Se Vizualiza Pantalla Productos",true, Status.FAILED,true);
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
        if(esperarElemento(btnMas, 5)){
            addStep("Se Vizualiza Boton Crear Cliente y Crear Producto",true, Status.PASSED,false);
        }else{
            addStep("Se Vizualiza Boton Crear Cliente y Crear Producto",true, Status.FAILED,true);
        }
    }

    public void tapBtnCrearCliente(){

        btnCrearCliente.click();
    }

    public void tapBtnCrearProducto(){

        btnCrearProducto.click();
    }

    public void tapSeleccionarCliente(String nombreCliente){
        boolean clienteEncontrado = false;
        for (int i = 0 ; 1<clientes.size();i++){
            if(clientes.get(i).getText().equals(nombreCliente)){
                clienteEncontrado = true;

                MobileElement cliente = (MobileElement) DriverContext.getDriver().findElement(By.xpath("//*[contains(@text,'"+nombreCliente+"')]"));
                cliente.click();
           //     addStep("Cliente Encontrado: "+nombreCliente, true, Status.PASSED, false);
                break;
            }
        }
        if(!clienteEncontrado){
            addStep("Cliente NO Encontrado: "+nombreCliente, true, Status.FAILED, true);
        }
    }

    public void validaClienteEliminado(String nombre){
        boolean clienteEncontrado = false;
        for (int i = 0; i<=clientes.size(); i++){
            String nombreCliente = clientes.get(i).getText();
            if (!nombreCliente.equals(nombre)){
                clienteEncontrado = true;
                break;
            }
        }
        if (clienteEncontrado){
            addStep("Valida Cliente: "+nombre+" Fue Eliminado", true, Status.PASSED, false);
        }
        else {
            addStep("Valida Cliente: "+nombre+" no se eliminó correctamente", true, Status.FAILED, true);
        }

    }

    public void validarProducto(String producto){
        System.out.println("[RegistroProducto] Validar producto");
        Boolean existeCliente = false;
        for (int i=0; i<=listaProductos.size(); i++){
            String productoActual = listaProductos.get(i).getText();
            if (productoActual.equals(producto)){
                existeCliente =true;
                break;
            }
        }
        if (existeCliente){
            System.out.println("[Existen Productos registrados]");
            addStep("Valida Producto: "+producto+" Encontrado", true, Status.PASSED,false);
        }
        else {
            addStep("Valida Producto: "+producto+" NO encontrado", true, Status.FAILED,true);
        }
    }

    public void validarPrecio(String montoProducto){
        Boolean existePrecio = false;
            for (int i = 0; i <= listaPrecioProductos.size(); i++) {
                String precioActual = listaPrecioProductos.get(i).getText();
                if (precioActual.equals(montoProducto)) {
                    existePrecio = true;
                    break;
                }
            }

        if (existePrecio){
            System.out.println("[RegistroPrecios] Validar precios");
            addStep("Valida Precio: "+montoProducto+" Encontrado", true, Status.PASSED,false);
        }
        else {
            addStep("Valida Precio: "+montoProducto+" NO Visualizado", true, Status.FAILED,true);
        }
    }


    public void tapRegistroClientes() {
        btnTabClientes.click();
    }

    public void tapRegistroProductos() {
        btnTabProductos.click();
    }

}
