import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {getAll} from "../../service/ContractService.jsx";

export function Contract() {

    const [contract, setContract] = useState([]);
    const [numContract,setNumContract] = useState("");

    useEffect(() => {
        display()
    }, [numContract]);

    const display = async () => {
        const res = await getAll(numContract);
        setContract(res)
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
        </>
    )
}