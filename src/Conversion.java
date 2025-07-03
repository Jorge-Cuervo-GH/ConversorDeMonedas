import java.time.LocalDateTime;

public record Conversion(String origen, String destino, double cantidad, double resultado, LocalDateTime fechaHora) {
    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s (%s)",
                cantidad, origen, resultado, destino, fechaHora.toString());
    }
}

