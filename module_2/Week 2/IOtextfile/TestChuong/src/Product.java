//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.Serializable;

public class Product implements Serializable {
    String productCode;
    String productName;
    String manufacture;
    double price;
    String description;

    public Product(String productCode, String productName, String manufacture, double price, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacture = manufacture;
        this.price = price;
        this.description = description;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacture() {
        return this.manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Product{productCode='" + this.productCode + "', productName='" + this.productName + "', manufacture='" + this.manufacture + "', price=" + this.price + ", description='" + this.description + "'}";
    }
}
