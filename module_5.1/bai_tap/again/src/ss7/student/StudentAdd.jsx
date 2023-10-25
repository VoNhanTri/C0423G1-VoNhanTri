import {ErrorMessage, Field, Form, Formik} from "formik";
import {addStudent} from "../service/StudentSetvice.jsx";
import {toast} from "react-toastify";
import {useDispatch} from "react-redux";
import {useNavigate} from "react-router-dom";
import * as Yup from "yup";
import {add} from "../redux/middlewares/StudentMiddleware.jsx";

export function StudentAdd() {
    const navigate = useNavigate();
    const dispatch = useDispatch();


    const initValue = {
        name: "",
        age: 0,
        gender: "0",
        languages: ["C#"]
    };

    const validateObject = {
        name: Yup.string()
            .required("Tên không được để trống")
            .matches(/^[A-Za-z ]{3,100}$/, "Tên không đúng format"),
        age: Yup.number()
            .min(18, "Tuổi không được nhỏ hơn 18")
            .max(50)
    };
    const createStudent = async (values) => {
        values.gender = +values.gender;
        dispatch(add(values))
        toast.success("Thêm mới thành công");
        navigate("/students");
    };
    return (
        <>
            <Formik
                initialValues={initValue}
                onSubmit={(values) => {
                    createStudent(values);
                }}
                validationSchema={Yup.object(validateObject)
                }
            >
                <div className='container'>
                    <h1>Create Student</h1>
                    <Form>
                        <div className='mb-3'>
                            <label htmlFor='studentName' className='form-label'>Name</label>
                            <Field type='text' name="name" className='form-control' id='studentName'/>
                            <ErrorMessage name="name" component="span" style={{color: "red"}}></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='studentAge' className='form-label'>Age</label>
                            <Field type='number' name="age" className='form-control' id='studentAge'/>
                            <ErrorMessage name="age" component="span" style={{color: "red"}}></ErrorMessage>
                        </div>
                        <div className='mb-3'>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" name="gender"
                                       id="inlineRadio1"
                                       value="1"/>
                                <label className="form-check-label" htmlFor="inlineRadio1">Male</label>
                            </div>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" name="gender"
                                       id="inlineRadio2"
                                       value="0"/>
                                <label className="form-check-label" htmlFor="inlineRadio2">FeMale</label>
                            </div>
                        </div>

                        <label htmlFor='studentAge' className='form-label'>Languages</label>
                        <div className="form-check">
                            <Field name="languages" className="form-check-input" type="checkbox" value="C#"
                                   id="flexCheckDefault"/>
                            <label className="form-check-label" htmlFor="flexCheckDefault">
                                C#
                            </label>
                        </div>
                        <div className="form-check">
                            <Field name="languages" className="form-check-input" type="checkbox" value="JAVA" id="cb1"/>
                            <label className="form-check-label" htmlFor="cb1">
                                JAVA
                            </label>
                        </div>
                        <div className="form-check">
                            <Field name="languages" className="form-check-input" type="checkbox" value="ReactJS"
                                   id="cb2"/>
                            <label className="form-check-label" htmlFor="cb2">
                                ReactJS
                            </label>
                        </div>
                        <button type='submit' className='btn btn-primary'>Submit</button>
                    </Form>
                </div>
            </Formik>

        </>
    )
}