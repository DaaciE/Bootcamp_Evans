package org.example;

public class Product {
    private String sku;
    private String clothingItem;
    private double price;
    private String category;

    public Product(String sku, String clothingItem, double price, String category) {
        this.sku = sku;
        this.clothingItem = clothingItem;
        this.price = price;
        this.category = category;
    }

    public String getSku() {
        return sku;
    }


    public String getClothingItem() {
        return clothingItem;
    }
    public void setClothingItem(String clothingItem) {
        this.clothingItem = clothingItem;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
