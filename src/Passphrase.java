import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
class Passphrase {
    private String passphrase;

    Passphrase(int complexityLevel) throws IOException {
        this.setPassphrase(complexityLevel);
    }
    String getPassphrase() {
        return passphrase;
    }

    private void setPassphrase(int complexityLevel) throws IOException {
        StringBuilder passphrase = new StringBuilder();
        // Génération de la phrase secrète itérativement en fonction de la complexité choisie.
        for(int i = 0; i < complexityLevel; ++i){
            (i == 0 ? passphrase.append(Passphrase.getDicewareWord()) : passphrase.append(" ")).append(Passphrase.getDicewareWord());
        }
        this.passphrase = passphrase.toString();
    }
    private static String random5DigitCode() {
        Random aRandom = new Random();
        StringBuilder fiveDigitCode = new StringBuilder();
        // Simule 5 lancés de dés successifs.
        for (int idx = 1; idx <= 5; ++idx){
            // get the range, casting to long to avoid overflow problems
            long range = (long) 6 - (long) 1 + 1;
            // compute a fraction of the range, 0 <= frac < range
            long fraction = (long) (range * aRandom.nextDouble());
            int randomNumber = (int) (fraction + 1);
            // Assemblage du nombre à cinq chiffres.
            fiveDigitCode.append(String.valueOf(randomNumber));
        }
        return fiveDigitCode.toString();
    }
    private static String getDicewareWord() throws IOException {
        String dicewareWord = "";
        String fileName = "C:\\Users\\pfpou\\Workspace\\Test\\tp-wordlist\\src\\francais.wordlist.asc";
        FileReader fileReader = new FileReader(fileName);
        String randomDigit = Passphrase.random5DigitCode();

        // Parcours du fichier wordlist.
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                // Récupère la portion de la ligne correspondant au mot.
                if(line.contains(randomDigit)) {
                    dicewareWord = line.substring(6);
                }
            }
        }
        return dicewareWord;
    }
}
