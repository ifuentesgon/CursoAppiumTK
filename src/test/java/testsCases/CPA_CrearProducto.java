package testsCases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

public class CPA_CrearProducto {

    CarruselPage carrusel = new CarruselPage();
    RegistroPage registro = new RegistroPage();
    CrearProductoPage producto = new CrearProductoPage();


    String nombreProducto = "NotebookPraaaah";
    String montoProducto = "12345.00";

    public void flujoFront(){
        //Desplegar App --> Se viaualiza arrusel informativo
        carrusel.vizualizaCarrucelInformativo();
        //Recorrer todoel carusel --> Se visualiza pantalla de 'Registro'
        carrusel.flujoCarrusel();
        registro.validarListaDesplegada();
        //Tap al botón '+' de la pantalla Registro --> Se visualizan 2 botones mas 'Crear Cliente' y 'Crear Producto'
        registro.tapBtnMas();
        //Tap al botón 'Crear Producto' -->	Se visualiza pantalla de 'Crear Producto'
        registro.tapBtnCrearProducto();
        producto.validarVistaCrearProducto();
        //Ingresar nombre y precio del producto y se da tap al botón 'Confirmar' -- > Se visualiza pantalla de 'Registro'
        producto.completarFormulario(nombreProducto, montoProducto);
        producto.tapConfirmar();
        registro.validarListaDesplegada();
        //Tap al botón Tab 'Productos' -- > Se visualiza pantalla de 'Productos'
        registro.tapRegistroProductos();
        registro.validarListaProdutosDesplegada();

        //Validación: Validar que el producto ingresado se encuentre en la lista de la pantalla 'Productos' con el nombre y el precio correcto.
        registro.validarProducto(nombreProducto);
        registro.validarPrecio(montoProducto);






    }


}
