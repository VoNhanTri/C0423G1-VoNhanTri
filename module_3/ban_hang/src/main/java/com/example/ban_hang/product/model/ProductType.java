package com.example.ban_hang.product.model;

public class ProductType {
    private int idType;
    private String nameType;

    public ProductType() {
    }

    public ProductType(int idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
