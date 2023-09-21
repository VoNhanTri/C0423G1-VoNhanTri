import React from 'react';
import {Formik, Form, Field,ErrorMessage} from "formik";
import * as Yup from "yup"

function FormMedical(props) {
    return (
        <>
            <Formik initialValues={{
                hoTen: "",
                cmnd: "",
                namSinh: "",
                gioiTinh: "0",
                quocTich: "",
                congTy: "",
                boPhan: "",
                baoHiem: "",
                tinhThanh: "",
                quanHuyen:"",
                phuongXa:"",
                thon: "",
                dienThoai:"",
                email:"",
                lanhTho:"",
                dauHieu: [],
                tiepSuc:[]
            }}
             onSubmit={()=>{
                 alert("Thêm Thành Công")
             }}
            validationSchema={Yup.object({
                hoTen: Yup.string()
                    .required("Không Được Để Trống"),
                cmnd: Yup.string()
                    .required("Không Được Để Trống"),
                namSinh: Yup.string()
                    .required("Không Được Để Trống")
                    .min(1900,"Phải Lớn hơn năm 1900"),
                quocTich: Yup.string()
                    .required("Không Được Để Trống"),
                tinhThanh:Yup.string()
                    .required("Không Được Để Trống"),
                quanHuyen: Yup.string()
                    .required("Không Được Để Trống"),
                phuongXa: Yup.string()
                    .required("Không Được Để Trống"),
                thon: Yup.string()
                    .required("Không Được Để Trống"),
                dienThoai: Yup.string()
                    .required("Không Được Để Trống"),
                email: Yup.string()
                    .required("Không Được Để Trống")
                    .matches(/^[\w\-.]+@([\w-]+\.)+[\w-]{2,}$/, "Email Không Đúng định dạng")
            })}
            >
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="hoTen">Họ Tên</label>
                            <Field className="form-control" id="hoTen" name="hoTen" type="text" placeholder="Họ Tên"
                                   data-sb-validations/>
                            <ErrorMessage name="hoTen" component="span" className="form-err"/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="cmnd">Số hộ chiếu /CMND</label>
                            <Field className="form-control" id="cmnd" name="cmnd" type="text"
                                   placeholder="Số hộ chiếu /CMND"
                                   data-sb-validations/>
                            <ErrorMessage name="cmnd" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="namSinh">Năm sinh</label>
                            <Field className="form-control" id="namSinh" name="namSinh" type="text" placeholder="Năm sinh"
                                   data-sb-validations/>
                            <ErrorMessage name="namSinh" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label d-block">Giới Tính</label>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" id="nam" value="1" type="radio" name="gioiTinh"
                                       data-sb-validations/>
                                <label className="form-check-label"  htmlFor="nam">Nam</label>
                            </div>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" id="nu" value="0" type="radio" name="gioiTinh"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="nu">Nữ</label>
                            </div>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="quocTich">Quốc Tịch</label>
                            <Field className="form-control" id="quocTich" type="text" name="quocTich" placeholder="Quốc Tịch"
                                   data-sb-validations/>
                            <ErrorMessage name="quocTich" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="congTy">Công ty làm việc</label>
                            <Field className="form-control" id="congTy" name="congTy" type="text"
                                   placeholder="Công ty làm việc"
                                   data-sb-validations/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="boPhan">Bộ phận làm việc</label>
                            <Field className="form-control" id="boPhan" name="boPhan" type="text"
                                   placeholder="Bộ phận làm việc"
                                   data-sb-validations/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="baoHiem">Có thẻ bảo hiểm y tế</label>
                            <Field className="form-control" id="baoHiem" name="baoHiem" type="text"
                                   placeholder="Có thẻ bảo hiểm y tế" data-sb-validations/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="tinhThanh">Tỉnh thành</label>
                            <Field className="form-control" id="tinhThanh" name="tinhThanh" type="text" placeholder="Tỉnh thành"
                                   data-sb-validations/>
                            <ErrorMessage name="tinhThanh" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="quanHuyen">Quận /huyện</label>
                            <Field className="form-control" id="quanHuyen" name="quanHuyen" type="text" placeholder="Quận /huyện"
                                   data-sb-validations/>
                            <ErrorMessage name="quanHuyen" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="phuongXa">Phường /xã</label>
                            <Field className="form-control" id="phuongXa" name="phuongXa" type="text" placeholder="Phường /xã"
                                   data-sb-validations/>
                            <ErrorMessage name="phuongXa" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="thon">Số nhà, phố, tổ dân phố
                                /thôn
                                /đội</label>
                            <Field className="form-control" id="thon" name="thon" type="text"
                                   placeholder="Số nhà, phố, tổ dân phố /thôn /đội" data-sb-validations/>
                            <ErrorMessage name="thon" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="dienThoai">Điện thoại</label>
                            <Field className="form-control" id="dienThoai" name="dienThoai" type="text" placeholder="Điện thoại"
                                   data-sb-validations/>
                            <ErrorMessage name="dienThoai" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="email">Email</label>
                            <Field className="form-control" id="email" name="email" type="text" placeholder="Email"
                                   data-sb-validations/>
                            <ErrorMessage name="email" component="span" className="form-err"/>

                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="lanhTho">Trong
                                vòng 14 ngày qua, Anh/Chị có đến quốc gia/vùng lãnh thổ nào ?</label>
                            <Field className="form-control" id="lanhTho" name="lanhTho"
                                      type="textarea"
                                      style={{height: '10rem'}} data-sb-validations defaultValue={""}/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label d-block">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu
                                hiệu
                                nào sau đây ?</label>
                            <div className="form-check">
                                <Field className="form-check-input" id="sot" value="Sốt" name="dauHieu" type="checkbox"
                                       data-sb-validations/>
                                <label className="form-check-label"  htmlFor="sot">Sốt</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="ho" value="Ho" name="dauHieu" type="checkbox"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="ho">Ho</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="khoTho" type="checkbox"
                                       name="dauHieu" value="Khó Thở"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="khoTho">Khó Thở</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="viemPhoi" type="checkbox"
                                       name="dauHieu" value="Viêm Phổi"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="viemPhoi">Viêm Phổi</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="dauHong" type="checkbox"
                                       name="dauHieu" value="Đau Họng"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="dauHong">Đau Họng</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="metMoi" type="checkbox"
                                       name="dauHieu" value="Mệt Mỏi"
                                       data-sb-validations/>
                                <label className="form-check-label" htmlFor="metMoi">Mệt Mỏi</label>
                            </div>
                        </div>
                        <div className="mb-3">
                            <label className="form-label d-block">Trong vòng 14 ngày qua, Anh/Chị có tiếp súc với
                                ?</label>
                            <div className="form-check">
                                <Field className="form-check-input" id="nguoiBenh"
                                       type="checkbox"
                                       name="tiepSuc" value="Người Bệnh" data-sb-validations/>
                                <label className="form-check-label" htmlFor="nguoiBenh">Người
                                    bệnh
                                    hoặc nghi ngờ mắc bệnh COVID-19</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="nuoc" type="checkbox"
                                       name="tiepSuc" value="Người Từ Nước Ngoài" data-sb-validations/>
                                <label className="form-check-label" htmlFor="nuoc">Người từ nước có
                                    bệnh
                                    COVID-19</label>
                            </div>
                            <div className="form-check">
                                <Field className="form-check-input" id="sot"
                                       type="checkbox" name="tiepSuc" value="Người Có Biểu Hiện" data-sb-validations/>
                                <label className="form-check-label"
                                       htmlFor="sot">Người có biểu hiện(sốt
                                    ho
                                    khó thở viêm phổi đau họng mệt mỏi)</label>
                            </div>
                        </div>
                        <div className="d-grid">
                            <button className="btn btn-primary " id="submitButton" type="submit">Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    );
}

export default FormMedical;