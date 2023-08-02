package com.example.ban_hang.product.model;

public class ProductImage {
    private int idImage;
    private String urlImage;
    private int idProduct;

    public ProductImage() {
    }

    public ProductImage(int idImage, String urlImage, int idProduct) {
        this.idImage = idImage;
        this.urlImage = urlImage;
        this.idProduct = idProduct;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
