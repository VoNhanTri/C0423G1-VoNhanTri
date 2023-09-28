import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate, useParams} from "react-router-dom";
import {toast} from "react-toastify";
import {useEffect, useState} from "react";
import {edit, getAllCustomerType, getById} from "../../service/CustomerService.jsx";
import * as Yup from "yup"
export function EditCustomer() {
    const {id} = useParams();
    const [customer,setCustomer] = useState(null);
    const navigate = useNavigate();
    const [type, setType] = useState([])

    useEffect(() => {
        getId();
        loadType();
    },[id]);
    const getId = async () =>{
        const rs =await getById(id)
        setCustomer(rs)
    }
    const loadType = async  () =>{
        const rs = await  getAllCustomerType()
        setType(rs)
    }
    const editCustomer = async (customer) => {
        customer.loaiKhach = JSON.parse(customer.loaiKhach)
        const rs = await edit(customer);
        if (rs.status === 200) {
            navigate("/customer")
            toast("Sua thanh cong")
        } else {
            toast.error("Sua that bai")
        }
    }

    return (
        customer &&
        <>
            <Formik initialValues={{
                ...customer,
                loaiKhach: JSON.stringify(customer.loaiKhach)
            }} onSubmit={(id) => {
                editCustomer(id);
            }}
                    validationSchema={Yup.object({
                        hoTen: Yup.string()
                            .required("Không Được Để Trống")
                            ,
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
                            <ErrorMessage name="ngayTen" component="span" className="form-err"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label>Gioi Tính</label>
                            <Field as="select" name="gioiTinh">
                                <option className="option" value="male">Male</option>
                                <option className="option" value="famale">Female</option>
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
                        <div className="mb-3">
                            <label>Customer Type</label>
                            <Field as="select" name="loaiKhach">
                                {
                                    type.map((e)=>(
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
        </>
    )

}