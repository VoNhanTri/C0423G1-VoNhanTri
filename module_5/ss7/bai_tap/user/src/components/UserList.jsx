import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import {getAllUser} from "../redux/middleware/StudentMiddleware.jsx";

export function UserList() {
    const user = useSelector(store => store.users)
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getAllUser)
    }, [dispatch]);
    return (
        <>

            <h1>User List</h1>
            <table className='table'>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Website</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {
                    user.map((us) => (
                        <tr key={us.id}>
                            <td>{us.id}</td>
                            <td>{us.name}</td>
                            <td>{us.email}</td>
                            <td>{us.website}</td>
                            <td></td>
                        </tr>

                    ))}
                < /tbody>
            </table>
        </>
    )
}