import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {getAll, getPage} from "../../service/ContractService.jsx";
import ReactPaginate from "react-paginate";

export function Contract() {

    const [contract, setContract] = useState([]);
    const [numContract, setNumContract] = useState("");


    const [currentPage] = useState(1);
    const [totalPage, setTotalPage] = useState(0);

    useEffect(() => {
        display()
    }, [currentPage, numContract]);

    const display = async () => {
        const res = await getAll(currentPage, numContract);
        const total = res.headers["x-total-count"]
        setTotalPage(Math.ceil(total / 5))
        setContract(res.data)
    }

    const handlePageClick = async (event) => {
        let currentPage = event.selected + 1;
        const contractList = await getPage(currentPage,numContract);
        setContract(contractList);
    }
    return (
        <>
            <h1 style={{textAlign: "center"}}>List Contract</h1>
            <div className="navbar navbar-inverse">
                <Link className="btn btn-outline-primary" to='/contract/add'>Add</Link>
            </div>
            <div className="d-flex justify-content-end">
                <input className="bg-light text-dark" style={{borderRadius: "15px", textAlign: "center"}}
                       placeholder='Search ...'
                       type='text' onChange={(event) => setNumContract(event.target.value)}/>
            </div>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Num Contract</th>
                    <th>Date Start</th>
                    <th>Date End</th>
                    <th>Deposit</th>
                    <th>Total</th>
                </tr>
                </thead>
                <tbody>
                {
                    contract.map((con, index) => (
                        <tr key={con.id}>
                            <td>{index + 1}</td>
                            <td>{con.numContract}</td>
                            <td>{con.dateStart}</td>
                            <td>{con.dateEnd}</td>
                            <td>{con.deposit}</td>
                            <td>{con.total}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>

            <ReactPaginate
                breakLabel="..."
                nextLabel="next >"
                onPageChange={handlePageClick}
                pageCount={totalPage}
                previousLabel="< previous"
                renderOnZeroPageCount={null}
                marginPagesDisplayed={1}
                pageRangeDisplayed={3}

                containerClassName={"pagination justify-content-center"}
                previousClassName={"page-item"}
                previousLinkClassName={"page-link"}
                pageClassName={"page-item"}
                pageLinkClassName={"page-link"}
                nextClassName={"page-item"}
                nextLinkClassName={"page-link"}
                breakClassName={"page-item"}
                breakLinkClassName={"page-link"}
                activeClassName={"active"}
            />
        </>
    )
}