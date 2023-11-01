import {useEffect, useState} from "react";
import {getAll, getAllType} from "../service/GoodsService.jsx";
import {DeleteGoods} from "./DeleteGoods.jsx";

export function GoodsList() {
    const [goods, setGoods] = useState([]);

    const [name, setName] = useState('');
    const [type, setType] = useState([]);
    const [searchType, setSearchType] = useState('')


    const [status, setStatus] = useState(false);
    const [select,setSelect] = useState(null);
    
    const handleDelete = async (data) => {
      setStatus(true);
      setSelect(data);
    }

    const notDelete =  () => {
        display();
        setStatus(false);
        setSelect(null);
    }


    useEffect(() => {
        displayType()
    }, []);

    useEffect(() => {
        display()
    }, [name, searchType]);

    const displayType = async () => {
        const res = await getAllType();
        setType(res)
    }
    const display = async () => {
        const res = await getAll(name, searchType);
        setGoods(res)
    }

    return (
        <>
            <a href='goods/add' className='btn btn-outline-primary'>Add</a>
            <div>
                <input className='input-group-text' type='text' onChange={(value) => {
                    setName(value.target.value)
                }}/>
            </div>
            <select className='select' onChange={(value) => {
                setSearchType(value.target.value)
            }}>
                <option value=''>Loại</option>
                {type.map((type) => {
                    return (
                        <option key={type.id} value={type.id}> {type.name}</option>
                    )
                })}
            </select>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã Hàng Hoá</th>
                    <th>Tên Hàng Hoá</th>
                    <th>Đơn Vị Tính</th>
                    <th>Giá(VNĐ/kg</th>
                    <th>Ngày Thu Hoạch</th>
                    <th>Loại Sản Phẩm</th>
                    <th>Functiob</th>
                </tr>
                </thead>
                <tbody>
                {
                    goods.map((goods, index) => (
                        <tr key={goods.id}>
                            <td>{index + 1}</td>
                            <td>{goods.code}</td>
                            <td>{goods.name}</td>
                            <td>{goods.unit}</td>
                            <td>{goods.price}</td>
                            <td>{goods.date}</td>
                            <td>{goods.type.name}</td>
                            <td><button onClick={()=>{handleDelete(goods)}} className='btn btn-outline-danger'>Xoá</button></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>

            <DeleteGoods
            show = {status}
            handle={notDelete}
            select ={select}
            >
            </DeleteGoods>
        </>
    )
}