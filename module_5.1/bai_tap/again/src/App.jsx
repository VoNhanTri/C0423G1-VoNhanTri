import {useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {Blog} from "./ss2/ex1.jsx";
import 'bootstrap/dist/css/bootstrap.css';
import {Posts} from "./ss3/Post.jsx";
import {ListPost} from "./ss3/component/ListPost.jsx";
import Again from "./ss4/Again.jsx";
import {Greetings} from "./ss4/Hookss.jsx";
import {BlogList} from "./ss5/component/BlogList.jsx";
import {Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import {CreateBlog} from "./ss5/component/CreateBlog.jsx";
import "react-toastify/dist/ReactToastify.css";
import {EditBlog} from "./ss5/component/EditBlog.jsx";
import {StudentList} from "./ss7/student/StudentList.jsx";
import {StudentAdd} from "./ss7/student/StudentAdd.jsx";


function App() {
    return (
        <>
            {/*<Routes>*/}
            {/*    <Route path='/' element={<BlogList/>}/>*/}
            {/*    <Route path='/create' element={<CreateBlog/>}/>*/}
            {/*    <Route path='/edit/:id' element={<EditBlog/>}/>*/}
            {/*</Routes>*/}
            {/*<ToastContainer></ToastContainer>*/}
            <Routes>
                <Route path="/students" element={<StudentList/>}></Route>
                <Route path="/students/add" element={<StudentAdd/>}></Route>
            </Routes>

            {/*<Blog/>*/}
            {/*<Posts/>*/}
            {/*<ListPost/>*/}
            {/*<Again/>*/}
            {/*<Greetings/>*/}
        </>
    )
}

export default App
