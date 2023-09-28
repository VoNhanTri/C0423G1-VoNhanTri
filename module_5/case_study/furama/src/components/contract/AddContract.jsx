import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import {toast} from "react-toastify";
import {Field, Form, Formik} from "formik";
import {add} from "../../service/ContractService.jsx";

export function AddContract() {
    const navigate = useNavigate();
    useEffect(() => {

    }, []);
    const addContract = async (data) => {
        const rs = await add(data);
        console.log(rs)
        if (rs.status === 201) {
            navigate("/contract");
            toast("them moi thanh cong")
        } else {
            toast.error("them moi that bai")
        }
    }

    return (
        <>
            <h1>Add New Contract</h1>
            <Formik initialValues={{
                hopDong: '',
                batDau: '',
                ketThuc: '',
                datCoc: '',
                tong: '',

            }} onSubmit={(values) => {
                addContract(values)
            }}>
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="soHopDong">Số Hợp Đồng</label>
                            <Field className="form-control" id="soHopDong" name="hopDong" type="text"
                                   placeholder="Số Hợp Đồng"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="batDau">Ngày Bắt Đầu</label>
                            <Field className="form-control" id="batDau" name="batDau" type="date"
                                   placeholder="Ngày Bắt Đầu"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="ketThuc">Ngày Kết Thúc</label>
                            <Field className="form-control" id="ketThuc" name="ketThuc" type="date"
                                   placeholder="Ngày Kết Thúc"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="datCoc">Số Tiền Cọc Trước</label>
                            <Field className="form-control" id="datCoc" name="datCoc" type="text"
                                   placeholder="Số Tiền Cọc Trước"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="tong">Tổng Tiền Thanh Toán</label>
                            <Field className="form-control" id="tong" name="tong" type="text"
                                   placeholder="Tổng Tiền Thanh Toán" data-sb-validations=""/>
                        </div>

                        <div className="d-grid">
                            <button className="btn btn-primary " id="submitButton" type="submit">Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    )

}