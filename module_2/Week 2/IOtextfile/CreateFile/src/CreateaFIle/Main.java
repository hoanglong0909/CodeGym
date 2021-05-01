package CreateaFIle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        File file = new File("long.txt");
        if(file.exists()){
            System.out.println("file exists");
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file not fount");
        }

        // ghi du lieu vào file;

        
        FileOutputStream fos = null ;
        Scanner sc = new Scanner(System.in) ;
        try {
            fos = new FileOutputStream("test.txt",true);
            for(;;){
                System.out.println("Insert line into File");
                String line = sc.nextLine() + "\n";
                byte[] b = line.getBytes();
                fos.write(b);
                System.out.println("continue: Y/N:");
                String choose = sc.nextLine();
                if(choose.equalsIgnoreCase("N")){
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
