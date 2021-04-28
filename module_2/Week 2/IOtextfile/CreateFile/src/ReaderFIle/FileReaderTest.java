package ReaderFIle;
import java.io.*;
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader("test.txt");
            bufferedReader = new BufferedReader(reader);

//            String line = bufferedReader.readLine();
//            System.out.println(line);
            String line;
            while ((line = bufferedReader.readLine()) != null){
//                System.out.println(line);
              String[] str =  line.split(",");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } if(bufferedReader != null){
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
