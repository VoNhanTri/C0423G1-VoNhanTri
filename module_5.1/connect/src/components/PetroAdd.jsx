import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {createPetro} from "../service/Petrols";
import {Field, Form, Formik} from "formik";
import {toast} from "react-toastify";

export function PetroAdd() {
    const navagite = useNavigate();

    useEffect(() => {

    }, []);

    const petrolAdd = async (data) => {
        const res = await createPetro(data)
        if (res.status === 201){
            navagite("/petrols")
            toast("Thêm mới ok")
        }else {
            toast.error("Thất baại")
        }
    }

    return (
        <>
            <Formik initialValues={{
                name: "",
                price: 0
            }} onSubmit={(value) => {
                petrolAdd(value)

            }}>
                <div>
                    <Form>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="name">Name</label>
                            <Field className="form-control" id="name" name="name" type="text" placeholder="Name"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="price">Birthday</label>
                            <Field className="form-control" id="price" name="price" type="number"
                                   placeholder="Price" data-sb-validations=""/>
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