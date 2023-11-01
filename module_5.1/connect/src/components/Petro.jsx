import {useEffect, useState} from "react";
import {getAll} from "../service/Petrols";
import {Link} from "react-router-dom";

export function Petro() {
    const [petrols, setPetrols] = useState([]);

    useEffect(() => {
        display()
    }, []);

    const display = async () => {
        const res = await getAll()
        console.log(res)
        setPetrols(res)
    }

    return (
        <>
            <div className="navbar navbar-inverse">
                <Link className="btn btn-primary" to="/petrols/add">ADD</Link>
            </div>
                    <table>
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            petrols.map((petro)=>{
                                return (
                                    <tr key={petro.id}>
                                        <td>{petro.id}</td>
                                        <td>{petro.name}</td>
                                        <td>{petro.price}</td>
                                    </tr>
                                )
                            })
                        }
                        </tbody>
                    </table>

        </>
    )
}