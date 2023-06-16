
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o_id, order_date,order_total_price
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, 
-- và danh sách sản phẩm được mua bởi các khách
select customer_name,p_name
from order_detail od
join `order` o on od.order_id = o.o_id
join product p on od.product_id = p.p_id
join customer c on o.customer_id = c.c_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào

select customer_name
from order_detail od
join `order`o on od.order_id = o.o_id
right join customer c on o.customer_id = c.c_id
where customer_id is null;