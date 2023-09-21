import {Formik, Form, Field,ErrorMessage} from "formik";
// eslint-disable-next-line no-unused-vars
import React from 'react';
import * as Yup from "yup";
import {toast} from "react-toastify";

export function FormContact() {
    return (
        <>
            <Formik initialValues={{
                name: "",
                email: "",
                phone: "",
                mess: ""
            }} onSubmit={(values => {
                console.log(values)
                toast("Thêm Mới Thành Công");
            })}
                    validationSchema={Yup.object({
                        name: Yup.string()
                            .required("Không Được Để Trống"),
                        email: Yup.string()
                            .required("Khống được để trống")
                            .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Email Không Đúng định dạng"),
                        phone: Yup.string()
                            .required("Không được để trống")
                            .matches(/^0[0-9]{9,12}$/,"Số điện Thoại Không Đúng Định Dạng"),
                        mess: Yup.string()
                            .required("Không được để trống")
                    })}

            >
                <Form >
                    <div className="container-fluid">
                    <div className=" mb-3">
                        <label className="form-label" htmlFor="name">Name</label>
                        <Field className="form-control" id="name" name="name" type="text" placeholder="Name"
                               data-sb-validations=""/>
                        <ErrorMessage name="name" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <Field className="form-control" id="email" name="email" type="text" placeholder="Email"
                               data-sb-validations=""/>
                        <ErrorMessage name="email" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="phone">Phone</label>
                        <Field className="form-control" id="phone" name="phone" type="text" placeholder="Phone"
                               data-sb-validations=""/>
                        <ErrorMessage name="phone" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="message">Message</label>
                        <Field className="form-control" id="message" name="mess" type="textarea" placeholder="Message"
                               data-sb-validations=""/>
                        <ErrorMessage name="mess" component="span" className="form-err" ></ErrorMessage>

                    </div>
                    <div className="d-grid">
                        <button className="btn btn-primary " id="submitButton" type="submit">Submit</button>
                    </div>
                    </div>
                </Form>

            </Formik>
        </>
    );
}


