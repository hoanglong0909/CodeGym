//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager {
    public Manager() {
    }

    public static void main(String[] args) {
        try {
            String pathname = "product_list.txt";
            File file = new File(pathname);
            if (file.exists()) {
                System.out.println("File is already exists.");
            } else {
                file.createNewFile();
            }

            ArrayList<Product> products = new ArrayList<>();
            products.add(new Product("1", "IP2", "China", 10000.0D, "White"));
            products.add(new Product("2", "IP3", "China", 10000.0D, "Black"));
            products.add(new Product("3", "IP3", "China", 10000.0D, "Black"));
            loadProduct(pathname, products);
            System.out.println(displayProduct(pathname).toString());
        } catch (Exception var4) {
            System.out.println(var4.getMessage());
        }

    }

    public static void loadProduct(String path, ArrayList<Product> products) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.flush();
        oos.close();
        fos.close();
    }

    public static ArrayList<Product> displayProduct(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Product> products = new ArrayList();
        if (fis.available() > 0) {
            products = (ArrayList)ois.readObject();
        }

        ois.close();
        return products;
    }
}
