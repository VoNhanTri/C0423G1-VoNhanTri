import {useEffect, useState} from "react";
import {getAll} from "../../service/ContractService.jsx";
import {Link} from "react-router-dom";

export function Contract() {
    const [contract, setContract] = useState([]);
    useEffect(() => {
        getContract();
    }, []);
    const getContract = async () => {
        setContract(await getAll())
    };
    return (
        <div>
            <h1>Hiển Thị Danh Sách Hợp Đồng</h1>
            <div  className="navbar navbar-inverse">
            <Link className="btn btn-outline-primary" to='/contract/add'>Add</Link>
            </div>
            <table className="table table-hover" >
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
                {
                    contract.map((c,index)=>(
                        <tr key={c.id}>
                            <td>{index+1}</td>
                            <td>{c.hopDong}</td>
                            <td>{c.batDau}</td>
                            <td>{c.ketThuc}</td>
                            <td>{c.datCoc}</td>
                            <td>{c.tong}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}