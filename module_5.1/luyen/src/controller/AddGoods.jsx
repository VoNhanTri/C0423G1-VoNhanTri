import {useEffect, useState} from "react";
import {addGoods, getAllType} from "../service/GoodsService.jsx";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as Yup from "yup";

export function AddGoods() {
    const [type, setType] = useState([]);
    const navigate = useNavigate()

    useEffect(() => {
        displayType()
    }, []);

    const displayType = async () => {
        const res = await getAllType();
        setType(res)
    }

    const add = async (data) => {
        const res = {...data, type: JSON.parse(data.type)}
        addGoods(res);

    }


    return (
        <>
            <Formik initialValues={{
                code: "",
                name: "",
                unit: "",
                price: 0,
                date: "",
                type: JSON.stringify({
                    id: 1,
                    name: "Rau"
                })


            }} onSubmit={(value) => {
                add(value);
                navigate("/goods");
                toast("Thêm Mới Thành Công");

            }}
                    validationSchema={Yup.object({
                        code: Yup.string()
                            .required("Không được để trống")
                            .matches(/^MHH-[A-Za-z0-9]{4}$/, "Phải đúng theo định dạng MHH-XXXX"),
                        price: Yup.number()
                            .required("không được để trống")
                            .min(1000, "Phải lớn hơn 1000")
                    })}>
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="maHangHoa">Mã Hàng Hoá</label>
                            <Field className="form-control" id="maHangHoa" name='code' type="text"
                                   placeholder="Mã Hàng Hoá"/>
                            <ErrorMessage name='code' component="span" className="text-danger"></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="tenHangHoa">Tên Hàng Hoá</label>
                            <Field className="form-control" id="tenHangHoa" name='name' type="text"
                                   placeholder="Tên Hàng Hoá"/>
                            <ErrorMessage name='name' component="span" className="text-danger"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label htmlFor="dơnVịTinh">Đơn VỊ Tính</label>
                            <Field as="select" className="form-select" id="dơnVịTinh" name="unit"
                                   aria-label="Đơn Vị Tính">
                                <option value="kg">Kg</option>
                                <option value="tui">Túi</option>
                                <option value="bo">Bó</option>
                            </Field>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="giaVndKg">Giá (VNĐ/kg)</label>
                            <Field className="form-control" id="giaVndKg" name='price' type="text"
                                   placeholder="Giá (VNĐ/kg)"/>
                            <ErrorMessage name='price' component="span" className="text-danger"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="ngayThuHoạch">Ngày Thu Hoạch</label>
                            <Field className="form-control" id="ngayThuHoạch" name='date' type="date"
                                   placeholder="Ngày Thu Hoạch"/>
                            <ErrorMessage name='date' component="span" className="text-danger"></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="loạiSảnPhẩm">Loại Sản Phẩm</label>
                            <Field as="select" className="form-select" name='type' id="loạiSảnPhẩm"
                                   aria-label="Loại Sản Phẩm">
                                {
                                    type.map((type) => (
                                        <option key={type.id} value={JSON.stringify(type)}> {type.name}</option>
                                    ))
                                }
                            </Field>
                            <ErrorMessage name='type' component="span" className="text-danger"></ErrorMessage>

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