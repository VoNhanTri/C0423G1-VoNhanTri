import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import {Field, Form, Formik} from "formik";
import {addContract} from "../../service/ContractService.jsx";
import {toast} from "react-toastify";

export function AddContract() {
    const navigate = useNavigate();

    useEffect(() => {

    }, []);

    const add = async (value) => {
        const res = await addContract(value);
        if (res.status === 201) {
            navigate("/contract");
            toast("Add Successfully");
        } else {
            toast.error("Error");
        }
    }

    return (
        <>
            <Formik initialValues={{
                numContract: "",
                dateStart: "",
                dateEnd: "",
                deposit: 0,
                total: 0
            }} onSubmit={(value) => {
                add(value)
            }}>
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="numContract">Num Contract</label>
                            <Field className="form-control" id="numContract" name="numContract" type="text"
                                   placeholder="Num Contract" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="dateStart">Date Start</label>
                            <Field className="form-control" id="dateStart" name="dateStart" type="date"
                                   placeholder="Date Start" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="dateEnd">Date End</label>
                            <Field className="form-control" id="dateEnd" name="dateEnd" type="date"
                                   placeholder="Date End" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="deposit">Deposit</label>
                            <Field className="form-control" name="deposit" id="deposit" type="text"
                                   placeholder="Deposit" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="total">Total</label>
                            <Field className="form-control" name="total" id="total" type="text" placeholder="Total"
                                   data-sb-validations=""/>
                        </div>

                        <div className="sunmit" style={{textAlign:"center"}}>
                            <button className="btn btn-primary " id="submitButton" type="submit">Submit</button>
                        </div>
                    </Form>
                </div>

            </Formik>
        </>
    )
}