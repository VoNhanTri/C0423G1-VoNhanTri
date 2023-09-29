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
        const rs = {...value, loaiKhach: JSON.parse(value.loaiKhach)}
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
            hoTen: '',
            ngaySinh: '',
            gioiTinh: "1",
            cmnd: '',
            sdt: '',
            email: '',
            diaChi: '',
            loaiKhach: JSON.stringify({
                id: 1,
                name: "PLATINUM"
            })
        }} onSubmit={(value) => {
            addNewCustomer(value);
            navigate("/customer");
            toast("thêm mới thành công")
        }}
                validationSchema={Yup.object({
                    hoTen: Yup.string()
                        .required("Không Được Để Trống"),
                    ngaySinh: Yup.string()
                        .required("Không Được Để Trống"),
                    cmnd: Yup.string()
                        .required("Không Được Để Trống")
                        .matches(/^[0-9]{9,12}$/, "Số CMND Không Đúng Định Dạng"),

                    sdt: Yup.string()
                        .required("Không Được Để Trống")
                        .matches(/^0[0-9]{9,11}$/, "Số điện Thoại Không Đúng Định Dạng"),

                    email: Yup.string()
                        .required("Không Được Để Trống")
                        .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Email Không Đúng định dạng"),
                    diaChi: Yup.string()
                        .required("Không Được Để Trống")
                })}
        >
            <div className="container px-5 my-5">
                <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                    <div className="mb-3">
                        <label className="form-label" htmlFor="hoTen">Họ Tên </label>
                        <Field className="form-control" id="hoTen" name="hoTen" type="text" placeholder="Họ Tên "
                               data-sb-validations=""/>
                        <ErrorMessage name="hoTen" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="ngaySinh">Ngày Sinh</label>
                        <Field className="form-control" id="ngaySinh" name='ngaySinh' type="date"
                               placeholder="Ngày Sinh"
                               data-sb-validations=""/>
                        <ErrorMessage name="ngaySinh" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label>Giới Tính</label>
                        <Field as="select" name="gioiTinh" style={{width:'1100px',textAlign:'center', backgroundColor:'white', color:'black'}}>
                            <option className="option" value>--Gender--</option>
                            <option className="option" value="male">Male</option>
                            <option className="option" value="famale">Famale</option>
                            <option className="option" value="other">Other</option>
                        </Field>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="cmnd">CMND</label>
                        <Field className="form-control" id="cmnd" name='cmnd' type="text" placeholder="CMND"
                               data-sb-validations=""/>
                        <ErrorMessage name="cmnd" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="sdt">SĐT</label>
                        <Field className="form-control" id="sdt" name="sdt" type="text" placeholder="SĐT"
                               data-sb-validations=""/>
                        <ErrorMessage name="sdt" component="span" className="form-err"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <Field className="form-control" id="email" name='email' type="text" placeholder="Email"
                               data-sb-validations=""/>
                        <ErrorMessage name="email" component="span" className="form-err"></ErrorMessage>

                    </div>

                    <div className="mb-3">
                        <label className="form-label" htmlFor="diaChi">Địa Chỉ</label>
                        <Field className="form-control" id="diaChi" name='diaChi' type="text" placeholder="Địa Chỉ"
                               data-sb-validations=""/>
                        <ErrorMessage name="diaChi" component="span" className="form-err"></ErrorMessage>
                    </div>
                    <div className="mb-3" >
                        <label>Loại Khách Hàng</label>
                        <Field as="select" name="loaiKhach" style={{width:"1100px", textAlign:"center", backgroundColor:'white',color:'black' }}>
                            {
                                type.map((e) => (
                                    <option key={e.id} value={JSON.stringify(e)}>{e.name}</option>
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