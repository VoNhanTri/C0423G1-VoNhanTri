package com.codegym.hom_thu_dien_tu.model;

public class MailBox {
    private int id;
    private String languages;
    private String sizePage;
    private String spams;
    private String signature;

    public MailBox(int id, String languages, String sizePage, String spams, String signature) {
        this.id = id;
        this.languages = languages;
        this.sizePage = sizePage;
        this.spams = spams;
        this.signature = signature;
    }

    public MailBox() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSizePage() {
        return sizePage;
    }

    public void setSizePage(String sizePage) {
        this.sizePage = sizePage;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
