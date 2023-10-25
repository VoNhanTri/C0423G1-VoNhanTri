import  {useEffect, useState} from "react";
import {getAll} from "../../service/CustomerService.jsx";
import {Link} from "react-router-dom";
import {Card} from "react-bootstrap";
import {DeleteCustomer} from "./DeleteCustomer.jsx";

export function Customer() {
    const [customer, setCustomer] = useState([]);
    const [name, setName] = useState("");


    const [status, setStatus] = useState(false);
    const [selectCustomer, setSelectCustomer] = useState(null);




    useEffect(() => {
        display()
    }, [name]);


    const display = async () => {
        const res = await getAll(name);
        setCustomer(res);
    }

    // xoá modal
    const handleModal = async (value) => {
        setStatus(true);
        setSelectCustomer(value);
    }
    const closeModel = async () => {
        display()
        setStatus(false);
        setSelectCustomer(null);
    }
    // end xoa modal


    return (
        <>

            <h1 style={{textAlign: "center"}}>List Customer</h1>
            <div className="navbar navbar-inverse">
                <Link className="btn btn-outline-primary" to='/customer/add'>Add</Link>
            </div>
            <div className="d-flex justify-content-end">
                <input className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}}
                       placeholder='Search ...'
                       type='text' onChange={(event) => setName(event.target.value)}/>
            </div>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Date Birth</th>
                    <th>Gender</th>
                    <th>Identity</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Type Customer</th>
                    <th colSpan={2}>Function</th>
                </tr>
                </thead>
                <tbody>
                {
                    customer.map((customers, index) => (
                        <tr key={customers.id}>
                            <td>{index + 1}</td>
                            <td>{customers.name}</td>
                            <td>{customers.date}</td>
                            <td>{customers.gender}</td>
                            <td>{customers.identity}</td>
                            <td>{customers.phone}</td>
                            <td>{customers.email}</td>
                            <td>{customers.address}</td>
                            <td>{customers.typeCustomer.name}</td>
                            <td><Link to={`/customer/edit/${customers.id}`}><i
                                className="me-5 fa-regular fa-pen-to-square"
                                style={{
                                    color: "#dca73a",
                                    fontSize: 25
                                }}></i></Link>
                            </td>
                            <td><Card.Link href="#" type="button" onClick={() => handleModal(customers)}><i
                                className="me-5 fa-solid fa-trash-can"
                                style={{color: "#fd2008", fontSize: 25,}}></i></Card.Link></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>

            <DeleteCustomer
                show={status}
                select={selectCustomer}
                handleClose={closeModel}
            ></DeleteCustomer>



        </>
    )
}