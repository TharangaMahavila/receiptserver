package se.lnu.receiptserver.model;
public class Customization {

    private String customizationId;
    private String name;
    private String type;
    private double price;

    public Customization() {}

    public Customization(String customizationId, String name, String type, double price) {
        this.customizationId = customizationId;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // getters and setters
    public String getCustomizationId() { return customizationId; }
    public void setCustomizationId(String customizationId) { this.customizationId = customizationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Customization [customizationId=" + customizationId + ", name=" + name + ", type=" + type + ", price="
                + price + "]";
    }

    
}
