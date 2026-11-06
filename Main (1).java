import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);
        Entrada entrada = new Entrada(teclado);
        Biblioteca biblioteca = new Biblioteca();


        int opcion;


        do {
            System.out.println("\n====================================");
            System.out.println("   SISTEMA DE GESTION DE BIBLIOTECA");
            System.out.println("====================================");
            System.out.println("1. Registrar libro nuevo");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Buscar libro por ISBN");
            System.out.println("5. Buscar libro por titulo");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Mostrar registro de eventos");
            System.out.println("0. Salir");
            System.out.println("====================================");


            opcion = entrada.leerEntero("Seleccione una opcion: ");


            switch (opcion) {


                case 1: {
                    System.out.println("\n--- REGISTRAR LIBRO ---");


                    String isbn = entrada.leerTexto("ISBN: ");
                    String titulo = entrada.leerTexto("Titulo: ");
                    String autor = entrada.leerTexto("Autor: ");
                    int cantidad = entrada.leerEntero(
                        "Cantidad de ejemplares: "
                    );


                    biblioteca.registrarLibro(
                        isbn, titulo, autor, cantidad
                    );
                    break;
                }


                case 2: {
                    System.out.println("\n--- PRESTAR LIBRO ---");


                    String isbn = entrada.leerTexto(
                        "Ingrese el ISBN: "
                    );


                    biblioteca.prestarLibro(isbn);
                    break;
                }


                case 3: {
                    System.out.println("\n--- DEVOLVER LIBRO ---");


                    String isbn = entrada.leerTexto(
                        "Ingrese el ISBN: "
                    );


                    biblioteca.devolverLibro(isbn);
                    break;
                }


                case 4: {
                    System.out.println("\n--- BUSCAR POR ISBN ---");


                    String isbn = entrada.leerTexto(
                        "Ingrese el ISBN: "
                    );


                    biblioteca.consultarPorISBN(isbn);
                    break;
                }


                case 5: {
                    System.out.println("\n--- BUSCAR POR TITULO ---");


                    String titulo = entrada.leerTexto(
                        "Ingrese el titulo: "
                    );


                    biblioteca.consultarPorTitulo(titulo);
                    break;
                }


                case 6:
                    biblioteca.listarLibros();
                    break;


                case 7:
                    RegistroEventos.mostrarEventos();
                    break;


                case 0:
                    System.out.println(
                        "Gracias por utilizar la biblioteca."
                    );
                    break;


                default:
                    RegistroEventos.registrar(
                        "ERROR: opcion de menu no valida: " + opcion
                    );
                    System.out.println("Opcion no valida.");
            }


        } while (opcion != 0);


        teclado.close();
    }
}
