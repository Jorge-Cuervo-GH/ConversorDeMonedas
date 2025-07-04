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

        HttpURLConnection conexion = (HttpURLConnection) new URL(urlStr).openConnection();
        conexion.setRequestMethod("GET");

        int responseCode = conexion.getResponseCode();
        if (responseCode == 200) {
            InputStreamReader reader = new InputStreamReader(conexion.getInputStream());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
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


