import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.*;

public class ProductManager{
    public static Scanner sc = new Scanner(System.in);
    public List<ProductManagement> productManagementList = new ArrayList<>();
    public ProductDao productDao = new ProductDao();

    public List<ProductManagement> getProductManagementList()
    {
        return productManagementList;
    }

    public void setProductManagementList(List<ProductManagement> productManagementList) {
        this.productManagementList = productManagementList;
    }

    //thêm sản phẩm
    public void add(){
        System.out.println("Mã sản phẩm: ");
        String productCode = sc.nextLine();
        System.out.println("Tên sản phẩm: ");
        String productName = sc.nextLine();
        System.out.println("Nơi sản xuất: ");
        String manufacturer = sc.nextLine();
        System.out.println("Giá: ");
        int price = sc.nextInt();
        ProductManagement productManagement = new ProductManagement(productCode,productName,manufacturer,price);
        productManagementList.add(productManagement);
        productDao.write(productManagementList);
    }

    //sửa sản phẩm
    public void edit(String productCode){


        boolean isExisted = false;
        int size = productManagementList.size();
        System.out.println(size);
        for (int i = 0; i < size ; i++) {
            if(productManagementList.get(i).getProductCode().equals(productCode)){

                isExisted = true;
                productManagementList.get(i).setProductName(sc.nextLine());
                productManagementList.get(i).setManufacturer(sc.nextLine());
                productManagementList.get(i).setPrice(sc.nextInt());
                break;

            }
        }
        if (!isExisted) {
            System.out.println("productCode = not existed.\n" +  productCode);
        } else {
            productDao.write(productManagementList);
        }
    }


    //Hiển thị sản phẩm
    public void show(){
        productDao.read();
    }
    //Tìm kiếm sản phẩm
    public void search(String productCode){

    }

    //Menu
    public void showMenu(){
        System.out.println("***********Menu***********");
        System.out.println("1. Thêm sản phẩm.");
        System.out.println("2. Chỉnh sửa thông tin sản phẩm.");
        System.out.println("3. Hiển thị sản phẩm.");
        System.out.println("4. Tìm kiếm sản phẩm sản phẩm.");
        System.out.println("0. Exit");
    }
}
