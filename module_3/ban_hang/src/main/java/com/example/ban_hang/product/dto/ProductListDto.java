package com.example.ban_hang.product.dto;

public class ProductListDto {
    private int id;
    private String code;
    private String name;
    private int price;
    private int inventory;
    private String description;
    private String nameType;
    private  String urlImage;

    public ProductListDto() {
    }

    public ProductListDto(int id, String code, String name, int price, int inventory, String description, String nameType, String urlImage) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.nameType = nameType;
        this.urlImage = urlImage;
    }

    public ProductListDto(String code, String name, int price, int inventory, String description, String nameType, String urlImage) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.nameType = nameType;
        this.urlImage = urlImage;
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

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
