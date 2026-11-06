public class Libro {
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final int cantidadTotal;
    private int cantidadDisponible;
    public Libro(String isbn, String titulo, String autor,
                 int cantidadTotal) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadTotal;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getCantidadTotal() {
        return cantidadTotal;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public boolean prestar() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
            return true;
        }
        return false;
    }
    public boolean devolver() {
        if (cantidadDisponible < cantidadTotal) {
            cantidadDisponible++;
            return true;
        }
        return false;
    }
    public void mostrarInformacion() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad total: " + cantidadTotal);
        System.out.println("Copias disponibles: " + cantidadDisponible);
        System.out.println("------------------------------------");
    }
}
