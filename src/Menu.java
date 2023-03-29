import java.util.Scanner;

public class Menu {
    public String menu(){
        System.out.println("Escolha qual ranking será mostrado\n");
        System.out.println("(1) Top filmes - IMDB");
        System.out.println("(2) Filmes mais populares - IMDB");
        System.out.println("(3) Top séries - IMDB");
        System.out.println("(4) Séries mais populares - IMDB");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        in.close();
        if (option == 1) {
            return "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        }
        else if(option == 2){
            return "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        }
        else if (option == 3) {
            return "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        }
        else if (option == 4) {
            return "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";            
        }
        else{
            System.out.println("Opção Inválida!");
        }

        return null;
    }
}
