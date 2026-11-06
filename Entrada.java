import java.util.Scanner;


public class Entrada {


    private final Scanner teclado;


    public Entrada(Scanner teclado) {
        this.teclado = teclado;
    }


    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }


    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String dato = teclado.nextLine().trim();


            try {
                return Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                RegistroEventos.registrar(
                    "ERROR: se esperaba un numero entero."
                );
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }
}