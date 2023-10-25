import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {edits, getAllType, getByIds} from "../../service/CustomerService.jsx";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";

export function EditCustomer() {
    const [customer, setCustomer] = useState(null);
    const [typeCustomer, setTypeCustomer] = useState([]);
    const {id} = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getType();
        getId()
    }, [id]);

    const getType = async () => {
        const res = await getAllType();
        setTypeCustomer(res)
    }

    const getId = async () => {
        const res = await getByIds(id)
        setCustomer(res);
    }

    // eslint-disable-next-line no-unused-vars
    const editCustomer = async (value) => {
        value.typeCustomer = JSON.parse(value.typeCustomer);
        const res = await edits(value);
        if (res.status === 200) {
            navigate("/customer");
            toast("Edit Successfully")
        } else {
            toast.error("Error")
        }
    }
    return (
        customer &&
        <>
            <Formik initialValues={
                {
                    ...customer, typeCustomer: JSON.stringify(customer.typeCustomer)
                }
            } onSubmit={(id) => {
                editCustomer(id)

            }}>
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="name">Name Customer</label>
                            <Field className="form-control" id="name" name="name" type="text" placeholder="Name "
                                   data-sb-validations=""/>
                            <ErrorMessage name="name" component="span" className="form-err"></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="date">Date</label>
                            <Field className="form-control" id="date" name='date' type="date"
                                   placeholder="Date"
                                   data-sb-validations=""/>
                            <ErrorMessage name="date" component="span" className="form-err"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label>Gender</label>
                            <Field as="select" name="gender" style={{
                                width: '1100px',
                                textAlign: 'center',
                                backgroundColor: 'white',
                                color: 'black'
                            }}>
                                <option className="option" value>--Gender--</option>
                                <option className="option" value="male">Male</option>
                                <option className="option" value="female">Female</option>
                            </Field>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="identity">Identity</label>
                            <Field className="form-control" id="identity" name='identity' type="text"
                                   placeholder="CMND"
                                   data-sb-validations=""/>
                            <ErrorMessage name="cmnd" component="span" className="form-err"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="phone">Number Phone</label>
                            <Field className="form-control" id="phone" name="phone" type="text" placeholder="SĐT"
                                   data-sb-validations=""/>
                            <ErrorMessage name="phone" component="span" className="form-err"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="email">Email</label>
                            <Field className="form-control" id="email" name='email' type="text" placeholder="Email"
                                   data-sb-validations=""/>
                            <ErrorMessage name="email" component="span" className="form-err"></ErrorMessage>

                        </div>

                        <div className="mb-3">
                            <label className="form-label" htmlFor="address">Address</label>
                            <Field className="form-control" id="address" name='address' type="text"
                                   placeholder="Address"
                                   data-sb-validations=""/>
                            <ErrorMessage name="address" component="span" className="form-err"></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label>Type Customer</label>
                            <Field as="select" name="typeCustomer" style={{
                                width: "1100px",
                                textAlign: "center",
                                backgroundColor: 'white',
                                color: 'black'
                            }}>
                                {
                                    typeCustomer.map((cus) => (
                                        <option key={cus.id} value={JSON.stringify(cus)}>{cus.name}</option>
                                    ))
                                }
                            </Field>
                        </div>
                        <div className="d-grid">
                            <button className="btn btn-primary" id="submitButton" type="submit">Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    )

}