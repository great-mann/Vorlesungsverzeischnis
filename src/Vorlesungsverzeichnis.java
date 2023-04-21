import java.io.*;
import java.util.*;


public class Vorlesungsverzeichnis {

    String filename;
    String[] vorlesung;
    Set<Vorlesung> file = new HashSet<>();
    List<List<String>> tmp;


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
        this.vorlesung = file.toString().replaceAll("\\[|\\]", "").split(", |,");
    }

    public List<String> titles() { // TODO verkürzen .indexof
        ArrayList a = new ArrayList();
        String vorlesung = "";

        for(int i = 0; i < file.size(); i++) {
            for (int j = 0; j < this.vorlesung[i].length(); j++) {
                if(this.vorlesung[i].charAt(j) == ':') {
                    for(int k = j; k < this.vorlesung[i].length(); k++) {
                        vorlesung += this.vorlesung[i].charAt(k + 1);
                        if (this.vorlesung[i].charAt(k + 2) == ':') {
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
        Set<String> end = new HashSet();
        int leftB, rightB;
        String dozent = "", duplicate = "";

        for(int i = 0; i < vorlesung.length; i++) {

            leftB = vorlesung[i].indexOf(":", vorlesung[i].indexOf(":") + 1) + 1;
            rightB =vorlesung[i].indexOf(":", (vorlesung[i].indexOf(":", leftB + 1)));
            for(int j = leftB; j < rightB; j++) {
                dozent += vorlesung[i].charAt(j);
            }
            // Duplicate
            for (int j = i + 1; j < vorlesung.length; j++) {
                leftB = vorlesung[j].indexOf(":", vorlesung[j].indexOf(":") + 1) + 1;
                rightB = vorlesung[j].indexOf(":", (vorlesung[j].indexOf(":", leftB + 1)));
                for(int k = leftB; k < rightB; k++) {
                    duplicate += vorlesung[j].charAt(k);
                }
                if(dozent.equals(duplicate)) {
                    end.add(duplicate);
                }
                duplicate = "";
            }
            dozent = "";
        }
        return end;
    }

    public Map<String, List<String>> groupToTitles() { // TODO Versteh ich nicht
        Map<String, List<String>> titles = new HashMap<>();
        int leftB, rightB;
        List<String> title = new ArrayList();
        String group = "", t = "";

        for(int i = 0; i < vorlesung.length; i++) {
            rightB = vorlesung[i].indexOf(":");
            for(int k = 0; k < rightB; k++) {
                group += vorlesung[i].charAt(k);
            }
           /* leftB = vorlesung[i].indexOf(":");
            rightB = vorlesung[i].indexOf(":", vorlesung[i].indexOf(":") + 1);
            for(int k = 0; k < rightB; k++) {
                t += vorlesung[i].charAt(k);
            }
            title.add(t);
            System.out.println(group +"   "+ t);
            titles.put(group, title);
            t = "";*/
            group = "";
        }
        return titles;
    }

    public Map<String, List<String>> multipleTitles() {

        return null;
    }

    public List<String> descendingTitles() {
        List<String> list= new ArrayList();


        return list;
    }

    public static void main(String[] args) throws TextFileFormatException, IOException {
        Vorlesungsverzeichnis a = new Vorlesungsverzeichnis("text.txt");
       // System.out.println(load(a.filename));
        //System.out.println(a.file.toArray()[0]);
        //System.out.println(a.file.toString());

        //System.out.println(a.workaholics());
        System.out.println(a.groupToTitles());
    }
}