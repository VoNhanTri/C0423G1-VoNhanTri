function Student({student}) {

    return (
            <table border={1}>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                </tr>
                { student.map(props=> (
                    <tr>
                        <td>{props.id}</td>
                        <td>{props.name}</td>
                        <td>{props.age}</td>
                        <td>{props.address}</td>
                    </tr>
                ))
                }
            </table>
    )
}
export default Student;