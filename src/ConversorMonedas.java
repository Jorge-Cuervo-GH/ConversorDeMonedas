import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedas {
    private static final String API_KEY = "e2d049ccef5ac1a9f65a1833";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double convertir(String origen, String destino, double cantidad) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/latest/" + origen;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .GET()
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() == 200) {
            JsonObject json = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (rates.has(destino)) {
                double tasa = rates.get(destino).getAsDouble();
                return cantidad * tasa;
            } else {
                throw new Exception("Moneda destino no válida.");
            }
        } else {
            throw new Exception("Error en conexión con la API.");
        }

    }
}


