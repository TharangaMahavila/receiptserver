package se.lnu.receiptserver.model;

import java.util.List;

public class MenuItem {

    private int itemId;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private boolean available;
    private List<Customization> availableCustomizations;

    public MenuItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Customization> getAvailableCustomizations() {
        return availableCustomizations;
    }

    public void setAvailableCustomizations(
            List<Customization> availableCustomizations) {

        this.availableCustomizations = availableCustomizations;
    }

    @Override
    public String toString() {
        return "MenuItem [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price
                + ", imageUrl=" + imageUrl + ", available=" + available + ", availableCustomizations=" + availableCustomizations + "]";
    }

    
}