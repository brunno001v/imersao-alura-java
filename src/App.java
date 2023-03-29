import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //Acessar via http os dados do imdb
        //Guardar em uma String os dados recebidos sobre os top 250 filmes
        Menu option = new Menu(); 
        String url = option.menu(); //recebe a url a partir de um menu
        
        if (url == null) {
            return;            
        }
        URI adress = URI.create(url);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        String body = response.body();

        //Extrair os dados(titúlo, poster e classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        //Exibir e manipular os dados

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[1mTítulo:\u001b[m" + filme.get("title"));
            System.out.println("\u001b[1mCapa:\u001b[m" + filme.get("image"));
            System.out.println("\u001b[1mClassificação:\u001b[m" + filme.get("imDbRating"));

            double classification = Double.parseDouble(filme.get("imDbRating"));
            int rating = (int) classification;

            for (int i = 0; i < rating; i++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }

    }
}
