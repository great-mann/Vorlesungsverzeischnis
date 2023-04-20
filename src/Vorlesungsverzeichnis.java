import java.io.*;
import java.util.*;

public class Vorlesungsverzeichnis {

    String dateiName = "C:/Users/janne/IdeaProjects/Vorlesungsverzeichnis/src/text.txt";
    String filename = "C:/Users/janne/IdeaProjects/Vorlesungsverzeichnis/src/text.txt";

    Set<Vorlesung> file = new HashSet<>();
    List<List<String>> tmp = new ArrayList<List<String>>();


    public static List<List<String>> load(String filename) throws IOException {
        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line=br.readLine(); line!=null; line=br.readLine())
            result.add(Arrays.asList(line.split(":")));
        br.close();
        return result;
    }
    public Vorlesungsverzeichnis(String fileName) throws TextFileFormatException, IOException{
        this.filename = fileName;
        this.tmp = load(this.filename);
        for (int i = 0; i < this.tmp.size(); i++) {
            //for (int j = 0; j < 5; j++) {
            //this.file.add((Vorlesung) this.tmp.indexOf(i));
            String s = this.tmp.get(i).toString();
            this.file.add(new Vorlesung(s));
            //}
        }

        /*try (BufferedReader ein = new BufferedReader(new FileReader(dateiName))){
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
*/

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
        Vorlesungsverzeichnis a = new Vorlesungsverzeichnis("text.txt");
        //System.out.println(a.tmp.get(1).get(2));
        //System.out.println(a.tmp.get(1).toString());
        //System.out.println(a.file.toArray()[0]);
        System.out.println(a.file.toString());
    }



}
