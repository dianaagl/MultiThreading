import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Диана on 07.07.2017.
 */
public class Main {
    public static void main(String[] args){
        NumberStorage storage = new NumberStorage();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numeral;
        try {
            while ((numeral = reader.readLine()) != null) {

                synchronized (storage) {
                    storage.addNumber(numeral);

                }
                new SecondThread("SecondThread",storage).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
