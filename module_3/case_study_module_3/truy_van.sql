use furama;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from staff
where name_staff like 'h%' or name_staff like 't%' or name_staff like 'k%' 
and length(name_staff) <15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*
from customer
where dress_customer like "%Đà Nẵng" or dress_customer like "%Quảng Trị"
and datediff(now(),date_customer/365) >18 and datediff(now(), date_customer/365)<50;
