import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vaaliliitto {
    private String puolue; //Oliolla puolue 
    private List<Ehdokas> jäsenet; //Oliolla jäsen lista täynnä Ehdokas olioita

    public Vaaliliitto(String puolue, List<Ehdokas> jäsenet){
        this.puolue = puolue;
        this.jäsenet = jäsenet;
    }

    //Annetaan vertailuluvut liiton jäsenille
    public void vertLuvut(){
        int TotalÄänet = jäsenet.stream()//Lasketaan äänet yhteen jäsenet streamistä
        .mapToInt(Ehdokas::getÄänet)//Otetaan olion äänet
        .sum();//Summataan äänet muuttujaan

        IntStream.range(0, jäsenet.size())//Tehdään jäsenten koon verran
        .forEach(n -> {//jokaiselle n:lle
            Ehdokas ehdokas = jäsenet.get(n); //jäsenen ehdokas ideksissä n
            double VertLuku = TotalÄänet / (double)(n + 1); //Lasketaan vertailuluku kaavalla muuttujaan
            ehdokas.setVert(VertLuku); //Setataan ehdokkaan VertLuku
        });
    }

    //Getterit
    public String getPuolue(){
        return puolue;
    }

    public List<Ehdokas> getJäsenet(){
        return jäsenet;
    }

    //To string
    @Override
    public String toString(){
        String ehdokasLista = jäsenet.stream() //Otetaan streamistä merkkijonoja
        .map(jäsen -> jäsen.toString()) //Olion toString
        .collect(Collectors.joining("\n")); // Yhdistetään rivin vaihdoilla yhdeksi

        return "\nPuolueen " + puolue + " Ehdokkaat: \n" + ehdokasLista; 

    }
}
