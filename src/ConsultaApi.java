import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Moeda buscaMoeda(String codigoMoeda) {
        URI moeda = URI.create("https://v6.exchangerate-api.com/v6/c4f4e7d4a0c861cc048d23c9/latest/" + codigoMoeda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(moeda).build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException("Verifique o código de 3 letras padrão ISO 4217.");
        }

        return new Gson().fromJson(response.body(), Moeda.class);
    }
}
