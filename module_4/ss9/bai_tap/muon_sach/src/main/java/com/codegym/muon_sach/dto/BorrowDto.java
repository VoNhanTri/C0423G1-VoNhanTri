package com.codegym.muon_sach.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BorrowDto implements Validator {
    private int code;
    private String nameBook;
    private String nameCustomer;
    private boolean status;

    public BorrowDto(int code, String nameBook, String nameCustomer, boolean status) {
        this.code = code;
        this.nameBook = nameBook;
        this.nameCustomer = nameCustomer;
        this.status = status;
    }

    public BorrowDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
