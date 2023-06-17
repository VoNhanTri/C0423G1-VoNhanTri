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










