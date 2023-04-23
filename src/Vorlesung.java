import java.util.Objects;
//Andres Eisenmann
//Jannes Müller
//TODO almost done
public class Vorlesung {
    private final String bereich;
    private final String titel;
    private final String dozent;
    private final String anzahl;

    public String toString() {
        return bereich + ":" + titel + ":" + dozent + ":" + anzahl;
    }

    public Vorlesung(String stringOfFour) throws TextFileFormatException{
        String s = stringOfFour.replaceAll("[\\[\\]]", "");// deletes all "[" and "]"
        String[] split = s.split(", |,");  // cuts the String in four parts ", " and ","

        // Saves all as an arraylike
        try {

            // Spaltenanzahl zu viel/zu wenig
            if (split.length != 4) {
                throw new TextFileFormatException("Spaltenanzahl zu viel/zu wenig");
            }
            for (String value : split) {
                if (Objects.equals(value, "")) {
                    throw new TextFileFormatException("Teile der Spalten haben keinen Inhalt");
                }
                if (!(split[3].matches("\\d+"))) {
                    throw new TextFileFormatException("Anzahl der Teilnehmer ist kein integer");
                }

            }


            this.bereich = split[0];
            this.titel = split[1];
            this.dozent = split[2];
            this.anzahl = split[3];
        } catch (TextFileFormatException e) {
            throw new TextFileFormatException("Fehler in " + s + ": " + e.getMessage());        }



    }
    public String getBereich(){

        return this.bereich.replaceAll("\\[", "");
    }
    public String getTitel(){
        return this.titel;
    }
    public String getDozent(){
        return this.dozent;
    }

    public String getAnzahl() {
        return this.anzahl;
    }
}
