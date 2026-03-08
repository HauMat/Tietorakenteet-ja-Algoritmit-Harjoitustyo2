import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.file.Paths;


public class ohjelma {
    //metodi Jsoniin tallentamiseen. 
    //metodiin apua Geminiltä
    public static void tallennaJson(List<Ehdokas> valtuusto, String tiedostoNimi) {
        try (PrintWriter writer = new PrintWriter(tiedostoNimi, StandardCharsets.UTF_8)) { //käytetään printwriter 
            writer.println("["); //Aloitetaan json tiedoston rivin kirjoitus
            for (int i = 0; i < valtuusto.size(); i++) { //For loopissa jokaiselle riville jotain
            Ehdokas e = valtuusto.get(i); // valtuuston indeksissä i otetaan Ehdokas olio e
            writer.print(String.format("  {\"puolue\": \"%s\", \"nimi\": \"%s\", \"äänet\": %d}", e.getPuolue(), e.getFullName(), e.getÄänet()));
            //Kirjoitetaan puolue, nimi ja äänet. Niille annetaan Olion e arvot gettereillä.
            if (i < valtuusto.size() - 1) writer.println(","); //erotellaan pilkulla
            else writer.println(); //viimmeiseen riviin ei pilkkua
        }
             writer.println("]"); //Viimmeistellään json ja nyt kaikki on [] sisällä
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args){
        //Aloitetaan tekemällä Array List, johon tallennetaan tiedon luku
        List<String> ehdokkaat = new ArrayList<>();
        try{ //Luetaan tiedosto ehdokkaat.txt ja tallennetaan jokainen rivi listan ehdokkaat alkioksi
            Files.lines(Paths.get("ehdokkaat.txt")).forEach(ehdokas -> ehdokkaat.add(ehdokas));
        }
        catch(Exception e){
            System.out.println("Virhe");
        }

        //Streamien komennot, jotka ei löydy kurssin materiaalista löydetty tekoälyllä.
        //Tehdään Lista, jonka tiedot määritellään streamissa
        List<Vaaliliitto> liitot =
        ehdokkaat.stream() //txt tiedostosta stream
        .map(palat -> palat.split("\\s+")) //Paloitellaan rivit
        .map(palat -> new Ehdokas( // Tehdään Ehdokas olioit
            palat[0], //Käytetään paloittelun indeksien mukaisia tietoja
            palat[1], 
            palat[2], 
            Integer.valueOf(palat[3]) //muutetaan tieto kokonaisluvuksi
        ))
        .sorted(Comparator.comparing(Ehdokas::getÄänet) //järjestetään streami Ehdokkaat äänien mukaan
        .reversed()) //Laskevasti Top->Bottom
        .collect(Collectors.groupingBy(Ehdokas::getPuolue)) //Kerätään puolueittain
        .entrySet().stream() //Jokaiselle puolueelle tehdään jotain
        .map(entry -> new Vaaliliitto(entry.getKey(), entry.getValue()))//Tehdään jokaiselle puolueelle Vaaliliitto olio, käyttäen entry arvoja
        .toList();//lisätään listaan
        
        //Nyt voidaan ottaa stream liitot listasta
        liitot.forEach(liitto -> liitto.vertLuvut()); //Jokaiselle listassa käytetään olion vertLuvut() metodia
        liitot.forEach(liitto -> System.out.println(liitto)); //Tulostetaan jokainen liitto
        
        //Streamilla tehdään lista kaikki, jossa on kaikki ehdokkaat
        List<Ehdokas> kaikki = liitot.stream()
        .flatMap(liitto -> liitto.getJäsenet().stream()) //Vaaliliitto olion getterillä kaikki jäsenet
        .collect(Collectors.toList()); //Kerätään streamin data listaan

        //Tehdään streamillä Valtuusto lista, jossa on 51 parhainta jäsentä
        List<Ehdokas> Valtuusto = kaikki.stream() //Stream kaikista
        .sorted(Comparator.comparing(Ehdokas::getVert).reversed())//Järjestetään vertaamalla Ehdokas olion getterin avulla. Käännetään järjestys Top->Bottom
        .limit(51) //Otetaan 51 parasta
        .collect(Collectors.toList()); //Kerätään listaan

        Valtuusto.forEach(liitto -> System.out.println(liitto)); //Tulostettaan Valtuusto
        tallennaJson(Valtuusto, "Valtuusto.json"); //tallennetaan metodilla Jsoniin

    }
    
}
