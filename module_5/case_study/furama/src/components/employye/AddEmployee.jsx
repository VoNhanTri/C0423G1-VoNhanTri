import {useEffect, useState} from "react";
import { Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {add, getAllLocation} from "../../service/EmployyeService.jsx";
import {toast} from "react-toastify";

export function AddEmployee() {
    const [type, setType] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        loadLocation()
    }, []);

    const addEmployee = async (value) => {
        const res = {...value, location: JSON.parse(value.location)};
       await add(res)
    }

    const loadLocation = async () => {
        const res = await getAllLocation();
        setType(res);
    }

    return (
        <>
            <Formik initialValues={{
                name: "",
                birthday: '',
                identity: '',
                phone: '',
                email: '',
                location: JSON.stringify({
                    id: 1,
                    name: "Cao Đẳng"
                })

            }} onSubmit={(values) => {
                addEmployee(values)
                navigate("/employee");
                toast("Thêm Mới Thành Công")
            }}>
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
                                    type.map((types) => (
                                        <option key={types.id} value={JSON.stringify(types)}>{types.name} </option>
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