import java.io.*;
import java.util.*;
//Andres Eisenmann
//Jannes Müller

public class Vorlesungsverzeichnis {

    String filename;
    String[] vorlesung;
    Set<Vorlesung> file = new HashSet<>();
    List<List<String>> tmp;


    public static List<List<String>> load(String filename) throws IOException {
        List<List<String>> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line = br.readLine(); line != null; line = br.readLine())
            result.add(Arrays.asList(line.split(":")));
        br.close();
        return result;
    }

    public Vorlesungsverzeichnis(String fileName) throws TextFileFormatException, IOException {
        this.filename = fileName;
        this.tmp = load(this.filename);
        for (int i = 0; i < this.tmp.size(); i++) {

            String s = this.tmp.get(i).toString();
            this.file.add(new Vorlesung(s));
        }
        this.vorlesung = file.toString().replaceAll("[\\[\\]]", "").split(", |,");
    }

    public List<String> titles() { //Jetzt ists nochj kürzer
        List<String> title = new ArrayList();
        for (Vorlesung zeile : file) {
            if (!title.contains(zeile.getTitel())) {
                title.add(zeile.getTitel());
            }
        }
        Collections.sort(title);
        return title;
    }


    public Set<String> workaholics() {
        Set<String> end = new HashSet<>();

        for (Vorlesung zeile : file) {
            Iterator<Vorlesung> iterator = file.iterator();
            while (iterator.hasNext()) {
                Vorlesung zeile1 = iterator.next();
                if (zeile1 == zeile) {
                    continue; // skip current element
                }
                if (zeile.getDozent().equals(zeile1.getDozent())) {
                    end.add(zeile.getDozent());
                }
            }
        }
        return end;
    }

    public Map<String, List<String>> groupToTitles() {
        Map<String, List<String>> erg = new HashMap<>();
        for (Vorlesung zeile : file) {
            String gruppe = zeile.getBereich();
            String titel = zeile.getTitel();
            if (!erg.containsKey(gruppe)) {
                erg.put(gruppe, new ArrayList<>());
            }
            if (erg.get(gruppe) != null && !erg.get(gruppe).contains(titel)) {
                erg.get(gruppe).add(titel);
            }
        }
        return erg;
    }

    public Map<String, List<String>> multipleTitles() {
        Map<String, List<String>> erg = new HashMap<>();
        for (Vorlesung zeile : file) {
            String titel = zeile.getTitel();
            String dozent = zeile.getDozent();
            if (!erg.containsKey(titel)) {
                erg.put(titel, new ArrayList<>());
            }
            if (erg.get(titel) != null && !erg.get(titel).contains(dozent)) {
                erg.get(titel).add(dozent);

            }
        }
        return erg;
    }

    public List<String> descendingTitles() {
        List<String> list = new ArrayList();
        List<Integer> anzahl = new ArrayList();

        for (Vorlesung zeile : file) {
            anzahl.add(Integer.parseInt(zeile.getAnzahl()));
        }
        Collections.sort(anzahl);
        Collections.reverse(anzahl);
        for(int i = 0; i < anzahl.size(); i++) {
            for (Vorlesung zeile : file) {
                if(Integer.parseInt(zeile.getAnzahl()) == anzahl.get(i)) {
                    list.add(zeile.getTitel());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws TextFileFormatException, IOException {
        Vorlesungsverzeichnis a = new Vorlesungsverzeichnis("text.txt");
        System.out.println(a.titles());
        // System.out.println(load(a.filename));
        //System.out.println(a.file.toArray()[0]);
        //System.out.println(a.file.toString());
        System.out.println(a.groupToTitles().toString());
        System.out.println(a.multipleTitles().toString());


        //System.out.println(a.workaholics());
        //System.out.println(a.groupToTitles());
    }
}