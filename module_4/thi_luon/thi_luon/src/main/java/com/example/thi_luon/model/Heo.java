package com.example.thi_luon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Heo {
    @Id
    private int id;
    private String maHeo;
    private String ngayNhap;
    private String trongLuongNhap;
    private String ngayXuat;
    private String trongLuongXuat;
    private XuatXu xuatXu;
}
