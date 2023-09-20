function Student() {
    const student = [
        {
            id: '1',
            name: 'Nguyen Van A',
            age: '29',
            address: 'Quang Ngai'
        },
        {
            id: '2',
            name: 'Nguyen Van B',
            age: '29',
            address: 'Quang Ngai'
        },
        {
            id: '3',
            name: 'Nguyen Van C',
            age: '28',
            address: 'Quang Ngai'
        }
    ]

    return (
        <div className="table">
            <table border={1}>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                </tr>
                {student.map(props => (
                    <tr>
                        <td>{props.id}</td>
                        <td>{props.name}</td>
                        <td>{props.age}</td>
                        <td>{props.address}</td>
                    </tr>
                ))
                }
            </table>
        </div>
    )
}

export default Student;