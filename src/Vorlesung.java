import java.util.List;

//TODO almost done
public class Vorlesung {
    private String bereich, titel, dozent, anzahl;

    public String toString() {
        return bereich + ":" + titel + ":" + dozent + ":" + anzahl;
    }

    public Vorlesung(String stringOfFour) {
        stringOfFour.replaceAll("\\[|\\]", ""); // deletes all "[" and "]"
        String[] split = stringOfFour.split("\\, |\\,");  // cuts the String in four parts ", " and ","

        // Saves all as an arraylike
        try {
            this.bereich = split[0];
            this.titel = split[1];
            this.dozent = split[2];
            this.anzahl = split[3];
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getBereich(){
        char klammer = '[';
        String s = this.bereich.replaceAll("\\[", "");
        return s;
    }
    public String getTitel(){
        return this.titel;
    }
}
