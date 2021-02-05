package testsCases;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegistroPage;

public class CPA_CrearCliente {

    CarruselPage carrusel = new CarruselPage();
    RegistroPage registro = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Nico";
    String id = "12345";
    String direccion = "Calle no existe 124";
    String fono = "123456789";
    String notas = "Sin notas";

    public void flujoFront(){
        carrusel.flujoCarrusel();
        registro.validarListaDesplegada();
        registro.tapBtnMas();
        registro.tapBtnCrearCliente();
        crearClientePage.validarListaDesplegada();
        crearClientePage.completarFormulario(nombre, id, fono, direccion, notas);
        crearClientePage.tapGuardar();
        registro.validarCliente(nombre);
    }
}
