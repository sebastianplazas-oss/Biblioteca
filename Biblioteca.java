import java.util.ArrayList;
import java.util.List;


public class Biblioteca {


    private final List<Libro> catalogo = new ArrayList<>();
    private static final int MAX_LIBROS = 100;


    public Biblioteca() {
        cargarLibrosIniciales();
    }


    // Cargar automaticamente el catalogo inicial
    private void cargarLibrosIniciales() {
        catalogo.add(new Libro(
            "9780",
            "Cien anos de soledad",
            "Gabriel Garcia Marquez",
            5
        ));


        catalogo.add(new Libro(
            "9788",
            "El principito",
            "Antoine de Saint-Exupery",
            4
        ));


        catalogo.add(new Libro(
            "9785",
            "Don Quijote de la Mancha",
            "Miguel de Cervantes",
            3
        ));


        catalogo.add(new Libro(
            "9786",
            "La sombra del viento",
            "Carlos Ruiz Zafon",
            4
        ));


        catalogo.add(new Libro(
            "9781",
            "El amor en los tiempos del colera",
            "Gabriel Garcia Marquez",
            3
        ));


        catalogo.add(new Libro(
            "9787",
            "La casa de los espiritus",
            "Isabel Allende",
            2
        ));


        catalogo.add(new Libro(
            "9782",
            "1984",
            "George Orwell",
            5
        ));


        catalogo.add(new Libro(
            "9789",
            "El alquimista",
            "Paulo Coelho",
            3
        ));


        RegistroEventos.registrar(
            "Catalogo inicial cargado: "
            + catalogo.size() + " libros."
        );
    }


    // Buscar un libro por ISBN
    private Libro buscarPorISBN(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }


    // Registrar un libro nuevo
    public void registrarLibro(String isbn, String titulo,
                               String autor, int cantidad) {


        if (isbn == null || isbn.isBlank()
                || titulo == null || titulo.isBlank()
                || autor == null || autor.isBlank()
                || cantidad <= 0) {


            RegistroEventos.registrar(
                "ERROR: datos incompletos o invalidos al registrar libro."
            );
            System.out.println(
                "Error: complete todos los campos y use una cantidad positiva."
            );
            return;
        }


        isbn = isbn.trim();
        titulo = titulo.trim();
        autor = autor.trim();


        if (buscarPorISBN(isbn) != null) {
            RegistroEventos.registrar(
                "ERROR: ISBN duplicado: " + isbn
            );
            System.out.println("Ese ISBN ya esta registrado.");
            return;
        }


        if (catalogo.size() >= MAX_LIBROS) {
            RegistroEventos.registrar("ERROR: catalogo lleno.");
            System.out.println(
                "No se pueden agregar mas libros. Limite: 100."
            );
            return;
        }


        catalogo.add(new Libro(isbn, titulo, autor, cantidad));


        RegistroEventos.registrar(
            "Libro registrado: " + titulo + ", ISBN: " + isbn
        );
        System.out.println("Libro registrado correctamente.");
    }


    // Prestar un ejemplar
    public void prestarLibro(String isbn) {
        Libro libro = buscarPorISBN(isbn);


        if (libro == null) {
            RegistroEventos.registrar(
                "ERROR: prestamo de libro inexistente. ISBN: " + isbn
            );
            System.out.println("El libro no existe.");
            return;
        }


        if (!libro.prestar()) {
            RegistroEventos.registrar(
                "ERROR: no hay copias disponibles de " + isbn
            );
            System.out.println("No hay copias disponibles.");
            return;
        }


        RegistroEventos.registrar(
            "Prestamo realizado: " + libro.getTitulo()
        );
        System.out.println("Prestamo realizado correctamente.");
        System.out.println(
            "Copias disponibles: " + libro.getCantidadDisponible()
        );
    }


    // Devolver un ejemplar
    public void devolverLibro(String isbn) {
        Libro libro = buscarPorISBN(isbn);


        if (libro == null) {
            RegistroEventos.registrar(
                "ERROR: devolucion de libro inexistente. ISBN: " + isbn
            );
            System.out.println("El libro no existe.");
            return;
        }


        if (!libro.devolver()) {
            RegistroEventos.registrar(
                "ERROR: no existen prestamos pendientes para " + isbn
            );
            System.out.println(
                "No se puede devolver: todas las copias ya estan disponibles."
            );
            return;
        }


        RegistroEventos.registrar(
            "Devolucion realizada: " + libro.getTitulo()
        );
        System.out.println("Devolucion realizada correctamente.");
        System.out.println(
            "Copias disponibles: " + libro.getCantidadDisponible()
        );
    }


    // Consultar por ISBN
    public void consultarPorISBN(String isbn) {
        Libro libro = buscarPorISBN(isbn);


        if (libro == null) {
            RegistroEventos.registrar(
                "ERROR: busqueda sin resultados para ISBN " + isbn
            );
            System.out.println("Libro no encontrado.");
            return;
        }


        libro.mostrarInformacion();
        RegistroEventos.registrar("Consulta por ISBN: " + isbn);
    }


    // Consultar por titulo completo o parcial
    public void consultarPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            RegistroEventos.registrar(
                "ERROR: busqueda con titulo vacio."
            );
            System.out.println("Ingrese un titulo.");
            return;
        }


        boolean encontrado = false;


        for (Libro libro : catalogo) {
            if (libro.getTitulo().toLowerCase()
                    .contains(titulo.trim().toLowerCase())) {
                libro.mostrarInformacion();
                encontrado = true;
            }
        }


        if (!encontrado) {
            System.out.println("No se encontraron libros.");
        }


        RegistroEventos.registrar(
            "Consulta por titulo: " + titulo
        );
    }


    // Listar todo el catalogo
    public void listarLibros() {
        System.out.println("\n===== CATALOGO DE LIBROS =====");


        if (catalogo.isEmpty()) {
            System.out.println("El catalogo esta vacio.");
        } else {
            for (Libro libro : catalogo) {
                libro.mostrarInformacion();
            }
        }


        RegistroEventos.registrar("Listado completo del catalogo.");
    }
}