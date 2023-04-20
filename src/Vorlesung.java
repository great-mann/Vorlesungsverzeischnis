//TODO Completly done
public class Vorlesung {
    private String bereich, vorlesung, dozent, anzahl;

    public String toString() {
        return bereich + ":" + vorlesung + ":" + dozent + ":" + anzahl;
    }


    public Vorlesung(String stringOfFour) {
        stringOfFour.replaceAll("\\[|\\]", ""); // deletes all "[" and "]"
        String[] split = stringOfFour.split("\\, |\\,");  // cuts the String in four parts ", " and ","

        // Saves all as an arraylike
        this.bereich = split[0];
        this.vorlesung = split[1];
        this.dozent = split[2];
        this.anzahl = split[3];
    }


}
