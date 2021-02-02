package testsCases;

import pages.CarruselPage;
import pages.CrearCliente;
import pages.RegistroPage;

public class CPA_CrearCliente {

    CarruselPage carrusel = new CarruselPage();
    RegistroPage registro = new RegistroPage();
    CrearCliente crearCliente = new CrearCliente();

    String nombre = "karen";
    String id = "12345";
    String direccion = "Calle no existe 124";
    String fono = "123456789";
    String notas = "Sin notas";

    public void flujoFront(){
        carrusel.flujoCarrusel();
        registro.validarListaDesplegada();
        registro.tapBtnMas();
        registro.tapBtnCrearCliente();
        crearCliente.validarListaDesplegada();
        crearCliente.completarFormulario(nombre, id, fono, direccion, notas);
        crearCliente.tapGuardar();
        registro.validarCliente(nombre);
    }
}