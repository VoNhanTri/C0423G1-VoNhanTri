create database quan_ly_vat_tu;
CREATE TABLE phieu_xuat (
    so_px INT PRIMARY KEY,
    ngay_xuat DATE
);
CREATE TABLE vat_tu (
    ma_vat_tu VARCHAR(50) PRIMARY KEY,
    ten_vat_tu VARCHAR(50)
);
CREATE TABLE chi_tiet_phieu_xuat (
    so_px INT,
    ma_vat_tu VARCHAR(50),
    dg_xuat VARCHAR(50),
    sl_xuat VARCHAR(50),
    PRIMARY KEY (so_px , ma_vat_tu),
    FOREIGN KEY (so_px)
        REFERENCES phieu_xuat (so_px),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE phieu_nhap (
    so_phieu_nhap INT PRIMARY KEY,
    ngay_nhap DATE
);
CREATE TABLE chi_tiet_phieu_nhap (
    so_pn INT,
    ma_vat_tu VARCHAR(50),
    dg_nhap VARCHAR(50),
    sl_nhap VARCHAR(50),
    PRIMARY KEY (so_pn , ma_vat_tu),
    FOREIGN KEY (so_pn)
        REFERENCES phieu_nhap (so_phieu_nhap),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
drop table nha_cung_cap;
CREATE TABLE nha_cung_cap (
    ma_nha_cc VARCHAR(50) PRIMARY KEY,
    ten_nha_cc VARCHAR(50),
    dia_chi VARCHAR(50),
    sdt VARCHAR(12)
);
CREATE TABLE don_dat_hang (
    so_don_hang INT PRIMARY KEY,
    ngay_don_hang DATE,
    ma_nha_cc VARCHAR(50),
    FOREIGN KEY (ma_nha_cc)
        REFERENCES nha_cung_cap (ma_nha_cc)
);
CREATE TABLE chi_tiet_don_dat_hang (
    so_don_hang INT,
    ma_vat_tu VARCHAR(50),
    PRIMARY KEY (so_don_hang , ma_vat_tu),
    FOREIGN KEY (so_don_hang)
        REFERENCES don_dat_hang (so_don_hang),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);

CREATE TABLE sdt (
    sdt VARCHAR(50) PRIMARY KEY,
    ma_nha_cc VARCHAR(50),
    FOREIGN KEY (ma_nha_cc)
        REFERENCES nha_cung_cap (ma_nha_cc)
);
