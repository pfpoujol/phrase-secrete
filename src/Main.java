import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Random;

public class Main {
    public static void main(String... aArgs) throws IOException {
        try {
            System.out.println("Quel niveau de complexité pour votre phrase secrète ?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
            if(input > 0){
                Passphrase ds = new Passphrase(input);
                System.out.println("Votre phrase secrète : " + ds.getPassphrase());
            } else {
                System.out.println("Désolé vous devez donner un chiffre positif et différent de 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Désolé vous devez donner un chiffre.");
        }
    }
}
