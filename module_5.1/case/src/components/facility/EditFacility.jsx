import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {edit, getAllService, getById} from "../../service/FacilityService.jsx";
import {Field, Form, Formik} from "formik";
import {toast} from "react-toastify";

export function EditFacility() {
    const [facility, setFacility] = useState(null);
    const {id} = useParams();
    const [serviceName,setServiceName] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getId()
        getService()
    }, [id]);
    const getId =async () =>{
        const res = await getById(id)
        setFacility(res)
    }

    const getService = async () => {
      const res = await getAllService();
      setServiceName(res)
    }

    const editFacility = async (value) => {
      value.serviceName = JSON.parse(value.serviceName)
        const res = await edit(value);
        if (res.status === 200){
            navigate("/facility")
            toast("Edit Successfully");
        }else {
            toast.error("Error");
        }
    }

    return (
        facility&&
            <>
            <Formik initialValues={
                {
                    ...facility, serviceName: JSON.stringify(facility.serviceName)
                }
            } onSubmit={(id)=>{
                editFacility(id)
            }}>
                <div className="container px-5 my-5">
                    <h1 style={{textAlign:"center"}}>Edit Facility</h1>
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="serviceName">Service Name</label>
                            <Field as="select" className="form-control" id="serviceName" name="serviceName"
                                   placeholder="Service Name" data-sb-validations="">
                                {
                                    serviceName.map((types) => (
                                        <option key={types.id} value={JSON.stringify(types)}>{types.name} </option>
                                    ))
                                }
                            </Field>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="area">Area</label>
                            <Field className="form-control" id="area" name="area" type="text" placeholder="Area"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="rentalCost">Rental Cost</label>
                            <Field className="form-control" id="rentalCost" name="rentalCost" type="text"
                                   placeholder="Rental Cost" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="maxCapacity">Max Capacity</label>
                            <Field className="form-control" id="maxCapacity" name="maxCapacity" type="text"
                                   placeholder="Max Capacity" data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="rentalType">Rental Type</label>
                            <Field as="select" className="form-control" id="rentalType" name="rentalType" type="text" placeholder="RentalType"
                                   data-sb-validations="">
                                <option className="option" value="Tháng">Tháng</option>
                                <option className="option" value="Ngày">Ngày</option>
                                <option className="option" value="Năm">Năm</option>
                            </Field>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="img">Image</label>
                            <Field className="form-control" id="img" name="img" type="img" placeholder="img"
                                   data-sb-validations=""/>
                        </div>

                        <div className="submit" style={{textAlign:"center"}}>
                            <button className="btn btn-primary" id="submitButton" type="submit">Submit</button>
                        </div>
                    </Form>
                </div>
            </Formik>
            </>
    )
}