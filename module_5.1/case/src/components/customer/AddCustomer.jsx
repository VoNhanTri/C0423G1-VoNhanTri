import {ErrorMessage, Field, Form, Formik} from "formik";
import {useEffect, useState} from "react";
import {addCustomer, getAllType} from "../../service/CustomerService.jsx";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as Yup from "yup"

export function AddCustomer() {
    const [typeCustomer, setTypeCustomer] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        displayType()
    }, []);

    const displayType = async () => {
        const res = await getAllType();
        setTypeCustomer(res);
    }

    const add = async (value) => {
        const res = {...value, typeCustomer: JSON.parse(value.typeCustomer)}
        await addCustomer(res)
    }
    //kiem tra trên 18
    const today = new Date();
    const years18 = new Date(today);
    years18.setFullYear(today.getFullYear() - 18);

    return (

        <>
            <Formik initialValues={{
                name: '',
                date: "",
                gender: "male",
                identity: "0",
                phone: "0",
                email: "",
                address: "",
                typeCustomer: JSON.stringify({
                    id: 1,
                    name: "PLATINUM"
                })

            }} onSubmit={(values) => {
                add(values)
                navigate("/customer");
                toast("Create Successfully ");
            }}
                    validationSchema={Yup.object({
                        name: Yup.string()
                            .required("Not null")
                            .matches(/^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$/),
                        date: Yup.date()
                            .required("Not null")
                            .max(years18, "Greater than 18 year old"),
                        identity: Yup.string()
                            .required("Not null")
                            .matches(/^[0-9]{9,12}$/, "Not Invalid"),
                        phone: Yup.string()
                            .required("Not Null")
                            .matches(/^0[0-9]{9,11}$/, "Not Invalid"),
                        email: Yup.string()
                            .required("Not null")
                            .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Not Invalid"),
                        address: Yup.string()
                            .required("Not null")
                    })}

            >
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
                                width: '1225px',
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
                            <Field className="form-control" id="identity" name='identity' type="text" placeholder="CMND"
                                   data-sb-validations=""/>
                            <ErrorMessage name="identity" component="span" className="form-err"></ErrorMessage>

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
                                width: "1225px",
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
                        <div className="submit" style={{textAlign:"center"}}>
                            <button className="btn btn-primary" id="submitButton" type="submit">Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    )


}