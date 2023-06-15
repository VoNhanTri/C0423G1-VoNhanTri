create database quan_ly_vat_tu;
create table phieu_xuat(
so_px int primary key,
ngay_xuat date
);
create table vat_tu(
ma_vat_tu varchar(50) primary key,
ten_vat_tu varchar(50)
);
create table chi_tiet_phieu_xuat(
so_px int,
ma_vat_tu varchar(50),
dg_xuat varchar(50),
sl_xuat varchar(50),
primary key(so_px, ma_vat_tu),
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table phieu_nhap(
so_phieu_nhap int primary key,
ngay_nhap date
);
create table chi_tiet_phieu_nhap(
so_pn int,
ma_vat_tu varchar(50),
dg_nhap varchar(50),
sl_nhap varchar(50),
primary key (so_pn, ma_vat_tu),
foreign key (so_pn) references phieu_nhap(so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
drop table nha_cung_cap;
create table nha_cung_cap(
ma_nha_cc varchar(50) primary key,
ten_nha_cc varchar(50),
dia_chi varchar(50),
sdt varchar(12)
);
create table don_dat_hang(
so_don_hang int primary key,
ngay_don_hang date,
ma_nha_cc varchar(50),
foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);
create table chi_tiet_don_dat_hang(
so_don_hang int,
ma_vat_tu varchar(50),
primary key (so_don_hang, ma_vat_tu),
foreign key (so_don_hang) references don_dat_hang(so_don_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table sdt(
sdt varchar(50) primary key,
ma_nha_cc varchar(50),
foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);
