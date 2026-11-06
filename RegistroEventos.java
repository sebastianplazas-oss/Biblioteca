import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class RegistroEventos {


    private static final List<String> eventos = new ArrayList<>();


    public static void registrar(String mensaje) {
        String fecha = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );


        eventos.add(fecha + " | " + mensaje);
        System.out.println("[EVENTO] " + mensaje);
    }


    public static void mostrarEventos() {
        System.out.println("\n===== REGISTRO DE EVENTOS =====");


        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }


        for (String evento : eventos) {
            System.out.println(evento);
        }
    }
}