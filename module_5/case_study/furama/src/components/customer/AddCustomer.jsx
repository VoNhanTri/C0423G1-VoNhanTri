import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import {useEffect, useState} from "react";
import {add, getAllCustomerType} from "../../service/CustomerService.jsx";
import * as Yup from "yup";

export function AddCustomer() {
    const navigate = useNavigate();
    const [type, setType] = useState([])
    const addNewCustomer = async (value) => {
        const rs = {...value, type: JSON.parse(value.type)}
        await add(rs);
    }
    const loadType = async () => {
        const res = await getAllCustomerType()
        setType(res)
    }

    useEffect(() => {
        loadType()
    }, []);


    return (
        <>
        <Formik initialValues={{
            name: '',
            date: '',
            gender: "1",
            identity: '',
            phone: '',
            email: '',
            address: '',
            type: JSON.stringify({
                id: 1,
                nameType: "PLATINUM"
            })
        }} onSubmit={(value) => {
            addNewCustomer(value);
            navigate("/customer");
            toast("thêm mới thành công")
        }}
                validationSchema={Yup.object({
                    // name: Yup.string()
                    //     .required("Không Được Để Trống"),
                    // date: Yup.string()
                    //     .required("Không Được Để Trống"),
                    // identity: Yup.string()
                    //     .required("Không Được Để Trống")
                    //     .matches(/^[0-9]{9,12}$/, "Số CMND Không Đúng Định Dạng"),
                    //
                    // phone: Yup.string()
                    //     .required("Không Được Để Trống")
                    //     .matches(/^0[0-9]{9,11}$/, "Số điện Thoại Không Đúng Định Dạng"),
                    //
                    // email: Yup.string()
                    //     .required("Không Được Để Trống")
                    //     .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Email Không Đúng định dạng"),
                    // address: Yup.string()
                    //     .required("Không Được Để Trống")
                })}>
            <div className="container px-5 my-5">
                <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                    <div className="mb-3">
                        <label className="form-label" htmlFor="name">Name Customer</label>
                        <Field className="form-control" id="name" name="name" type="text" placeholder="Họ Tên "
                               data-sb-validations=""/>
                        <ErrorMessage name="name" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="date">Date</label>
                        <Field className="form-control" id="date" name='date' type="date"
                               placeholder="Ngày Sinh"
                               data-sb-validations=""/>
                        <ErrorMessage name="date" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label>Giới Tính</label>
                        <Field as="select" name="gender" style={{width:'1100px',textAlign:'center', backgroundColor:'white', color:'black'}}>
                            <option className="option" value>--Gender--</option>
                            <option className="option" value="male">Male</option>
                            <option className="option" value="famale">Famale</option>
                        </Field>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="identity">CMND</label>
                        <Field className="form-control" id="identity" name='identity' type="text" placeholder="CMND"
                               data-sb-validations=""/>
                        <ErrorMessage name="cmnd" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="phone">SĐT</label>
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
                        <label className="form-label" htmlFor="address">Địa Chỉ</label>
                        <Field className="form-control" id="address" name='address' type="text" placeholder="Địa Chỉ"
                               data-sb-validations=""/>
                        <ErrorMessage name="address" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className="mb-3" >
                        <label>Loại Khách Hàng</label>
                        <Field as="select" name="type" style={{width:"1100px", textAlign:"center", backgroundColor:'white',color:'black' }}>
                            {
                                type.map((e) => (
                                    <option key={e.id} value={e.id}>{e.nameType}</option>
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
    </>)

}