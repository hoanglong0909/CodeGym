import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    public static void main(String[] args) {


        try {
            FileInputStream fis = new FileInputStream("country.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);


            List<Country> result =(ArrayList) ois.readObject();

            for (Country obj: result
            ) {
                System.out.println(obj);
            }
//            while (fis.available()> 0){
//               Country obj =(Country) ois.readObject();
//                System.out.println(obj);
//            }

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}