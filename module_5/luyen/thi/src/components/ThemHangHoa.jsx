import {ErrorMessage, Field, Form, Formik} from "formik";
import {useEffect, useState} from "react";
import {getAllLoai, themMoi} from "../service/HangHoaService.jsx";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as Yup from "yup"

export function ThemHangHoa() {
    const [loai, setLoai] = useState([]);
    const navigator = useNavigate()
    useEffect(() => {
        getLoai()
    }, []);

    const getLoai = async () => {
        const res = await getAllLoai();
        setLoai(res)
    }

    const getThemMoi = async (data) => {
        const res = {...data, loai: JSON.parse(data.loai)}
        await themMoi(res)
    }

    return (
        <>
            <Formik initialValues={{
                maHangHoa: "",
                tenHangHoa: "",
                donVi: "kg",
                gia: 0,
                ngayThu: "",
                loai: JSON.stringify({
                    id: 1,
                    tenLoai: "Rau"
                })


            }} onSubmit={(data) => {
                getThemMoi(data)
                navigator("/")
                toast("Thêm Mới Thành Công")
            }

            }
                    validationSchema={Yup.object({
                        maHangHoa: Yup.string()
                            .required("Không được để trống"),
                        tenHangHoa: Yup.string()
                            .required("Không được để trống"),
                        gia: Yup.number()
                            .min(10001, "Phải lớn hơn 10000")
                            .required("Không được để trống"),
                        ngayTHu: Yup.date()
                            .required("Không được để trống")
                            .min(new Date(), "Ngày phải lớn hơn ngày hiện taại")
                    })}
            >
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="maHangHoa">Mã Hàng Hoá</label>
                            <Field className="form-control" id="maHangHoa" name='maHangHoa' type="text"
                                   placeholder="Mã Hàng Hoá" data-sb-validations=""/>
                            <ErrorMessage name='maHangHoa' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="tenHangHoa">Tên Hàng Hoá</label>
                            <Field className="form-control" id="tenHangHoa" name='tenHangHoa' type="text"
                                   placeholder="Tên Hàng Hoá" data-sb-validations=""/>
                            <ErrorMessage name='tenHangHoa' component='span' className='text-danger'></ErrorMessage>

                        </div>
                        <div className="mb-3">
                            <label htmlFor="dơnVi">Đơn VỊ Tính</label>
                            <Field as='select' className="form-select" name="donVi" id="dơnVi" aria-label="Đơn Vị Tính">
                                <option value="kg">kg</option>
                                <option value="túi">túi</option>
                                <option value="bó">bó</option>
                            </Field>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="gia">Giá (VNĐ/kg)</label>
                            <Field className="form-control" id="gia" name='gia' type="text" placeholder="Giá (VNĐ/kg)"
                                   data-sb-validations=""/>
                            <ErrorMessage name='gia' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="ngayThu">Ngày Thu Hoạch</label>
                            <Field className="form-control" id="ngayThu" name='ngayThu' type='date'
                                   placeholder="Ngày Thu Hoạch" />
                            <ErrorMessage name='ngayTHu' component='span' className='text-danger'></ErrorMessage>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="loaiSanPham">Loại Sản Phẩm</label>
                            <Field as="select" className="form-select" name='loai' id="loaiSanPham"
                                   aria-label="Loại Sản Phẩm">
                                {
                                    loai.map((loai) => (
                                        <option key={loai.id} value={JSON.stringify(loai)}>{loai.tenLoai}</option>
                                    ))
                                }
                            </Field>
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