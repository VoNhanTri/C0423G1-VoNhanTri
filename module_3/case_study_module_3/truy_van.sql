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
sum( (cd.quantity * aser.price)+ s.expense_service)
as total
from customer c
left join customer_type ct on c.id_type_customer = ct.id_type_customer
left join contract con on  c.id_customer = con.id_customer
left join service s on con.id_service = s.id_service
left join contract_detailed cd on con.id_contract = cd.id_contract
left join accompanied_service aser on cd.id_accompanied_service = aser.id_accompanied_service
group by c.id_customer, c.name_customer, ct.name_type_customer,
  con.id_contract,
  s.name_service,
  con.date_contract,
  con.date_end;


 -- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
 -- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select s.id_service, s.name_service, s.area_service,s.expense_service ,ts.name_type_service
from service s
left join type_service ts on s.id_type_service = ts.id_type_service;


-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

select s.id_service, s.name_service, s.area_service,s.maximum_service,s.expense_service ,ts.name_type_service
from service s
join contract con on s.id_service = con.id_service
join type_service ts on s.id_type_service = ts.id_type_service
where s.id_service not in(select id_service
from contract
where year(date_contract) = 2021)
group by s.id_service;
;


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
 
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

select aser.id_accompanied_service, aser.name_accomanied_service
from contract_detailed cd
join accompanied_service aser on cd.id_accompanied_service = aser.id_accompanied_service
join contract con on cd.id_contract = con.id_contract
join customer c on con.id_customer = c.id_customer
join customer_type ct on c.id_type_customer = ct.id_type_customer
where ct.name_type_customer like "Diamond" && c.dress_customer like "%Vinh" or c.dress_customer like "%Quảng Ngãi" ;

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- , so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất 
-- cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

select con.id_contract, s.name_staff, c.name_customer, c.number_phone_customer,ser.id_service, ser.name_service ,con.deposits, sum(cd.quantity) as count
from contract con
join customer c on con.id_customer = c.id_customer
join staff s on con.id_staff =  s.id_staff
join service ser on con.id_service = ser.id_service
join type_service ts on  ser.id_type_service = ts.id_type_service
left join contract_detailed cd on con.id_contract = cd.id_contract 
where con.date_contract between '2020-10-01' and '2020-12-31'
and ser.id_service not in(select ts.name_type_service
from contract con
join service serv on con.id_contract =  serv.id_service
where con.date_contract between '2021-01-01' and '2021-06-30'
)
group by con.id_contract, s.name_staff, c.name_customer, c.number_phone_customer,ser.id_service, ser.name_service,con.deposits
;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
--  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select aser.id_accompanied_service, aser.name_accomanied_service, sum(cd.quantity) as count
from accompanied_service aser
join contract_detailed cd on aser.id_accompanied_service = cd.id_accompanied_service
group by  aser.id_accompanied_service
order by count desc
limit 2;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select con.id_contract,ts.name_type_service,aser.name_accomanied_service, count(aser.id_accompanied_service)as count
from contract con
join service ser on con.id_service = ser.id_service
join type_service ts on ser.id_type_service = ts.id_type_service
join contract_detailed cd on con.id_contract = cd.id_contract
join accompanied_service aser on  cd.id_accompanied_service =  aser.id_accompanied_service
-- where cd.id_accompanied_service in(select aser.name_accomanied_service, count(*) as count
-- from accompanied_service aser 
-- join contract_detailed cd on aser.id_accompanied_service = cd.id_accompanied_service
-- group by aser.name_accomanied_service
-- having count(*) =1
--  )
group by con.id_contract,ts.name_type_service,aser.name_accomanied_service, aser.id_accompanied_service
having count(aser.id_accompanied_service)=1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select st.id_staff, st.name_staff, lv.name_level, p.name_part, st.number_phone_staff, st.dress_staff, count(*) as count
from staff st
join job_position jp on st.id_position = jp.id_position
join level lv on st.id_level = lv.id_level
join part p on st.id_part = p.id_part
join contract con on st.id_staff =  con.id_staff
where year(con.date_contract) between 2020 and 2021
group by st.id_staff, st.name_staff, lv.name_level, p.name_part, st.number_phone_staff, st.dress_staff
 having count(*) <3
;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
set sql_safe_updates = 0;
delete from staff
where id_staff not in (
select distinct id_staff
from contract
where year(date_contract) between 2019 and 2021
);
set sql_safe_updates = 1;
select*
from staff;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

create view update_customer as
select c.id_customer, c.name_customer, sum(aser.price* cd.quantity + s.expense_service) as total
from customer c
join customer_type ct on c.id_type_customer = ct.id_type_customer
join contract con on c.id_customer = con.id_customer
join contract_detailed cd on con.id_contract = cd.id_contract
join accompanied_service aser on cd.id_accompanied_service = aser.id_accompanied_service
join service s on con.id_service = s.id_service
where year(date_contract) = 2021
group by  con.id_customer, c.name_customer
;
update customer c
join customer_type ct on c.id_type_customer = ct.id_type_customer
join update_customer uc on c.id_customer = uc.id_customer
set c.id_type_customer = 1
where c.id_type_customer = 2 and uc.total > 10000000 ;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
delete c
from customer c
join contract con on c.id_customer = con.id_customer
where year(date_contract) <2021;
