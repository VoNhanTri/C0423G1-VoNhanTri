import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {edit, getAllLocation, getById} from "../../service/EmployyeService.jsx";
import {toast} from "react-toastify";
import {Field, Form, Formik} from "formik";

export function EditEmployee() {
    const [employee, setEmployee] = useState(null);
    const {id} = useParams();
    const [location, setLocation] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getId()
        getLocation()
    }, [id]);
    const getId = async () => {
        const res = await getById(id)
        setEmployee(res)
    }

    const getLocation = async () => {
        const res = await getAllLocation()
        setLocation(res)
    }

    const editEmployee = async (employees) => {
        employees.location = JSON.parse(employees.location)
        const res = await edit(employees);
        if (res.status === 200) {
            navigate("/employee")
            toast("Sửa Thành Công")
        } else {
            toast.error("Sửa Thất Bại")
        }
    }

    return (
        employee &&
        <>
            <Formik initialValues={
                {
                    ...employee, location: JSON.stringify(employee.location)
                }
            } onSubmit={(id) => {
                editEmployee(id)
            }
            }>

                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">

                        <div className="mb-3">
                            <label className="form-label" htmlFor="name">Name</label>
                            <Field className="form-control" id="name" name="name" type="text" placeholder="Name"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="birthday">Birthday</label>
                            <Field className="form-control" id="birthday" name="birthday" type="date"
                                   placeholder="Birthday" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="identity">Identity</label>
                            <Field className="form-control" id="identity" name="identity" type="text"
                                   placeholder="Identity" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="phone">Phone</label>
                            <Field className="form-control" id="phone" name="phone" type="text" placeholder="Phone"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="email">Email</label>
                            <Field className="form-control" id="email" name="email" type="text" placeholder="Email"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="location">Location</label>
                            <Field as="select" className="form-control" id="location" name="location"
                                   placeholder="Location" data-sb-validations="">
                                {
                                    location.map((lo) => (
                                        <option key={lo.id} value={JSON.stringify(lo)}>{lo.name} </option>
                                    ))
                                }

                            </Field>
                        </div>
                        <div className="d-grid">
                            <button className="btn btn-primary" id="submitButton" type="submit">Submit</button>
                        </div>
                    </Form>
                </div>

            </Formik>


        </>

    )

}