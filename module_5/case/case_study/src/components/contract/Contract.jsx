import React from 'react';

function Contract(props) {
    return (
        <div>
            <h1>Hiển Thị Danh Sách Hợp Đồng</h1>
            <table>
                <thead>
                <tr>
                    <th>Số Hợp Đồng</th>
                    <th>Ngày Bắt Đầu</th>
                    <th>Ngày Kết Thúc</th>
                    <th>Số Tiền Cọc Trước</th>
                    <th>Tổng Tiền Thanh Toán</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                </tbody>
            </table>
        </div>
    );
}

export default Contract;