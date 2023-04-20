public class Vorlesung {
    private String bereich, vorlesung, dozent, anzahl;

    public String toString() {
        return bereich + ":" + vorlesung + ":" + dozent + ":" + anzahl;
    }


    public Vorlesung(String stringOfFour) {
        String tmp = stringOfFour;
        String a = "";
        for(int i = 0; i < stringOfFour.length(); i++) {
            // TODO Regrex for String tmp => stringOfFour.replaceAll ...
            if (tmp.charAt(i) != '[' && tmp.charAt(i) != ']') {
                a += tmp.charAt(i);
            }
        }

        String[] split = stringOfFour.split(",");

        this.bereich = split[0];
        this.vorlesung = split[1];
        this.dozent = split[2];
        this.anzahl = split[3];
        /*String bereich, String vorlesung, String dozent, String anzahl
        this.bereich = bereich;
        this.vorlesung = vorlesung;
        this.dozent = dozent;
        this.anzahl = anzahl;*/
    }


}
