package com.example.ban_hang.product.model;

public class Product {


    private String urlImage;
    private int id;
    private String code;
    private String name;
    private int price;
    private int inventory;
    private String description;
    private int available;
    private int productType;

    public Product() {
    }

    public Product(int id, String code, String name, int price, int inventory, String description, int productType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.productType = productType;
    }

    public Product(String code, String name, int price, int inventory, String description, int productType) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.productType = productType;
    }

    public Product(String code, String name, int price, int inventory, String description, int available, int productType) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.available =  available;
        this.productType = productType;
    }

    public Product(String code, String name, int price, int inventory, String description, int productType, String urlImage) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.urlImage = urlImage;
        this.productType = productType;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }


}
