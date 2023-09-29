import {useEffect, useState} from "react";
import {getAllLocation, getSearch} from "../../service/EmployyeService.jsx";
import {Link} from "react-router-dom";
import {DeleteEmployee} from "./DeleteEmployee.jsx";
import {Button} from "react-bootstrap";

export function Employee() {
    const [employee, setEmployee] = useState([]);
    const [name, setName] = useState('');
    const [location, setLocation] = useState([]);
    const [locationSearch, setLocationSearch] = useState('');
    const [modalStatus, setModalStatus] = useState(false);
    const [selectEmployee, setselectEmployee] = useState(null);

    console.log('name: ' + name, 'location: ' + locationSearch);

    useEffect(() => {
        getLocation();
    }, [])

    // console.log(employee)

    useEffect(() => {
        searchName()
    }, [name, locationSearch]);

    const searchName = async () => {
        const res = await getSearch(name, locationSearch)
        setEmployee(res);
    }


    const handleModal = (value) => {
        setselectEmployee(value)
        setModalStatus(true);
    }
    const closeModal = () => {
        searchName();
        setselectEmployee(null);
        setModalStatus(false)
    }
    const getLocation = async () => {
        const location = await getAllLocation();
        setLocation(location);
    }


    return (
        <>
            <h1>List Employee</h1>
            <div className="navbar navbar-inverse">
                <Link className="btn btn-primary" to="/employee/add">ADD</Link>
            </div>
            <div className="d-flex justify-content-end">
                <input className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}}
                       placeholder='Search ...'
                       type='text' onChange={(event) => setName(event.target.value)}/>
                <select onChange={(event) => {
                    setLocationSearch(event.target.value);
                }} className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}}>
                    <option value=''>Location</option>
                    {location && location.map((item) => {
                        return (

                            <option key={item.id} value={item.id}>{item.name}</option>)
                    })}
                    <option></option>
                </select>
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
                    employee.map((em, index) => (
                        <tr key={em.id}>
                            <td>{index + 1}</td>
                            <td>{em.name}</td>
                            <td>{em.birthday}</td>
                            <td>{em.identity}</td>
                            <td>{em.phone}</td>
                            <td>{em.email}</td>
                            <td>{em.location.name}</td>
                            <td>
                                <Link className='btn btn-outline-primary' to={`/employee/edit/${em.id}`}>Edit</Link>
                            </td>
                            <td><Button className='btn btn-outline-danger'
                                        onClick={() => handleModal(em)}>Delete</Button></td>
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