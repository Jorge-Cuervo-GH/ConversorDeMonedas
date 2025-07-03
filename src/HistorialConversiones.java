import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private List<Conversion> historial;

    public HistorialConversiones() {
        historial = new ArrayList<>();
    }

    public void agregar(Conversion conversion) {
        historial.add(conversion);
    }

    public List<Conversion> obtenerHistorial() {
        return historial;
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (Conversion conv : historial) {
                writer.write(conv.toString() + "\n");
            }
            System.out.println("Historial guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar historial: " + e.getMessage());
        }
    }
}
