import {useEffect, useState} from "react";
import {getAll, getSearch} from "../../service/EmployyeService.jsx";
import {Link} from "react-router-dom";
import {DeleteEmployee} from "./DeleteEmployee.jsx";
import {Button} from "react-bootstrap";

export function Employee() {
    const [employee, setEmployee] = useState([]);
    const [name,setName] = useState("");

    const [modalStatus,setModalStatus] = useState(false);
    const [selectEmployee,setselectEmployee] = useState(null);

    useEffect(() => {
        getAllEmployee()
    }, []);

    useEffect(() => {
        searchName()
    }, [name]);

    const searchName = async () =>{
        const res = await getSearch(name)
        setEmployee(res);
    }
    const getAllEmployee = async () => {
        const res = await getAll()
        setEmployee(res)
    }

    const handleModal = (value) =>{
        setselectEmployee(value)
        setModalStatus(true);
    }
    const closeModal = () =>{
        getAllEmployee();
        setselectEmployee(null);
        setModalStatus(false)
    }


    return (
        <>
            <h1>List Employee</h1>
            <div className="navbar navbar-inverse">
            <Link className="btn btn-primary" to="/employee/add">ADD</Link>
            </div>
            <div className="d-flex justify-content-end">
                <input  className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}}
                        type='text' onChange={(event) => setName(event.target.value)}/>
            </div>
                <table className="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Identity</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Location</th>
                    <th colSpan={2}>Function</th>
                </tr>
                </thead>
                <tbody>
                {
                    employee.map((em,index) => (
                        <tr key={em.id}>
                            <td>{index+1}</td>
                            <td>{em.name}</td>
                            <td>{em.birthday}</td>
                            <td>{em.identity}</td>
                            <td>{em.phone}</td>
                            <td>{em.email}</td>
                            <td>{em.location.name}</td>
                            <td>
                                <Link className='btn btn-outline-primary' to={`/employee/edit/${em.id}`}>Edit</Link>
                            </td>
                            <td><Button className='btn btn-outline-danger' onClick={()=> handleModal(em)}>Delete</Button></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <DeleteEmployee
            show={modalStatus}
            handleClose={closeModal}
            select={selectEmployee}
            >

            </DeleteEmployee>
        </>
    )

}