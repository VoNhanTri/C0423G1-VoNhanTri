import {useState} from 'react'
import "react-toastify/dist/ReactToastify.css"
import {ToastContainer} from "react-toastify";
import './App.css'
import {NavLink, Route, Routes} from "react-router-dom";
import TodoList from "./components/TodoList.jsx";
import {TodoCreate} from "./components/TodoCreate.jsx";

function App() {
    const [count, setCount] = useState(0)

    return (
        <>
            <NavLink to='/todos'>List</NavLink>
            <NavLink to='/todos/create' className='ms-2'>Add</NavLink>
            <Routes>
                <Route path='/todos' element={<TodoList/>}/>
                <Route path='/todos/create' element={<TodoCreate/>}/>
            </Routes>
            <ToastContainer></ToastContainer>
        </>
    )
}

export default App
