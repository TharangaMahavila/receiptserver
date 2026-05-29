package se.lnu.receiptserver.model;

import java.util.List;

public class OrderItem {

    private int quantity;
    private String itemName;
    private double basePrice;
    private MenuItem menuItem;
    private List<Customization> customizations;

    // Getters and setters
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public MenuItem getMenuItem() { return menuItem; }
    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public List<Customization> getCustomizations() { return customizations; }
    public void setCustomizations(List<Customization> customizations) { this.customizations = customizations; }

    public double getTotalPrice() {
        double total = basePrice;
        if (customizations != null) {
            for (Customization c : customizations) {
                total += c.getPrice();
            }
        }
        return total * quantity;
    }
}