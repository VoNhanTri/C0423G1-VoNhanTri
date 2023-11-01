import {useEffect, useState} from "react";
import {getAll, getAllType} from "../service/ProductService";
import {Link} from "react-router-dom";

export function ProductList() {
    const [product, setProduct] = useState([]);

    const [name, setName] = useState('');
    const [type, setType] = useState([]);
    const [searchType, setSearchType] = useState('');



    useEffect(() => {
        display();
        displayType();
    }, [name]);

    const display = async () => {
        const res = await getAll(name);
        setProduct(res)
    }
    const displayType = async () => {
        const res = await getAllType();
        setType(res);
    }

    return (
        <>

            <h1 style={{textAlign: "center"}}>List Product</h1>

            <div className="navbar navbar-inverse">
                <Link to='/product/add' className='btn btn-outline-primary'>Add</Link>
            </div>
            <div className="d-flex justify-content-end">
                <div style={{marginRight: "10px"}}>
                    <input className='input-group-text' type='text' onChange={(value) => {
                        setName(value.target.value)
                    }}/>
                </div>
                {/*<div style={{marginRight: "10px"}}>*/}
                {/*    <select className='select form-select-sm' onChange={(va) => {*/}
                {/*        setSearchType(va.target.value)*/}
                {/*    }}>*/}
                {/*        <option value=''>Type</option>*/}
                {/*        {type.map((type) => {*/}
                {/*            return (*/}
                {/*                <option key={type.id} value={type.id}>{type.name}</option>*/}
                {/*            )*/}
                {/*        })}*/}
                {/*    </select>*/}
                {/*</div>*/}
            </div>

            <table className="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Date</th>
                    <th>Type</th>
                </tr>
                </thead>
                <tbody>
                {
                    product.length !== 0 ?
                        product.map((product, index) => (
                            <tr key={product.id}>
                                <td>{index + 1}</td>
                                <td>{product.code}</td>
                                <td>{product.name}</td>
                                <td>{product.quantity}</td>
                                <td>{product.price}</td>
                                <td>{product.date}</td>
                                <td>{product.typeProduct.name}</td>
                            </tr>
                        ))
                    : (<p>No Data</p>)
                }
                </tbody>
            </table>

        </>
    )
}