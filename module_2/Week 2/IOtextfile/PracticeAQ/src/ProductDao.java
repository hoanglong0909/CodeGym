import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao{
    public static final String PRODUCT_FILE_NAME = "product.txt";


    public void write(List<ProductManagement> productManagementList){
        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(PRODUCT_FILE_NAME),true);
//             oos = new ObjectOutputStream(fos);


            for (int i = 0; i < productManagementList.size() ; i++) {
                byte[] b = productManagementList.get(i).toString().getBytes();
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
//            closeStream(oos);
        }
    }

    public List<ProductManagement> read(){
        List<ProductManagement> productManagementList = new ArrayList<>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(PRODUCT_FILE_NAME));
            int code;
            while ((code=fis.read())!=-1){
                System.out.print((char)code);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
        }
        return productManagementList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}