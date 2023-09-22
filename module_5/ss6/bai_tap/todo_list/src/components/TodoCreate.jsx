import React, {useEffect} from 'react';
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import * as todoService from "../../src/service/TodoService.jsx"
import {toast} from "react-toastify";
import * as Yup from 'yup';

export function TodoCreate() {
    const navigate = useNavigate();
    useEffect(() => {
    }, []);
    const createTodo = async (data) => {
        const res = await todoService.create(data);
        console.log(res)
        if (res.status == 201) {
            navigate('/todos');
            toast("Them moi thanh cong");
        } else {
            toast.error("them moi that bai")
        }
    }

    return (
        <>
            <Formik initialValues={{
                name: ""
            }} onSubmit={(values) => {
                createTodo(values);
            }}
                    validationSchema={Yup.object({
                        name: Yup.string()
                            .required("Khong duoc de trong")

                    })}

            >

                <div className='container'>
                    <h1>Todo List</h1>
                    <Form>
                        <div className='mb-3'>
                            <label htmlFor='todo' className='form-label'></label>
                            <Field type='text' className='form-control' name='name' id='todo'/>
                            <ErrorMessage name='name' component='span' className='form-err'/>
                        </div>
                        <button type="submit" className='btn btn-primary'>Submit</button>
                    </Form>
                </div>
            </Formik>

        </>
    );
}

