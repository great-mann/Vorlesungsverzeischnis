public class TextFileFormatException extends Exception {
    //TODO , wenn mehr als 4 Spalten
    public TextFileFormatException(int error) {
        switch(error) {
            case 1:
                // Spaltenanzahl zu viel/zu wenig
                System.out.println("Die Spaltenanzahl beträgt nicht 4");
                break;
            case 2:
                // Zu wenig Informationen
                System.out.println("Teile der Spalten haben keinen Inhalt");
                break;
            case 3:
                // Formatfehler
                System.out.println("In der Tabelle sind Formatfehler");
                break;
            default:
                // Falscher Fehlercode
                System.out.println("Falscher Fehlercode");
        }

       // System.out.println(error);
    }
}
