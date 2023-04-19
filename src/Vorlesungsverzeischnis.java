import java.io.*;
import java.util.*;

public class Vorlesungsverzeischnis {

    String dateiName = "C:/Users/janne/IdeaProjects/Vorlesungsverzeichnis/src/text.txt";

    Set<Vorlesung> Vorlesungen;

    public static List<List<String>> load(String filename) throws IOException {
        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line=br.readLine(); line!=null; line=br.readLine())
            result.add(Arrays.asList(line.split(":")));
        br.close();
        return result;
    }
    public Vorlesungsverzeischnis(String dateiName) throws TextFileFormatException, IOException{
        this.Vorlesungen = new HashSet<>();



        try (BufferedReader ein = new BufferedReader(new FileReader(dateiName))){
            String zeile;
            while ((zeile = ein.readLine()) != null){
                if(zeile.split(":").length != 4){
                    throw new TextFileFormatException(1);
                    //throw new TextFileFormatException("Anzahl der Parametern zu Groß ");
                }
                String studienGruppe = zeile.split(":")[0];
                String vorlesungsTitel = zeile.split(":")[1];
                String dozentName = zeile.split(":")[2];
                int teilnehmerAnzahl = Integer.parseInt(zeile.split(":")[3]);

                Vorlesung vorlesung = new Vorlesung(studienGruppe, vorlesungsTitel, dozentName, teilnehmerAnzahl);

                this.Vorlesungen.add(vorlesung);

            }

        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new TextFileFormatException(3);
        }


    }

    public List<String> titles() {
        return null;
    }

    public Set<String> workaholics() {

        return null;
    }

    public Map<String, List<String>> groupToTitles() {

        return null;
    }

    public Map<String, List<String>> multipleTitles() {

        return null;
    }


    public List<String> descendingTitles() {

        return null;
    }



    public static void main(String[] args) throws TextFileFormatException, IOException {
        Vorlesungsverzeischnis a = new Vorlesungsverzeischnis("text.txt");
            load(a.dateiName);
    }



}
