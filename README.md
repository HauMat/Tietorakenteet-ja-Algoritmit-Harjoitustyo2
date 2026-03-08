# Harjoitustyö Raportti

## Ohjelman toimintaa
Ohjelma toimii hyödyntämällä paljon streamien hyviä puolia.
Ohjelmassa streameilla saadaan tallennettua muuttujiin tai listoihin halutut tiedot, joita voidaan käyttää uudestaan streameissa uusiin käyttökohteisiin.
Ohjelma sisältää ohjelman lisäksi kaksi luokkaa, joiden toimintoja voidaan hyödyksikäyttää streamien sisällä.
Streameissa getterien avulla järjestetään tietoa, josta on helppo tehdä uusia Array Listoja.
Luokilla on tarpeelliset konstruktorit ja getterit, mutta käyttämättömiä settereitä ei ole luotu. Luokka Vaaliliitto sisältää metodin, jolla se asettaa Ehdokas oliolle vertailuluvut.
Vaaliliitto luokalla on monimutkaisempi toString tulostus, jossa streamin avulla tulostetaan listan kaikki olio jäsenet käyttäen Ehdokkaan toString tulostusta.

## Ohjelman kulku
Aloitetaan tekemällä ohjelmaan metodi tiedon tallennukseen. Metodissa tallennetaan Json tiedostoon manuaalisesti jokainen rivi for loopin sisällä.

Main alkaa "ehdokkaat" Array List luonnilla.
Listaan "ehdokkaat" yritetään Filesillä lukea ehdokkaat.txt jokainen rivi omaan indeksiin.

Seuraavaksi aloitetaan streameilla luokkien tekeminen ja tiedon järjestäminen.
"Vaaliliitto" luokalle tehdään "liitot" lista, joka tehdään streamilla.
Streamissa paloitellaan rivien välit pois.
Jokaisen rivin paloista tehdään "Ehdokas" olio.
Oliot järjestetään ääni järjestykseen.
Tehdään jokaiselle "puolue" arvolle "Vaaliliitto" olio, joka tarvitsee listan ja puolueen nimen.
"Vaaliliitto" oliot lisätään "liitot" listaan.

Otetaan stream "liitot" listasta.
Liiton jäsenet ovat valmiiksi järjestyksessä ja voidaan jokaiselle liitolle käyttää vertLuvut() metodia vertailulukujen lisäämiseen.
vertLuvut() on "Vaaliliitto" luokan metodi, joka käyttää "Ehdokas" luokan setter metodia.

Otetaan "liitot" stream, josta tehdään "kaikki" lista.
Kerätään "liitot" listan jokaiselta "Vaaliliito" oliolta jäsenet "kaikki" listaan.

Tehdään "Valtuusto" lista "kaikki" streamista.
Järjestetään lista "Ehdokas" olioiden vertailuluvuilla.
Otetaan 51 parasta oliota ja kerätään ne listaan.

Tallennetaan lopuksi metodilla tallennaJson() "Valtuusto" lista json tiedostoon.

## Hienoa koodissa
Koodissa on hienoa streamien käyttö. 
Koodissa on onnistuneesti käytetty 2 kertaa try catch tyyliä koodin suorittamiseen.
Koodissa uusien listojen luonti on suurimmaksi osaksi osa streamin käyttöä.
Luokat ovat yksinkertaisia ja minulle nättejä, kun niissä ei ole käyttämätöntä koodia.
Koodi tulostaa hienosti ehdokkaat puolueittan eroteltuna vertailuluvun mukaan.

## Huonoa koodissa
Luokkien siällä ei ole kaikkia settereitä vaan niihin on lisätty vain tarpeelliset getterit, konstruktorit ja metodit.
Luokkien sisällä ei logiikassa oteta huomioon, onko äänimäärä järjestyksessä vai ei. Tein ensin ohjelman sisällä järjestelyä, jota en enää halunnut siirtää luokan sisälle.
Pääohjelman listojen luonti on ehkä liiallista. Paremmalla streamien osaamisella voisi vähentää rivien määrää ja tehdä vähemmän listoja.
Streamien käyttö pilkottu osiin eikä tehokkaasti mahdollisimman pienillä rivi määrillä tehty.
Jsoniin piti pyytää tekoälyltä apua. Olin liian pitkällä Jsonin käytössä kun tajusin, että ehkä ei ole pakko käyttää json, kunhan se on samanlaisella tyylillä esim csv tai txt tiedostossa.

## Mallia materiaalista
Eniten otin mallia omista tunnilla tehdyistä harjoituksista ja/tai opettajan malleista.
Kurssin materiaalin ja sen sisältävien linkkien avulla sai hyvin tietoa.
Tekoälyltä usein tuli käytettyä hakukoneena streamin komennoille ja virhe koodien ymmärtämiseen.
esimerkkinä etsin stream komentoa, jolla tehdä jokaiselle erilaiselle puolueelle toiminto. Löytyi entrySet ja hain sillä tietoa sen toiminnasta.


## Opittua
Opin työtä tehtäessä paremmin käyttämään luokkia.
Opin näppärästi hyödyntämään streameja, joilla saa tehtyä toimintoja vaikuttamatta streamin lähteeseen.
Opin käyttämään streamia uuden listan luonti vaiheessa, eikä sitä tarvitse erikseen tehdä ensiksi.
Opin käyttämään oloita streamin sisällä.
Opin paremmin hyödyntämään eri tietorakenteita.
Opin Jsonin käytöstä, että se tarvitsee libraryn asentamisen tai sen voi tehdä manuaalisesti.
Opin ymmärtämään javan ympäristöä paremmin vscodessa tekemällä intelj sijasta.

## Tekoäly
Tekoälyä on oppimisessa hyödynnetty. Tekoälyltä on kysytty kysymyksiä samalla tavalla, kuin kysyisin opettajalta tai kaverilta.
Miten tämä komento toimii ja mistä siihen löytää dokumentaatiota.
Johtuuko virhe tästä, tuosta vai jostain muusta?
Millä komennolla voi tehdä asian x?
