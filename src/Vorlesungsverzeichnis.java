import java.io.*;
import java.util.*;

public class Vorlesungsverzeichnis {

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
    //TODO Done, I think
    public Vorlesungsverzeichnis(String fileName) throws TextFileFormatException, IOException{
        this.filename = fileName;
        this.tmp = load(this.filename);
        for (int i = 0; i < this.tmp.size(); i++) {
            String s = this.tmp.get(i).toString();
            this.file.add(new Vorlesung(s));
        }
    }

    public List<String> titles() { // Almost Done
        String[][] end = new String[file.size()][2];  // end[0][0] => Vorlesung end[0][1] => complete String
        String[] tmp = file.toString().replaceAll("\\[|\\]", "").split(", |,");
        ArrayList a = new ArrayList<>();
        String vorlesung = "";

        for(int i = 0; i < file.size(); i++) {
            for (int j = 0; j < tmp[i].length(); j++) {
                if(tmp[i].charAt(j) == ':') {
                    for(int k = j; k < tmp[i].length(); k++) {
                        vorlesung += tmp[i].charAt(k + 1);
                        if (tmp[i].charAt(k + 2) == ':') {
                            break;
                        }
                    }
                    break;
                }
            }
            end[i][0] = vorlesung;
            end[i][1] = tmp[i];
            vorlesung = "";
        }
        for(int i = 0; i < file.size(); i++) {
            for(int j = 0; j < 2; j++) {
                System.out.println(end[i][j]);
            }
            a.add(end[i][0] + ";" + end[i][1]);
        }
        // TODO in a sind jetzt noch immer am anfang die vorlesungsnamen, die müssen nach dem sortieren wieder deleted werden
        Collections.sort(a);
        System.out.println(a);
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
       // System.out.println(load(a.filename));


        //System.out.println(a.file.toArray()[0]);
        //System.out.println(a.file.toString());
        System.out.println(a.titles());

    }



}
