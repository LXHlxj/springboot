package org.xmldata.mode;

public class TableName {
    private int id;
    private String phonename;
    private String strorage;
    private int quantity;
    private String price;
    private String SystemVersion;
    private String cpu;
    private String gpu;
    private String intertype;
    private String colour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonename() {
        return phonename;
    }

    public void setPhonename(String phonename) {
        this.phonename = phonename;
    }

    public String getStrorage() {
        return strorage;
    }

    public void setStrorage(String strorage) {
        this.strorage = strorage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSystemVersion() {
        return SystemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        SystemVersion = systemVersion;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getIntertype() {
        return intertype;
    }

    public void setIntertype(String intertype) {
        this.intertype = intertype;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "TableName{" +
                "id=" + id +
                ", phonename='" + phonename + '\'' +
                ", strorage='" + strorage + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                ", SystemVersion='" + SystemVersion + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", intertype='" + intertype + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
