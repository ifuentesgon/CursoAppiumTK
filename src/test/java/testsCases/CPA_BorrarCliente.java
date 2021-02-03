package testsCases;

import pages.CarruselPage;
import pages.DetalleClientePage;
import pages.RegistroPage;
import utils.Utils;

public class CPA_BorrarCliente {

    CarruselPage carrusel = new CarruselPage();
    RegistroPage registro = new RegistroPage();
    DetalleClientePage detalle = new DetalleClientePage();
    Utils utils = new Utils();

    //Parametro Nombre a eliminar
    String nombre = "karen";

    public void flujoFront(){

        //Desplegar APP Correctamente
        carrusel.vizualizaCarrucelInformativo();
        //Recorre carrusel
        carrusel.flujoCarrusel();
        //Selecionamos un cliente
        registro.tapSeleccionarCliente(nombre);
        //Tap Eliminar Cliente
        utils.swipeAbajo();
        detalle.tapBtnEliminar();
        //Ingresar palabra borrar y tap en boton OK





    }




}
