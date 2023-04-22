import java.util.List;

//TODO almost done
public class Vorlesung {
    private String bereich, titel, dozent, anzahl;

    public String toString() {
        return bereich + ":" + titel + ":" + dozent + ":" + anzahl;
    }

    public Vorlesung(String stringOfFour) throws TextFileFormatException{
        stringOfFour.replaceAll("\\[|\\]", ""); // deletes all "[" and "]"
        String[] split = stringOfFour.split("\\, |\\,");  // cuts the String in four parts ", " and ","

        // Saves all as an arraylike
        try {

            // Spaltenanzahl zu viel/zu wenig
            if (split.length != 4) {
                throw new TextFileFormatException("Spaltenanzahl zu viel/zu wenig");
            }
            for (int i = 0; i < split.length; i++) {
                if (split[i] == "") {
                    throw new TextFileFormatException("Teile der Spalten haben keinen Inhalt");
                }
            }


            this.bereich = split[0];
            this.titel = split[1];
            this.dozent = split[2];
            this.anzahl = split[3];
        } catch (TextFileFormatException e) {
            System.out.println(e.getMessage());
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
    public String getDozent(){
        return this.dozent;
    }
}
