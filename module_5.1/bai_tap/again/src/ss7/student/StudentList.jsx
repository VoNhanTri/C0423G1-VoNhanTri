import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import {getAll} from "../redux/middlewares/StudentMiddleware.jsx";
import {NavLink} from "react-router-dom";


export function StudentList() {
    const students = useSelector(store => store.students
        )
    ;
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getAll())
    }, []);

    console.log(students)

    if (!students) {
        return null;
    }
    return (
        <>
            <NavLink to="/students/add">
                <button>Create</button>
            </NavLink>
            <h1>Student List</h1>
            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Language</th>
                </tr>
                </thead>
                <tbody>
                {
                    students  ?
                        students.map((temp, index) => {
                            return (
                                <tr key={temp.id}>
                                    <td>{index + 1}</td>
                                    <td>{temp.name}</td>
                                    <td>{temp.gender === 1 ? "Nam" : "Nữ"}</td>
                                    <td>{temp.age}</td>
                                    <td>{temp.languages.map((value, index) => {
                                        return <span key={index}>{value}</span>
                                    })}</td>
                                </tr>

                            )
                        }) : ""
                }
                </tbody>
            </table>
        </>
    )
}