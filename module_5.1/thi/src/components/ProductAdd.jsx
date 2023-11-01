import {useEffect, useState} from "react";
import {addProduct, getAllType} from "../service/ProductService";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as Yup from "yup"
export function ProductAdd() {
    const [type, setType] = useState([]);
    const navigate = useNavigate();


    useEffect(() => {
        getType()
    }, []);

    const getType = async () => {
      const res = await getAllType();
      setType(res);
    }

    const add = async (data) => {
      const res = {...data, typeProduct:JSON.parse(data.typeProduct)};
      await  addProduct(res);
    }

    return (
        <>
        <Formik initialValues={{
            code: "",
            name: "",
            quantity:0,
            price: 0,
            date: "",
            description: "",
            typeProduct:JSON.stringify({
                id: 1,
                name: "Banh"
            })
        }} onSubmit={(values)=>{
            add(values);
            navigate("/product");
            toast("Yes");
        }}
        validationSchema={ Yup.object ({
            code: Yup.string()
                .required("Khong Duoc De Trong")
                .matches(/^PROD-[0-9]{4}$/,"Phai theo dinh dang PROD-xxxx"),
            name: Yup.string()
                .required("Khong Duoc De Trong"),
            quantity: Yup.number()
                .required("Khong Duoc De Trong")
                .min(0,"phai lon hon khong")
                .integer(),
            price: Yup.number()
                .required("Khong duoc de trong"),
            date: Yup.date()
                .required("Khong Duoc De Trong"),
            description: Yup.string()
                .required("Khong Duoc De Trong"),


        })
        }
        >

            <div className="container px-5 my-5">
                <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                    <div className="mb-3">
                        <label className="form-label" htmlFor="code">Code Product</label>
                        <Field className="form-control" id="code" name='code' type="text" placeholder="Code Product"/>
                        <ErrorMessage name="code" component="span" className="from"></ErrorMessage>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="name">Name</label>
                        <Field className="form-control" id="name" name='name' type="text" placeholder="name"/>
                        <ErrorMessage name="name" component="span" className="from"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="quantity">Quantity</label>
                        <Field className="form-control" id="quantity" name='quantity' type="text" placeholder="quantity"/>
                        <ErrorMessage name="quantity" component="span" className="from"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="price">Price</label>
                        <Field className="form-control" id="price" name='price' type="text" placeholder="price"/>
                        <ErrorMessage name="price" component="span" className="from"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="date">Date</label>
                        <Field className="form-control" id="date" name='date' type="date" placeholder="date"/>
                        <ErrorMessage name="date" component="span" className="from"></ErrorMessage>

                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="description">Description</label>
                        <Field className="form-control" id="description" name='description' type="text" placeholder="description"/>
                        <ErrorMessage name="description" component="span" className="from"></ErrorMessage>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="type">Type</label>
                        <Field as="select" className="form-select" name='typeProduct' id="type" aria-label="type">
                            {
                               type.map((type)=>(
                                    <option key={type.id} value={JSON.stringify(type)}>{type.name}</option>
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