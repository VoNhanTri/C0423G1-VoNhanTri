import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import {addFacility, getAllService} from "../../service/FacilityService.jsx";

export function AddFacility() {
    const [service, setService] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        displayService()
    }, []);

    const displayService = async () => {
        const res = await getAllService();
        setService(res)
    }

    const addFacilities = async (data) => {
      const res = {...data, serviceName: JSON.parse(data.serviceName)}
        await addFacility(res)
    }

    return (
        <>
            <Formik initialValues={{
                serviceName: JSON.stringify({
                    id: 1,
                    name: "Villa"
                }),
                area: '',
                rentalCost: '',
                maxCapacity: '',
                rentalType: '',
                img: ''
            }} onSubmit={(values) => {
                addFacilities(values)
                navigate("/facility");
                toast("Thêm Mới Thành Công")
            }}>
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="mb-3">
                            <label className="form-label" htmlFor="serviceName">Service Name</label>
                            <Field as="select" className="form-control" id="serviceName" name="serviceName"
                                   placeholder="Service Name" data-sb-validations="">
                                {
                                    service.map((types) => (
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
                            <Field className="form-control" id="rentalType" name="rentalType" type="text" placeholder="RentalType"
                                   data-sb-validations=""/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label" htmlFor="img">Image</label>
                            <Field className="form-control" id="img" name="img" type="text" placeholder="img"
                                   data-sb-validations=""/>
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