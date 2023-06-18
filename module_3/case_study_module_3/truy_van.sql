use furama;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from staff
where name_staff like 'h%' or name_staff like 't%' or name_staff like 'k%' 
and length(name_staff) <15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*
from customer
where (dress_customer like "%Đà Nẵng" or dress_customer like "%Quảng Trị")
and datediff(now(),date_customer)/365>18 and datediff(now(), date_customer)/365<50;


-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select c.id_customer, c.name_customer, ct.name_type_customer, count(*) as so_lan_dat
from customer c
join customer_type ct on c.id_type_customer = ct.id_type_customer
 join contract con on  c.id_customer = con.id_customer
where ct.name_type_customer = "diamond"
group by con.id_customer
order by so_lan_dat;



-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
--  (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select c.id_customer, c.name_customer, ct.name_type_customer,
  con.id_contract,
  s.name_service,
  con.date_contract,
  con.date_end,
	s.expense_service + cd.quantity * aser.price
as tong_tien
from customer c
left join customer_type ct on c.id_type_customer = ct.id_type_customer
left join contract con on  c.id_customer = con.id_customer
left join service s on con.id_service = s.id_service
left join contract_detailed cd on con.id_contract = cd.id_contract
left join accompanied_service aser on cd.id_accompanied_service = aser.id_accompanied_service;


 -- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
 -- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select s.id_service, s.name_service, s.area_service,s.expense_service ,ts.name_type_service
from service s
left join type_service ts on s.id_type_service = ts.id_type_service;


-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

select s.id_service, s.name_service, s.area_service,s.maximum_service,s.expense_service ,ts.name_type_service
from service s
left join type_service ts on s.id_type_service = ts.id_type_service;


-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.

select distinct name_customer
from customer;

select name_customer
from customer 
group by name_customer;


-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select year(date_contract) as year, month(date_contract) as month, count(*) as count
from contract
where  (date_contract like "2021%")
group by year(date_contract), month(date_contract) 
order by month;


-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong,
--  ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
 
 select con.id_contract, con.date_contract, con.date_end, con.deposits, sum(cd.quantity)as sum_detailed
from contract con
left join contract_detailed cd on con.id_contract = cd.id_contract 
left join accompanied_service ac on cd.id_accompanied_service = ac.id_accompanied_service
 group by con.id_contract, con.date_contract, con.date_end, con.deposits;
 

