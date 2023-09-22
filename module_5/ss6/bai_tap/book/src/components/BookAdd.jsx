import React, {useEffect} from 'react';
import {Field, Form, Formik} from "formik";
import {add} from "../service/BokkService.jsx";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";

export function BookAdd(props) {
    const navigate = useNavigate();
    useEffect(()=>{
    },[]);
    const addBook = async (data)=>{
      const rs = await add(data);
        console.log()
        if(rs.status === 201){
            navigate("/");
            toast("Them moi thanh cong")
        }else {
            toast.error("Them moi that bai")
        }
    }

    return (
        <>
        <h1>Add Book</h1>
            <Formik initialValues={{
                title: '',
                quantity: ''
            }} onSubmit={(value)=>{
                addBook(value)
            }}>

                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="title">Title</label>
                            <Field className="form-control" name="title" id="title" type="text" placeholder="Title" data-sb-validations="" />
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="quantity">Quantity</label>
                            <Field className="form-control" name="quantity" id="quantity" type="text" placeholder="Quantity" data-sb-validations="" />
                        </div>

                        <div className="d-grid">
                            <button className="btn btn-primary " id="submitButton" type="submit">Submit</button>
                        </div>
                    </Form>
                </div>

            </Formik>
        </>
    );
}

export default BookAdd;