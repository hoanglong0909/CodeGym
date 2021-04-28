import java.io.Serializable;

public class ProductManagement implements Serializable {
    public String productCode;
    public String productName;
    public String manufacturer;
    public int price;

    public ProductManagement() {
    }

    public ProductManagement(String productCode, String productName, String manufacturer, int price) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String toString(){
        return productCode + " " + productName + " " + manufacturer+ " " + price + "\n";
    }
}