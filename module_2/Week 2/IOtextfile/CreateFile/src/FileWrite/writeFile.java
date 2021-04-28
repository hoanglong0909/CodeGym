package FileWrite;

import java.io.*;
import java.util.Scanner;

public class writeFile {
    public static void main(String[] args) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        File file;
        Scanner sc = new Scanner(System.in);
        try {
            writer = new FileWriter("test.txt",true);
            bufferedWriter = new BufferedWriter(writer);
            for (;;){
                System.out.println("Insert line into File");
                String line = sc.nextLine()+ "\n";
                writer.write(line);
                System.out.println("continue: Y/N:");
                String choose = sc.nextLine();
                if ((choose.equalsIgnoreCase("N"))){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }if(bufferedWriter != null){
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
