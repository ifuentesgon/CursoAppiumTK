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

    //Parametro Nombre Cliente a eliminar
    String nombre = "Adriana";

    public void flujoFront(){

        //Desplegar App -->	Se visualiza carrusel informativo
        carrusel.vizualizaCarrucelInformativo();
        //Recorrer todoel carusel --> Se visualiza pantalla de 'Registro'
        carrusel.flujoCarrusel();
        registro.validarListaDesplegada();
        //Seleccionamos un cliente --> Se visualiza pantalla 'Detalle del Cliente'
        registro.tapSeleccionarCliente(nombre);
        detalle.validarVistaDetalleCliente(nombre);
        //Tap al botón 'Eliminar Cliente' --> Se visualiza popUp de confirmación
        utils.swipeAbajo();
        detalle.tapBtnEliminar();
        detalle.vizualizaPopUpEliminacion();
        //Se ingresa la palabra 'BORRAR' y se da tap al botón 'ok'	--> Sevisualiza pantalla de 'Registro'
        detalle.confirmarEliminacion();
        registro.validarListaDesplegada();

        //Validación: Validar que el cliente no se visualice en la pantalla de 'Registro', en el tab de 'Clientes'
        registro.tapRegistroClientes();
        registro.validaClienteEliminado(nombre);

    }

}
