import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            // 1. Lire le fichier JSON et le convertir en objet java 
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/data.json"));

            // 2. Convertir en JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            // 3. Récupérer le tableau "pokemon"
            JSONArray pokemonArray = (JSONArray) jsonObject.get("pokemon");

            // 4. Parcourir chaque objet Pokémon dans le tableau
            for (Object item : pokemonArray) {
                JSONObject pokemon = (JSONObject) item;
    
                // 5. Récupérer les informations du Pokémon
                long id = (long) pokemon.get("id");
                String name = (String) pokemon.get("name");
                String img = (String) pokemon.get("img");
                JSONArray typeArray = (JSONArray) pokemon.get("type");
                String weight = (String) pokemon.get("weight");

              

                // 6. Afficher les informations
                // System.out.println("ID : " + id);
                // System.out.println("Name : " + name);
                // System.out.println("Image URL : " + img);
                // System.out.println("Types : " + typeArray);

                // Si tu veux afficher les types individuellement :
                // for (Object type : typeArray) {
                //     System.out.println("Type: " + type);
                // }
                System.out.println(); // Ajouter une ligne vide entre chaque Pokémon
            }

              // Combien y’a-t-il de Pokemon dans les données ?
            int sum =0;
             // Boucle pour parcourir chaque objet Pokémon dans le tableau
           for (int item = 0; item < pokemonArray.size(); item++) {
            JSONObject pokemon = (JSONObject) pokemonArray.get(item);
            String str = (String) pokemon.get("weight");
            str = str.replace(" kg", "").replace(",",". ");
            double poids = Double.parseDouble(str);
            int limit =10;
            if (poids < limit) { 
                System.out.println(str);

            }
            
            // System.out.println("Nombre des pokemons : " + str);

            // if () {

            // }
            // Incrementer le compteur
            // sum = sum + 1;
            // Afficher le nombre de pokemons   
            
           }
           

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}



