import java.io.Serializable;

public class Country implements Serializable {
    private String startIp;
    private String endIp;
    private String startByte;
    private String endByte;
    private String countryCode;
    private String country;

    public Country() {
    }

    public Country(String startIp, String endIp, String startByte, String endBytes, String countryCode, String country) {
        this.startIp = startIp;
        this.endIp = endIp;
        this.startByte = startByte;
        this.endByte = endBytes;
        this.countryCode = countryCode;
        this.country = country;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getStartByte() {
        return startByte;
    }

    public void setStartByte(String startByte) {
        this.startByte = startByte;
    }

    public String getEndBytes() {
        return endByte;
    }

    public void setEndBytes(String endBytes) {
        this.endByte = endByte;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        return startIp + "," + endIp + "," + startByte + "," + endByte + "," + countryCode + "," + country + "\n";
    }
}