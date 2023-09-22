import React, {useEffect, useState} from 'react';
import {Formik} from "formik";
import {getAll} from "../service/BokkService.jsx";
import {Link} from "react-router-dom";

export function BookList(props) {
    const [books,setBooks] = useState([]);
    const getBook = async ()=>{
        const res = await getAll();
        setBooks(res)
    }
    useEffect(()=>{
        getBook()
    },[]);
    return (
        <>
            <h1>Library</h1>
            <Link className="btn btn-outline-primary" to="/add">Add</Link>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th colSpan={2}>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    books.map((b)=>(
                        <tr key={b.id}>
                            <td>{b.title}</td>
                            <td>{b.quantity}</td>
                            <td><Link className="btn btn-outline-primary" to="/edit">Edit</Link></td>
                            <td><Link className="btn btn-outline-danger" to="/delete">Delete</Link></td>
                        </tr>
                    ))
                }

                </tbody>


            </table>

        </>
    );
}

export default BookList;