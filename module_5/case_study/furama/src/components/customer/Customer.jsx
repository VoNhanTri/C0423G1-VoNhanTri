// eslint-disable-next-line no-unused-vars
import React, {useEffect, useState} from 'react';
import {getAll} from "../../service/CustomerService.jsx";
import {Link} from "react-router-dom";
import {DeleteCustomer} from "./DeleteCustomer.jsx";

function Customer() {
    const [customers, setCustomers] = useState([]);
    const [hoTen, setHoTen] = useState("");

    const [modalStatus, setModalStatus] = useState(false);
    const [selectCustomer, setSelectCustomer] = useState(null);

    useEffect(() => {
        getCustomer(hoTen)
    }, [hoTen]);

    // useEffect(()=>{
    //     searchName()
    // },[hoTen])

    const getCustomer = async () => {
        const res = await getAll()
        setCustomers(res);
    }
    const handleModal = (customer) => {
        setSelectCustomer(customer);
        setModalStatus(true);
    }

    const closeModal = () => {
        getCustomer()
        setSelectCustomer(null);
        setModalStatus(false);
    }

    // const handlePageClick = async (event) => {
    //     const page = event.selected + 1
    //     const res = await getPage(page);
    //     setCustomers(res)
    // }

    return (
        <>
            <h1>Danh Sách Khách Hàng</h1>
            <div className="navbar navbar-inverse">
                <Link className="btn btn-outline-primary" to='/customer/add'>Add</Link>
            </div>
            <div className="d-flex justify-content-end">
                <input className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}} type="text"
                       onChange={(event => setHoTen(event.target.value))}/>
            </div>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Họ Tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>CMND</th>
                    <th>SĐT</th>
                    <th>Email</th>
                    <th>Địa Chỉ</th>
                    <th>Loại Khách</th>
                    <th colSpan={2}>Chức Năng</th>
                </tr>
                </thead>
                <tbody>
                {customers.map((cus,index) => {
                    return (
                        <tr key={cus.id}>
                            <td>{index+1}</td>
                            <td>{cus.name}</td>
                            <td>{cus.date}</td>
                            <td>{cus.gender}</td>
                            <td>{cus.identity}</td>
                            <td>{cus.phone}</td>
                            <td>{cus.email}</td>
                            <td>{cus.address}</td>
                            <td>{cus.type.nameType}</td>
                            <td>
                                <button className="btn btn-outline-danger"
                                        onClick={() => handleModal(cus)}>Delete
                                </button>
                            </td>
                            <td>
                                <Link className="btn btn-outline-primary" to={`/customer/edit/${cus.id}`}>Edit</Link>
                            </td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
            <DeleteCustomer
                show={modalStatus}
                handleClose={closeModal}
                selectCustomer={selectCustomer}
            >
            </DeleteCustomer>

            {/*<ReactPaginate*/}
            {/*    breakLabel="..."*/}
            {/*    nextLabel="next >"*/}
            {/*    onPageChange={handlePageClick}*/}
            {/*    pageCount={totalPage}*/}
            {/*    previousLabel="< previous"*/}
            {/*    renderOnZeroPageCount={null}*/}
            {/*    marginPagesDisplayed={3}*/}
            {/*    pageRangeDisplayed={1}*/}



            {/*    containerClassName={"pagination justify-content-center"}*/}
            {/*    previousClassName={"page-item"}*/}
            {/*    previousLinkClassName={"page-link"}*/}
            {/*    pageClassName={"page-item"}*/}
            {/*    pageLinkClassName={"page-link"}*/}
            {/*    nextClassName={"page-item"}*/}
            {/*    nextLinkClassName={"page-link"}*/}
            {/*    breakClassName={"page-item"}*/}
            {/*    breakLinkClassName={"page-link"}*/}
            {/*    activeClassName={"active"}*/}
            {/*/>*/}

        </>
    );
}

export default Customer;