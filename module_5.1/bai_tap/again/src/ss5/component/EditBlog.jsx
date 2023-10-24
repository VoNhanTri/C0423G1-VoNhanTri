import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {editBlog, getById} from "../service/BlogService.jsx";
import {object} from "yup";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";

export function EditBlog() {
    const navigate = useNavigate();

    const param = useParams();
    const [select, setSelect] = useState(null);

    useEffect(() => {
        getBlogById()
    }, [param]);

    const getBlogById = async () => {
      const res = await getById(param.id);
      setSelect(res)
    }

    const loadBlog = async (object) => {
        await editBlog(object)
        navigate("/")
        toast("Sửa Thành Công")
    }

    if (select === null){
        return null
    }
    return (
        <>

            <Formik
                initialValues={select}
                validationSchema={Yup.object({
                    title: Yup.string()
                        .required("Title canot is empty"),
                    category: Yup.string().required("CAtegory canot is empty"),
                    content: Yup.string().required("Content canot is empty"),
                    slug: Yup.string().required("Time canot is empty"),
                    author: Yup.string().required("Author canot is empty"),
                    email: Yup.string()
                        .required("Email canot is empty")
                        .matches(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/, "Email invalidate")
                })}
                onSubmit={async (values) => {
                    await loadBlog(values)

                }}
            >
                <div className="container px-5 my-5">
                    <Form id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="title"
                                name="title"
                                type="text"
                                placeholder="Title"

                            />
                            <ErrorMessage className='err' name='title' component="span"></ErrorMessage>
                            <label htmlFor="title">Title</label>
                        </div>
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="author"
                                name="author"
                                type="text"
                                placeholder="Author"

                            />
                            <ErrorMessage className='err' name='author' component="span"></ErrorMessage>
                            <label htmlFor="author">Author</label>
                        </div>
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="category"
                                name="category"
                                type="text"
                                placeholder="Category"

                            />
                            <ErrorMessage className='err' name='category' component="span"></ErrorMessage>
                            <label htmlFor="category">Category</label>
                        </div>
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="content"
                                name="content"
                                type="text"
                                placeholder="Content"

                            />
                            <ErrorMessage className='err' name='content' component="span"></ErrorMessage>
                            <label htmlFor="content">Content</label>
                        </div>
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="time"
                                name="slug"
                                type="text"
                                placeholder="Time"

                            />
                            <ErrorMessage className='err' name='slug' component="span"></ErrorMessage>
                            <label htmlFor="time">Time</label>
                        </div>
                        <div className="form-floating mb-3">

                            <Field
                                className="form-control"
                                id="email"
                                name="email"
                                type="text"
                                placeholder="Email"

                            />
                            <ErrorMessage className='err' name='email' component="span"></ErrorMessage>
                            <label htmlFor="email">Email</label>
                        </div>
                        <div className="d-grid">
                            <button
                                className="btn btn-primary"
                                id="submitButton"
                            >
                                Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>

        </>

    )
}