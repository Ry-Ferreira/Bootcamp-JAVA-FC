import java.util.HashMap;
import java.util.Set;
public class Bandas{
    public static void main(String[] args){
        HashMap<String,String> tracklist = new HashMap<String,String>();
        tracklist.put("Tendencia global", "sus ojos irradian la sensualidad...");
        tracklist.put("Voy a beber", "Me preguntan: tu te vas? yo le digo si mamita aqui no pasa na");
        tracklist.put("Lo que me duele", "Lo que me duele es que no hayas tenido el valor de decirme frente a frente");
        tracklist.put("Ya fue", "Apenas puedes mirarme a la cara Y no te salen las palabras, pero yo sé que lo di todo por tu amor, no, no");
        Set<String> tracks = tracklist.keySet();
        for(String items: tracks){
            System.out.println(items);
            System.out.println(tracklist.get(items));
        }
    }
}