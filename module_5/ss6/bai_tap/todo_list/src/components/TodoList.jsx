import React, {useEffect, useState} from 'react';
import * as todoService from "../../src/service/TodoService.jsx"
import index from "async";

export function TodoList(props) {
    const [todos, setTodo] = useState([]);


    useEffect(() => {
        getTodos();
    }, []);

    const getTodos = async () => {
        setTodo(await todoService.getAll());
    }
    return (
        <>

            <h1>Todo List</h1>
            <table className='table'>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Todo</th>
                </tr>
                </thead>
                <tbody>
                {
                    todos.map((todo) => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.name}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    );
}

export default TodoList;