
public class Ehdokas {
    private String etunimi;
    private String sukunimi;
    private String puolue;
    private int äänet;
    private double vertailuluku;

    //Tehdään olio, joka tarvitsee tarvitsee tietoa. Vertailuluku jätetään pois, koska se asetetaan myöhemmin
    public Ehdokas(String etunimi, String sukunimi, String puolue, int äänet){
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.puolue = puolue;
        this.äänet = äänet;
        this.vertailuluku = 0;
    }

    //Tulostetaan olion tiedot
    @Override
    public String toString(){
        return etunimi +" "+ sukunimi + ", Puolue: " +
        puolue + ", Äänimäärä: " + äänet + ",  Vertailuluku: " + vertailuluku;
    }

    //Getterit
    public String getFullName(){
        return etunimi + " " + sukunimi;
    }

    public String getEtunimi(){
        return etunimi;
    }

    
    public String getSukunimi(){
        return sukunimi;
    }
    
    public String getPuolue(){
        return puolue;
    }
    
    public int getÄänet(){
        return äänet;
    }

    public double getVert(){
        return vertailuluku;
    }
    //Setteri vertailuluvulle
    public void setVert(double luku){
        this.vertailuluku = luku;        
    }
    

}
