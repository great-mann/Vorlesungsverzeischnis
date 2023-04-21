import java.io.*;
import java.lang.reflect.Array;
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

    public List<String> titles() { // TODO verkürzen .indexof
        String[] tmp = file.toString().replaceAll("\\[|\\]", "").split(", |,");
        ArrayList a = new ArrayList();
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
            if(a.contains(vorlesung) == false){
                a.add(vorlesung);
            }
            vorlesung = "";
        }
        Collections.sort(a);
        return a;
    }

    public Set<String> workaholics() { // TODO Done
        String[] tmp = file.toString().replaceAll("\\[|\\]", "").split(", |,");
        Set<String> end = new HashSet();
        int leftB, rightB;
        String dozent = "", duplicate = "";

        for(int i = 0; i < tmp.length; i++) {

            leftB = tmp[i].indexOf(":", tmp[i].indexOf(":") + 1) + 1;
            rightB =tmp[i].indexOf(":", (tmp[i].indexOf(":", leftB + 1)));
            for(int j = leftB; j < rightB; j++) {
                dozent += tmp[i].charAt(j);
            }
            // Duplicate
            for (int j = i + 1; j < tmp.length; j++) {
                leftB = tmp[j].indexOf(":", tmp[j].indexOf(":") + 1) + 1;
                rightB =tmp[j].indexOf(":", (tmp[j].indexOf(":", leftB + 1)));
                for(int k = leftB; k < rightB; k++) {
                    duplicate += tmp[j].charAt(k);
                }
                if(dozent.equals(duplicate)) {
                    end.add(duplicate);
                }
                duplicate = "";
            }

           // System.out.println(tmp[i] + "  Index"+ leftB + " index" + rightB + " " + charstoString);
            dozent = "";
        }
        return end;
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
        System.out.println(a.workaholics());
    }
}