import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Paths;



public class ohjelma {
    public static void tallennaJson(List<Ehdokas> valtuusto, String tiedostoNimi) {
        try (PrintWriter writer = new PrintWriter(tiedostoNimi, StandardCharsets.UTF_8)) {
            writer.println("[");
            for (int i = 0; i < valtuusto.size(); i++) {
            Ehdokas e = valtuusto.get(i);
            writer.print(String.format("  {\"puolue\": \"%s\", \"nimi\": \"%s\", \"äänet\": %d}", e.getPuolue(), e.getFullName(), e.getÄänet()));
            if (i < valtuusto.size() - 1) writer.println(",");
            else writer.println();
        }
             writer.println("]");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args){
        List<String> ehdokkaat = new ArrayList<>();
        try{
            Files.lines(Paths.get("ehdokkaat.txt")).forEach(ehdokas -> ehdokkaat.add(ehdokas));
        }
        catch(Exception e){
            System.out.println("Virhe");
        }

        List<Vaaliliitto> liitot =
        ehdokkaat.stream()
        .map(palat -> palat.split("\\s+"))
        .map(palat -> new Ehdokas(
            palat[0], 
            palat[1], 
            palat[2], 
            Integer.valueOf(palat[3])
        ))
        .sorted(Comparator.comparing(Ehdokas::getÄänet)
        .reversed())
        .collect(Collectors.groupingBy(Ehdokas::getPuolue))
        .entrySet().stream()
        .map(entry -> new Vaaliliitto(entry.getKey(), entry.getValue()))
        .toList();
        
        liitot.forEach(liitto -> liitto.vertLuvut());
        liitot.forEach(liitto -> System.out.println(liitto));
        
        List<Ehdokas> kaikki = liitot.stream()
        .flatMap(liitto -> liitto.getJäsenet().stream())
        .collect(Collectors.toList());

        List<Ehdokas> Valtuusto = kaikki.stream()
        .sorted(Comparator.comparing(Ehdokas::getVert).reversed())
        .limit(51)
        .collect(Collectors.toList());

        Valtuusto.forEach(liitto -> System.out.println(liitto));
        tallennaJson(Valtuusto, "Valtuusto.json");

    }
    
}
