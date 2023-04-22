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

        try {
            this.filename = fileName;
            this.tmp = load(this.filename);
            for (int i = 0; i < this.tmp.size(); i++) {
                String s = this.tmp.get(i).toString();
                this.file.add(new Vorlesung(s));
            }
            this.vorlesung = file.toString().replaceAll("\\[|\\]", "").split(", |,");

        } catch(TextFileFormatException e){
            System.out.println(e.getMessage());
        }

    }

    public List<String> titles() { //Habe ich ein bisschen schoener gemacht
        List<String> erg = new ArrayList<String>();
        for (Vorlesung zeile : file) {
            String[] spalten = zeile.toString().split(":");
            String title = spalten[1];
            if (!erg.contains(title)) {
                erg.add(title);
            }
        }
        Collections.sort(erg);
        return erg;
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

    public Map<String, List<String>> groupToTitles() {
        Map<String, List<String>> erg = new HashMap<>();
        for(Vorlesung zeile : file){
            String gruppe = zeile.getBereich();
            String titel = zeile.getTitel();
            if(!erg.containsKey(gruppe)){
                erg.put(gruppe, new ArrayList<>());
            }
            if(erg.get(gruppe) != null && !erg.get(gruppe).contains(titel)){
                erg.get(gruppe).add(titel);

            }

        }



            return erg;
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
        System.out.println(a.titles());
       // System.out.println(load(a.filename));
        //System.out.println(a.file.toArray()[0]);
        //System.out.println(a.file.toString());
        System.out.println(a.groupToTitles().toString());

        //System.out.println(a.workaholics());
        //System.out.println(a.groupToTitles());
    }
}