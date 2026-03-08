import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vaaliliitto {
    private String puolue;
    private List<Ehdokas> jäsenet;

    public Vaaliliitto(String puolue, List<Ehdokas> jäsenet){
        this.puolue = puolue;
        this.jäsenet = jäsenet;
    }

    public void vertLuvut(){
        int TotalÄänet = jäsenet.stream()
        .mapToInt(Ehdokas::getÄänet)
        .sum();

        IntStream.range(0, jäsenet.size())
        .forEach(n -> {
            Ehdokas ehdokas = jäsenet.get(n);
            double VertLuku = TotalÄänet / (double)(n + 1);
            ehdokas.setVert(VertLuku);
        });
    }
    public String getPuolue(){
        return puolue;
    }

    public List<Ehdokas> getJäsenet(){
        return jäsenet;
    }

    @Override
    public String toString(){
        String ehdokasLista = jäsenet.stream()
        .map(jäsen -> jäsen.toString())
        .collect(Collectors.joining("\n"));

        return "\nPuolueen " + puolue + " Ehdokkaat: \n" + ehdokasLista;

    }
}
